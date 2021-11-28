package net.alfonsomadrid.swaggerexample.repository.inhabitant;

import net.alfonsomadrid.swaggerexample.model.planet.InhabitantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InhabitantJPARepository extends JpaRepository<InhabitantEntity, Long> {}
