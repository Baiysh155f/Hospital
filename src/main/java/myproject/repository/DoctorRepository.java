package myproject.repository;

import myproject.entity.Doctor;

import java.util.List;

public interface DoctorRepository {
    List<Doctor> getAll(Long id);
    List<Doctor> all();

    Doctor getByHospitalId(Doctor doctor);

    void update(Long id, Doctor doctor);

    void delete(Long id);

    Doctor getById(Long id);

}
