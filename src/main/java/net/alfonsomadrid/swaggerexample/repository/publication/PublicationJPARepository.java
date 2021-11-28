package net.alfonsomadrid.swaggerexample.repository.publication;

import net.alfonsomadrid.swaggerexample.model.planet.PublicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationJPARepository extends JpaRepository<PublicationEntity, Long> {
}
