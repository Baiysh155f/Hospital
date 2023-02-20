package myproject.repository;

import myproject.entity.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PatientRepository {
    List<Patient> getAll();
    void save(Patient patient);
    void update(Long id, Patient newPatient);
    void delete(Long id);
    Patient getById(Long id);
}
