package subway.user.controller;

import java.sql.SQLException;
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
			SuccessView.successMessage("insert ¼º°ø!");
		} catch (SQLException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		return result;
	}
	
	public static List<OrderDTO> orderSelect(String userId) {
		
		return null;
	}
	
	public static List<OrderDTO> myMenuSelect(String userID) {
		
		return null;
	}
}
