import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySach {
    static Scanner sc = new Scanner(System.in);

    static class Sach {
        String ma, ten, tacGia;
        int namXB, soLuong;
        double donGia;

        Sach(String ma, String ten, String tacGia, int namXB, double donGia, int soLuong) {
            this.ma = ma; this.ten = ten; this.tacGia = tacGia;
            this.namXB = namXB; this.donGia = donGia; this.soLuong = soLuong;
        }

        @Override
        public String toString() {
            return ma + " | " + ten + " | " + tacGia + " | " + namXB + " | " + donGia + " | " + soLuong;
        }
    }

    // Bài 3 & 4: danh sách sách
    static ArrayList<Sach> danhSachSach = new ArrayList<>();

    // Bài 1: mảng int[] soLuong cho 5 cuốn
    static void baiMang() {
        int[] soLuong = new int[5];
        int tong = 0;
        for (int i = 0; i < soLuong.length; i++) {
            System.out.print("Số lượng cuốn " + (i + 1) + ": ");
            soLuong[i] = Integer.parseInt(sc.nextLine());
            tong += soLuong[i];
        }
        int max = soLuong[0];
        for (int x : soLuong) if (x > max) max = x;
        System.out.println("Danh sách: " + java.util.Arrays.toString(soLuong));
        System.out.println("Tổng: " + tong + " | Lớn nhất: " + max);
    }

    // Bài 2: ArrayList<String> mã sách
    static void baiMaSach() {
        ArrayList<String> dsMa = new ArrayList<>();
        int c;
        do {
            System.out.println("\n1. Thêm mã  2. Hiển thị  3. Tìm  4. Xóa  0. Quay lại");
            System.out.print("Chọn: ");
            c = Integer.parseInt(sc.nextLine());
            switch (c) {
                case 1:
                    System.out.print("Mã cần thêm: "); dsMa.add(sc.nextLine()); break;
                case 2:
                    System.out.println(dsMa); break;
                case 3:
                    System.out.print("Mã cần tìm: ");
                    String k = sc.nextLine();
                    System.out.println(dsMa.contains(k) ? "Có, vị trí " + dsMa.indexOf(k) : "Không có");
                    break;
                case 4:
                    System.out.print("Mã cần xóa: ");
                    System.out.println(dsMa.remove(sc.nextLine()) ? "Đã xóa" : "Không tìm thấy");
                    break;
            }
        } while (c != 0);
    }

    static int timViTri(String ma) {
        for (int i = 0; i < danhSachSach.size(); i++)
            if (danhSachSach.get(i).ma.equalsIgnoreCase(ma)) return i;
        return -1;
    }

    static void themSach() {
        System.out.print("Mã sách: ");
        String ma = sc.nextLine();
        if (timViTri(ma) != -1) { System.out.println("Mã đã tồn tại!"); return; }
        System.out.print("Tên sách: ");  String ten = sc.nextLine();
        System.out.print("Tác giả: ");   String tg = sc.nextLine();
        System.out.print("Năm xuất bản: "); int nam = Integer.parseInt(sc.nextLine());
        System.out.print("Đơn giá: ");   double gia = Double.parseDouble(sc.nextLine());
        System.out.print("Số lượng: ");  int sl = Integer.parseInt(sc.nextLine());
        danhSachSach.add(new Sach(ma, ten, tg, nam, gia, sl));
        System.out.println("Đã thêm sách.");
    }

    static void hienThiSach() {
        if (danhSachSach.isEmpty()) { System.out.println("Chưa có sách."); return; }
        for (int i = 0; i < danhSachSach.size(); i++)
            System.out.println((i + 1) + ". " + danhSachSach.get(i));
    }

    static void timSach() {
        System.out.print("Nhập mã cần tìm: ");
        int i = timViTri(sc.nextLine());
        System.out.println(i == -1 ? "Không tìm thấy." : danhSachSach.get(i).toString());
    }

    static void xoaSach() {
        System.out.print("Nhập mã cần xóa: ");
        int i = timViTri(sc.nextLine());
        if (i == -1) System.out.println("Không tìm thấy.");
        else { danhSachSach.remove(i); System.out.println("Đã xóa."); }
    }

    static void suaSach() {
        System.out.print("Nhập mã cần sửa: ");
        int i = timViTri(sc.nextLine());
        if (i == -1) { System.out.println("Không tìm thấy."); return; }
        Sach s = danhSachSach.get(i);
        System.out.print("Tên mới: ");        s.ten = sc.nextLine();
        System.out.print("Tác giả mới: ");    s.tacGia = sc.nextLine();
        System.out.print("Năm XB mới: ");     s.namXB = Integer.parseInt(sc.nextLine());
        System.out.print("Đơn giá mới: ");    s.donGia = Double.parseDouble(sc.nextLine());
        System.out.print("Số lượng mới: ");   s.soLuong = Integer.parseInt(sc.nextLine());
        System.out.println("Đã cập nhật.");
    }

    static void tongSoLuong() {
        int t = 0;
        for (Sach s : danhSachSach) t += s.soLuong;
        System.out.println("Tổng số lượng: " + t);
    }

    static void tongGiaTri() {
        double t = 0;
        for (Sach s : danhSachSach) t += s.donGia * s.soLuong;
        System.out.println("Tổng giá trị: " + t);
    }

    // Bài 4: menu hoàn chỉnh
    public static void main(String[] args) {
        int chon;
        do {
            System.out.println("\n===== QUẢN LÝ THƯ VIỆN =====");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị sách");
            System.out.println("3. Tìm sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Sửa sách");
            System.out.println("6. Tính tổng số lượng");
            System.out.println("7. Tính tổng giá trị");
            System.out.println("8. Thoát");
            System.out.println("(9. Bài 1: mảng soLuong | 10. Bài 2: ArrayList mã sách)");
            System.out.print("Chọn: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1: themSach(); break;
                case 2: hienThiSach(); break;
                case 3: timSach(); break;
                case 4: xoaSach(); break;
                case 5: suaSach(); break;
                case 6: tongSoLuong(); break;
                case 7: tongGiaTri(); break;
                case 8: System.out.println("Tạm biệt!"); break;
                case 9: baiMang(); break;
                case 10: baiMaSach(); break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != 8);
    }
}