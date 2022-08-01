package pl.coderslab.person;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "peopleDetails")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int streetNumber;
    private String street;
    private String city;
    @OneToOne
    private Person person;
}
