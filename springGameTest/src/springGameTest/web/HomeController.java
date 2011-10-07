package springGameTest.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springGameTest.domain.HomeVO;
import springGameTest.service.ViewService;

@Controller
public class HomeController {

	@RequestMapping("/index.html")
	@ModelAttribute("info")
	public HomeVO getUserHome() {
		return ViewService.getHomeVOByUserId(1);
	}

}
