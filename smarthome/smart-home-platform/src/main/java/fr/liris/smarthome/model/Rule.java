package fr.liris.smarthome.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.synyx.hades.domain.Persistable;

@Entity
@Table(name = "rule")
public class Rule implements java.io.Serializable, Persistable<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6796111620764250316L;

	private Long ruleId;
	
	private Sensor sensor;
	private String name;
	private String inferenceType;
	private String deduce;
	private String suggest;
	private String unit;
	private Double value;
	private Set<RuleAction> ruleActions = new HashSet<RuleAction>(0);

	public Rule() {
	}

	public Rule(Sensor sensor) {
		this.sensor = sensor;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "RULE_ID", unique = true, nullable = false)
	public Long getId() {
		return this.ruleId;
	}
	
	public void setId(Long ruleId) {
		this.ruleId = ruleId;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SENSOR_SENSOR_ID", nullable = false)
	public Sensor getSensor() {
		return this.sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "INFERENCE_TYPE", length = 45)
	public String getInferenceType() {
		return this.inferenceType;
	}

	public void setInferenceType(String inferenceType) {
		this.inferenceType = inferenceType;
	}

	@Column(name = "DEDUCE", length = 45)
	public String getDeduce() {
		return this.deduce;
	}

	public void setDeduce(String deduce) {
		this.deduce = deduce;
	}

	@Column(name = "SUGGEST", length = 45)
	public String getSuggest() {
		return this.suggest;
	}

	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}

	@Column(name = "UNIT", length = 45)
	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "VALUE", precision = 22, scale = 0)
	public Double getValue() {
		return this.value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "rule")
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rule [ruleId=").append(ruleId)
//				.append(", sensor=").append(sensor)
				.append(", name=").append(name)
				.append(", inferenceType=").append(inferenceType)
				.append(", deduce=").append(deduce).append(", suggest=")
				.append(suggest).append(", unit=").append(unit)
				.append(", value=").append(value)
//				.append(", ruleActions=").append(ruleActions)
				.append("]");
		return builder.toString();
	}
}