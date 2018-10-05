package subway.user.model.dao;

import java.sql.SQLException;

import subway.user.model.dto.OrderDTO;
import subway.user.model.dto.VegetablesDTO;

public interface OrderDAO {
	/**
	 * order 테이블 생성, 주문 또는 마이메뉴 설정시 사용 메소드
	 * @param orderDTO
	 * @return
	 * @throws SQLException
	 */
	public int orderInsert (OrderDTO orderDTO) throws SQLException;
	
	/**
	 * VegetablesInsert 테이블 생성, 주문 또는 마이메뉴 설정시 사용 메소드
	 * @param vegDTO
	 * @return
	 * @throws SQLException
	 */
	public int vegetablesInsert(VegetablesDTO vegDTO) throws SQLException;
	
}
