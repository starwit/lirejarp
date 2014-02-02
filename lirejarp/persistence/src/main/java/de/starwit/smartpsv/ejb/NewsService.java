package de.starwit.smartpsv.ejb;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import de.starwit.smartpsv.entity.NewsEntity;

@Local
public interface NewsService extends Serializable, AbstractService<NewsEntity> {
	
	List<NewsEntity> findNewsByDay(Date date);
}
