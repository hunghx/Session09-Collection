package ra.crud.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Product {
    public static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
    private String productId,productName,description;
    private float price;
    private Date created;
    private byte status;

    public Product() {
    }

    public Product(String productId, String productName, String description, float price, Date created, byte status) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.created = created;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
    public void inputData(List<Product> products,boolean isAdd){
        if (isAdd){
            getInputProductId(products);
        }
        getInputProductName(products);
        getInputProductPrice();
        System.out.println("Nhập mô tả");
        this.description = new Scanner(System.in).nextLine();
        getInputCreateDate();
        this.status = 0;
    };
    public void displayData(){
        System.out.printf("| ID : %-5s | Name : %-30s | Price : %-5s |\n| Description : %-10s | Created : %-10s | Status : %-10s\n",
                productId,productName,price,description,SDF.format(created),getStatusByIndex(status));
    }
    private void getInputProductId(List<Product> products){
        String regex = "^[CSA]\\w{3}$";
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Hãy nhập vào id");
            String productId = sc.nextLine();
            if (productId.matches(regex)){
                if (!existById(productId,products)){
                    this.productId = productId;
                    break;
                }
                System.err.println("ID đã tồn tại");
            }
            System.err.println("Id không đúng đin dạng, bắt đầu bằng C,S,A và có 4 kí tự");
        }
    }
    private void getInputProductName(List<Product> products){
//        String regex = "^\\w{10,50}$";
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Hãy nhập vào tên");
            String productName = sc.nextLine();
            if (productName.length()>=10 && productName.length()<=50){
                if (!existByName(productName,products)){
                    this.productName = productName;
                    break;
                }
                System.err.println("Tên đã tồn tại");
            }
            System.err.println("Tên sp phải từ 10- 50 kí tự");
        }
    }
    private void getInputProductPrice(){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Hãy nhập vào giá");
            this.price = sc.nextFloat();
            if (price > 0){
                break;
            }
            System.err.println("Giá sp pha lớn hơn 0");
        }
    }
    private void getInputDescription(){

    }


    private boolean existById(String id, List<Product> products){
        for (Product p:products){
            if(p.getProductId().equals(id)){
                return true;
            }
        }
        return false;
    }
    private boolean existByName(String name, List<Product> products){
        for (Product p:products){
            if(p.getProductName().equals(name)){
                return true;
            }
        }
        return false;
    }
    private void getInputCreateDate(){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Nhập ngày tạo");
            String input = sc.nextLine();
            try {
                this.created = SDF.parse(input);
                break;
            } catch (ParseException e) {
                System.err.println("Ko đúng định dạng dd/MM/yyyy");
            }
        }
    }
    private String getStatusByIndex(byte index){
        switch (index){
            case 0:
                return "Đang bán";
            case 1:
                return "Hết hàng";
            case 3:
                return "Không bán";
        }
        return null;
    }

}
