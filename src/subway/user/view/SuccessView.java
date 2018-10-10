package subway.user.view;


import java.util.List;

import subway.user.model.dto.OrderDTO;

public class SuccessView {
	
	public static void successMessage(String message) {
		System.out.println(message);
	}

	
	public static void listView(List<OrderDTO> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
 
}
