package fr.liris.smarthome.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	private Long ruleActionId;
	
	private Actuator actuator;
	private Rule rule;
	private String label;
	private String status;
	private Double value;

	public RuleAction() {
	}

	public RuleAction(Actuator actuator, Rule rule) {
		this.actuator = actuator;
		this.rule = rule;
	}

	public RuleAction(Actuator actuator, Rule rule, String label, String status, Double value) {
		this.actuator = actuator;
		this.rule = rule;
		this.label = label;
		this.status = status;
		this.value = value;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "RULE_ACTION_ID", unique = true, nullable = false)
	public Long getId() {
		return this.ruleActionId;
	}
	
	public void setId(Long ruleActionId) {
		this.ruleActionId = ruleActionId;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ACTUATOR_ACTUATOR_ID", nullable = false)
	public Actuator getActuator() {
		return this.actuator;
	}

	public void setActuator(Actuator actuator) {
		this.actuator = actuator;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RULE_RULE_ID", nullable = false)
	public Rule getRule() {
		return this.rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}
	
	@Column(name = "LABEL", length = 100)
	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Column(name = "STATUS", length = 45)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "VALUE", precision = 22, scale = 0)
	public Double getValue() {
		return this.value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Transient
	public boolean isNew() {
		return null == this.getId();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RuleAction [ruleActionId=").append(ruleActionId)
				.append(", actuator=").append(actuator).append(", rule=")
				.append(rule).append(", label=").append(label)
				.append(", status=").append(status).append(", value=")
				.append(value).append("]");
		return builder.toString();
	}
}
