package de.starwit.lirejarp.ejb.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import de.starwit.lirejarp.dao.AbstractDao;
import de.starwit.lirejarp.ejb.NewsService;
import de.starwit.lirejarp.entity.NewsEntity;

@Stateless(name="PackingPieceService")
public class NewsServiceImpl extends AbstractDao<NewsEntity> implements NewsService {
	
	private static final long serialVersionUID = -1034640519269748512L;

	@Override
	public List<NewsEntity> findNewsByDay(Date date) {
		Calendar calBefore = Calendar.getInstance();
		calBefore.setTime(date);
		calBefore.set(Calendar.HOUR_OF_DAY, 0);
		calBefore.set(Calendar.MINUTE, 0);
		calBefore.set(Calendar.SECOND, 0);
		calBefore.set(Calendar.MILLISECOND, 0);

		Calendar calAfter = Calendar.getInstance();
		calAfter.setTime(calBefore.getTime());
		calAfter.add(Calendar.DATE, 1);

		String sql = "select distinct ppe from PackingPieceEntity ppe join fetch ppe.scanEvents se where se.scanTime > :dateBefore and se.scanTime < :dateAfter";

		TypedQuery<NewsEntity> query = getEntityManager().createQuery(
				sql, NewsEntity.class);
		query.setParameter("dateBefore", calBefore.getTime());
		query.setParameter("dateAfter", calAfter.getTime());

		return query.getResultList();
	}
	
}
