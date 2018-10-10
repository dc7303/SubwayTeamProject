package subway.user.view;

import java.util.List;
import java.util.Scanner;

import subway.admin.dto.IngredientDTO;
import subway.user.controller.OrderController;
import subway.user.model.dto.OrderDTO;
import subway.user.controller.UserInfoController;
import subway.user.model.dao.UserInfoDAO;
import subway.user.model.dto.UserInfoDTO;

public class MainApp {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		while(run){
			System.out.println("*********************������Ʈ �׽�Ʈ*********************");
			System.out.println("1.ȸ������ | 2.�α��� | 3.ȸ������ ���� | 4.ȸ��Ż�� | 5. OrderInsert |"
			        + " 6. orderSelect | 7.myMenuSelect | 8.���̵�üũ | 9.�޴�����Ʈ | 10.����");
			System.out.print("��ȣ�Է� = >");
			int select = sc.nextInt();
			
			switch(select) {
			
			case 1 : MainApp.userSignUp(sc); break;
			case 2 : MainApp.userSignIn(sc); break;
			case 3 : MainApp.userUpdate(sc); break;
			case 4 : MainApp.userDelete(sc); break;
			case 5 : MainApp.orderInsert(sc); break;
			case 6 : MainApp.orderSelect(sc); break;
			case 7 : MainApp.myMenuSelect(sc); break;
			case 8 : MainApp.userIdCheck(sc); break;
			case 9 : MainApp.menuList(); break;
			case 10 : System.out.println("�����մϴ�."); run = false;
			}
		}
	}
	
	/**
	 * ȸ������
	 * @param sc
	 */
	public static void userSignUp (Scanner sc){
	 System.out.println("ID�� �Է��ϼ���");
	 String id = sc.next();
   	 
   	 System.out.println("PASSWORD�� �Է��ϼ���");
   	 String pw = sc.next();
   	 
   	 System.out.println("�̸��� �Է��ϼ���");
   	 String name = sc.next();
   	 
   	 System.out.println("�޴��� ��ȣ�� �Է��ϼ���");
	 String phone = sc.next();
	 
	 System.out.println("email�� �Է��ϼ���");
	 String email = sc.next();
	 
	 UserInfoDTO userDTO = new UserInfoDTO(id, pw, name, phone, email);
	 UserInfoController.userSignUp(userDTO);
	}
	
	/**
	 * �α���
	 * @param sc
	 */
	public static void userSignIn (Scanner sc) {
		System.out.println("ID �Է� : ");
		String id = sc.next();
		
		System.out.println("�н����� �Է� : ");
		String pw = sc.next();
		
		UserInfoDTO userDTO = new UserInfoDTO(id, pw);
		UserInfoController.userSignIn(id,pw);
	}
	
	/**
	 * ȸ������ ����
	 * @param sc
	 */
	public static void userUpdate (Scanner sc) {
		System.out.println("ID�� �Է��ϼ��� : ");
		String id = sc.next();  //???
		
		System.out.println("������ �н����� �Է� : ");
		String pw = sc.next();
		
		System.out.println("������ �̸� �Է� : ");
		String name = sc.next();
		
		System.out.println("������ phone ��ȣ �Է� : ");
		String phone = sc.next();
		
		System.out.println("������ �̸��� �Է� : ");
		String email = sc.next();
		
		UserInfoDTO userDTO = new UserInfoDTO(id, pw, name, phone, email);
		UserInfoController.userUpdate(userDTO);
	}
	
	/**
	 * ȸ�� Ż��
	 * @param sc
	 */
	public static void userDelete (Scanner sc) {
		
	}
	
	/**
	 * order���̺� ����
	 * @param sc
	 */
	public static void orderInsert (Scanner sc) {
		//INSERT INTO ORDERS VALUES(ORDER_SEQ.NEXTVAL, 30 , '��Ƽ���� ġŲ', 
		//'���׸���','��Ͽ�Ʈ','��ġ����',9000,1035,'C62','������ָ� �ȵǿ�? ���ݰ�..?','TRUE', 2, 2);
		System.out.println("�� ���̸� �������ּ���.(15 or 30");
		System.out.print("�Է�=> ");
		int length = sc.nextInt();
		
		System.out.println("���θ޴��� �������ּ���(exǮ����ũ, ���׸���)");
		System.out.print("�Է�=> ");
		String main = sc.next();
		
		System.out.println("�߰����θ� �Է��ϼ���.(ex�����, ���ɷ�");
		System.out.print("�Է�=>");
		String extra = sc.next();
		
		System.out.println("���� �������ּ��� (ex��Ͽ�Ʈ, ��Ƽ)");
		System.out.print("�Է�=>");
		String bread = sc.next();
		
		System.out.println("�ҽ��� �����ϼ���.(ex��ġ����, �������");
		System.out.print("�Է�=> ");
		String sause = sc.next();
		
		System.out.println("id�� �Է��ϼ���");
		System.out.print("�Է�=> ");
		String userId = sc.next();
		
		System.out.println("�޴��� ���� �䱸�Ͻ� �κ��� �Է����ּ���(ex���Ӿ�ä ���ּ���)");
		System.out.print("�Է�=> ");
		String text = sc.next();
		
		System.out.println("������ �Է����ּ���");
		System.out.print("�Է�=> ");
		int quantity = sc.nextInt();
		
		
		int result = OrderController.orderInsert(new OrderDTO(0, length, main, extra, bread, sause, 0, 0, userId, text, "FALSE", quantity, "1"));
		
	}
	
	/**
	 * ��������� �������� ���� select�� ���
	 * @param sc
	 * ���� insert�� �⺻�޴����� ���� �ʾ���. ���� 2���� / ��Ƽ������ ������ũ�� �� ����.
	 */
	public static void orderSelect (Scanner sc) {
		System.out.print("userId �Է����ּ��� :  ");
		String userId = sc.next();
		OrderController.orderSelect(userId);
	}
	
	/**
	 * ������ �޴� �������� ���� �޼ҵ�
	 * @param sc
	 */
	public static void myMenuSelect (Scanner sc) {
		List<OrderDTO>list = OrderController.myMenuSelect("C62");
	}
	
	/**
	 * id �ߺ�üũ
	 * @param sc
	 */
	public static void userIdCheck (Scanner sc) {
	    System.out.println("�ߺ�üũ�Ͻ� ���̵� �Է��ϼ���");
	    String id = sc.next();
	    UserInfoController.userIdCheck(id);
	}
	
	public static void menuList () {
	    List<IngredientDTO> list = OrderController.menuList();
	}
	
}
