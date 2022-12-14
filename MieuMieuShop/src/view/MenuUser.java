package view;

import java.util.Scanner;

public class MenuUser {
    static ProductView productView = new ProductView();
    static OrderView orderView = new OrderView();

    public static void menuOderUser() {
        System.out.println("⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷");
        System.out.println("⋇      CHÀO MỪNG BẠN ĐẾN VỚI CỬA HÀNG MỸ PHẨM       ⋇");
        System.out.println("⋇                   MIEU MIEU SHOP                  ⋇");
        System.out.println("⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷");
        System.out.println("                       MAIN MENU                     ");
        System.out.println("⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷");
        System.out.println("⋇                                                   ⋇");
        System.out.println("⋇                1. Mua sản phẩm                    ⋇");
        System.out.println("⋇                2. Hiện thị các sản phẩm           ⋇");
        System.out.println("⋇                0. Đăng xuất                       ⋇");
        System.out.println("⋇                                                   ⋇");
        System.out.println("⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷");
    }

    public static void runOderUser() {
        menuOderUser();
        System.out.println("Chọn chức năng:");
        System.out.println("➽ ");
        Scanner scanner = new Scanner(System.in);
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                orderView.addOrderUser();
                break;
            case 2:
                productView.showProduct(InputOption.SHOW);
                runOderUser();
                break;
            case 0:
                UserViewLauncher.login();
                break;
            default:
                System.out.println("Nhập chức năng sai ❌ Vui lòng nhập lại !!!");
        }
    }
}
