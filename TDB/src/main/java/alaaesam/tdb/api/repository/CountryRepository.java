package alaaesam.tdb.api.repository;

import alaaesam.tdb.model.entity.Country;

import java.util.List;

public interface CountryRepository {
    Country insert(Country country);
    List<Country> insertAll(List<Country> country);
    void delete(Country country);
}
