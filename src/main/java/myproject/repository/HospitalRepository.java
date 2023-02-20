package myproject.repository;

import myproject.entity.Hospital;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HospitalRepository {
    List<Hospital> getAll();
    void save(Hospital hospital);
    void update(Long id, Hospital newHospital);
    void delete(Long id);
    Hospital getById(Long id);
}
