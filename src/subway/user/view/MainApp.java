package subway.user.view;

import java.util.Scanner;

import subway.user.controller.UserInfoController;
import subway.user.model.dao.UserInfoDAO;
import subway.user.model.dto.UserInfoDTO;

public class MainApp {
	
	public static void main(String[] args) {
		new MainFrame();
		/*
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
		*/
	}
	
	
}
