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
            SuccessView.listView(list);
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
            SuccessView.listView(list);
        } catch (SQLException e) {
            e.printStackTrace();
            FailView.errorMessage(e.getMessage());
        }
        return list;
    }

    public static List<IngredientDTO> menuList() {
        List<IngredientDTO> list = null;
        try {
            list = orderService.menuList();
            SuccessView.menuListView(list);
        } catch (SQLException e) {
            e.printStackTrace();
            FailView.errorMessage(e.getMessage());
        }
        return list;
    }
}
