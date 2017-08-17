package app.repositories;

import org.springframework.stereotype.Repository;

import app.entities.Subregion;

@Repository
public interface SubregionRepository extends ReadOnlyRepository<Subregion, String> {

}
