package fr.liris.smarthome.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.liris.smarthome.data.RuleDao;
import fr.liris.smarthome.model.Rule;
import fr.liris.smarthome.service.RuleManager;

@Service("ruleManager")
@Transactional
public class RuleManagerImpl implements RuleManager {
	
	@Autowired
	private RuleDao ruleDao;

	/*
	 * (non-Javadoc)
	 * @see fr.liris.smarthome.service.RuleManager#getSensorRules(java.lang.Long)
	 */
	@Override
	public List<Rule> getSensorRules(Long sensorId) {
		List<Rule> rules = new ArrayList<Rule>();
		
		return rules;
	}

	@Override
	public Rule getById(Long ruleId) {
		return ruleDao.readByPrimaryKey(ruleId);
	}
}
