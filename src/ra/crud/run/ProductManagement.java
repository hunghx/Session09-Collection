package ra.crud.run;

import ra.crud.design.IDesignProduct;
import ra.crud.impl.ProductImpl;

import java.util.Scanner;

public class ProductManagement {
    private static IDesignProduct productImpl = new ProductImpl();
    public static void main(String[] args) {
        while (true){
            displayMenu();
            System.out.println("Nhap lua chon cua ban");
            byte choice = new Scanner(System.in).nextByte();
            switch (choice){
                case 1:
                    // nhạp mơi
                    productImpl.addProduct();
                    break;
                case 2:
                    // hien thi
                    productImpl.displayProducts();
                    break;
                    case 3:
                    // sua
                    productImpl.editProduct();
                    break;
                case 7:
                    // tim kiem
                    productImpl.searchProductByPrice();
                    break;
                case 8:
                    System.out.println("Thoat chuong trinh");
                    return;
                default:
                    System.err.println("Nhap sai ");

            }
        }
    }
    private static void displayMenu(){
        System.out.println("====================Product Management====================");
        System.out.println("1.\tNhập thông tin các sản phẩm\n" +
                "2.\tHiển thị thông tin các sản phẩm\n" +
                "3.\tSắp xếp các sản phẩm theo giá\n" +
                "4.\tCập nhật thông tin sản phẩm theo mã sản phẩm\n" +
                "5.\tXóa sản phẩm theo mã sản phẩm\n" +
                "6.\tTìm kiếm các sản phẩm theo tên sản phẩm\n" +
                "7.\tTìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)\n" +
                "8.\tThoát\n");
    }
}
