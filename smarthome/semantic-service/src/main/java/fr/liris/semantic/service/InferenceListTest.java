package fr.liris.semantic.service;

import java.util.ArrayList;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import fr.liris.semantic.m3.common.M2MAppGeneric;
import fr.liris.semantic.m3.common.ReadFile;
import fr.liris.semantic.m3.common.VariableSparql;

public class InferenceListTest {
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
	
	public static void main(String args[]) {
		try{
//			System.out.println("measurementName: " + measurementName);
			//load the M2M measurement
			//M2MAppGeneric m2mappli = new M2MAppGeneric(Var.KIND_JDO_HOME, Var.KEY_NAME_JDO_HOME);
			Model model = ModelFactory.createDefaultModel();
			ReadFile.enrichJenaModelOntologyDataset(model, HOME_M3_SENSOR_DATA);
			M2MAppGeneric m2mappli = new M2MAppGeneric(model);

			
			ReadFile.enrichJenaModelOntologyDataset(m2mappli.model, ROOT_OWL_WAR + "m3");
			ReadFile.enrichJenaModelOntologyDataset(m2mappli.model, HOME_ONTOLOGY_PATH);
			ReadFile.enrichJenaModelOntologyDataset(m2mappli.model, HOME_DATASET_PATH);

			//variable in the sparql query
			ArrayList<VariableSparql> var = new ArrayList<VariableSparql>();
			var.add(new VariableSparql("inferTypeUri", NS_M3 + "RoomTemperature", false));// RoomTemperature, Noise
			var.add(new VariableSparql("typeRecommendedUri", NS_HOME_ONTOLOGY + "Status", false));// RoomTemperature, Noise
			
			 String result = m2mappli.executeLinkedOpenRulesAndSparqlQuery(SPARQL_QUERY_GENERIC, var, LINKED_OPEN_RULES_HOME);
//			 return result;
			 System.out.println("Result =\n" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
