package subway.user.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import subway.user.model.dto.OrderDTO;

public interface OrderService {
	
	/**
	 * 
	 * @param orderDTO
	 * @return
	 */
	public int orderInsert (OrderDTO orderDTO) throws SQLException;
	
	public List<OrderDTO> orderSelect(String userId) throws SQLException;
	
	public List<Vector<Object>> orderSelectVector(String userId, boolean isMyMenu) throws SQLException;
	
	public List<OrderDTO> myMenuSelect(String userID) throws SQLException;
	
}
