package view;

import model.Product;
import service.ProductService;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class SearchProductView {
    static Scanner scanner = new Scanner(System.in);
    static ProductView productView = new ProductView();
    static ProductService productService = new ProductService();
    static DecimalFormat format = new DecimalFormat("###,###,###" + "đ");

    public static void search() {

        productView.show(productService.findAll());
        boolean flag = true;
        int choice = -1;
        do {
            System.out.println("\t┌──────────────────────────────────────────────────────────┐");
            System.out.println("\t│► ░░░░░░░░░░░░░░░░░░[ TÌM KIẾM SẢN PHẨM]░░░░░░░░░░░░░░░░ ◄│");
            System.out.println("\t└──────────────────────────────────────────────────────────┘");
            System.out.println("\t│               【1】. Tìm kiếm theo id sản phẩm            │");
            System.out.println("\t│               【2】. Tìm kiếm theo tên sản phẩm           │");
            System.out.println("\t│               【3】. Tìm kiếm theo tên thương hiệu        │");
            System.out.println("\t│               【0】. Quay lại                             │");
            System.out.println("\t└──────────────────────────────────────────────────────────┘");
            System.out.println("Chọn chức năng: ");
            System.out.print("➽ ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            }catch (Exception e) {
                e.printStackTrace();
            }
            switch (choice) {
                case 1:
                    searchById();
                    break;
                case 2:
                    searchByName();
                    break;
                case 3:
                    searchByTrademark();
                    break;
                case 0:
                    ProductViewLauncher.runProduct();
                    flag = false;
                    break;
                default:
                    System.out.println("Nhập sai !!! Vui lòng nhập lại !!!");
                    break;
            }
        }while (flag);
    }

    public static void searchById() {
        List<Product> products = productService.findAll();
        int count = 0;
        System.out.println("Nhập id cần tìm kiếm: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
            System.out.printf("%-15s %-20s %-18s %-10s %-18s", "Id", "Tên Sản Phẩm", "Giá", "Số lượng" ,"Thương hiệu\n");
            System.out.println("");
            System.out.println("────────────────────────────────────────────────────────────────────────────────────────────");
            for (Product product : products) {
                if (product.getProductID() == id) {
                    count++;
                    System.out.printf("%-15s %-20s %-18s %-10s %-18s\n", product.getProductID(), product.getName(), format.format(product.getPrice()),
                            product.getQuantity() , product.getTrademark());
                }
            }
            showReturnSearch(count);

        } catch (Exception e) {
            System.out.println("Chưa hợp lệ!Mời nhập lại");
        }
    }
    public static void searchByName() {
        List<Product> products = productService.findAll();
        int count = 0;
        System.out.println("Nhập tên cần tìm kiếm (Tên có dấu): ");
        try {
            String name = scanner.nextLine();
            System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
            System.out.printf("%-15s %-20s %-18s %-10s %-18s", "Id", "Tên Sản Phẩm", "Giá", "Số lượng" ,"Thương hiệu\n");
            System.out.println("");
            System.out.println("────────────────────────────────────────────────────────────────────────────────────────────");
            for (Product product : products) {
                if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                    count++;
                    System.out.printf("%-20s %-20s %-18s %-10s %-18s\n", product.getProductID(), product.getName(), format.format(product.getPrice()),
                            product.getQuantity(),product.getTrademark());
                }
            }
            showReturnSearch(count);

        } catch (Exception e) {
            System.out.println("Chưa hợp lệ!Mời nhập lại");
        }
    }

    public static void searchByTrademark() {
        List<Product> products = productService.findAll();
        int count = 0;
        System.out.println("Nhập tên thương hiệu cần tìm kiếm (tên có dấu): ");
        try {
            String trademark = scanner.nextLine();
            System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
            System.out.printf("%-15s %-20s %-18s %-10s %-18s", "Id", "Tên Sản Phẩm", "Giá", "Số lượng" ,"Thương hiệu\n");
            System.out.println("");
            System.out.println("────────────────────────────────────────────────────────────────────────────────────────────");
            for (Product product : products) {
                if (product.getTrademark().toLowerCase().contains(trademark.toLowerCase())) {
                    count++;
                    System.out.printf("%-20s %-20s %-18s %-10s %-18s\n", product.getProductID(), product.getName(), format.format(product.getPrice()),
                            product.getQuantity(),product.getTrademark());
                }
            }
            showReturnSearch(count);

        } catch (Exception e) {
            System.out.println("Chưa hợp lệ!Mời nhập lại");
        }
    }
    public static void showReturnSearch(int count) {
        char choice = ' ';
        boolean isChoice;
        System.out.println();
        do {
            System.out.println("Nhấn 'q' để quay lại.");
            System.out.print("➤ ");
            try {
                choice = scanner.nextLine().charAt(0);
            } catch (Exception e) {
                choice = ' ';
            }
            switch (choice) {
                case 'q': {
                    SearchProductView.search();
                    isChoice = false;
                    break;
                }
                default:
                    isChoice = true;
            }
        } while (isChoice);
    }
}
