package iofile;

import entity.Employee;

import java.io.*;
import java.time.LocalDate;

public class DemoFile {
    public static void main(String[] args) {
        // Lop File
//        File file = new File("demo.docx");
//        System.out.println("exists :"+file.exists());
//        System.out.println("issDirectory : "+file.isDirectory());
//        if (!file.exists()){
//            // tao moi thu muc
////            file.mkdirs();
//            // tao moi file
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//
//        if (file.exists()){
//            file.delete();
//        }

        // tuan tu hoa (serializable) cho phep Object trong Java -> byte[]
        // giai tuan tu hoa (deserializatble) cho phep byte[] -> Object

//        Employee employee = new Employee("S001","Nguyen Van A", LocalDate.of(1999,10,10),true,10000000,null);
//        writeToFile("student.txt",employee);

        Employee e =readFromFile("student.txt");
        System.out.printf("ID : %s| Name: %s",e.getEmployeeId(),e.getEmployeeName());

    }

    public static  void writeToFile(String pathFile, Employee employee){
        // tao doi tuong FILE
        File file = new File(pathFile);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectOutputStream oos = null;
        // luu ra file
        try {
           oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(employee);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (oos!=null) {
                    oos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static Employee readFromFile(String pathFile){
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream(new FileInputStream(pathFile));
           Employee e =(Employee) ois.readObject();
           return e;
        }catch (FileNotFoundException e){
            System.err.println("file ko ton tai");
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Lopw ko doc duoc");
        }finally {
            try {
                if (ois!=null) {
                    ois.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
