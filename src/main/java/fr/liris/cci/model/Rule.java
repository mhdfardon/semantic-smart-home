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
@Table(name = "rule")
public class Rule implements java.io.Serializable, Persistable<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6796111620764250316L;

	private Long ruleId;
	
	@Column(name = "NAME", length = 100)
	private String name;
	@Column(name = "NAME", length = 50)
	private String inferenceType;
	@Column(name = "NAME", length = 50)
	private String deduce;
	@Column(name = "UNIT", length = 50)
	private String unit;
	@Column(name = "SUGGEST", length = 50)
	private String suggest;
	@Column(name = "VALUE")
	private double value;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "RULE_ID", unique = true, nullable = false)
	public Long getId() {
		return this.ruleId;
	}
	
	public void setId(Long ruleId) {
		this.ruleId = ruleId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInferenceType() {
		return inferenceType;
	}

	public void setInferenceType(String inferenceType) {
		this.inferenceType = inferenceType;
	}

	public String getDeduce() {
		return deduce;
	}

	public void setDeduce(String deduce) {
		this.deduce = deduce;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getSuggest() {
		return suggest;
	}

	public void setSuggest(String suggest) {
		this.suggest = suggest;
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