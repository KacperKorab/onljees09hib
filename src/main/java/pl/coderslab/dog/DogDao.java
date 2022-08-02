package pl.coderslab.dog;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DogDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Dog dog){
        entityManager.persist(dog);
    }
}
