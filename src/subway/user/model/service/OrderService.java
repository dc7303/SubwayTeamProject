package subway.user.model.service;

import java.sql.SQLException;
import java.util.List;

import subway.admin.dto.IngredientDTO;
import subway.user.model.dto.OrderDTO;

public interface OrderService {

    /**
     * 
     * @param orderDTO
     * @return
     */
    public int orderInsert(OrderDTO orderDTO) throws SQLException;

    public List<OrderDTO> orderSelect(String userId) throws SQLException;

    public List<OrderDTO> myMenuSelect(String userID) throws SQLException;

    public int myMenuUpdate(OrderDTO orderDTO) throws SQLException;
    
    public int myMenuDelete(String orderID) throws SQLException;
    
    public List<IngredientDTO> menuList() throws SQLException;

}
