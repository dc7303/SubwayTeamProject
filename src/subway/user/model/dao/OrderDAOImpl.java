package subway.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import subway.dbUtil.DBUtil;
import subway.user.model.dto.OrderDTO;

public class OrderDAOImpl implements OrderDAO {
	private Properties proFile = new DBUtil().getProFile();
	
	@Override
	public int orderInsert(OrderDTO orderDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO ORDERS VALUES(ORDER_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int result;
		//INSERT INTO ORDERS VALUES(ORDER_SEQ.NEXTVAL, 15, 'Ǯ����ũ', '���ɷ�', '��Ƽ', '��ġ�巹��', 5100,750,'C62',
		//'����� ���� ����͸� �� �־��ּ���(�ұ�)', 'FALSE', 1, 2);
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, orderDTO.getOrderBreadLength());
			ps.setString(2, orderDTO.getOrderMenu());
			ps.setString(3, orderDTO.getOrderExtra());
			ps.setString(4, orderDTO.getOrderBread());
			ps.setString(5, orderDTO.getOrderSauce());
			ps.setInt(6, orderDTO.getOrderPrice());
			ps.setInt(7, orderDTO.getOrderCalorie());
			ps.setString(8, orderDTO.getOrderUser());
			ps.setString(9,  orderDTO.getOrderText());
			ps.setString(10, orderDTO.getOrderIsMyMenu());
			ps.setInt(11, orderDTO.getOrderQuantity());
			ps.setString(12, orderDTO.getOrderBasket());
			result = ps.executeUpdate();
			
			return result;
		}finally {
			DBUtil.dbClose(ps, con);
		}
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
