package ra.crud.impl;

import ra.crud.design.IDesignProduct;
import ra.crud.entity.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProductImpl implements IDesignProduct {
    public static final Scanner SCANNER = new Scanner(System.in);
    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product("S001","Caphe hương chồn","nothing",10,new Date(),(byte)0));
        productList.add(new Product("S002","Caphe hương mèo","nothing",10,new Date(),(byte)0));
        productList.add(new Product("S003","Caphe hương chó","nothing",10,new Date(),(byte)0));
    }
    @Override
    public void addProduct() {
        System.out.println("Nhập vào s lượng muốn thêm");
        byte count = Byte.parseByte(SCANNER.nextLine());
        for (int i =1; i <=count ; i++) {
            System.out.println("Nhập thông tin cho product thứ "+i);
            Product newProduct = new Product();
            newProduct.inputData(productList,true);
            productList.add(newProduct);
        }
        System.out.println("thêm mơ thanh công "+count+ " phần tử !");
    }

    @Override
    public void displayProducts() {
        if (productList.isEmpty()){
            System.err.println("danh sach trống");
        }else {
            for (Product p: productList){
                p.displayData();
            }
        }
    }

    @Override
    public void editProduct() {
        System.out.println("Nhập id caa sửa");
        String idEdit = SCANNER.nextLine();
        Product productEdit = findById(idEdit);

        if (productEdit==null){
            System.err.println("id  ko tìm thấy");
        }else {
            System.out.println("Thông tin cũ là ");
            productEdit.displayData();
            System.out.println("Nhập thông tin mơi");
            productEdit.inputData(productList,false);
            System.out.println("đã cap nhạt thành cong");
        }
    }
    private Product findById(String id){
        for (Product p:productList){
            if (p.getProductId().equals(id)){
                return p;
            }
        }
        return null;
    }

    @Override
    public void deleteProduct() {

    }

    @Override
    public void searchProductByPrice() {
        System.out.println("Nhap và giá bắt đầu");
        float start = Float.parseFloat(SCANNER.nextLine());
        System.out.println("Nhap và giá kết thúc");
        float end = Float.parseFloat(SCANNER.nextLine());
        boolean check = false;
        for (Product p:productList){
            if (p.getPrice()>=start && p.getPrice()<=end){
                check =true;
                p.displayData();
            }
        }
        if (!check){
            System.err.println("Khong tim thay sp nào có gia từ "+start +" đến "+end);
        }
    }
}
