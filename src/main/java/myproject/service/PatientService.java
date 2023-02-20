package myproject.service;

import myproject.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAll();
    void save(Patient patient);
    void update(Long id, Patient newPatient);
    void delete(Long id);
    Patient getById(Long id);
}
