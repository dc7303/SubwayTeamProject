package subway.admin.view;

import java.util.Scanner;

public class AdminMainApp {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while(run) {
            System.out.println("***************����Ͻ� ����� �����ϼ���****************");
            System.out.println("1.ȸ����ȸ | 2.�޴��߰� | 3.�޴����� | 4.����");
            int input = sc.nextInt();
            switch(input) {
                case 1 : userSearch(); break;
                case 2 : menuInsert(sc); break;
                case 3 : menuUpdate(sc);break;
                case 4 : System.out.println("���α׷� �����մϴ�."); run = false;
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
