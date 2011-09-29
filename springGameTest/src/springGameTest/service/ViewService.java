package springGameTest.service;

import java.util.HashMap;
import java.util.Map;

import springGameTest.domain.CraftVO;
import springGameTest.domain.HomeVO;
import springGameTest.domain.MarketVO;
import springGameTest.model.User;
import springGameTest.test.GameMock;

public class ViewService {

	private static final User user = GameMock.user;
	private static final Map<Integer, CraftVO> craftResult = new HashMap<Integer, CraftVO>();

	public static User getUserId(int userId) {
		return user;
	}

	public static HomeVO getHomeVOByUserId(long userId) {
		return new HomeVO(user);
	}

	public static MarketVO getMarketVOByUserId(long userId) {
		return new MarketVO(user);
	}

	public static CraftVO getCraftVOByUserId(long userId) {
		return new CraftVO(user);
	}

	public static CraftVO getCraftResult(Integer userId) {
		CraftVO craftVO = craftResult.get(userId);
		if (craftVO == null) return new CraftVO(user);
		return craftVO;
	}

	public static CraftVO setCraftResult(CraftVO craftVO) {
		Integer userId = new Integer(""+craftVO.getUser().getUserId());
		return craftResult.put(userId, craftVO);
	}

	public static CraftVO removeCraftResult(CraftVO craftVO) {
		return removeCraftResult(new Integer(""+craftVO.getUser().getUserId()));
	}

	public static CraftVO removeCraftResult(Integer userId) {
		return craftResult.remove(userId);
	}

}
