package myproject.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import myproject.entity.Doctor;
import myproject.entity.Patient;
import myproject.service.DoctorService;
import myproject.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/mainPatient")
@RequiredArgsConstructor
public class PatientAPI {
    private final PatientService patientService;
    @GetMapping
    String findAll(Model model){
        List<Patient> patients = patientService.getAll();
        model.addAttribute("patient",patients);
        return "mainPatient";
    }
    @GetMapping("/savePatient")
    String save(Model models) {
        models.addAttribute("patient", new Patient());
        return "savePatient";
    }

    @PostMapping("/newPatient")
    String create(@ModelAttribute("patient") Patient patient) {
        patientService.save(patient);
        return "redirect:/mainPatient";
    }

    @DeleteMapping("{patientId}/delete")
    public String deleteCompany(@PathVariable("patientId") Long id) {
        patientService.delete(id);
        return "redirect:/mainPatient";
    }
    @GetMapping("/{patId}")
    public String getCompanyById(@PathVariable("patId") Long id, Model model) {
        model.addAttribute("pat", patientService.getById(id));
        return "pat";
    }
    @GetMapping("/{patId}/updatePatient")
    public String edit(@PathVariable("patId") Long id, Model model){
        model.addAttribute("patient", patientService.getById(id));
        return "updatePatient";
    }
    @PatchMapping("/{patId}")
    public String updateCompany(@PathVariable("patId") Long id,
                                @ModelAttribute("patient") @Valid Patient patient,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updatePatient";
        }
        patientService.update(id, patient);
        return "redirect:/mainPatient";
    }
}
