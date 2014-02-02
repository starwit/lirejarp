package de.starwit.smartpsv.ejb;

import java.io.Serializable;

import javax.ejb.Local;

import de.starwit.smartpsv.entity.CategoryEntity;

@Local
public interface CategoryService extends Serializable, AbstractService<CategoryEntity> {
}
