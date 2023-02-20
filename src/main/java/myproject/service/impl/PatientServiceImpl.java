package myproject.service.impl;

import lombok.RequiredArgsConstructor;
import myproject.entity.Patient;
import myproject.repository.PatientRepository;
import myproject.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Override
    public List<Patient> getAll() {
        return patientRepository.getAll();
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void update(Long id, Patient newPatient) {
        patientRepository.update(id, newPatient);
    }

    @Override
    public void delete(Long id) {
        patientRepository.delete(id);
    }

    @Override
    public Patient getById(Long id) {
        return patientRepository.getById(id);
    }
}
