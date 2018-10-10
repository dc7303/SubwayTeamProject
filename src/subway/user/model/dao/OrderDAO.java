package subway.user.model.dao;

import java.sql.SQLException;
import java.util.List;

import subway.admin.dto.IngredientDTO;
import subway.user.model.dto.OrderDTO;

public interface OrderDAO {
	/**
	 * 
	 * @param orderDTO
	 * @param vegDTO
	 * @return 
	 * @throws SQLException
	 */
	public int orderInsert (OrderDTO orderDTO) throws SQLException;
	
	public List<OrderDTO> orderSelect(String userId) throws SQLException;
	
	public List<OrderDTO> myMenuSelect(String userID) throws SQLException;
	
	public List<IngredientDTO> menuList() throws SQLException;
}
