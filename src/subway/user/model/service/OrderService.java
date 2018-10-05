package subway.user.model.service;

import java.sql.SQLException;

import subway.user.model.dto.OrderDTO;
import subway.user.model.dto.VegetablesDTO;

public interface OrderService {
	
	/**
	 * order 테이블 생성, 주문 또는 마이메뉴 설정시 사용 메소드
	 * @param userId
	 * @param orderDTO
	 * @return int 0 이상이면 true, 0이면 false
	 * @throws SQLException
	 */
	public int orderInsert (OrderDTO orderDTO) throws SQLException;
	
	/**
	 * VegetablesDTO 테이블 생성, 주문 또는 마이메뉴 설정시 사용 메소드
	 * @param vegDTO
	 * @return int 0 이상이면 true, 0이면 false
	 * @throws SQLException
	 */
	public int vegetablesInsert(VegetablesDTO vegDTO) throws SQLException;
}
