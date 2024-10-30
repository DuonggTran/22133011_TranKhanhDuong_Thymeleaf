package code.services;

import java.util.List;
import java.util.Optional;

import code.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


public interface CategoryService {

	void deleteAll();

	void delete(code.entity.CategoryEntity entity);

	void deleteById(Integer id);

	long count();

	Optional<code.entity.CategoryEntity> findById(Integer id);

	List<code.entity.CategoryEntity> findAll();

	List<code.entity.CategoryEntity> findAllById(Iterable<Integer> ids);

	List<code.entity.CategoryEntity> findAll(Sort sort);

	Page<code.entity.CategoryEntity> findAll(Pageable pageable);

	Page<code.entity.CategoryEntity> findByCategoryNameContaining(String categoryName, Pageable pageable);

	List<code.entity.CategoryEntity> findByCategoryNameContaining(String categoryName);

	<S extends CategoryEntity> S save(S entity);


	
}
