import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập họ tên: ");
        String hoTen = sc.nextLine();
        System.out.println("Họ tên của bạn là: " + hoTen);
        System.out.println("Xin chào!");
        sc.close();
    }
}