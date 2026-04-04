package alaaesam.tdb.api.repository;

import alaaesam.tdb.model.entity.Destination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DestinationRepository {
    void insertAll(List<Destination> Destination);
    void delete(Destination Destination);
    Optional<Destination> selectById(Long destinationId);
    Page<Destination> selectAll(String quickSearch, Pageable pageable);
    List<Destination> selectAll();
}
