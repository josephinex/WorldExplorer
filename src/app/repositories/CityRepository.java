package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.entities.City;

@Repository
public interface CityRepository extends ReadOnlyRepository<City, Long>{
	
	@Query("select * from City ci join Country c on(ci.country_code = c.country_code) where c.country_name = :countryName ")
	public List<City> findByCountryName(@Param("countryName") String countryName);
	
}
