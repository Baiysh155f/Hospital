package myproject.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import myproject.entity.Hospital;
import myproject.repository.HospitalRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
@RequiredArgsConstructor
public class HospitalRepositoryImpl implements HospitalRepository {
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public List<Hospital> getAll() {
        return entityManager.createQuery("from Hospital",Hospital.class).getResultList();
    }

    @Override
    public void save(Hospital hospital) {
        entityManager.persist(hospital);
        entityManager.merge(hospital);
    }

    @Override
    public void update(Long id, Hospital newHospital) {
        Hospital hospital = entityManager.find(Hospital.class, id);
        hospital.setName(newHospital.getName());
        hospital.setAddress(newHospital.getAddress());
        hospital.setImages(newHospital.getImages());
        entityManager.merge(hospital);
    }

    @Override
    public void delete(Long id) {
//        entityManager.createQuery("delete from Hospital where id =:id")
//                .setParameter("id",id)
//                .executeUpdate();
        Hospital hospital = entityManager.find(Hospital.class, id);
        entityManager.remove(hospital);
    }

    @Override
    public Hospital getById(Long id) {
       return entityManager.find(Hospital.class,id);
    }
}