package fr.liris.cci.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.liris.cci.model.RuleAction;
import fr.liris.cci.model.Actuator;
import fr.liris.cci.service.ActionManager;

@Service("actionManager")
@Transactional
public class ActionManagerImpl implements ActionManager {

	@Override
	public List<RuleAction> getRuleActions(Long ruleId) {
		// TODO Auto-generated method stub
		List<RuleAction> actions = new ArrayList<RuleAction>();
		RuleAction action = new RuleAction();
		action.setId(1L);
		action.setLabel("Turn on BedRoom Air Conditionner");
		action.setStatus("ON");
		action.setValue(19);
		Actuator actuator = new Actuator();
		actuator.setId(1L);
		actuator.setName("BedRoom Air Conditionner");
		action.setActuator(actuator);
		return actions;
	}

	@Override
	public void createNewAction(RuleAction action) {
		// TODO Auto-generated method stub
	}
}
