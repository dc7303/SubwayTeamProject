package subway.user.view;

import java.util.List;

import subway.user.model.dto.OrderDTO;

public class SuccessView {
	
	public static void successMessage(String message) {
		System.out.println(message);
	}
	public static void SelectAll(List<OrderDTO> list) {
		for(OrderDTO orderDTO:list) {
			System.out.println(orderDTO);
		}
	}
	
}
