package de.starwit.lirejarp.ejb;

import java.io.Serializable;
import javax.ejb.Local;
import de.starwit.lirejarp.entity.PersonEntity;

@Local
public interface PersonService extends Serializable, AbstractService<PersonEntity> {

}


    
