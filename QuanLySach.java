import java.util.Scanner;

public class QuanLySach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Bài 1: Nhập thông tin sách
        System.out.print("Nhập mã sách: ");
        String maSach = sc.nextLine();
        System.out.print("Nhập tên sách: ");
        String tenSach = sc.nextLine();
        System.out.print("Nhập tác giả: ");
        String tacGia = sc.nextLine();
        System.out.print("Nhập năm xuất bản: ");
        int namXB = sc.nextInt();
        System.out.print("Nhập đơn giá: ");
        double donGia = sc.nextDouble();
        System.out.print("Nhập số lượng: ");
        int soLuong = sc.nextInt();
        System.out.println("\n===== THÔNG TIN SÁCH =====");
        System.out.println("Mã sách     : " + maSach);
        System.out.println("Tên sách    : " + tenSach);
        System.out.println("Tác giả     : " + tacGia);
        System.out.println("Năm xuất bản: " + namXB);
        System.out.println("Đơn giá     : " + donGia);
        System.out.println("Số lượng    : " + soLuong);

        // Bài 2: Thành tiền
        double thanhTien = donGia * soLuong;

        // Bài 3: Phí vận chuyển = 5% giá trị sách
        double phiVanChuyen = thanhTien * 0.05;

        // Bài 4: Tổng tiền nhập
        double tongTienNhap = thanhTien + phiVanChuyen;
        System.out.println("\n===== TÍNH TOÁN =====");
        System.out.printf("Thành tiền      : %,.0f%n", thanhTien);
        System.out.printf("Phí vận chuyển  : %,.0f%n", phiVanChuyen);
        System.out.printf("Tổng tiền nhập  : %,.0f%n", tongTienNhap);
        sc.close();
    }
}