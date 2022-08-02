package pl.coderslab.person;

import lombok.*;

import javax.persistence.*;

@Entity

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PersonDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

}
