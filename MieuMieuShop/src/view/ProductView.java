package view;

import model.Product;
import service.ProductService;
import utils.AppUtils;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    private ProductService productService = new ProductService();

    private final Scanner scanner = new Scanner(System.in);
    private final DecimalFormat decimalFormat = new DecimalFormat("###,###,###" + " đ");

    public ProductView() {
        productService = ProductService.getInstance();
    }

    private static final String PATH = "E:\\Module2\\Case_Study_M2\\MieuMieuShop\\data\\product.csv";

    public String inputNameProduct(InputOption option) {
        String nameProduct = "";
        switch (option) {
            case ADD:
                System.out.println("Nhập tên sản phẩm : ");
                break;
            case UPDATE:
                System.out.println("Nhập tên sản phẩm bạn muốn sửa: ");
                break;
        }
        do {
            nameProduct = AppUtils.retrySring("Tên sản phẩm");
        } while (nameProduct.isEmpty());
        return nameProduct;
    }

    public int inputQuantity(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập số lượng: ");
                break;
            case UPDATE:
                System.out.println("Nhập số lượng muốn sửa: ");
                break;
        }
        int quantity;
        do {
            quantity = AppUtils.retryParseInt();
            if (quantity < 0) {
                System.out.println("Số lượng phải lớn hơn 0");
            }
        } while (quantity < 0);
        return quantity;
    }

    private double inputPrice(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập giá sản phẩm: ");
                break;
            case UPDATE:
                System.out.println("Nhập giá sản phẩm muốn sửa: ");
                break;
        }
        double price;
        do {
            price = AppUtils.retryParseDouble();
            if (price <= 0) {
                System.out.println("Giá phải lớn hơn 0");
            }
        } while (price < 0);
        return price;
    }

    public void addProduct() {
        do {
            long id = System.currentTimeMillis() / 1000;
            String nameProduct = inputNameProduct(InputOption.ADD);
            double price = inputPrice(InputOption.ADD);
            int quantity = inputQuantity(InputOption.ADD);
            Product product = new Product((int) id, nameProduct, price, quantity);
            productService.add(product);
            System.out.println("Sản phẩm đã được thêm thành công!✅");
            showProduct(InputOption.ADD);
        } while (AppUtils.isRetry(InputOption.ADD));
    }

    public void update() {
        show(productService.findAll());
        System.out.println("Nhập ID cần sửa :");
        System.out.print("➤ ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            if (productService.exitsts(id)) {
                MainLauncher.inputUpdate();
                boolean is = true;
                do {
                    try {
                        int choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                inputPrice(id);
                                break;
                            case 2:
                                inputQuantity(id);
                                break;
                            case 3:
                                ProductViewLauncher.runProduct();
                                break;
                            default:
                                System.out.println("Không hợp lệ! Vui lòng nhập lại !");
                                break;
                        }
                    } catch (Exception e) {
                        update();
                    }
                } while (!is);
                boolean flag = true;
                do {
                    System.out.print("Nhấn 'c' để tiếp tục cập nhật || Nhấn 'b' để quay lại || Nhấn 'e' để thoát \n");
                    System.out.print("➠");
                    String choice = scanner.nextLine();
                    switch (choice) {
                        case "c":
                            update();
                            break;
                        case "b":
                            ProductViewLauncher.runProduct();
                            break;
                        case "e":
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Nhập sai ❌ Vui lòng nhập lại !");
                            break;
                    }
                } while (!flag);
            } else {
                System.out.println("Mời nhập lại!");
                update();
            }
        } catch (Exception e) {
            System.out.println("Nhập không chính xác❌");
            update();
        }
    }



    public void show(List<Product> productList) {
        System.out.println("──────────────────────────────────────── DANH SÁCH SẢN PHẨM ────────────────────────────────────────");
        System.out.printf("%-25s▎ %-25s| %-15s| %-18s|", "ID", "Tên ", "Giá", "Số lượng");
        System.out.println("");
        System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────");
        for (Product product : productList) {
            System.out.printf("%-25s| %-25s| %-15s| %-13s     |\n",
                    product.getProductID(),
                    product.getName(),
                    decimalFormat.format(product.getPrice()),
                    product.getQuantity());
        }
        System.out.println("");
        System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────\n");
    }


    public void showProduct(InputOption option) {
        List<Product> productList = productService.findAll();
        System.out.println("──────────────────────────────────────── DANH SÁCH SẢN PHẨM ────────────────────────────────────────");
        System.out.printf("%-25s %-25s %-15s %17s", "ID", "Tên ", "Giá", "Số lượng");
        System.out.println("");
        for (Product product : productList) {
            System.out.printf("%-25s %-25s %-15s %13s\n",
                    product.getProductID(),
                    product.getName(),
                    decimalFormat.format(product.getPrice()),
                    product.getQuantity());
        }
        System.out.println("");
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────\n");
    }

    public void inputPrice(int id) {
        Product product = productService.getProductByID(id);
        System.out.print("Nhập giá: ");
        System.out.print("➤ ");
        double price = Double.parseDouble(scanner.nextLine());
        product.setPrice(price);
        productService.update(product);
        showProduct(InputOption.UPDATE);
        System.out.println("Cập nhật thành công ✅ ");
    }

    public void inputQuantity(int id) {
        Product product = productService.getProductByID(id);
        System.out.print("Nhập số lượng: ");
        System.out.print("➤ ");
        int quartity = Integer.parseInt(scanner.nextLine());
        product.setQuantity(quartity);
        productService.update(product);
        showProduct(InputOption.UPDATE);
        System.out.println("Cập nhật thành công ✅");
    }

    public int inputId(InputOption option) {
        int id;
        switch (option) {
            case ADD:
                System.out.println("Nhập ID: ");
                break;
            case UPDATE:
                System.out.println("Nhập ID bạn muốn sửa: ");
                break;
            case DELETE:
                System.out.println("Nhập ID bạn muốn xóa: ");
                break;
        }
        boolean isRetry = false;
        do {
            id = AppUtils.retryParseInt();
            boolean exist = productService.exitsts(id);
            switch (option) {
                case ADD:
                    if (exist) {
                        System.out.println("ID đã tồn tại! Vui lòng nhập lại");
                    }
                    isRetry = !exist;
                    break;
            }
        } while (isRetry);
        return id;
    }

    public void remove() {
        List<Product> productList = productService.findAll();
        show(productList);
        int id;
        while (!productService.exitsts(id = inputId(InputOption.DELETE))) {
            System.out.println("Không tìm thấy ID! ");
            System.out.println("Nhấn '1' để tiếp tục || Nhấn '2' để quay lại || Nhấn '0' để thoát !");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    remove();
                    MainLauncher.menuProduct();
                    break;
                case 2:
                    MainLauncher.menuProduct();
                    return;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Chọn sai ❌Vui lòng chọn lại!");
                    break;
            }
        }
        System.out.println("\t┌────────────────────────────────────────────────────┐");
        System.out.println("\t│► ░░░░░░░░░░░░░░░░░[ XÁC NHẬN XÓA]░░░░░░░░░░░░░░░░ ◄│");
        System.out.println("\t└────────────────────────────────────────────────────┘");
        System.out.println("\t│               【1】. Nhấn 1 để xóa                  │");
        System.out.println("\t│               【2】. Nhấn 2 để quay lại             │");
        System.out.println("\t└────────────────────────────────────────────────────┘");
        int option = AppUtils.retryChoose(1, 2);
        if (option == 1) {
            productService.remove(id);
            System.out.println("Đã xóa sản phẩm thành công ✅");
            showProduct(InputOption.DELETE);
            AppUtils.isRetry(InputOption.DELETE);
        } else if (option == 2) {
            ProductViewLauncher.runProduct();
        }
    }
}

