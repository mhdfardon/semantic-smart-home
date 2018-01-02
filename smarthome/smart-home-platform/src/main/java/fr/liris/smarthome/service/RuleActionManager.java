package fr.liris.smarthome.service;

import java.util.List;

import fr.liris.smarthome.model.RuleAction;

public interface RuleActionManager {
	
	public List<RuleAction> getRuleActions(Long ruleId);
	
	void createNewAction(RuleAction ruleAction);
}
