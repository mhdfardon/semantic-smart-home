package fr.liris.cci.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.synyx.hades.domain.Persistable;

@Entity
@Table(name = "sensor")
public class Sensor implements java.io.Serializable, Persistable<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7387527859534364319L;

	private Long sensorId;
	
	private String name;
	private String type;
	private String measure;
	private String unit;
	private double value;
	private Set<Rule> rules = new HashSet<Rule>(0);

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SENSOR_ID", unique = true, nullable = false)
	public Long getId() {
		return this.sensorId;
	}

	public void setId(Long sensorId) {
		this.sensorId = sensorId;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "TYPE", length = 50)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "MEASURE", length = 50)
	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	@Column(name = "UNIT", length = 50)
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "VALUE")
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.REMOVE)
	@JoinTable(name = "SENSOR_HAS_RULE", joinColumns = { @JoinColumn(name = "SENSOR_ID", nullable = false, updatable = false) }, 
	inverseJoinColumns = { @JoinColumn(name = "RULE_ID", nullable = false, updatable = false) })	
	@OrderBy("name")
	public Set<Rule> getRules() {
		return rules;
	}

	public void setRules(Set<Rule> rules) {
		this.rules = rules;
	}

	@Transient
	public boolean isNew() {
		return null == this.getId();
	}
}
