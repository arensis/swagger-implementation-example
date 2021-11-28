package net.alfonsomadrid.swaggerexample.repository.planet;

import net.alfonsomadrid.swaggerexample.model.planet.PlanetEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlanetRepository {

    @Autowired
    PlanetJPARepository planetJPARepository;

    public List<PlanetEntity> findAll() {
        return planetJPARepository.findAll();
    }

    public PlanetEntity save(PlanetEntity entity) {
        return planetJPARepository.save(entity);
    }

    public Optional<PlanetEntity> findById(Long planetId) {
        return planetJPARepository.findById(planetId);
    }

}
