package springGameTest.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springGameTest.domain.CraftVO;
import springGameTest.service.UserService;
import springGameTest.service.ViewService;

@Controller
public class CraftController {

	@RequestMapping("/workbench.html")
	@ModelAttribute("info")
	public CraftVO getUserWorkbench() {
		CraftVO craftVO = ViewService.getCraftResult(new Integer(1));
		ViewService.removeCraftResult(craftVO);
		return craftVO;
	}

	@RequestMapping("/workbenchSelect.html")
	@ModelAttribute("info")
	public String processWorkbenchSelect(
			@RequestParam(value="recipeId", required=true) String recipeId) {
		CraftVO craftVO = ViewService.getCraftVOByUserId(1);
		if (UserService.processWorkbenchSelect(craftVO, recipeId)) {
			craftVO.setViewPage("select");
			ViewService.setCraftResult(craftVO);
		}
		else ViewService.removeCraftResult(craftVO);
		return "redirect:workbench.html";
	}

	@RequestMapping("/workbenchCraft.html")
	@ModelAttribute("info")
	public String processCraftOrder(
			@RequestParam(value="recipeId", required=true) String recipeId,
			@RequestParam(value="resourceId", required=true) String resourceId) {
		CraftVO craftVO = ViewService.getCraftVOByUserId(1);
		if (UserService.processCraftOrder(craftVO, recipeId, resourceId)) {
			craftVO.setViewPage("craft");
			ViewService.setCraftResult(craftVO);
		}
		else ViewService.removeCraftResult(craftVO);
		return "redirect:workbench.html";
	}

}