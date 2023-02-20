package myproject.service;

import myproject.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface PatientService {
    List<Patient> getAll();
    void save(Patient patient);
    void update(Long id, Patient newPatient);
    void delete(Long id);
    Patient getById(Long id);
}
