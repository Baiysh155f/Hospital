package myproject.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import myproject.entity.Doctor;
import myproject.entity.Patient;
import myproject.service.DoctorService;
import myproject.service.HospitalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/{id}/mainDoctor")
@RequiredArgsConstructor
public class DoctorAPI {
    private final HospitalService hospitalService;
    private final DoctorService doctorService;
    @GetMapping("/mainDoctor")
    String findAll(@PathVariable("id") Long id, Model model) {
        List<Doctor> doctors = doctorService.getAll(id);
        model.addAttribute("doctor", doctors);
        return "fordoctor/mainDoctor";
    }

    @GetMapping("/savedoctor")
    String save(Model models) {
        models.addAttribute("doctor", new Doctor());
        models.addAttribute("hospitals",hospitalService.getAll());
        return "fordoctor/savedoctor";
    }

    @PostMapping("/newdoctor")
    String create(@ModelAttribute("doctor") Doctor doctor) {
        doctorService.save(doctor);
        return "redirect:/{id}/mainDoctor";
    }

    @DeleteMapping("/{doctorId}/delete")
    public String deleteCompany(@PathVariable("doctorId") Long id) {
        doctorService.delete(id);
        return "redirect:/{id}/mainDoctor";
    }

    @GetMapping("/{docId}")
    public String getCompanyById(@PathVariable("docId") Long id, Model model) {
        model.addAttribute("doc", doctorService.getById(id));
        return "doc";
    }

    @GetMapping("/{docId}/updateDoctor")
    public String edit(@PathVariable("docId") Long id, Model model) {
        model.addAttribute("doctor", doctorService.getById(id));
        return "fordoctor/updatedoctor";
    }

    @PatchMapping("/{docId}")
    public String updateCompany(@PathVariable("docId") Long id,
                                @ModelAttribute("doctor") @Valid Doctor doctor,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "fordoctor/updatedoctor";
        }
        doctorService.update(id, doctor);
        return "redirect:/{id}/mainDoctor";
    }
}
