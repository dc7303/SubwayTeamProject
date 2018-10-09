package subway.user.view;

import java.util.Scanner;

import subway.user.controller.UserInfoController;
import subway.user.model.dto.UserInfoDTO;

public class MainApp {
	
	public static void main(String[] args) {
		new MainFrame();
		/*
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		while(run){
			System.out.println("*********************프로젝트 테스트*********************");
			System.out.println("1.회원가입 | 2.로그인 | 3.회원정보 수정 | 4.회원탈퇴 | 5. OrderInsert | 6. orderSelect | 7.myMenuSelect | 8.종료");
			System.out.print("번호입력 = >");
			int select = sc.nextInt();
			
			switch(select) {
			
			case 1 : MainApp.userSignUp(sc); break;
			case 2 : MainApp.userSignIn(sc); break;
			case 3 : MainApp.userUpdate(sc); break;
			case 4 : MainApp.userDelete(sc); break;
			case 5 : MainApp.orderInsert(sc); break;
			case 6 : MainApp.orderSelect(sc); break;
			case 7 : MainApp.myMenuSelect(sc); break;
			case 8 : System.out.println("종료합니다."); run = false;
			}
		}
		*/
	}
	
	/**
	 * 회원가입
	 * @param sc
	 */
	public static void userSignUp (Scanner sc){
		
	}
	
	/**
	 * 로그인
	 * @param sc
	 */
	public static void userSignIn (Scanner sc) {
		
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
		
	}
	
	/**
	 * order테이블 생성
	 * @param sc
	 */
	public static void orderInsert (Scanner sc) {
		
	}
	
	/**
	 * 사용자한테 보여지기 위해 select문 사용
	 * @param sc
	 */
	public static void orderSelect (Scanner sc) {
		
	}
	
	/**
	 * 나만의 메뉴 가져오기 위한 메소드
	 * @param sc
	 */
	public static void myMenuSelect (Scanner sc) {
		
	}
}
