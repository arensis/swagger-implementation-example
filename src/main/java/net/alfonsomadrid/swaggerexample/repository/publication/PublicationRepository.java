package net.alfonsomadrid.swaggerexample.repository.publication;

import net.alfonsomadrid.swaggerexample.model.planet.PublicationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PublicationRepository {

    @Autowired
    PublicationJPARepository publicationJPARepository;

    public Optional<PublicationEntity> findById(Long id) {
        return publicationJPARepository.findById(id);
    }

}
