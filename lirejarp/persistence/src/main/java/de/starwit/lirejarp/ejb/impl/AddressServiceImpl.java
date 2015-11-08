package de.starwit.lirejarp.ejb.impl;


import javax.ejb.Stateless;
import de.starwit.lirejarp.ejb.AddressService;
import de.starwit.lirejarp.entity.AddressEntity;

@Stateless(name = "AddressService")
public class AddressServiceImpl extends AbstractServiceImpl<AddressEntity> implements AddressService {
	
	private static final long serialVersionUID = 1L;

}



    
