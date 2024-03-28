package exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoException {
    public static void main(String[] args) throws MyCheckedException{
//        System.out.println("kq chia cho la "+(9/0)); // unchecked exception : la cac lop ke thua RuntimeException
//        System.out.println("ket thuc chuong trinh");


        // eps kieu tu String -> Date
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        Date date = sdf.parse("12/12/2024"); // checked exception , yeu cau phai xu li moi chay dc

//        Exception e = new Exception();
//        MyCheckedException checkedException = new MyCheckedException("loi checked");
//        MyUnCheckedException unCheckedException = new MyUnCheckedException("loi un checked : khong chia het cho 2");
//
//        if (9%2==0){
//            throw checkedException; // checked
//        }
        // try catch
        try{
            try {
                // code co the sinh ra loi
                checkSideTriangle(0, 1, 2);
            }catch (MyCheckedException e){
//            e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                // thuc thi khoi lenh bat chap co hay ko co loi
                System.out.println("thuc hien khoi finally");
                throw new  RuntimeException("loi moi");
            }

        }catch (RuntimeException r){
            System.out.println(r.getMessage());
        }
        System.out.println("ket thuc chuong trinh");


    }

    public static boolean checkSideTriangle(double a, double b, double c) throws Exception{
        if (a<=0 || b<=0 || c<=0){
            throw new MyCheckedException("3 canh phai lon hon 0");
        }

        if (a+b<=c || a+c<=b ||b+c<=a){
            throw new Exception("tong 2 canh phai lon hon canh con lai");
        }
        System.out.printf("%s , %s ,%s lla 3 canh cua 1 tam giac",a,b,c);
        return true;
    }
}
