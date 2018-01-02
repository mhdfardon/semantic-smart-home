package fr.liris.cci.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.liris.cci.model.Rule;
import fr.liris.cci.service.RuleManager;

@Service("ruleManager")
@Transactional
public class RuleManagerImpl implements RuleManager {

	/*
	 * (non-Javadoc)
	 * @see fr.liris.cci.service.RuleManager#getSensorRules(java.lang.Long)
	 */
	@Override
	public List<Rule> getSensorRules(Long sensorId) {
		List<Rule> rules = new ArrayList<Rule>();
		
		Rule rule1 = new Rule();
		rule1.setId(1L);
		rule1.setName("Temperature");
		rule1.setValue(5);
		rule1.setUnit("Cel");
		rule1.setInferenceType("Room Temperature");
		rule1.setDeduce("AboveZeroTemperature");
		rule1.setSuggest("Alert");
		rules.add(rule1);
		
		rule1 = new Rule();
		rule1.setId(2L);
		rule1.setName("Temperature");
		rule1.setValue(23);
		rule1.setUnit("Cel");
		rule1.setInferenceType("Room Temperature");
		rule1.setDeduce("LowTemperature");
		rule1.setSuggest("Switch Off Heating");
		rules.add(rule1);
		
		rule1 = new Rule();
		rule1.setId(3L);
		rule1.setName("Temperature");
		rule1.setValue(55);
		rule1.setUnit("Cel");
		rule1.setInferenceType("Room Temperature");
		rule1.setDeduce("Heat");
		rule1.setSuggest("Switch On Air Conditioning");
		rules.add(rule1);
		
		return rules;
	}
}
