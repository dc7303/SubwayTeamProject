package subway.user.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import subway.admin.dto.IngredientDTO;
import subway.dbUtil.DBUtil;
import subway.user.model.dto.OrderDTO;

public class OrderDAOImpl implements OrderDAO {
    private Properties proFile = DBUtil.getProFile();

    @Override
    public int orderInsert(OrderDTO orderDTO) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        int result;
        // INSERT INTO ORDERS VALUES(ORDER_SEQ.NEXTVAL, 15, '«ÆµÂ∆˜≈©', 'ø¿π…∑ø', '«œ∆º',
        // '∑£ƒ°µÂ∑πΩÃ', 5100,750,'C62',
        // 'ªÁ¿Â¥‘ ∏Ù∑° ∞Ì±‚¬Õ∏∏ ¥ı ≥÷æÓ¡÷ººø‰(º“±Ÿ)', 'FALSE', 1, 2);
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(proFile.getProperty("order.orderInsert"));
            ps.setInt(1, orderDTO.getOrderBreadLength());
            ps.setString(2, orderDTO.getOrderMenu());
            ps.setString(3, orderDTO.getOrderExtra());
            ps.setString(4, orderDTO.getOrderBread());
            ps.setString(5, orderDTO.getOrderSauce());
            ps.setInt(6, orderDTO.getOrderPrice());
            ps.setInt(7, orderDTO.getOrderCalorie());
            ps.setString(8, orderDTO.getOrderUser());
            ps.setString(9, orderDTO.getOrderText());
            ps.setString(10, orderDTO.getOrderIsMyMenu());
            ps.setInt(11, orderDTO.getOrderQuantity());
            //ps.setInt(12, orderDTO.getOrderBasket());
            result = ps.executeUpdate();

            return result;
        } finally {
            DBUtil.dbClose(ps, con);
        }
    }

    @Override
    public List<OrderDTO> orderSelect(String userId) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<OrderDTO> list = new ArrayList<>();
         try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(proFile.getProperty("order.orderSelect"));
            ps.setString(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                OrderDTO orderDTO = new OrderDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
                        rs.getString(11), rs.getInt(12), rs.getInt(13));
                list.add(orderDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
		String isMy;
		if(isMyMenu) {
			isMy = "TRUE";
		}
		else isMy = "FALSE";
		  try {
			  con=DBUtil.getConnection();  //selectπÆ ∫¡¡÷ººø‰
			  ps=con.prepareStatement(proFile.getProperty("order.orderSelectVector"));
			  ps.setString(1, userId);
			  ps.setString(2, isMy);
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
        List<OrderDTO> list = new ArrayList<OrderDTO>();
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(proFile.getProperty("order.myMenuSelect"));
            ps.setString(1, userID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDTO(rs.getInt("ORDER_ID"), rs.getInt("ORDER_BREAD_LEN"), rs.getString("ORDER_MENU"),
                        rs.getString("ORDER_EXTRA"), rs.getString("ORDER_BREAD"), rs.getString("ORDER_SAUCE"),
                        rs.getInt("ORDER_PRICE"), rs.getInt("ORDER_CALORIE"), rs.getString("ORDER_USER"),
                        rs.getString("ORDER_TEXT"), rs.getString("ORDER_IS_MY_MENU"), rs.getInt("ORDER_QUANTITY"),
                        rs.getInt("ORDER_BASKET")));

            }
            return list;
        } finally {
            DBUtil.dbClose(rs, ps, con);
        }
    }

    @Override
    public int myMenuUpdate(OrderDTO orderDTO) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        int result;
        try {
        	con = DBUtil.getConnection();
            ps = con.prepareStatement(proFile.getProperty("order.myMenuUpdate"));
            ps.setInt(1, orderDTO.getOrderBreadLength());
            ps.setString(2, orderDTO.getOrderMenu());
            ps.setString(3, orderDTO.getOrderExtra());
            ps.setString(4, orderDTO.getOrderBread());
            ps.setString(5, orderDTO.getOrderSauce());
            ps.setInt(6, orderDTO.getOrderPrice());
            ps.setInt(7, orderDTO.getOrderCalorie());
            ps.setString(8, orderDTO.getOrderUser());
            ps.setString(9, orderDTO.getOrderText());
            ps.setString(10, orderDTO.getOrderIsMyMenu());
            ps.setInt(11, orderDTO.getOrderQuantity());
            ps.setInt(12, orderDTO.getOrderBasket());
            ps.setInt(13, orderDTO.getOrderId());
            result = ps.executeUpdate();

            return result;
        } finally {
            DBUtil.dbClose(ps, con);
        }
    }
    
    
    public int myMenuDelete(String orderID) throws SQLException{
    	 Connection con = null;
         PreparedStatement ps = null;
         int result;
         try {
             con = DBUtil.getConnection();
             ps = con.prepareStatement(proFile.getProperty("order.myMenuDelete"));
             ps.setString(1, orderID);
 			/*for(int i=0 ; i<orderID.length();i++) {
 				ps.setString(i, orderID);
 			}*/
 			result=ps.executeUpdate();
 		}finally {
 			DBUtil.dbClose(ps, con);
 		}
 		return result;
    }
    
    @Override
    public List<IngredientDTO> menuList() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<IngredientDTO> list = new ArrayList<IngredientDTO>();
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(proFile.getProperty("order.menuList"));
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new IngredientDTO(rs.getString("ingred_name"), rs.getString("ingred_category"),
                        rs.getInt("ingred_calorie"), rs.getInt("ingred_price_15"), rs.getInt("ingred_price_30"),
                        rs.getString("ingred_recommend_sauce")));

            }
            return list;
        } finally {
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
    @Override
    public List<IngredientDTO> menuList(String category) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<IngredientDTO> list = new ArrayList<IngredientDTO>();
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(proFile.getProperty("order.menuListcategory"));
            ps.setString(1, category);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new IngredientDTO(rs.getString("ingred_name"), rs.getString("ingred_category"),
                        rs.getInt("ingred_calorie"), rs.getInt("ingred_price_15"), rs.getInt("ingred_price_30"),
                        rs.getString("ingred_recommend_sauce")));

            }
            return list;
        } finally {
            DBUtil.dbClose(rs, ps, con);
        }
    }

    @Override
    public OrderDTO selectOrderById(int id) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        OrderDTO orderDTO = new OrderDTO();
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(proFile.getProperty("order.selectOrderById"));
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                orderDTO = new OrderDTO(rs.getInt("ORDER_ID"), rs.getInt("ORDER_BREAD_LEN"), rs.getString("ORDER_MENU"),
                        rs.getString("ORDER_EXTRA"), rs.getString("ORDER_BREAD"), rs.getString("ORDER_SAUCE"),
                        rs.getInt("ORDER_PRICE"), rs.getInt("ORDER_CALORIE"), rs.getString("ORDER_USER"),
                        rs.getString("ORDER_TEXT"), rs.getString("ORDER_IS_MY_MENU"), rs.getInt("ORDER_QUANTITY"),
                        rs.getInt("ORDER_BASKET"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(rs, ps, con);
        }
        return orderDTO;
    }

 



}
