package de.starwit.lirejarp.ejb;

import java.io.Serializable;

import javax.ejb.Local;

import de.starwit.lirejarp.entity.PublicationEntity;

@Local
public interface PublicationService extends Serializable, AbstractService<PublicationEntity> {

}
