package subway.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

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
		//INSERT INTO ORDERS VALUES(ORDER_SEQ.NEXTVAL, 15, '풀드포크', '오믈렛', '하티', '랜치드레싱', 5100,750,'C62',
		//'사장님 몰래 고기쫌만 더 넣어주세요(소근)', 'FALSE', 1, 2);
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
	/*public List<OrderDTO> orderSelect(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrderDTO> list = new ArrayList<>();
		String sql = "SELECT * FROM ORDERS WHERE lower(ORDER_USER) like lower(?) ";
		try {
			con = DBUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+userId+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				OrderDTO orderDTO = new OrderDTO(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
				rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12),rs.getString(13)	);
				list.add(orderDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, ps, con);
		}
		return list;
	}*/
	public List<OrderDTO> orderSelect(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrderDTO> list = new ArrayList<>();
		String sql = "SELECT ingred_name, ingred_calorie, ingred_price_15, ingred_price_30, ingred_recommend_sauce "
				+ "FROM INGREDIENTS where ingred_category='메뉴'";
		try {
			con = DBUtil.getConnection();
			ps=con.prepareStatement(sql);
			//ps.setString(1, "%"+userId+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				OrderDTO orderDTO = new OrderDTO(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
				list.add(orderDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, ps, con);
		}
		return list;
	}
	
	@Override
	public List<Vector<Object>> orderSelectVector(String userId, boolean isMyMenu) throws SQLException {
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Vector<Object>> vList = new ArrayList<>();
		  try {
			  con=DBUtil.getConnection();  //select문 봐주세요
			  ps=con.prepareStatement("SELECT * FROM ORDERS WHERE ORDER_USER = ? AND ORDER_IS_MY_MENU = ? ORDER BY ORDER_ID DESC");
			  ps.setString(1, userId);
			  ps.setBoolean(2, isMyMenu);
		      rs=ps.executeQuery();
		      while(rs.next()) {
		    	  Vector<Object> v = new Vector<>();
		    	  v.add(rs.getInt("ORDER_ID"));
		    	  v.add(rs.getInt("ORDER_BREAD_LEN"));
		    	  v.add(rs.getString("ORDER_MENU"));
		    	  v.add(rs.getString("ORDER_EXTRA"));
		    	  v.add(rs.getString("ORDER_BREAD"));
		    	  v.add(rs.getString("ORDER_SAUCE"));
		    	  v.add(rs.getInt("ORDER_PRICE"));
		    	  v.add(rs.getInt("ORDER_CALORIE"));
		    	  v.add(rs.getString("ORDER_USER"));
		    	  v.add(rs.getString("ORDER_TEXT"));
		    	  v.add(rs.getString("ORDER_IS_MY_MENU"));
		    	  v.add(rs.getInt("ORDER_QUANTITY"));
		    	  v.add(rs.getString("ORDER_BASKET"));
		    	  vList.add(v);
		      }
		  }finally {
			  DBUtil.dbClose(rs, ps , con);
		  }
		return vList;
	}

	@Override
	public List<OrderDTO> myMenuSelect(String userID) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from orders where order_is_my_menu = 'TRUE' and order_user = ?";
		List<OrderDTO> list = new ArrayList<OrderDTO>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userID);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new OrderDTO(rs.getInt("ORDER_ID"), rs.getInt("ORDER_BREAD_LEN"), rs.getString("ORDER_MENU"),
						rs.getString("ORDER_EXTRA"), rs.getString("ORDER_BREAD"), rs.getString("ORDER_SAUCE"), rs.getInt("ORDER_PRICE"),
						rs.getInt("ORDER_CALORIE"), rs.getString("ORDER_USER"), rs.getString("ORDER_TEXT"), rs.getString("ORDER_IS_MY_MENU"),
						rs.getInt("ORDER_QUANTITY"), rs.getString("ORDER_BASKET")));
				
			}
			return list;
		}finally {
			DBUtil.dbClose(rs, ps, con);
		}
	}

}
