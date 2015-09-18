package de.starwit.lirejarp.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="${domainUpper}")
public class ${domain}Entity extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
}