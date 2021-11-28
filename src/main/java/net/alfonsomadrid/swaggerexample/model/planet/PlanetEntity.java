package net.alfonsomadrid.swaggerexample.model.planet;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "PLANET")
public class PlanetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column Long id;

    @Column(nullable = false) String name;

    @Column String capitalCity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PLANET_LOCATION")
    LocationEntity location;

    @ManyToMany
    @JoinTable(name = "PLANET_INHABITANTS")
    @Builder.Default
    List<InhabitantEntity> inhabitants = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PLANET_PUBLICATION")
    PublicationEntity publication;
}
