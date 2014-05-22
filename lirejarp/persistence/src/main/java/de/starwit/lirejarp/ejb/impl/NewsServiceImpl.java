package de.starwit.lirejarp.ejb.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import de.starwit.lirejarp.ejb.NewsService;
import de.starwit.lirejarp.entity.NewsEntity;

@Stateless(name="NewsService")
public class NewsServiceImpl extends AbstractServiceImpl<NewsEntity> implements NewsService {
	
	private static final long serialVersionUID = 1L;

	@Override
	public List<NewsEntity> findToday() {
		Calendar calBefore = Calendar.getInstance();
		calBefore.setTime(new Date());
		calBefore.set(Calendar.HOUR_OF_DAY, 0);
		calBefore.set(Calendar.MINUTE, 0);
		calBefore.set(Calendar.SECOND, 0);
		calBefore.set(Calendar.MILLISECOND, 0);

		Calendar calAfter = Calendar.getInstance();
		calAfter.setTime(calBefore.getTime());
		calAfter.add(Calendar.DATE, 1);

		String sql = "select distinct news from NewsEntity news where news.publishedAt > :dateBefore and news.publishedAt < :dateAfter order by news.publishedAt desc";

		TypedQuery<NewsEntity> query = getEntityManager().createQuery(
				sql, NewsEntity.class);
		query.setParameter("dateBefore", calBefore.getTime());
		query.setParameter("dateAfter", calAfter.getTime());
		return query.getResultList();
	}
	
	public List<NewsEntity> findByCategory(Long id) {
		String sql = "select news from NewsEntity news where news.category.id = :id";
		TypedQuery<NewsEntity> query = getEntityManager().createQuery(
				sql, NewsEntity.class);
		query.setParameter("id", id);
		return query.getResultList();
	}
	
}
