package springGameTest.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView processBuyOrder(
			@RequestParam(value="buyingQuantity", required=true) String buyingQuantity,
			@RequestParam(value="itemId", required=true) String itemId) {
		MarketVO marketVO = ViewService.getMarketVOByUserId(1);
		UserService.processBuyOrder(marketVO.getUser(), marketVO.getMarketInventory(),
				itemId, buyingQuantity);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("market");
        mav.addObject("info", marketVO);
        return mav;
	}

	@RequestMapping("/marketSell.html")
	@ModelAttribute("info")
	public ModelAndView processSellOrder(
			@RequestParam(value="itemId", required=true) String itemId) {
		MarketVO marketVO = ViewService.getMarketVOByUserId(1);
		UserService.processSellOrder(marketVO.getUser(), marketVO.getInventory(),
				itemId);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("market");
        mav.addObject("info", marketVO);
        return mav;
	}

}
