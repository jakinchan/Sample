package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.Item;
import logic.Shop;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller {

	private Shop shopService;

	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// ���i�ꗗ�����擾
		List<Item> itemList = this.shopService.getItemList();

		// ���f���̍쐬
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemList", itemList);

		// �߂�l�ƂȂ�ModelAndView�C���X�^���X���쐬
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/index.jsp");
		modelAndView.addAllObjects(model);

		return modelAndView;
	}
}