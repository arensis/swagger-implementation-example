package net.alfonsomadrid.swaggerexample.model.planet;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "INHABITANT")
public class InhabitantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column(nullable = false) String race;

    @Column String language;
}
