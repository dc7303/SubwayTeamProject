package subway.user.view;


import java.util.List;
import java.util.Vector;

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
	
	
	public static void vListView(List<Vector<Object>> vList) {
		for(int i = 0; i < vList.size(); i++) {
			System.out.println(vList.get(i));
		}
	}
}
