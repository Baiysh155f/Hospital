package myproject.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import myproject.entity.Doctor;
import myproject.repository.DoctorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
@RequiredArgsConstructor
public class DoctorRepositoryImpl implements DoctorRepository {
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public List<Doctor> getAll(Long id) {
        return entityManager.createQuery("from Doctor d join d.hospital h where h.id = :id", Doctor.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<Doctor> all() {
        return entityManager.createQuery("from Doctor ",Doctor.class).getResultList();
    }

    @Override
    public Doctor getByHospitalId(Doctor doctor) {
        entityManager.persist(doctor);
        return doctor;
    }

    @Override
    public void update(Long id, Doctor newDoctor) {
        Doctor doctor = entityManager.find(Doctor.class, id);
        doctor.setFirstName(newDoctor.getFirstName());
        doctor.setLastName(newDoctor.getLastName());
        doctor.setPosition(newDoctor.getPosition());
        doctor.setEmail(newDoctor.getEmail());
        doctor.setImages(newDoctor.getImages());
        entityManager.merge(doctor);
    }

    @Override
    public void delete(Long id) {
        Doctor doctor = entityManager.find(Doctor.class, id);
        entityManager.remove(doctor);
    }

    @Override
    public Doctor getById(Long id) {
        return entityManager.find(Doctor.class,id);
    }
}
