package net.alfonsomadrid.swaggerexample.model.planet;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "PUBLICATION")
public class PublicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column(nullable = false) String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    PublicationType type;

    @Column
    Integer year;
}
