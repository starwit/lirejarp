package de.starwit.lirejarp.ejb;

import java.io.Serializable;
import javax.ejb.Local;
import de.starwit.lirejarp.entity.AddressEntity;

@Local
public interface AddressService extends Serializable, AbstractService<AddressEntity> {

}


    
