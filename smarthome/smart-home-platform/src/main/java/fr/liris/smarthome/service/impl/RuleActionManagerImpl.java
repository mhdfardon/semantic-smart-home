package fr.liris.smarthome.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.liris.smarthome.data.RuleActionDao;
import fr.liris.smarthome.model.Actuator;
import fr.liris.smarthome.model.RuleAction;
import fr.liris.smarthome.service.RuleActionManager;

@Service("ruleActionManager")
@Transactional
public class RuleActionManagerImpl implements RuleActionManager {
	
	@Autowired
	private RuleActionDao ruleActionDao;

	/*
	 * (non-Javadoc)
	 * @see fr.liris.smarthome.service.RuleActionManager#getRuleActions(java.lang.Long)
	 */
	public List<RuleAction> getRuleActions(Long ruleId) {
		// TODO Auto-generated method stub
		List<RuleAction> actions = new ArrayList<RuleAction>();
		RuleAction action = new RuleAction();
		action.setId(1L);
		action.setLabel("Turn on BedRoom Air Conditionner");
		action.setStatus("ON");
		action.setValue(19.0);
		Actuator actuator = new Actuator();
		actuator.setId(1L);
		actuator.setName("BedRoom Air Conditionner");
		action.setActuator(actuator);
		return actions;
	}

	@Override
	public void createNewAction(RuleAction ruleAction) {
		ruleActionDao.save(ruleAction);
	}
}
