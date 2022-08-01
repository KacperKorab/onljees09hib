package pl.coderslab.book;

import lombok.*;
import pl.coderslab.author.Author;
import pl.coderslab.publisher.Publisher;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int rating;
    private String description;
    @ManyToOne
    private Publisher publisher;
    @ManyToMany
    private List<Author> authors;
}
