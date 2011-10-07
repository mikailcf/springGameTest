package springGameTest.service;

import springGameTest.model.Recipe;
import springGameTest.model.Skill;
import springGameTest.model.User;
import springGameTest.model.UserSkill;
import springGameTest.model.UserSkillGroup;

public class SkillService {
	
	public static void grantSkillToUser (User user, Skill newSkill) {
		if (newSkill == null || user == null) return;
		if (user.getSkills().hasSkill(newSkill.getName())) return;
		user.getSkills().addUserSkill(new UserSkill(newSkill));
		grantSkillToUser(user, newSkill.getParentSkill());
	}

	public static double getSkillRating(UserSkillGroup skillGroup, Recipe recipe) {
		UserSkill skill;
		double skillRating = 0;
		long divisor = 1;
		skill = skillGroup.getUserSkillByName(recipe.getSkill().getName());
		
		while (skill != null) {
			skillRating = skillRating + skill.getRating()/divisor;
			divisor *= 2;
			skill = skillGroup.getUserSkillByName(skill.getSkill().getParentSkillName());
		}
		return skillRating;
	}

	public static void increaseSkill(UserSkillGroup skillGroup, Recipe recipe,
			double increaseAmount) {
		UserSkill skill;
		skill = skillGroup.getUserSkillByName(recipe.getSkill().getName());
		
		while (skill != null) {
			increaseSkill(skill, increaseAmount);
			skill = skillGroup.getUserSkillByName(skill.getSkill().getParentSkillName());
		}
		
	}

	private static void increaseSkill(UserSkill skill, double increaseAmount) {
		double rating = skill.getRating();
		double difficulty = skill.getDifficulty();
		
		rating = rating == 0 ? 1 : rating;
		increaseAmount = increaseAmount < 1 ? 1 : increaseAmount;
		increaseAmount = Math.sqrt(increaseAmount);
		double actualIncrease = increaseAmount/difficulty;
		double baseIncrease = rating/difficulty + 1;
		
		if (actualIncrease > baseIncrease) {
			actualIncrease = baseIncrease +
					Math.max(0, Math.log(actualIncrease - baseIncrease));
		}
		
		skill.setRating(rating + actualIncrease);
	}
	

}
