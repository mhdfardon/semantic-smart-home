package fr.liris.cci.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.synyx.hades.domain.Persistable;

@Entity
@Table(name = "actuator")
public class Actuator implements java.io.Serializable, Persistable<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1860154169176034881L;

	private Long actuatorId;

	@Column(name = "NAME", length = 100)
	private String name;
	@Column(name = "DESCRIPTION", length = 50)
	private String description;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ACTUATOR_ID", unique = true, nullable = false)
	public Long getId() {
		return this.actuatorId;
	}

	public void setId(Long actuatorId) {
		this.actuatorId = actuatorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Transient
	public boolean isNew() {
		return null == this.getId();
	}
}
