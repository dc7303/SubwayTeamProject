package subway.user.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.omg.PortableInterceptor.SUCCESSFUL;

import subway.user.model.dto.OrderDTO;
import subway.user.model.service.OrderService;
import subway.user.model.service.OrderServiceImpl;
import subway.user.view.FailView;
import subway.user.view.SuccessView;

public class OrderController {
	private static OrderService orderService = new OrderServiceImpl();
	
	public static int orderInsert (OrderDTO orderDTO) {
		int result = 0;
		try {
			result = orderService.orderInsert(orderDTO);
			SuccessView.successMessage("insert 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		return result;
	}
	
	public static List<OrderDTO> orderSelect(String userId) {
		List<OrderDTO> list = new ArrayList<>();
		try{
			list = orderService.orderSelect(userId);
			System.out.println(userId+"님이 선택할 수 있는 메뉴");
			SuccessView.SelectAll(list);
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<OrderDTO> myMenuSelect(String userID) {
		
		return null;
	}
}
