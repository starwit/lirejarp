package de.starwit.lirejarp.ejb.impl;

import javax.ejb.Stateless;

import de.starwit.lirejarp.dao.AbstractDao;
import de.starwit.lirejarp.ejb.CategoryService;
import de.starwit.lirejarp.entity.CategoryEntity;

@Stateless(name = "CategoryService")
public class CategoryServiceImpl extends AbstractDao<CategoryEntity> implements CategoryService {
	
	private static final long serialVersionUID = 2426831807321817571L;

}
