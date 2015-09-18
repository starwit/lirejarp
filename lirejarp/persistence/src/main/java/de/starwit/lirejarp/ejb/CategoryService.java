package de.starwit.lirejarp.ejb;

import java.io.Serializable;
import javax.ejb.Local;
import de.starwit.lirejarp.entity.CategoryEntity;

@Local
public interface CategoryService extends Serializable, AbstractService<CategoryEntity> {
	
	CategoryEntity findByName(String name);
}
