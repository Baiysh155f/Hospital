package myproject.service;

import myproject.entity.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> getAll(Long id);
    List<Doctor> all();
    Doctor save(Doctor newDoctor);
    void update(Long id, Doctor doctor);
    void delete(Long id);
    Doctor getById(Long id);
}
