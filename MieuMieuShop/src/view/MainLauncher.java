package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainLauncher {
    static Scanner scanner = new Scanner(System.in);

    public MainLauncher() {
        launch();
    }
    public static void launch() {
        UserViewLauncher.login();
    }


    public static void menuOption() {
        do {
            mainMenu();
            try {
                System.out.println("Chọn chức năng: ");
                System.out.print("➱ ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        UserViewLauncher.lauch();
                        break;
                    case 2:
                        ProductViewLauncher.runProduct();
                        break;
                    case 3:
                        OrderViewLauncher.runOrder();
                        break;
                    case 4:
                        UserViewLauncher.login();
                        break;
                    default:
                        System.out.println("Nhập sai ⚔️Vui lòng nhập lại! ");
                        break;
                }
            }catch (Exception e) {
                System.out.println("Error!  ̿’̿’\\̵͇̿̿\\");
            }
        }while (true);
    }

    public static void mainMenu() {
        System.out.println("⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷");
        System.out.println("⋇          CỬA HÀNG MỸ PHẨM MIEU MIEU SHOP          ⋇");
        System.out.println("⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷");
        System.out.println("⋇                    MENU QUẢN LÝ                   ⋇");
        System.out.println("⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷");
        System.out.println("⋇                                                   ⋇");
        System.out.println("⋇                1.Quản lý người dùng               ⋇");
        System.out.println("⋇                2.Quản lý sản phẩm                 ⋇");
        System.out.println("⋇                3.Quản lý đơn đặt hàng             ⋇");
        System.out.println("⋇                4.Đăng xuất                        ⋇");
        System.out.println("⋇                                                   ⋇");
        System.out.println("⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷⊷");
    }

    public static void menuUser() {
        System.out.println("\t┌──────────────────────────────────────────────────────────┐");
        System.out.println("\t│► ░░░░░░░░░░░░░░░░░░[QUẢN LÝ NGƯỜI DÙNG]░░░░░░░░░░░░░░░░ ◄│");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
        System.out.println("\t│               【1】. Thêm người dùng                      │");
        System.out.println("\t│               【2】. Sửa thông tin người dùng             │");
        System.out.println("\t│               【3】. Xóa người dùng                       │");
        System.out.println("\t│               【4】. Hiện thông tin người dùng            │");
        System.out.println("\t│               【5】. Quay lại MAIN MENU                   │");
        System.out.println("\t│               【6】. Thoát                                │");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
    }
    public static void menuProduct() {
        System.out.println("\t┌──────────────────────────────────────────────────────────┐");
        System.out.println("\t│► ░░░░░░░░░░░░░░░░░░░[QUẢN LÝ SẢN PHẨM]░░░░░░░░░░░░░░░░░ ◄│");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
        System.out.println("\t│               【1】. Thêm sản phẩm                        │");
        System.out.println("\t│               【2】. Sửa thông tin sản phẩm               │");
        System.out.println("\t│               【3】. Tìm kiếm sản phẩm                    │");
        System.out.println("\t│               【4】. Hiển thị danh sách sản phẩm          │");
        System.out.println("\t│               【5】. Sắp xếp sản phẩm                     │");
        System.out.println("\t│               【6】. Xóa sản phẩm                         │");
        System.out.println("\t│               【7】. Quay lại MAIN MENU                   │");
        System.out.println("\t│               【8】. Thoát                                │");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
        System.out.println("Chọn chức năng");
        System.out.printf("⭆ \t");
    }

    public static void startMainMenu() {
        try {
            boolean flag = true;
            do {
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        ProductViewLauncher.runProduct();
                        break;
                    case "2" :
                        break;
                    default:
                        System.out.println("Nhập sai ❌️Vui lòng nhập lại !");
                }
            }while (!flag);
        }catch (InputMismatchException io) {
            io.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void inputUpdate() {
        System.out.println("\t┌───────────────────────────────────────────────────┐");
        System.out.println("\t│► ░░░░░░░░░░░░░░░░░░░░[CẬP NHẬT]░░░░░░░░░░░░░░░░░ ◄│");
        System.out.println("\t└───────────────────────────────────────────────────┘");
        System.out.println("\t│               【1】. Cập nhật giá                  │");
        System.out.println("\t│               【2】. Cập nhật số lượng             │");
        System.out.println("\t│               【3】. Cập nhật tên                  │");
        System.out.println("\t│               【4】. Cập nhật tên thương hiệu      │");
        System.out.println("\t│               【5】. Quay lại                      │");
        System.out.println("\t└───────────────────────────────────────────────────┘");
        System.out.println("Chọn chức năng");
        System.out.printf("⭆ \t");
    }
    public static void menuOrder() {
        System.out.println("\t┌──────────────────────────────────────────────────────────┐");
        System.out.println("\t│► ░░░░░░░░░░░░░░░░░░░[QUẢN LÝ ĐƠN HÀNG]░░░░░░░░░░░░░░░░░ ◄│");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
        System.out.println("\t│                 【1】. Tạo đơn hàng                       │");
        System.out.println("\t│                 【2】. Xem doanh thu                      │");
        System.out.println("\t│                 【3】. Quay lại MAIN MENU                 │");
        System.out.println("\t│                 【4】. Thoát                              │");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
    }
}
