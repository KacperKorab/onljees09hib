package pl.coderslab.book;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.dog.Dog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> findAllWithAnyPublisher(){
        return entityManager
                .createQuery("select b from Book b join b.publisher", Book.class)
                .getResultList();
    }

    public List<Book> findAllWithPublisher(Publisher publisher){
        return entityManager
                .createQuery("select b from Book b where b.publisher=:publisher", Book.class)
                .setParameter("publisher", publisher)
                .getResultList();
    }

    public List<Book> findBooksWithAuthor(Author author) {
        return entityManager
                .createQuery("SELECT distinct b FROM Book b join FETCH b.authors " +
                        "WHERE :author member of b.authors", Book.class)
                .setParameter("author", author)
                .getResultList();
    }


    public List<Book> findAll(){
        return entityManager
                .createQuery("select b from Book b", Book.class)
                .getResultList();
    }

    public List<Book> findAllByRating(int rating){
        return entityManager
                .createQuery("select b from Book b where b.rating=:rat", Book.class)
                .setParameter("rat", rating)
                .getResultList();
    }


    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }

    public Book findBookWithAuthorsById(Long id) {
        Book book = findById(id);
        Hibernate.initialize(book.getAuthors());
        return book;
    }
}
