package de.starwit.lirejarp.ejb;

import java.io.InputStream;

import javax.ejb.Local;

import de.starwit.lirejarp.entity.AbstractEntity;

@Local
public interface DataImportExportService {
	
	void init();

	void importEntityData(Class<? extends AbstractEntity> entityClass,
			InputStream in);
}
