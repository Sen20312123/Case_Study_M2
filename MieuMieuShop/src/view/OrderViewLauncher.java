package view;

import java.util.Scanner;

import static view.MainLauncher.menuOrder;

public class OrderViewLauncher {
    static Scanner scanner = new Scanner(System.in);
    static OrderView orderView = new OrderView();

    public static void runOrder() {
        int choice;
        do {
            menuOrder();
            try {
                System.out.println("Chọn chức năng");
                System.out.print("➽");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        orderView.addOrder();
                        break;
                    case 2:
                        orderView.showTurnover();
                        break;
                    case 3:
                        MainLauncher.menuOption();
                        break;
                    case 4:
                        UserViewLauncher.login();
                        break;
                    default:
                        System.out.println("Nhập sai ❌ Vui lòng nhập lại!");
                }
            }catch (Exception e) {
                System.out.println("Nhập sai ❌ Vui lòng nhập lại!!!");
            }
        }while (true);
    }
}
