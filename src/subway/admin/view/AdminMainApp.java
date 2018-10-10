package subway.admin.view;

import java.util.Scanner;

import subway.admin.controller.AdminController;
import subway.admin.dto.IngredientDTO;

public class AdminMainApp {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while(run) {
            System.out.println("***************사용하실 기능을 선택하세요****************");
            System.out.println("1.회원조회 | 2.메뉴추가 | 3.메뉴수정 | 4.메뉴삭제 | 5.종료");
            int input = sc.nextInt();
            switch(input) {
                case 1 : userSearch(); break;
                case 2 : menuInsert(sc); break;
                case 3 : menuUpdate(sc);break;
                case 4 : menuDelete(sc);break;
                case 5 : System.out.println("프로그램 종료합니다."); run = false;
            }
        }
    }
    
    public static void userSearch () {
        AdminController.userSearch();
    }
    
    public static void menuInsert (Scanner sc) {
        System.out.println("추가하실 메뉴 또는 재료의 이름을 입력하세요");
        String name = sc.next();
        
        System.out.println("카테고리를 입력하세요");
        String category = sc.next();
        
        System.out.println("칼로리를 입력하세요");
        int calorie = sc.nextInt();
        
        System.out.println("15cm 가격을 입력하세요");
        int price15 = sc.nextInt();
        
        System.out.println("30cm 가격을 입력하세요");
        int price30 = sc.nextInt();
        
        System.out.println("메인메뉴를 입력하셨다면 기본 소스를 입력해주세요");
        String sause = sc.next();
        
        AdminController.menuInsert(new IngredientDTO(name, category, calorie, price15, price30, sause));
    }
    
    public static void menuUpdate (Scanner sc) {
        System.out.println("수정하실 메뉴 또는 재료의 이름을 입력하세요");
        String name = sc.next();
        
        System.out.println("수정하실 카테고리를 입력하세요");
        String category = sc.next();
        
        System.out.println("수정하실 칼로리를 입력하세요");
        int calorie = sc.nextInt();
        
        System.out.println("수정하실 15cm 가격을 입력하세요");
        int price15 = sc.nextInt();
        
        System.out.println("수정하실 30cm 가격을 입력하세요");
        int price30 = sc.nextInt();
        
        System.out.println("수정하실 기본 소스를 입력해주세요");
        String sause = sc.next();
        
        AdminController.menuUpdate(new IngredientDTO(name, category, calorie, price15, price30, sause));
    }
    
    public static void menuDelete (Scanner sc) {
        System.out.println("삭제하실 메뉴 또는 재료의 이름을 입력하세요");
        String name = sc.next();
        
        AdminController.menuDelete(name);
    }
}
