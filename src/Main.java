import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Generic la tham số cho kiểu dữ liệu tham chiếu
        int[] arr = {1,2,3,4,5};
        // thêm mới 1 phần tử vào

//        Collection
//        Collections
        // khởi tạo collection
        Collection<Integer> list = new ArrayList<>();
        System.out.println("so luong ptu trong danh sach là :"+list.size());
        // thêm mới
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(2);
         // in  danh sách
        System.out.println(list);
        // xóa pần tử
        list.remove(5);
        System.out.println(list);
        // kiểm tra tồn tai
        System.out.println(" phần tử 4 có tồn tại trong list hay ko ? "+list.contains(4));
        // kiểm tra xem danh sách có rỗng hay ko
        System.out.println("is empty là "+list.isEmpty());
        // duyệt danh sách với iterator
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(" phần tử tiêp theo là "+iterator.next());
        }
        // for each
        for (Integer i : list){
            System.out.println(i);
        }

        // xóa toan bô
        list.clear();

        System.out.println(list);

        // List collection

        List<String> studentNameList = new LinkedList<>();
        // cung cấp các phương thức làm việc với index
        studentNameList.add("Uy");
        studentNameList.add("Nam");
        studentNameList.add("Long");
        studentNameList.add("Long");
        studentNameList.add(1,"Khanh");
        System.out.println(studentNameList);
        // xóa theo vị tri
        studentNameList.remove(1);// xóa khánh
        System.out.println(studentNameList);
        // sửa theo vị trí
        studentNameList.set(1,"Hùng");
        System.out.println(studentNameList);
        // lấy giá trị theo v trí
        System.out.println("phan tu tai vi tri index = 2 là "+studentNameList.get(2));
        // tim vị trí của phần tư
        int index = studentNameList.indexOf("Long");
        System.out.println(index);
        int lastIndex = studentNameList.lastIndexOf("Long");
        System.out.println(lastIndex);

        // Sắp xếp
        studentNameList.sort((o1, o2) -> o2.compareTo(o1));


        // Set - danh sách các phần tử ko trùng lặp
        Set<Integer> set = new HashSet<>();
//        Set<Integer> set = new LinkedHashSet<>();
//        Set<Integer> set = new TreeSet<>();

        set.add(1);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);
        System.out.println(set);

        // xóa
        set.remove(1);
        System.out.println(set);
        int a = 10;
        changeVariable(a);
        System.out.println(a); // 10

        int[] arrInt = {1,2};
        changeArray(arrInt);
        System.out.println(Arrays.toString(arrInt));


        StringBuilder str =new StringBuilder("hung");
        changeString(str);
        System.out.println(str);

    }
    public static void changeVariable(int c){
        c =100;

        // c sẽ bị hủy
    }
    public static void changeArray(int[] a){
        a[0] =100;
    } public static void changeString(StringBuilder a){
        a.append("khánh");
    }
}