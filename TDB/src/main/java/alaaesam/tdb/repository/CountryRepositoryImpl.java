package alaaesam.tdb.repository;

import alaaesam.tdb.api.repository.CountryRepository;
import alaaesam.tdb.model.entity.Country;
import alaaesam.tdb.repository.jpa.CountryJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class CountryRepositoryImpl implements CountryRepository {
    private final CountryJPARepository countryJPARepository;

    @Override
    public Country insert(Country country) {
        return countryJPARepository.save(country);
    }

    @Override
    public List<Country> insertAll(List<Country> countries) {
        return countryJPARepository.saveAll(countries);
    }

    @Override
    public void delete(Country country) {
        countryJPARepository.delete(country);
    }

}
