package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.entities.City;

@Repository
public interface CityRepository extends ReadOnlyRepository<City, Long>{
	
	@Query("select ci from City ci join fetch ci.country c where c.countryName = :countryName order by ci.cityName")
	public List<City> findByCountryName(@Param("countryName") String countryName);
	
}
