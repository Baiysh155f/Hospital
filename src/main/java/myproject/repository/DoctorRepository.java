package myproject.repository;

import myproject.entity.Doctor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Repository
public interface DoctorRepository {
    Doctor save(Doctor newDoctor);
    List<Doctor> getAll(Long id);
    List<Doctor> all();
    Doctor getByHospitalId(Doctor doctor);

    void update(Long id, Doctor doctor);

    void delete(Long id);

    Doctor getById(Long id);

}
