package subway.user.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import subway.user.model.dao.OrderDAO;
import subway.user.model.dao.OrderDAOImpl;
import subway.user.model.dto.OrderDTO;

public class OrderServiceImpl implements OrderService {
	private OrderDAO orderDAO = new OrderDAOImpl();
	
	@Override
	public int orderInsert(OrderDTO orderDTO) throws SQLException {
		int result = orderDAO.orderInsert(orderDTO);
		if (result == 0) {
			throw new SQLException("orderInsert ����");
		}
		return result;
	}

	@Override
	public List<OrderDTO> orderSelect(String userId) throws SQLException {
		List<OrderDTO> list = orderDAO.orderSelect(userId);
		return list;
	}
	
	
	@Override
	public List<Vector<Object>> orderSelectVector(String userId, boolean isMyMenu) throws SQLException {
		List<Vector<Object>> vList = orderDAO.orderSelectVector(userId, isMyMenu);
		if(vList==null || vList.size()==0)
			throw new SQLException("�˻��� ������ �����ϴ�.");
		return vList;
	}

	@Override
	public List<OrderDTO> myMenuSelect(String userID) throws SQLException {
		List<OrderDTO> list = orderDAO.myMenuSelect(userID);
		if(list==null) {
			throw new SQLException("������ �޴� ����Ʈ�� �ҷ����µ� �����߽��ϴ�.");
		}
		return list;
	}

}
