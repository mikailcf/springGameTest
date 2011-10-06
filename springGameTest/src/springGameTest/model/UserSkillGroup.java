package springGameTest.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserSkillGroup {

	private final Map<String, UserSkill> userSkillList;
	
	public UserSkillGroup() {
		userSkillList = new HashMap<String, UserSkill>();
	}

	public UserSkill getUserSkillByName (String skillName) {
		return userSkillList.get(skillName);
	}

	public void addUserSkill(UserSkill userSkill) {
		userSkillList.put(userSkill.getName(), userSkill);
	}
	
	public void clear() {
		userSkillList.clear();
	}
	
	public void remove(String skillName) {
		userSkillList.remove(skillName);
	}

	public boolean hasSkill(String skillName) {
		return userSkillList.containsKey(skillName);
	}

	public boolean equals(UserSkillGroup other) {
		if (!(this.userSkillList.keySet().equals(other.keySet()))) {
			return false;
		}
		for (String propertyName: this.userSkillList.keySet()) {
			if (!(this.userSkillList.get(propertyName).
					equals(other.userSkillList.get(propertyName)))) {
				return false;
			}
		}
		return true;
	}

	public Set<String> keySet() {
		return userSkillList.keySet();
	}

	public int size() {
		return userSkillList.size();
	}

	public Collection<UserSkill> values() {
		return userSkillList.values();
	}
	
	public String toString() {
		String result = "";
		for (String propertyName: userSkillList.keySet()) {
			result = result + (result.equals("") ? "[" : ", ") +
					propertyName + ":" +userSkillList.get(propertyName);
		}
		return result + "]";
	}

}
