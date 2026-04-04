package alaaesam.tdb.repository.jpa;

import alaaesam.tdb.model.entity.Destination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface DestinationJPARepository extends JpaRepositoryImplementation<Destination,Long> {
    @Query("""
            SELECT d FROM Destination d WHERE (:quickSearch IS NULL OR
                        LOWER(d.name) LIKE LOWER(CONCAT('%',:quickSearch,'%')))
            """)
    Page<Destination> findAll(String quickSearch, Pageable pageable);
}
