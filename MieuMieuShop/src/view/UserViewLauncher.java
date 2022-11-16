package view;

import java.util.Scanner;

import static view.MainLauncher.menuUser;

public class UserViewLauncher {
    static Scanner scanner = new Scanner(System.in);
    static UserView userView = new UserView();
    static AdminView adminView = new AdminView();

    public static void lauch() {
        int choice = -1;
        do {
            menuUser();
            try {
                do {
                    System.out.println("Chọn chức năng");
                    System.out.print("➠ ");
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice > 6 || choice < 1)
                        System.out.println("Chọn chức năng không đúng !!!");
                } while (choice > 6 || choice < 1);
                switch (choice) {
                    case 1:
                        userView.addUser();
                        break;
                    case 2:
                        userView.updateUser();
                        break;
                    case 3:
                        userView.deleteUser();
                        break;
                    case 4:
                        userView.showUsers(InputOption.SHOW);
                        break;
                    case 5:
                        MainLauncher.menuOption();
                        break;
                    case 6:
                        UserViewLauncher.login();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng !!!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Nhập sai !!!");
            }
        } while (choice != 6);
    }

    public static void login() {
        System.out.println("\t┌───────────────────────────────────────────┐");
        System.out.println("\t│► ░░░░░░░░░░░░░░░░[LOGIN]░░░░░░░░░░░░░░░░ ◄│");
        System.out.println("\t└───────────────────────────────────────────┘");
        System.out.println("\t│                1.Đăng ký                  │");
        System.out.println("\t│                2.Đăng nhập                │");
        System.out.println("\t│                0.Thoát                    │");
        System.out.println("\t└───────────────────────────────────────────┘");
        System.out.println("Chọn chức năng");
        System.out.print("➠ ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                userView.addUsers();
                break;
            case 2:
                adminView.adminLogin();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Nhập sai !!! Vui lòng nhập lại !!!");
        }
    }
}
