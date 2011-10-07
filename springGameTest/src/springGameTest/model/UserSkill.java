package springGameTest.model;

public class UserSkill {
	
	private final Skill skill;
	private double rating;
	
	public UserSkill (Skill skill){
		this(skill, 1.0);
	}
	
	public UserSkill (Skill skill, double rating){
		this.skill = skill;
		this.rating = rating;
	}

	public Skill getSkill() {
		return skill;
	}

	public long getSkillId() {
		return skill.getSkillId();
	}

	public String getName() {
		return skill.getName();
	}

	public double getDifficulty() {
		return skill.getDifficulty();
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public String toString() {
		return skill.toString() + ", rating: " + rating;
	}

}
