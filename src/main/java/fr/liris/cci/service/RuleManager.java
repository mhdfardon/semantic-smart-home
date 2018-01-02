package fr.liris.cci.service;

import java.util.List;

import fr.liris.cci.model.Rule;

public interface RuleManager {
	
	public List<Rule> getSensorRules(Long sensorId);
}
