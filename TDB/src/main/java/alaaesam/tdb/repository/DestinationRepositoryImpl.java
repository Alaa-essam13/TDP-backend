package alaaesam.tdb.repository;

import alaaesam.tdb.api.repository.DestinationRepository;
import alaaesam.tdb.model.entity.Destination;
import alaaesam.tdb.repository.jpa.DestinationJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class DestinationRepositoryImpl implements DestinationRepository {
    private final DestinationJPARepository destinationJPARepository;

    @Override
    public void insertAll(List<Destination> countries) {
        LocalDateTime now=LocalDateTime.now();
        countries.forEach(country->country.setCreatedOn(now));
        destinationJPARepository.saveAll(countries);
    }

    @Override
    public void delete(Destination country) {
        destinationJPARepository.delete(country);
    }

    @Override
    public Optional<Destination> selectById(Long destinationId) {
        return destinationJPARepository.findById(destinationId);
    }

    @Override
    public Page<Destination> selectAll(String quickSearch, Pageable pageable) {
        return destinationJPARepository.findAll(quickSearch,pageable);
    }

    @Override
    public List<Destination> selectAll() {
        return destinationJPARepository.findAll();
    }

}
