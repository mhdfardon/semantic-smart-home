package fr.liris.smarthome.model;

// Generated 27 oct. 2010 13:51:30 by Hibernate Tools 3.2.4.GA

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.synyx.hades.domain.Persistable;

/**
 * Objet metier utilise pour les periodes
 */
@Entity
@Table(name = "PERIOD")
public class Period implements java.io.Serializable, Persistable<Integer> {

	private static final long serialVersionUID = -4859902547073423523L;
	
	/**
	 * Identifiant de la periode
	 */
	private Integer periodId;
	
	/**
	 * Date de debut de la periode
	 */
	private Date startDate;
	
	/**
	 * Date de fin de la periode
	 */
	private Date endDate;
	
	/**
	 * Type de la periode (SPECIAL_OPENING, SPECIAL_CLOSING...)
	 */
	private Type periodType;

	/**
	 * Type de la periode
	 * Pour l'instant, Huit types de profils existent :
	 * - Organisme
	 * - Hyperviseur plateforme telephonique
	 * - PRM
	 * - Certi
	 * - National
	 * - OBS
	 * - Atos
	 */
	public static enum Type {
		SPECIAL_OPENING((String) "SPECIAL_OPENING"),
		SPECIAL_CLOSING((String) "SPECIAL_CLOSING");
		private final String type;
		private Type(String type){this.type = type;}
		public String getValue(){return this.type;}
	};
	
	@Transient
	public boolean isNew() {
		return null == this.getId();
	}

	/**
	 * @return the periodId
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PERIOD_ID", unique = true, nullable = false)
	public Integer getId() {
		return this.periodId;
	}

	/**
	 * @param periodId the periodId to set
	 */
	public void setId(Integer periodId) {
        this.periodId = periodId;
    }

	/**
	 * @return the periodType
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "PERIOD_TYPE", nullable = false, length = 15)
	public Type getPeriodType() {
		return this.periodType;
	}

	/**
	 * @param nodes the periodType to periodType
	 */
	public void setPeriodType(Type periodType) {
		this.periodType = periodType;
	}
	
	/**
	 * @return the startDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE", nullable = false, length = 19)
	public Date getStartDate() {
		return this.startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_DATE", nullable = false, length = 19)
	public Date getEndDate() {
		return this.endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * Constructeur par defaut
	 */
	public Period() {
	}

	/**
	 * Constructeur partiel
	 * 
	 * @param startDate La date de debut de la periode
	 * @param endDate La date de fin de la periode
	 * @param periodType Le type de la periode (SPECIAL_OPENING, SPECIAL_CLOSING...)
	 */
	public Period(Date startDate, Date endDate, Type periodType) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.periodType = periodType;
	}

	/**
	 * Constructeur complet
	 * 
	 * @param startDate date de debut de la periode
	 * @param endDate date de fin de la periode
	 * @param periodType type de la periode
	 * @param plannings les plannings associes a la periode
	 */
	public Period(Date startDate, Date endDate, Type periodType, Set<Planning> plannings) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.periodType = periodType;
	}

	/**
	 * Constructeur partiel
	 * 
	 * @param startDate date de debut de la periode
	 * @param endDate date de fin de la periode
	 * @param plannings les plannings associes a la periode
	 */
	public Period(Date startDate, Date endDate, Set<Planning> plannings) {
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	@Override
	public String toString() {		
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).
		append("periodId", this.periodId).
		append("startDate", this.startDate).
		append("endDate", this.endDate).
		append("periodType", periodType).
		toString();
	}	
}