package springGameTest.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springGameTest.domain.HomeVO;
import springGameTest.model.User;
import springGameTest.service.EventService;
import springGameTest.service.ViewService;
import springGameTest.test.GameMock;

@Controller
public class HomeController {

	@RequestMapping("/index.html")
	@ModelAttribute("info")
	public HomeVO getUserHome() {
		User user = GameMock.user;
		EventService.addEventToUser(user, "Sword skill: "+user.getSkills().
				getUserSkillByName("Sword Crafting").getRating());
		EventService.addEventToUser(user, "Dagger skill: "+user.getSkills().
				getUserSkillByName("Dagger Crafting").getRating());
		return ViewService.getHomeVOByUserId(1);
	}

}
