package fr.liris.semantic.service;

import java.io.IOException;
import java.util.ArrayList;

import fr.liris.semantic.model.SensorRule;

public interface SensorRuleService {
	
	ArrayList<SensorRule> getLinkedOpenRules(String measurementName) throws IOException;

}
