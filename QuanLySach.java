import java.util.Scanner;

public class QuanLySach {
    static Scanner sc = new Scanner(System.in);

    static int n = 0;
    static String[] ma = new String[100];
    static String[] ten = new String[100];
    static String[] tacGia = new String[100];
    static int[] namXB = new int[100];
    static double[] donGia = new double[100];
    static int[] soLuong = new int[100];

    // Bài 1: nhập n sách bằng vòng lặp for
    static void nhapSach() {
        System.out.print("Nhập số lượng sách cần nhập: ");
        int k = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < k && n < 100; i++) {
            System.out.println("--- Sách thứ " + (n + 1) + " ---");
            System.out.print("Mã sách: ");   ma[n] = sc.nextLine();
            System.out.print("Tên sách: ");  ten[n] = sc.nextLine();
            System.out.print("Tác giả: ");   tacGia[n] = sc.nextLine();
            System.out.print("Năm xuất bản: "); namXB[n] = Integer.parseInt(sc.nextLine());
            System.out.print("Đơn giá: ");   donGia[n] = Double.parseDouble(sc.nextLine());
            System.out.print("Số lượng: ");  soLuong[n] = Integer.parseInt(sc.nextLine());
            n++;
        }
    }

    static void hienThi() {
        if (n == 0) { System.out.println("Chưa có sách."); return; }
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". " + ma[i] + " | " + ten[i] + " | " + tacGia[i]
                    + " | " + namXB[i] + " | " + donGia[i] + " | " + soLuong[i]);
        }
    }

    // Bài 2: tổng số lượng và tổng giá trị
    static void tinhTong() {
        int tongSL = 0;
        double tongGT = 0;
        for (int i = 0; i < n; i++) {
            tongSL += soLuong[i];
            tongGT += donGia[i] * soLuong[i];
        }
        System.out.println("Tổng số lượng: " + tongSL);
        System.out.println("Tổng giá trị: " + tongGT);
    }

    // Bài 4: tìm sách theo mã
    static void timTheoMa() {
        System.out.print("Nhập mã sách cần tìm: ");
        String key = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (ma[i].equalsIgnoreCase(key)) {
                System.out.println("Tìm thấy: " + ten[i] + " | " + tacGia[i] + " | "
                        + namXB[i] + " | " + donGia[i] + " | " + soLuong[i]);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Không tìm thấy sách có mã " + key);
    }

    // Bài 3: menu lặp đến khi chọn Thoát (do-while)
    public static void main(String[] args) {
        int chon;
        do {
            System.out.println("\n===== QUẢN LÝ THƯ VIỆN =====");
            System.out.println("1. Nhập sách");
            System.out.println("2. Hiển thị sách");
            System.out.println("3. Tính tổng số lượng và giá trị");
            System.out.println("4. Tìm sách theo mã");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1: nhapSach(); break;
                case 2: hienThi(); break;
                case 3: tinhTong(); break;
                case 4: timTheoMa(); break;
                case 0: System.out.println("Tạm biệt!"); break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != 0);
    }
}