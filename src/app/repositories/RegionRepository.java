package app.repositories;
import org.springframework.stereotype.Repository;

import app.entities.Country;
import app.entities.Region;

@Repository
public interface RegionRepository extends ReadOnlyRepository<Region, Long> {
	
}
