package subway.user.view;

import java.util.Scanner;

import subway.user.controller.OrderController;
import subway.user.model.dto.OrderDTO;

public class MainApp {
	
	public static void main(String[] args) {
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
		//INSERT INTO ORDERS VALUES(ORDER_SEQ.NEXTVAL, 30 , '로티세리 치킨', 
		//'에그마요','허니오트','리치시저',9000,1035,'C62','배달해주면 안되요? 오반가..?','TRUE', 2, 2);
		System.out.println("빵 길이를 선택해주세요.(15 or 30");
		System.out.print("입력=> ");
		int length = sc.nextInt();
		
		System.out.println("메인메뉴를 선택해주세요(ex풀드포크, 에그마요)");
		System.out.print("입력=> ");
		String main = sc.next();
		
		System.out.println("추가토핑를 입력하세요.(ex더블업, 오믈렛");
		System.out.print("입력=>");
		String extra = sc.next();
		
		System.out.println("빵을 선택해주세요 (ex허니오트, 하티)");
		System.out.print("입력=>");
		String bread = sc.next();
		
		System.out.println("소스를 선택하세요.(ex리치시저, 마요네즈");
		System.out.print("입력=> ");
		String sause = sc.next();
		
		System.out.println("id를 입력하세요");
		System.out.print("입력=> ");
		String userId = sc.next();
		
		System.out.println("메뉴에 대해 요구하실 부분을 입력해주세요(ex절임야채 빼주세요)");
		System.out.print("입력=> ");
		String text = sc.next();
		
		System.out.println("수량을 입력해주세요");
		System.out.print("입력=> ");
		int quantity = sc.nextInt();
		
		
		int result = OrderController.orderInsert(new OrderDTO(0, length, main, extra, bread, sause, 0, 0, userId, text, "FALSE", quantity, "1"));
		
	}
	
	/**
	 * 사용자한테 보여지기 위해 select문 사용
	 * @param sc
	 * 아직 insert로 기본메뉴들을 넣지 않았음. 지금 2가지 / 로티세리와 폴드포크만 들어가 있음.
	 */
	public static void orderSelect (Scanner sc) {
		System.out.print("userId 입력해주세요 :  ");
		String userId = sc.next();
		OrderController.orderSelect(userId);
	}
	
	/**
	 * 나만의 메뉴 가져오기 위한 메소드
	 * @param sc
	 */
	public static void myMenuSelect (Scanner sc) {
		
	}
}
