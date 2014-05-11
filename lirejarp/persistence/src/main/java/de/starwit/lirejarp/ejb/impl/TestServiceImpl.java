package de.starwit.lirejarp.ejb.impl;

import javax.ejb.Stateless;

import de.starwit.lirejarp.ejb.TestService;
import de.starwit.lirejarp.entity.TestEntity;

@Stateless(name="TestService")
public class TestServiceImpl extends AbstractServiceImpl<TestEntity> implements TestService {

	private static final long serialVersionUID = 1L;

}
