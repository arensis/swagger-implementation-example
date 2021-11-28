package net.alfonsomadrid.swaggerexample.repository.location;

import net.alfonsomadrid.swaggerexample.model.planet.LocationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class LocationRepository {

    @Autowired
    LocationJPARepository locationJPARepository;

    public Optional<LocationEntity> findById(Long id) {
        return locationJPARepository.findById(id);
    }

}
