package subway.admin.view;

import java.util.Scanner;

public class AdminMainApp {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while(run) {
            System.out.println("***************사용하실 기능을 선택하세요****************");
            System.out.println("1.회원조회 | 2.메뉴추가 | 3.메뉴수정 | 4.종료");
            int input = sc.nextInt();
            switch(input) {
                case 1 : userSearch(); break;
                case 2 : menuInsert(sc); break;
                case 3 : menuUpdate(sc);break;
                case 4 : System.out.println("프로그램 종료합니다."); run = false;
            }
        }
    }
    
    public static void userSearch () {
        
    }
    
    public static void menuInsert (Scanner sc) {
        
    }
    
    public static void menuUpdate (Scanner sc) {
        
    }
}
