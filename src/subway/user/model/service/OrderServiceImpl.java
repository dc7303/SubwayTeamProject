package subway.user.model.service;

import java.sql.SQLException;
import java.util.List;

import subway.user.model.dao.OrderDAO;
import subway.user.model.dao.OrderDAOImpl;
import subway.user.model.dto.OrderDTO;

public class OrderServiceImpl implements OrderService {
	private OrderDAO orderDAO = new OrderDAOImpl();
	
	@Override
	public int orderInsert(OrderDTO orderDTO) throws SQLException {
		int result = orderDAO.orderInsert(orderDTO);
		if (result == 0) {
			throw new SQLException("orderInsert ½ÇÆÐ");
		}
		return result;
	}

	@Override
	public List<OrderDTO> orderSelect(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDTO> myMenuSelect(String userID) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
