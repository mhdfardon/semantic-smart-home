package fr.liris.semantic.service.impl;

import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.reasoner.rulesys.GenericRuleReasoner;
import com.hp.hpl.jena.reasoner.rulesys.Rule;

import fr.liris.semantic.m3.common.ExecuteSparqlGeneric;
import fr.liris.semantic.m3.common.ReadFile;
import fr.liris.semantic.m3.common.VariableSparql;
import fr.liris.semantic.model.SensorRule;
import fr.liris.semantic.service.SensorRuleService;

@Service("sensorRuleService")
public class SensorRuleServiceImpl implements SensorRuleService {

	private static final Logger logger = LoggerFactory.getLogger(SensorRuleServiceImpl.class);

	public static long TIME_REASONING = 0;
	public static long TIME_SPARQL_QUERY = 0;
	public static long TIME_ACCESS_SENSOR_DATA = 0;

	public static final String HOME_M3_SENSOR_DATA = "dataset/sensor_data/senml_m3_home_data.rdf";
	public static final String ROOT_OWL_WAR = "ont/m3/";
	public static final String ROOT_DATASET_WAR = "dataset/";
	public static final String HOME_ONTOLOGY_PATH = ROOT_OWL_WAR + "home";
	public static final String HOME_DATASET_PATH = ROOT_DATASET_WAR + "home-dataset";
	public static String NS_M3= "http://sensormeasurement.appspot.com/m3#";
	public static String NS_LOV4IOT= "http://sensormeasurement.appspot.com/ont/m3/lov4iot#";
	public static String NS_HOME_ONTOLOGY= "http://sensormeasurement.appspot.com/ont/m3/home#";


	public static String ROOT_SPARQL_TEMPLATE = "SPARQL/template/";
	public static String LINKED_OPEN_RULES_HOME = "RULES/LinkedOpenRulesHome.txt";
	public static String SPARQL_QUERY_GENERIC = ROOT_SPARQL_TEMPLATE + "m3SparqlGeneric.sparql";
	public static String SPARQL_QUERY_LIGHT_PRESENCE = ROOT_SPARQL_TEMPLATE + "testLightPresence.sparql";

	public Model model;
	String kindJDO;
	String keynameJDO;
	String query;
	
	public ArrayList<SensorRule> getLinkedOpenRules(String measurementName) throws IOException {
		
//		Model model = ModelFactory.createDefaultModel();
		this.model = ModelFactory.createDefaultModel();
		ReadFile.enrichJenaModelOntologyDataset(model, HOME_M3_SENSOR_DATA);
		
		ReadFile.enrichJenaModelOntologyDataset(this.model, ROOT_OWL_WAR + "m3");
		ReadFile.enrichJenaModelOntologyDataset(this.model, HOME_ONTOLOGY_PATH);
		ReadFile.enrichJenaModelOntologyDataset(this.model, HOME_DATASET_PATH);

		//variable in the sparql query
		ArrayList<VariableSparql> var = new ArrayList<VariableSparql>();
		var.add(new VariableSparql("inferTypeUri", NS_M3 + "RoomTemperature", false));// RoomTemperature, Noise
		var.add(new VariableSparql("typeRecommendedUri", NS_HOME_ONTOLOGY + "Status", false));// RoomTemperature, Noise
		
		

		long startTime = System.currentTimeMillis();


		model = ModelFactory.createDefaultModel();
		Model model = ModelFactory.createDefaultModel();
		ReadFile.enrichJenaModelOntologyDataset(model, HOME_M3_SENSOR_DATA);

		long stopTime = System.currentTimeMillis();
		TIME_ACCESS_SENSOR_DATA = stopTime - startTime;

		logger.info("LOAD JDO (Google App engine) SENSOR DATA in milliseconds: " + TIME_ACCESS_SENSOR_DATA);


		Model inf = reasonWithJenaRules(LINKED_OPEN_RULES_HOME);//reasoner for jena rules //Var.LINKED_OPEN_RULES

		//TO MEASURE SPARQL QUERY PERFORMANCE
		startTime = System.currentTimeMillis();
		ExecuteSparqlGeneric reqSenml = new ExecuteSparqlGeneric(inf, SPARQL_QUERY_GENERIC);

		//TO MEASURE SPARQL QUERY PERFORMANCE
		stopTime = System.currentTimeMillis();
		TIME_SPARQL_QUERY= stopTime - startTime;
		logger.info("SPARQL QUERY in milliseconds: " + TIME_SPARQL_QUERY);

		//inf.write(System.out);
		ArrayList<SensorRule> linkedOpenRules = reqSenml.getSelectResultAnsParseIt(var);

		logger.info("Rules List size = {}", linkedOpenRules.size());
		for(SensorRule sensorRule : linkedOpenRules) {
			logger.info("Rule found = {}", sensorRule);
		}
		return linkedOpenRules;
	}
	
	
	/**
	 * Apply the jena reasoner
	 * @param file where are the jena rules
	 * @return the model with inference
	 */
	private Model reasonWithJenaRules(String file){

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
