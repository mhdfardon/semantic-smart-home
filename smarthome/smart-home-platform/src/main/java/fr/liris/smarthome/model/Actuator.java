package fr.liris.smarthome.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	private String name;
	private String description;
	private Set<RuleAction> ruleActions = new HashSet<RuleAction>(0);
	
	public Actuator() {
	}
	
	public Actuator(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Actuator(String name, String description, Set<RuleAction> ruleActions) {
		this.name = name;
		this.description = description;
		this.ruleActions = ruleActions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ACTUATOR_ID", unique = true, nullable = false)
	public Long getId() {
		return this.actuatorId;
	}

	public void setId(Long actuatorId) {
		this.actuatorId = actuatorId;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION", length = 45)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "actuator")
	public Set<RuleAction> getRuleActions() {
		return this.ruleActions;
	}

	public void setRuleActions(Set<RuleAction> ruleActions) {
		this.ruleActions = ruleActions;
	}

	@Transient
	public boolean isNew() {
		return null == this.getId();
	}
}
