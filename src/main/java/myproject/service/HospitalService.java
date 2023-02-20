package myproject.service;

import myproject.entity.Hospital;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface HospitalService {
    List<Hospital> getAll();
    void save(Hospital hospital);
    void update(Long id, Hospital newHospital);
    void delete(Long id);
    Hospital getById(Long id);
}
