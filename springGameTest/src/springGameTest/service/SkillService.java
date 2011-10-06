package springGameTest.service;

import springGameTest.Constants;
import springGameTest.model.Item;
import springGameTest.model.Skill;
import springGameTest.model.User;
import springGameTest.model.UserSkill;
import springGameTest.model.UserSkillGroup;
import springGameTest.test.GameMock;

public class SkillService {
	
	public static void grantSkillToUser (User user, Skill newSkill) {
		if (newSkill == null || user == null) return;
		if (user.getSkills().hasSkill(newSkill.getName())) return;
		user.getSkills().addUserSkill(new UserSkill(newSkill));
		grantSkillToUser(user, newSkill.getParentSkill());
	}

	public static double getSkillRating(UserSkillGroup skillGroup, Item recipe) {
		UserSkill skill;
		double skillRating = 0;
		long divisor = 1;
		if (recipe.getName().equals(Constants.swordName)) {
			skill = skillGroup.getUserSkillByName(Constants.skillSwordCrafting);
		}
		else {
			skill = skillGroup.getUserSkillByName(Constants.skillDaggerCrafting);
		}
		
		while (skill != null) {
			skillRating = skillRating + skill.getRating()/divisor;
			divisor *= 2;
			skill = skillGroup.getUserSkillByName(skill.getSkill().getParentSkillName());
		}
		return skillRating;
	}

	public static void increaseSkill(UserSkillGroup skillGroup, Item recipe,
			double increaseAmount) {
		UserSkill skill;
		if (recipe.getName().equals(Constants.swordName)) {
			skill = skillGroup.getUserSkillByName(Constants.skillSwordCrafting);
		}
		else {
			skill = skillGroup.getUserSkillByName(Constants.skillDaggerCrafting);
		}
		
		while (skill != null) {
			increaseSkill(skill, increaseAmount);
			skill = skillGroup.getUserSkillByName(skill.getSkill().getParentSkillName());
		}
		
	}

	private static void increaseSkill(UserSkill skill, double increaseAmount) {
		double rating = skill.getRating();
		double difficulty = skill.getDifficulty();
		
		rating = rating == 0 ? 1 : rating;
		increaseAmount = increaseAmount == 0 ? 1 : increaseAmount;
		double actualIncrease = increaseAmount/difficulty;
		double baseIncrease = rating/difficulty;
		
		if (actualIncrease > baseIncrease) {
			actualIncrease = baseIncrease + Math.log(actualIncrease - baseIncrease);
		}
		
		EventService.addEventToUser(GameMock.user, "actualIncrease: "+
				actualIncrease+"|baseIncrease: "+baseIncrease);
		skill.setRating(rating + actualIncrease);
	}
	

}
