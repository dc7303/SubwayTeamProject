package subway.admin.view;

import java.util.Scanner;

import subway.admin.controller.AdminController;
import subway.admin.dto.IngredientDTO;

public class AdminMainApp {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while(run) {
            System.out.println("***************����Ͻ� ����� �����ϼ���****************");
            System.out.println("1.ȸ����ȸ | 2.�޴��߰� | 3.�޴����� | 4.�޴����� | 5.����");
            int input = sc.nextInt();
            switch(input) {
                case 1 : userSearch(); break;
                case 2 : menuInsert(sc); break;
                case 3 : menuUpdate(sc);break;
                case 4 : menuDelete(sc);break;
                case 5 : System.out.println("���α׷� �����մϴ�."); run = false;
            }
        }
    }
    
    public static void userSearch () {
        AdminController.userSearch();
    }
    
    public static void menuInsert (Scanner sc) {
        System.out.println("�߰��Ͻ� �޴� �Ǵ� ����� �̸��� �Է��ϼ���");
        String name = sc.next();
        
        System.out.println("ī�װ��� �Է��ϼ���");
        String category = sc.next();
        
        System.out.println("Į�θ��� �Է��ϼ���");
        int calorie = sc.nextInt();
        
        System.out.println("15cm ������ �Է��ϼ���");
        int price15 = sc.nextInt();
        
        System.out.println("30cm ������ �Է��ϼ���");
        int price30 = sc.nextInt();
        
        System.out.println("���θ޴��� �Է��ϼ̴ٸ� �⺻ �ҽ��� �Է����ּ���");
        String sause = sc.next();
        
        AdminController.menuInsert(new IngredientDTO(name, category, calorie, price15, price30, sause));
    }
    
    public static void menuUpdate (Scanner sc) {
        System.out.println("�����Ͻ� �޴� �Ǵ� ����� �̸��� �Է��ϼ���");
        String name = sc.next();
        
        System.out.println("�����Ͻ� ī�װ��� �Է��ϼ���");
        String category = sc.next();
        
        System.out.println("�����Ͻ� Į�θ��� �Է��ϼ���");
        int calorie = sc.nextInt();
        
        System.out.println("�����Ͻ� 15cm ������ �Է��ϼ���");
        int price15 = sc.nextInt();
        
        System.out.println("�����Ͻ� 30cm ������ �Է��ϼ���");
        int price30 = sc.nextInt();
        
        System.out.println("�����Ͻ� �⺻ �ҽ��� �Է����ּ���");
        String sause = sc.next();
        
        AdminController.menuUpdate(new IngredientDTO(name, category, calorie, price15, price30, sause));
    }
    
    public static void menuDelete (Scanner sc) {
        System.out.println("�����Ͻ� �޴� �Ǵ� ����� �̸��� �Է��ϼ���");
        String name = sc.next();
        
        AdminController.menuDelete(name);
    }
}
