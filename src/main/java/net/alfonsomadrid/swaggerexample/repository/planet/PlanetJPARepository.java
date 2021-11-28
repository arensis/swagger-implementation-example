package net.alfonsomadrid.swaggerexample.repository.planet;

import net.alfonsomadrid.swaggerexample.model.planet.PlanetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetJPARepository extends JpaRepository<PlanetEntity, Long> {}
