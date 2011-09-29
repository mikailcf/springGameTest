package springGameTest.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springGameTest.domain.MarketVO;
import springGameTest.service.UserService;
import springGameTest.service.ViewService;

@Controller
public class MarketController {

	@RequestMapping("/market.html")
	@ModelAttribute("info")
	public MarketVO getUserMarket() {
		return ViewService.getMarketVOByUserId(1);
	}

	@RequestMapping("/marketBuy.html")
	@ModelAttribute("info")
	public String processBuyOrder(
			@RequestParam(value="buyingQuantity", required=true) String buyingQuantity,
			@RequestParam(value="itemId", required=true) String itemId) {
		MarketVO marketVO = ViewService.getMarketVOByUserId(1);
		UserService.processBuyOrder(marketVO.getUser(), marketVO.getMarketInventory(),
				itemId, buyingQuantity);
		return "redirect:market.html";
	}

	@RequestMapping("/marketSell.html")
	@ModelAttribute("info")
	public String processSellOrder(
			@RequestParam(value="itemId", required=true) String itemId) {
		MarketVO marketVO = ViewService.getMarketVOByUserId(1);
		UserService.processSellOrder(marketVO.getUser(), marketVO.getInventory(),
				itemId);
		return "redirect:market.html";
	}

}
