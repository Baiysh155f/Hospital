package myproject.service;

import myproject.entity.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DoctorService {
    Doctor save(Doctor newDoctor);
    List<Doctor> getAll(Long id);
    List<Doctor> all();
    void update(Long id, Doctor doctor);
    void delete(Long id);
    Doctor getById(Long id);
}
