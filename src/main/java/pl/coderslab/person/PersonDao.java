package pl.coderslab.person;

import org.springframework.stereotype.Repository;
import pl.coderslab.person.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDao {
    @PersistenceContext
    EntityManager entityManager;

    public void addPerson(Person person) {
        entityManager.persist(person);
    }
    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }
    public void updatePerson(Person person) {
        entityManager.merge(person);
    }
    public void deletePerson(Person person) {
        entityManager.remove(entityManager.contains(person) ?
                person : entityManager.merge(person)); }
}
