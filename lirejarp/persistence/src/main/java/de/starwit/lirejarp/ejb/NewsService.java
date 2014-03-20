package de.starwit.lirejarp.ejb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import de.starwit.lirejarp.entity.NewsEntity;

@Local
public interface NewsService extends Serializable, AbstractService<NewsEntity> {

	List<NewsEntity> findToday();
	
	List<NewsEntity> findByCategory(Long id);
}
