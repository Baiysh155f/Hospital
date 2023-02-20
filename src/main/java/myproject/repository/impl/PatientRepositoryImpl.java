package myproject.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import myproject.entity.Patient;
import myproject.repository.PatientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class PatientRepositoryImpl implements PatientRepository {
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public List<Patient> getAll() {
        return entityManager.createQuery("from Patient",Patient.class).getResultList();
    }

    @Override
    public void save(Patient patient) {
        entityManager.persist(patient);
    }

    @Override
    public void update(Long id, Patient newPatient) {
        Patient patient = entityManager.find(Patient.class, id);
        patient.setLastName(newPatient.getLastName());
        patient.setFirstName(newPatient.getFirstName());
        patient.setPhoneNumber(newPatient.getPhoneNumber());
        patient.setEmail(newPatient.getEmail());
        patient.setGender(newPatient.getGender());
        entityManager.merge(patient);
    }

    @Override
    public void delete(Long id) {
        Patient patient = entityManager.find(Patient.class, id);
        entityManager.remove(patient);
    }

    @Override
    public Patient getById(Long id) {
        return entityManager.find(Patient.class,id);
    }
}
