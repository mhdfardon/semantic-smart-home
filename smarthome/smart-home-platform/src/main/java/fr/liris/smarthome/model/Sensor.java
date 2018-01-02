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
	
	public Sensor() {
	}
	
	public Sensor(String name, String type, String measure, String unit) {
		this.name = name;
		this.type = type;
		this.measure = measure;
		this.unit = unit;
	}

	public Sensor(String name, String type, String measure, String unit, Double value, Set<Rule> rules) {
		this.name = name;
		this.type = type;
		this.measure = measure;
		this.unit = unit;
		this.value = value;
		this.rules = rules;
	}

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

	@Column(name = "TYPE", length = 45)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "MEASURE", length = 45)
	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	@Column(name = "UNIT", length = 45)
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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "sensor")
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sensor [sensorId=").append(sensorId).append(", name=")
				.append(name).append(", type=").append(type)
				.append(", measure=").append(measure).append(", unit=")
				.append(unit).append(", value=").append(value)
				.append("]");
		return builder.toString();
	}
}
