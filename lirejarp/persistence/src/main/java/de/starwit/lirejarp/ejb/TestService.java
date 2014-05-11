package de.starwit.lirejarp.ejb;

import java.io.Serializable;

import javax.ejb.Local;

import de.starwit.lirejarp.entity.TestEntity;

@Local
public interface TestService extends Serializable, AbstractService<TestEntity> {

}
