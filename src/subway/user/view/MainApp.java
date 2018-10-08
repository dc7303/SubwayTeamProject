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
			System.out.println("*********************프로젝트 테스트*********************");
			System.out.println("1.회원가입 | 2.로그인 | 3.회원정보 수정 | 4.회원탈퇴 | 5. OrderInsert | 6. VegetablesInsert | 7.종료");
			System.out.print("번호입력 = >");
			int select = sc.nextInt();
			
			switch(select) {
			
			case 1 : MainApp.userSignUp(sc); break;
			case 2 : MainApp.userSignIn(sc); break;
			case 3 : MainApp.userUpdate(sc); break;
			case 4 : MainApp.userDelete(sc); break;
			case 5 : MainApp.orderInsert(sc); break;
			case 6 : MainApp.vegetablesInsert(sc); break;
			case 7 : System.out.println("종료합니다."); run = false;
			}
		}
	}
	
	/**
	 * 회원가입
	 * @param sc
	 */
	public static void userSignUp (Scanner sc){
	 System.out.println("ID를 입력하세요");
	 String id = sc.next();
   	 
   	 System.out.println("PASSWORD를 입력하세요");
   	 String pw = sc.next();
   	 
   	 System.out.println("이름을 입력하세요");
   	 String name = sc.next();
   	 
   	 System.out.println("휴대폰 번호를 입력하세요");
	 String phone = sc.next();
	 
	 System.out.println("주소를 입력하세요");
	 String addr = sc.next();
	 
	 UserInfoDTO userDTO = new UserInfoDTO(id, pw, name, phone, addr);
	 UserInfoController.userSignUp(userDTO);
	}
	
	/**
	 * 로그인
	 * @param sc
	 */
	public static void userSignIn (Scanner sc) {
		System.out.println("ID 입력 : ");
		String id = sc.next();
		
		System.out.println("패스워드 입력 : ");
		String pw = sc.next();
	}
	
	/**
	 * 회원정보 수정
	 * @param sc
	 */
	public static void userUpdate (Scanner sc) {
		
	}
	
	/**
	 * 회원 탈퇴
	 * @param sc
	 */
	public static void userDelete (Scanner sc) {
		System.out.println("ID를 입력하세요 : ");
		String id = sc.next();  //???
		
		System.out.println("수정할 패스워드 입력 : ");
		String pw = sc.next();
		
		System.out.println("수정할 이름 입력 : ");
		String name = sc.next();
		
		System.out.println("수정할 phone 번호 입력 : ");
		String phone = sc.next();
		
		System.out.println("수정할 이메일 입력 : ");
		String email = sc.next();
	}
	
	/**
	 * order테이블 생성
	 * @param sc
	 */
	public static void orderInsert (Scanner sc) {
		
	}
	
	/**
	 * vegetables 테이블 생성
	 * @param sc
	 */
	public static void vegetablesInsert (Scanner sc) {
		
	}
}
