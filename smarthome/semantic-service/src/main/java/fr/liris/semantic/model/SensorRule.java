/*******************************************************************************
    Machine to Machine Measurement (M3) Framework 
    Copyright(c) 2012 - 2015 Eurecom

    M3 is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.


    M3 is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with M3. The full GNU General Public License is 
   included in this distribution in the file called "COPYING". If not, 
   see <http://www.gnu.org/licenses/>.

  Contact Information
  M3 : gyrard__at__eurecom.fr, bonnet__at__eurecom.fr, karima.boudaoud__at__unice.fr
  
The M3 framework has been designed and implemented during Amelie Gyrard's thesis.
She is a PhD student at Eurecom under the supervision of Prof. Christian Bonnet (Eurecom) and Dr. Karima Boudaoud (I3S-CNRS/University of Nice Sophia Antipolis).
This work is supported by the Com4Innov platform of the Pole SCS and DataTweet (ANR-13-INFR-0008). 
  
  Address      : Eurecom, Campus SophiaTech, 450 Route des Chappes, CS 50193 - 06904 Biot Sophia Antipolis cedex, FRANCE

 *******************************************************************************/
package fr.liris.semantic.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
/**
 * Object to represent the sensor measurements after the reasoning
 * @author Amelie gyrard
 *
 */
@XmlRootElement(name = "sensorDataInferred")
public class SensorRule {
	
	String name;
	String unit;
	String value;
	String inferType;//exemple domain=health and typemeasurement=temperature then newtype=body temperature
	String deduce;
	String suggest;
	
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	@XmlElement
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@XmlElement
	public String getInferType() {
		return inferType;
	}
	public void setInferType(String inferType) {
		this.inferType = inferType;
	}
	
	@XmlElement
	public String getDeduce() {
		return deduce;
	}
	public void setDeduce(String deduce) {
		this.deduce = deduce;
	}
	
	@XmlElement
	public String getSuggest() {
		return suggest;
	}
	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SensorRule [name=").append(name).append(", unit=")
				.append(unit).append(", value=").append(value)
				.append(", inferType=").append(inferType).append(", deduce=")
				.append(deduce).append(", suggest=").append(suggest)
				.append("]");
		return builder.toString();
	}	
}