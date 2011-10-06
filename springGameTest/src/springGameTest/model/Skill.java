package springGameTest.model;

import java.util.HashMap;
import java.util.Map;

public class Skill {
	
	private static long nextSkillId;
	private static final Map<Integer, Skill> skillListById = new HashMap<Integer, Skill>();
	private static final Map<String, Skill> skillListByName = new HashMap<String, Skill>();
	
	private final long skillId;
	private final String name;
	private final double difficulty;
	private final Skill parentSkill;
	
	public Skill(String name, double difficulty, Skill parentSkill) {
		this.skillId = nextSkillId++;
		this.name = name;
		this.difficulty = difficulty;
		this.parentSkill = parentSkill;
		
		skillListById.put(new Integer(""+skillId), this);
		skillListByName.put(name, this);
	}

	public static Skill getSkillById(long skillId) {
		return getSkillById(new Integer(""+skillId));
	}

	public static Skill getSkillById(Integer skillId) {
		return skillListById.get(skillId);
	}

	public static Skill getSkillByName(String name) {
		return skillListByName.get(name);
	}

	public long getSkillId() {
		return skillId;
	}

	public String getName() {
		return name;
	}

	public double getDifficulty() {
		return difficulty;
	}

	public Skill getParentSkill() {
		return parentSkill;
	}

	public String getParentSkillName() {
		return parentSkill == null ? null : parentSkill.getName();
	}
	
}
