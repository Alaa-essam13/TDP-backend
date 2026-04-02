package alaaesam.tdb.repository.jpa;

import alaaesam.tdb.model.entity.Country;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface CountryJPARepository extends JpaRepositoryImplementation<Country,Long> {
}
