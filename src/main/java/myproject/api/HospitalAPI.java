package myproject.api;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import myproject.entity.Hospital;
import myproject.service.HospitalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class HospitalAPI {
    private final HospitalService hospitalService;

    @GetMapping
    String link() {
        return "forhospital/main";
    }

    @GetMapping("/hospitals")
    String findAll(Model models) {
        List<Hospital> hospitals = hospitalService.getAll();
        models.addAttribute("hospital", hospitals);
        return "forhospital/hospitals";
    }

    @GetMapping("/savehospital")
    String save(Model models) {
        models.addAttribute("hospital", new Hospital());
        return "forhospital/savehospital";
    }

    @PostMapping("/new")
    String create(@ModelAttribute("hospital") Hospital hospital) {
        hospitalService.save(hospital);
        return "redirect:/main/hospitals";
    }

    @DeleteMapping("{hospitalId}/delete")
    public String deleteCompany(@PathVariable("hospitalId") Long id) {
        hospitalService.delete(id);
        return "redirect:/main/hospitals";
    }
    @GetMapping("/{hosId}")
    public String getCompanyById(@PathVariable("hosId") Long id, Model model) {
        model.addAttribute("hos", hospitalService.getById(id));
        return "hos";
    }
    @GetMapping("/{hosId}/update")
    public String edit(@PathVariable("hosId") Long id, Model model){
        model.addAttribute("hospital", hospitalService.getById(id));
        return "forhospital/updatehospital";
    }
    @PatchMapping("/{hosId}")
    public String updateCompany(@PathVariable("hosId") Long id,
                                @ModelAttribute("hospital") @Valid Hospital hospital,
                                BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "forhospital/updatehospital";
        }
        hospitalService.update(id, hospital);
        return "redirect:/main/hospitals";
    }
}
