package pl.coderslab.person;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDetailsDao {
    @PersistenceContext
    EntityManager entityManager;

    public void addPersonDetails(PersonDetails personDetails) {
        entityManager.persist(personDetails);
    }

    public PersonDetails findById(long id) {
        return entityManager.find(PersonDetails.class, id);
    }

    public void updatePersonDetails(PersonDetails personDetails) {
        entityManager.merge(personDetails);
    }

    public void deletePersonDetails(PersonDetails personDetails) {
        entityManager.remove(entityManager.contains(personDetails) ?
                personDetails : entityManager.merge(personDetails));
    }
}
