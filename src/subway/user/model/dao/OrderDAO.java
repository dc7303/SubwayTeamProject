package subway.user.model.dao;

import java.sql.SQLException;

import subway.user.model.dto.OrderDTO;
import subway.user.model.dto.VegetablesDTO;

public interface OrderDAO {
	/**
	 * order ���̺� ����, �ֹ� �Ǵ� ���̸޴� ������ ��� �޼ҵ�
	 * @param orderDTO
	 * @return
	 * @throws SQLException
	 */
	public int orderInsert (OrderDTO orderDTO) throws SQLException;
	
	/**
	 * VegetablesInsert ���̺� ����, �ֹ� �Ǵ� ���̸޴� ������ ��� �޼ҵ�
	 * @param vegDTO
	 * @return
	 * @throws SQLException
	 */
	public int vegetablesInsert(VegetablesDTO vegDTO) throws SQLException;
	
}
