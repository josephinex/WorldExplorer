package app.repositories;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface ReadOnlyRepository<T, ID extends Serializable> extends Repository<T, ID>{
	
	T findOne(ID id);
	
	boolean exists(ID id);
	
	Iterable<T> findAll();
	
	Iterable<T> findAll(Iterable<ID> ids);
}
