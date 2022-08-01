package pl.coderslab.person;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "people")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String email;
    @OneToOne
    private PersonDetails personDetails;
}
