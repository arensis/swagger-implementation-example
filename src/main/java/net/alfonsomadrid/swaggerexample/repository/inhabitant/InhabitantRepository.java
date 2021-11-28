package net.alfonsomadrid.swaggerexample.repository.inhabitant;

import net.alfonsomadrid.swaggerexample.model.planet.InhabitantEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InhabitantRepository {

    @Autowired
    private InhabitantJPARepository inhabitantJPARepository;

    public Optional<InhabitantEntity> findById(Long id) {
        return inhabitantJPARepository.findById(id);
    }

    public Page<InhabitantEntity> findAll(Pageable pageable) {
        return inhabitantJPARepository.findAll(pageable);
    }

    public InhabitantEntity save(InhabitantEntity entity) {
        return inhabitantJPARepository.save(entity);
    }

}
