package de.starwit.lirejarp.ejb.impl;

import javax.ejb.Stateless;

import de.starwit.lirejarp.ejb.PublicationService;
import de.starwit.lirejarp.entity.PublicationEntity;

@Stateless(name="PublicationService")
public class PublicationServiceImpl extends AbstractServiceImpl<PublicationEntity> implements PublicationService {

	private static final long serialVersionUID = 1L;

}
