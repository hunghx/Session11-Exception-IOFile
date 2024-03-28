package ra.bt.business.entity;

import ra.bt.util.InputMethods;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Category implements Serializable {
    // field
    private int id;
    private String name;
    private boolean status;
    // constructor

    public Category() {
    }

    public Category(int id, String name, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public void inputData(List<Category> categories){
        this.id = newId(categories);
        this.name = inputName(categories);
        this.status = inputStatus();
    }
    private int newId(List<Category> categories){
        int idMax =0;
        for (Category cat : categories){
            if (cat.getId()>idMax){
                idMax = cat.getId();
            }
        }
        return idMax+1;
    }
    private String inputName(List<Category> categories){
        while (true){
            System.out.println("hay nhap ten cho danh muc");
            String name = InputMethods.getString();
            if (!existByName(name,categories)){
                return name;
            }
            System.err.println("Ten da ton tai");
        }
    }
    private boolean existByName(String name,List<Category> categories){
        for (Category cat : categories){
            if (cat.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    public boolean inputStatus(){
        System.out.println("Hayx chon trang thai ");
        System.out.println("1. Hoat dong");
        System.out.println("2. Khong hoat dong");
        System.out.println("nhap lua chon");
        byte choice = InputMethods.getByte();
        return choice==1;
    }
}
