package code.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import code.entity.CategoryEntity;
import code.repository.CategoryRepository;
import code.services.CategoryService;
import org.thymeleaf.util.StringUtils;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public <S extends CategoryEntity> S save(S entity) {
		if(entity.getCategoryId() == null) {
			return categoryRepository.save(entity);
		}
		else {
			Optional<CategoryEntity> opt = findById(entity.getCategoryId());
			if (opt.isPresent()) {
				if(StringUtils.isEmpty(entity.getCategoryName())) {
					entity.setCategoryName(opt.get().getCategoryName());
				}
				else {
					entity.setCategoryName(entity.getCategoryName());
				}
			}
		}
		return categoryRepository.save(entity);
	}
	
	@Override
	public List<code.entity.CategoryEntity> findByCategoryNameContaining(String categoryName) {
		return categoryRepository.findByCategoryNameContaining(categoryName);
	}
	@Override
	public Page<code.entity.CategoryEntity> findByCategoryNameContaining(String categoryName,
			Pageable pageable) {
		return categoryRepository.findByCategoryNameContaining(categoryName, pageable);
	}
	@Override
	public Page<code.entity.CategoryEntity> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}
	@Override
	public List<code.entity.CategoryEntity> findAll(Sort sort) {
		return categoryRepository.findAll(sort);
	}
	@Override
	public List<code.entity.CategoryEntity> findAllById(Iterable<Integer> ids) {
		return categoryRepository.findAllById(ids);
	}
	@Override
	public List<code.entity.CategoryEntity> findAll() {
		return categoryRepository.findAll();
	}
	@Override
	public Optional<code.entity.CategoryEntity> findById(Integer id) {
		return categoryRepository.findById(id);
	}
	@Override
	public long count() {
		return categoryRepository.count();
	}
	@Override
	public void deleteById(Integer id) {
		categoryRepository.deleteById(id);
	}
	@Override
	public void delete(code.entity.CategoryEntity entity) {
		categoryRepository.delete(entity);
	}
	@Override
	public void deleteAll() {
		categoryRepository.deleteAll();
	}


}
