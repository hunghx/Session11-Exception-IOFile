package ra.bt.presentation;

import ra.bt.business.design.ICategory;
import ra.bt.business.entity.Category;
import ra.bt.business.impl.CategoryImpl;
import ra.bt.util.InputMethods;

import java.util.List;

public class CategoryManagement {
    private static ICategory categoryImpl = new CategoryImpl();
    public static void main(String[] args) {
        while (true){
            System.out.println(categoryMenu());
            // yeu cau nhap vao
            System.out.println("Hay nhap lua chon cua ban");
            byte choice = InputMethods.getByte();
            switch (choice){
                case 1:
                    showAllCategories();
                    break;
                case 2:
                    addNewCategories();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.err.println("Nhap ko hop le, vui long nhap lai");
            }
            if (choice==5){
                System.out.println("Dung chuong trinh");
                break;
            }

        }

    }

    public static String categoryMenu(){
        return "===============MENU=================\n" +
                "1. Hiển thị tất cả category\n" +
                "2. Thêm mới category\n" +
                "3. Sửa thông tin category\n" +
                "4. Xóa thông tin category\n" +
                "5. Dừng chương trình\n";
    }
    public static void showAllCategories(){
        List<Category> list = categoryImpl.findAll();
        if (list.isEmpty()){
            System.err.println("Danh sach danh muc trong!");
        }else {
            System.out.printf("| %-3s | %-15s | %-15s |\n","ID","Name","Status");
            for (Category cat : list){
                System.out.printf("| %-3s | %-15s | %-15s |\n",cat.getId(),cat.getName(),cat.isStatus()?"Hoạt động":"Không hoạt động");
            }
        }
    }
    public static void addNewCategories(){
        System.out.println("Nhap so luong muon them moi");
        int count = InputMethods.getInteger();
        for (int i = 0; i < count; i++) {
            System.out.println("Nhap thong tin cho danh muc thu "+(i+1));
            Category newCat = new Category();
            newCat.inputData(categoryImpl.findAll());
            categoryImpl.save(newCat);
        }
        System.out.println("da them thanh cong!");
    }


}
