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
package fr.liris.semantic.m3.common;

import java.io.IOException;
import java.util.ArrayList;

import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.reasoner.rulesys.GenericRuleReasoner;
import com.hp.hpl.jena.reasoner.rulesys.Rule;

import fr.liris.semantic.model.SensorRule;

/**
 * The generic semantic-based IoT application
 * We try to design all application in this way
 * The other files in this package should be adapted to theis generic class
 * @author Amelie Gyrard
 *
 */
public class M2MAppGeneric {
	
	public static long TIME_REASONING = 0;
	public static long TIME_SPARQL_QUERY = 0;
	public static long TIME_ACCESS_SENSOR_DATA = 0;

	public Model model;
	String kindJDO;
	String keynameJDO;
	String query;


	public M2MAppGeneric() {
		model = ModelFactory.createDefaultModel();
	}
	
	//constructor with data stored in app engine
	public M2MAppGeneric(String kindJDO, String keynameJDO) {
		
		//TO MEASURE PERFORMANCE TO GET SENSOR DATA
		long startTime = System.currentTimeMillis();
		
		model = ModelFactory.createDefaultModel();
		this.kindJDO = kindJDO;
		this.keynameJDO = keynameJDO;
//		loadGoogleDatastoreIntoJenaModel();
		
		//TO MEASURE PERFORMANCE TO GET SENSOR DATA
		long stopTime = System.currentTimeMillis();
		TIME_ACCESS_SENSOR_DATA = stopTime - startTime;
		System.out.println("LOAD JDO (Google App engine) SENSOR DATA in milliseconds: " + TIME_ACCESS_SENSOR_DATA);

	}
	
	// constructor with data stored in a model
	public M2MAppGeneric(Model model) {
		this.model = model;
	}
	
	/**
	 * Execute Linked Open Rules
	 * Execute sparql query
	 * @param sparqlQuery
	 * @param var
	 * @param lor file file path with jena rules
	 * @return
	 * @throws IOException
	 */
	public String executeLinkedOpenRulesAndSparqlQuery(String sparqlQuery, ArrayList<VariableSparql> var, String pathLORfile) throws IOException{
		Model inf = reasonWithJenaRules(pathLORfile);//reasoner for jena rules //Var.LINKED_OPEN_RULES
		
		//TO MEASURE SPARQL QUERY PERFORMANCE
		long startTime = System.currentTimeMillis();
		ExecuteSparqlGeneric reqSenml = new ExecuteSparqlGeneric(inf, sparqlQuery);
		
		//TO MEASURE SPARQL QUERY PERFORMANCE
		long stopTime = System.currentTimeMillis();
		TIME_SPARQL_QUERY= stopTime - startTime;
		System.out.println("SPARQL QUERY in milliseconds: " + TIME_SPARQL_QUERY);
		ArrayList<SensorRule> linkedOpenRules = reqSenml.getSelectResultAnsParseIt(var);
		System.out.println("linkedOpenRules size = " + linkedOpenRules.size());
		
		String resultSparqlsenml = reqSenml.getSelectResultAsXML(var);
		return resultSparqlsenml;
	}
	
	ArrayList<SensorRule> getLinkedOpenRules(String sparqlQuery, ArrayList<VariableSparql> var, String pathLORfile) throws IOException{
			Model inf = reasonWithJenaRules(pathLORfile);//reasoner for jena rules //Var.LINKED_OPEN_RULES
			
			//TO MEASURE SPARQL QUERY PERFORMANCE
			long startTime = System.currentTimeMillis();
			ExecuteSparqlGeneric reqSenml = new ExecuteSparqlGeneric(inf, sparqlQuery);
			
			//TO MEASURE SPARQL QUERY PERFORMANCE
			long stopTime = System.currentTimeMillis();
			TIME_SPARQL_QUERY= stopTime - startTime;
			System.out.println("SPARQL QUERY in milliseconds: " + TIME_SPARQL_QUERY);
			
			//inf.write(System.out);
			ArrayList<SensorRule> linkedOpenRules = reqSenml.getSelectResultAnsParseIt(var);
			return linkedOpenRules;
	}

	/**
	 * Apply the jena reasoner
	 * @param file where are the jena rules
	 * @return the model with inference
	 */
	public Model reasonWithJenaRules(String file){
		
		long startTime = System.currentTimeMillis();		
		
		Reasoner reasoner = new GenericRuleReasoner(Rule.rulesFromURL(file));// read rules
		//for android use Rule.parseRule 
		reasoner.setDerivationLogging(true);
		InfModel inf = ModelFactory.createInfModel(reasoner, model); //apply the reasoner
		
		long stopTime = System.currentTimeMillis();
		TIME_REASONING = stopTime - startTime;
		System.out.println("time reasoning engine in milliseconds: " + TIME_REASONING);
		return inf;
	}

}