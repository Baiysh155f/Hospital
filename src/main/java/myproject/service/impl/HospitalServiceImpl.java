package myproject.service.impl;

import lombok.RequiredArgsConstructor;
import myproject.entity.Hospital;
import myproject.repository.HospitalRepository;
import myproject.service.HospitalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {
    private final HospitalRepository hospitalRepository;
    @Override
    public List<Hospital> getAll() {
        return hospitalRepository.getAll();
    }

    @Override
    public void save(Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    @Override
    public void update(Long id, Hospital newHospital) {
        hospitalRepository.update(id,newHospital);
    }

    @Override
    public void delete(Long id) {
        hospitalRepository.delete(id);
    }

    @Override
    public Hospital getById(Long id) {
       return hospitalRepository.getById(id);
    }
}
