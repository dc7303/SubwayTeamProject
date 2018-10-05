package subway.user.model.service;

import java.sql.SQLException;

import subway.user.model.dto.OrderDTO;
import subway.user.model.dto.VegetablesDTO;

public interface OrderService {
	
	/**
	 * order ���̺� ����, �ֹ� �Ǵ� ���̸޴� ������ ��� �޼ҵ�
	 * @param userId
	 * @param orderDTO
	 * @return int 0 �̻��̸� true, 0�̸� false
	 * @throws SQLException
	 */
	public int orderInsert (OrderDTO orderDTO) throws SQLException;
	
	/**
	 * VegetablesDTO ���̺� ����, �ֹ� �Ǵ� ���̸޴� ������ ��� �޼ҵ�
	 * @param vegDTO
	 * @return int 0 �̻��̸� true, 0�̸� false
	 * @throws SQLException
	 */
	public int vegetablesInsert(VegetablesDTO vegDTO) throws SQLException;
}
