package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.entities.Country;

@Repository
public interface CountryRepository extends ReadOnlyRepository<Country, Long> {
	
	@Query("select co from Country co join co.cities c where c.cityName = :cityName")
	public List<Country> findByCityName(@Param("cityName")String cityName);
	
	@Query("select c from Country c where c.countryCode = :countryCode")
	public List<Country> findByCountryCode(@Param("countryCode")String countryCode);
}
