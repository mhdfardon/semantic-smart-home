package fr.liris.smarthome.service;

import java.util.List;

import fr.liris.smarthome.model.Rule;

public interface RuleManager {
	
	public Rule getById(Long ruleId);
	
	public List<Rule> getSensorRules(Long sensorId);
}
