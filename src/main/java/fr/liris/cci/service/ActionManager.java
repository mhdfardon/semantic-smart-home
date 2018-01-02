package fr.liris.cci.service;

import java.util.List;

import fr.liris.cci.model.RuleAction;

public interface ActionManager {
	
	public List<RuleAction> getRuleActions(Long ruleId);
	
	void createNewAction(RuleAction action);
}
