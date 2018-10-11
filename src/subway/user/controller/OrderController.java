package subway.user.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import subway.admin.dto.IngredientDTO;
import subway.user.model.dto.OrderDTO;
import subway.user.model.service.OrderService;
import subway.user.model.service.OrderServiceImpl;
import subway.user.view.FailView;
import subway.user.view.SuccessView;

public class OrderController {

    private static OrderService orderService = new OrderServiceImpl();

    public static int orderInsert(OrderDTO orderDTO) {
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
        try {
            list = orderService.orderSelect(userId);
            System.out.println(userId + "님이 선택한 메뉴");
            SuccessView.listView(list);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Vector<Object>> orderSelectVector(String userId, boolean isMyMenu){
		List<Vector<Object>> vList = new ArrayList<>();
		try {
			vList = orderService.orderSelectVector(userId, isMyMenu);
			SuccessView.vListView(vList);
		}catch(Exception e){
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		return vList;
	}
    
    public static List<OrderDTO> myMenuSelect(String userID) {
        List<OrderDTO> list = null;
        try {
            list = orderService.myMenuSelect(userID);
            SuccessView.listView(list);
        } catch (SQLException e) {
            e.printStackTrace();
            FailView.errorMessage(e.getMessage());
        }
        return list;
    }
    
    public static int myMenuUpdate(OrderDTO orderDTO) {
    	int result=0;
    	try {
            result = orderService.myMenuUpdate(orderDTO);
            SuccessView.successMessage("MY 메뉴 수정 성공!");
        } catch (SQLException e) {
            e.printStackTrace();
            FailView.errorMessage(e.getMessage());
        }
        return result;
    }
    
    public static int myMenuDelete(String orderID) {
    	int result=0;
    	try {
            result = orderService.myMenuDelete(orderID);
            SuccessView.successMessage("MY 메뉴 삭제 성공!");
        } catch (SQLException e) {
            e.printStackTrace();
            FailView.errorMessage(e.getMessage());
        }
        return result; 
    }

    public static List<IngredientDTO> menuList() {
        List<IngredientDTO> list = new ArrayList<>();
        try {
            list = orderService.menuList();
           SuccessView.menuListView(list);
        } catch (SQLException e) {
            e.printStackTrace();
            FailView.errorMessage(e.getMessage());
        }
        return list;
    }
    

    public static OrderDTO selectOrderById(int id) {
        OrderDTO orderDTO = null;
        try {
            orderDTO = orderService.selectOrderById(id);
            SuccessView.selectOrder(orderDTO);
        }catch(SQLException e) {
            e.printStackTrace();
            FailView.errorMessage(e.getMessage());
        }
        return orderDTO;
    }
}



