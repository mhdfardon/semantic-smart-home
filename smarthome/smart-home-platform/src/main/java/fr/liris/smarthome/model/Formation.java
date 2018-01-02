package fr.liris.smarthome.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.synyx.hades.domain.Persistable;

@Entity
@Table(name = "formation")
public class Formation implements java.io.Serializable, Persistable<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 644966583978153439L;

	private Long formationId;
	private String formationName;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "FORMATION_ID", unique = true, nullable = false)
	public Long getId() {
		return this.formationId;
	}

	public void setId(Long formationId) {
		this.formationId = formationId;
	}

	@Column(name = "FORMATION_NAME", length = 45)
	public String getFormationName() {
		return formationName;
	}

	public void setFormationName(String formationName) {
		this.formationName = formationName;
	}

//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "STUDENT_HAS_FORMATION", 
//	joinColumns = { @JoinColumn(name = "FORMATION_ID", nullable = false, updatable = false) }, 
//	inverseJoinColumns = { @JoinColumn(name = "STUDENT_ID", nullable = false, updatable = false) })
//	public Set<Student> getStudents() {
//		return students;
//	}
//
//	public void setStudents(Set<Student> students) {
//		this.students = students;
//	}

	@Transient
	public boolean isNew() {
		return null == this.getId();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Formation [formationId=").append(formationId)
		.append(", formationName=").append(formationName).append("]");
		return builder.toString();
	}

}
