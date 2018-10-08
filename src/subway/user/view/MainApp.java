package subway.user.view;

import java.util.Scanner;

import subway.user.controller.UserInfoController;
import subway.user.model.dao.UserInfoDAO;
import subway.user.model.dto.UserInfoDTO;

public class MainApp {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		while(run){
			System.out.println("*********************������Ʈ �׽�Ʈ*********************");
			System.out.println("1.ȸ������ | 2.�α��� | 3.ȸ������ ���� | 4.ȸ��Ż�� | 5. OrderInsert | 6. VegetablesInsert | 7.����");
			System.out.print("��ȣ�Է� = >");
			int select = sc.nextInt();
			
			switch(select) {
			
			case 1 : MainApp.userSignUp(sc); break;
			case 2 : MainApp.userSignIn(sc); break;
			case 3 : MainApp.userUpdate(sc); break;
			case 4 : MainApp.userDelete(sc); break;
			case 5 : MainApp.orderInsert(sc); break;
			case 6 : MainApp.vegetablesInsert(sc); break;
			case 7 : System.out.println("�����մϴ�."); run = false;
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
	 
	 System.out.println("�ּҸ� �Է��ϼ���");
	 String addr = sc.next();
	 
	 UserInfoDTO userDTO = new UserInfoDTO(id, pw, name, phone, addr);
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
	}
	
	/**
	 * ȸ������ ����
	 * @param sc
	 */
	public static void userUpdate (Scanner sc) {
		
	}
	
	/**
	 * ȸ�� Ż��
	 * @param sc
	 */
	public static void userDelete (Scanner sc) {
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
	}
	
	/**
	 * order���̺� ����
	 * @param sc
	 */
	public static void orderInsert (Scanner sc) {
		
	}
	
	/**
	 * vegetables ���̺� ����
	 * @param sc
	 */
	public static void vegetablesInsert (Scanner sc) {
		
	}
}
