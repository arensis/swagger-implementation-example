package net.alfonsomadrid.swaggerexample.repository.location;

import net.alfonsomadrid.swaggerexample.model.planet.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationJPARepository extends JpaRepository<LocationEntity, Long> {}
