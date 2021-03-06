package org.verapdf.validation.profile.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Structure of the valid validation profile.
 *
 * @author Maksim Bezrukov
 */
public class ValidationProfile {
	private final String model;
	private final String name;
	private final String description;
	private final String creator;
	private final String created;
	private final String hash;

	private final Map<String, List<Rule>> rules;
	private final Map<String, List<Variable>> variables;

	/**
	 * Creates new Validation profile model with given description.
	 *
	 * @param model       model of the validation profile
	 * @param name        name of the validation profile
	 * @param description description of the validation profile
	 * @param creator     creator (author) of the validation profile
	 * @param created     date of creation of the validation profile
	 * @param hash        hash code of the validation profile
	 * @param rules       map of rules of the validation profile (key is the name of the
	 *                    object, value is the list of rules)
	 * @param variables   map of variables of the validation profile (key is the name of
	 *                    the object, value is the list of variables)
	 */
	public ValidationProfile(String model, String name, String description,
							 String creator, String created, String hash,
							 Map<String, List<Rule>> rules, Map<String, List<Variable>> variables) {
		this.model = model;
		this.name = name;
		this.description = description;
		this.creator = creator;
		this.created = created;
		this.hash = hash;
		this.rules = Collections.unmodifiableMap(rules);
		this.variables = Collections.unmodifiableMap(variables);
	}

	/**
	 * @return Text provided by attribute "model".
	 */
	public String getModel() {
		return this.model;
	}

	/**
	 * @return Text in tag "name".
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return Text in tag "description".
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @return Text in tag "creator".
	 */
	public String getCreator() {
		return this.creator;
	}

	/**
	 * @return Text in tag "created".
	 */
	public String getCreated() {
		return this.created;
	}

	/**
	 * @return Text in tag "hash".
	 */
	public String getHash() {
		return this.hash;
	}

	/**
	 * Get all rools for the given object.
	 *
	 * @param objName name of the object
	 * @return List of rules for the given object.
	 */
	public List<Rule> getRoolsForObject(String objName) {
		return this.rules.get(objName);
	}

	/**
	 * Get rule by it's id.
	 *
	 * @param id rule id
	 * @return rule by it's id or null, if there is no rule with such id.
	 */
	public Rule getRuleById(String id) {
		if (id == null) {
			return null;
		}

		for (List<Rule> ruleList : this.rules.values()) {
			for (Rule rule : ruleList) {
				if (rule != null && id.equals(rule.getAttrID())) {
					return rule;
				}
			}
		}

		return null;
	}

	/**
	 * @return list of all id of rules
	 */
	public List<String> getAllRulesId() {
		List<String> result = new ArrayList<>();

		for (List<Rule> ruleList : this.rules.values()) {
			for (Rule rule : ruleList) {
				if (rule != null) {
					result.add(rule.getAttrID());
				}
			}
		}

		return result;
	}

	/**
	 * Get all variables for the given object.
	 *
	 * @param objName name of the object
	 * @return List of variables for the given object.
	 */
	public List<Variable> getVariablesForObject(String objName) {
		if (this.variables.get(objName) != null) {
			return this.variables.get(objName);
		}
		return Collections.emptyList();
	}

	/**
	 * @return list of all variables
	 */
	public List<Variable> getAllVariables() {
		List<Variable> result = new ArrayList<>();

		for (List<Variable> variablesList : this.variables.values()) {
			result.addAll(variablesList);
		}

		return result;
	}
}
