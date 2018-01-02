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
@Table(name = "rule_action")
public class RuleAction implements java.io.Serializable, Persistable<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8826143495823633631L;
	
	private Long actionId;
	
	@Column(name = "LABEL", length = 100)
	private String label;
	@Column(name = "STATUS", length = 50)
	private String status;
	@Column(name = "actuator", length = 50)
	private Actuator actuator ;
	@Column(name = "VALUE")
	private double value;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "RULE_ID", unique = true, nullable = false)
	public Long getId() {
		return this.actionId;
	}
	
	public void setId(Long actionId) {
		this.actionId = actionId;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Actuator getActuator() {
		return actuator;
	}

	public void setActuator(Actuator actuator) {
		this.actuator = actuator;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Transient
	public boolean isNew() {
		return null == this.getId();
	}
}
