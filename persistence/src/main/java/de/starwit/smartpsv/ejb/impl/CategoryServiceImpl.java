package de.starwit.smartpsv.ejb.impl;

import javax.ejb.Stateless;

import de.starwit.smartpsv.dao.AbstractDao;
import de.starwit.smartpsv.ejb.CategoryService;
import de.starwit.smartpsv.entity.CategoryEntity;

@Stateless(name = "CategoryService")
public class CategoryServiceImpl extends AbstractDao<CategoryEntity> implements CategoryService {
	
	private static final long serialVersionUID = 2426831807321817571L;

}
