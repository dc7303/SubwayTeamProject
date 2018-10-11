package subway.user.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<OrderDTO> myMenuSelect(String userID) {
        List<OrderDTO> list = null;
        try {
            list = orderService.myMenuSelect(userID);
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
           
        } catch (SQLException e) {
            e.printStackTrace();
            FailView.errorMessage(e.getMessage());
        }
        return list;
    }
    
    public static List<IngredientDTO> menuList(String category) {
        List<IngredientDTO> list = new ArrayList<>();
        try {
            list = orderService.menuList(category);
           
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
        }catch(SQLException e) {
            e.printStackTrace();
            FailView.errorMessage(e.getMessage());
        }
        return orderDTO;
    }
    
}



