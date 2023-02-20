package myproject.service.impl;

import lombok.RequiredArgsConstructor;
import myproject.entity.Doctor;
import myproject.repository.DoctorRepository;
import myproject.service.DoctorService;
import myproject.service.HospitalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final HospitalService hospitalService;
    private final DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getAll(Long id) {
        return doctorRepository.getAll(id);
    }

    @Override
    public List<Doctor> all() {
        return doctorRepository.all();
    }

    @Override
    public Doctor save(Doctor newDoctor) {
        Doctor doctor = new Doctor();
        doctor.setId(newDoctor.getId());
        doctor.setFirstName(newDoctor.getFirstName());
        doctor.setLastName(newDoctor.getLastName());
        doctor.setImages(newDoctor.getImages());
        doctor.setEmail(newDoctor.getEmail());
        doctor.setPosition(newDoctor.getPosition());
        doctor.setHospital(hospitalService.getById(newDoctor.getHospitalId()));
        return doctorRepository.getByHospitalId(doctor);
    }

    @Override
    public void update(Long id, Doctor doctor) {
        doctorRepository.update(id, doctor);
    }

    @Override
    public void delete(Long id) {
        doctorRepository.delete(id);
    }

    @Override
    public Doctor getById(Long id) {
        return doctorRepository.getById(id);
    }
}
