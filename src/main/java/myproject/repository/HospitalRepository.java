package myproject.repository;

import myproject.entity.Hospital;

import java.util.List;

public interface HospitalRepository {
    List<Hospital> getAll();
    void save(Hospital hospital);
    void update(Long id, Hospital newHospital);
    void delete(Long id);
    Hospital getById(Long id);
}