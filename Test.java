import java.util.ArrayList;
import java.util.Scanner;

abstract class Sach {
    private String maSach;
    private int ngay, thang, nam;      
    private double donGia;
    private int soLuong;
    private String nhaXuatBan;

    public Sach() {
    }

    public Sach(String maSach, int ngay, int thang, int nam,
                double donGia, int soLuong, String nhaXuatBan) {
        this.maSach = maSach;
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
    }

    static int docSoNguyen(Scanner sc, String thongBao, int min, int max) {
        while (true) {
            System.out.print(thongBao);
            try {
                int giaTri = Integer.parseInt(sc.nextLine().trim());
                if (giaTri >= min && giaTri <= max) {
                    return giaTri;
                }
            } catch (NumberFormatException e)           
            
            System.out.println("  Giá trị không hợp lệ, vui lòng nhập lại!");
        }
    }

    static double docSoThuc(Scanner sc, String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                double giaTri = Double.parseDouble(sc.nextLine().trim());
                if (giaTri >= 0) {
                    return giaTri;
                }
            } catch (NumberFormatException e) 
            System.out.println("  Giá trị không hợp lệ, vui lòng nhập lại!");
        }
    }

    public void nhap(Scanner sc) {
        System.out.print("Mã sách: ");
        maSach = sc.nextLine().trim();
        ngay = docSoNguyen(sc, "Ngày nhập (1-31): ", 1, 31);
        thang = docSoNguyen(sc, "Tháng nhập (1-12): ", 1, 12);
        nam = docSoNguyen(sc, "Năm nhập: ", 1, 9999);
        donGia = docSoThuc(sc, "Đơn giá: ");
        soLuong = docSoNguyen(sc, "Số lượng: ", 0, Integer.MAX_VALUE);
        System.out.print("Nhà xuất bản: ");
        nhaXuatBan = sc.nextLine().trim();
    }

    public void xuat() {
        System.out.printf("Mã sách: %s | Ngày nhập: %02d/%02d/%d | Đơn giá: %.0f | SL: %d | NXB: %s",
                maSach, ngay, thang, nam, donGia, soLuong, nhaXuatBan);
    }

    public abstract double tinhThanhTien();

    public String getMaSach() {
        return maSach;
    }

    public double getDonGia() {
        return donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }
}

class SachGiaoKhoa extends Sach {
    private boolean tinhTrangMoi;   

    public SachGiaoKhoa() {
    }

    public SachGiaoKhoa(String maSach, int ngay, int thang, int nam,
                        double donGia, int soLuong, String nhaXuatBan, boolean tinhTrangMoi) {
        super(maSach, ngay, thang, nam, donGia, soLuong, nhaXuatBan);
        this.tinhTrangMoi = tinhTrangMoi;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        tinhTrangMoi = docSoNguyen(sc, "Tình trạng (1: mới, 0: cũ): ", 0, 1) == 1;
    }

    @Override
    public void xuat() {
        System.out.print("[Giáo khoa]   ");
        super.xuat();
        System.out.printf(" | Tình trạng: %s | Thành tiền: %.0f%n",
                tinhTrangMoi ? "mới" : "cũ", tinhThanhTien());
    }

    @Override
    public double tinhThanhTien() {
        double tien = getSoLuong() * getDonGia();
        return tinhTrangMoi ? tien : tien * 0.5;
    }
}

class SachThamKhao extends Sach {
    private double thue;

    public SachThamKhao() {
    }

    public SachThamKhao(String maSach, int ngay, int thang, int nam,
                        double donGia, int soLuong, String nhaXuatBan, double thue) {
        super(maSach, ngay, thang, nam, donGia, soLuong, nhaXuatBan);
        this.thue = thue;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        thue = docSoThuc(sc, "Thuế: ");
    }

    @Override
    public void xuat() {
        System.out.print("[Tham khảo]   ");
        super.xuat();
        System.out.printf(" | Thuế: %.0f | Thành tiền: %.0f%n", thue, tinhThanhTien());
    }

    @Override
    public double tinhThanhTien() {
        return getSoLuong() * getDonGia() + thue;
    }
}

public class Test {
    static ArrayList<Sach> danhSach = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chon;
        do {
            System.out.println("\n========== QUẢN LÝ SÁCH THƯ VIỆN ==========");
            System.out.println("1. Nhập danh sách sách");
            System.out.println("2. Xuất danh sách sách");
            System.out.println("3. Tính tổng thành tiền từng loại");
            System.out.println("4. Tính trung bình cộng đơn giá sách tham khảo");
            System.out.println("5. Xuất sách giáo khoa của nhà xuất bản X");
            System.out.println("6. Thêm dữ liệu mẫu (để test nhanh)");
            System.out.println("0. Thoát");
            chon = Sach.docSoNguyen(sc, "Chọn chức năng: ", 0, 6);

            switch (chon) {
                case 1:
                    nhapDanhSach(sc);
                    break;
                case 2:
                    xuatDanhSach();
                    break;
                case 3:
                    tongThanhTienTungLoai();
                    break;
                case 4:
                    trungBinhDonGiaThamKhao();
                    break;
                case 5:
                    System.out.print("Nhập tên nhà xuất bản X: ");
                    xuatGiaoKhoaTheoNXB(sc.nextLine().trim());
                    break;
                case 6:
                    themDuLieuMau();
                    break;
                default:
                    System.out.println("Kết thúc chương trình.");
            }
        } while (chon != 0);
    }

    static void nhapDanhSach(Scanner sc) {
        int n = Sach.docSoNguyen(sc, "Số lượng sách giáo khoa cần nhập: ", 0, 1000);
        for (int i = 1; i <= n; i++) {
            System.out.println("--- Sách giáo khoa thứ " + i + " ---");
            SachGiaoKhoa sgk = new SachGiaoKhoa();
            sgk.nhap(sc);
            danhSach.add(sgk);
        }
        int m = Sach.docSoNguyen(sc, "Số lượng sách tham khảo cần nhập: ", 0, 1000);
        for (int i = 1; i <= m; i++) {
            System.out.println("--- Sách tham khảo thứ " + i + " ---");
            SachThamKhao stk = new SachThamKhao();
            stk.nhap(sc);
            danhSach.add(stk);
        }
    }

    static void xuatDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách đang trống!");
            return;
        }
        System.out.println("===== DANH SÁCH SÁCH =====");
        for (Sach s : danhSach) {
            s.xuat();
        }
    }

    static void tongThanhTienTungLoai() {
        double tongGiaoKhoa = 0;
        double tongThamKhao = 0;
        for (Sach s : danhSach) {
            if (s instanceof SachGiaoKhoa) {
                tongGiaoKhoa += s.tinhThanhTien();
            } else if (s instanceof SachThamKhao) {
                tongThamKhao += s.tinhThanhTien();
            }
        }
        System.out.printf("Tổng thành tiền sách giáo khoa: %.0f%n", tongGiaoKhoa);
        System.out.printf("Tổng thành tiền sách tham khảo: %.0f%n", tongThamKhao);
    }

    static void trungBinhDonGiaThamKhao() {
        double tong = 0;
        int dem = 0;
        for (Sach s : danhSach) {
            if (s instanceof SachThamKhao) {
                tong += s.getDonGia();
                dem++;
            }
        }
        if (dem == 0) {
            System.out.println("Chưa có sách tham khảo nào!");
        } else {
            System.out.printf("Trung bình cộng đơn giá sách tham khảo: %.2f%n", tong / dem);
        }
    }

    static void xuatGiaoKhoaTheoNXB(String nxb) {
        boolean timThay = false;
        for (Sach s : danhSach) {
            if (s instanceof SachGiaoKhoa && s.getNhaXuatBan().equalsIgnoreCase(nxb)) {
                s.xuat();
                timThay = true;
            }
        }
        if (!timThay) {
            System.out.println("Không có sách giáo khoa nào của nhà xuất bản " + nxb);
        }
    }

    static void themDuLieuMau() {
        danhSach.add(new SachGiaoKhoa("GK01", 5, 9, 2025, 50000, 10, "Giáo Dục", true));
        danhSach.add(new SachGiaoKhoa("GK02", 12, 10, 2025, 40000, 20, "Kim Đồng", false));
        danhSach.add(new SachGiaoKhoa("GK03", 1, 11, 2025, 60000, 5, "Giáo Dục", false));
        danhSach.add(new SachThamKhao("TK01", 20, 8, 2025, 80000, 4, "Trẻ", 10000));
        danhSach.add(new SachThamKhao("TK02", 15, 9, 2025, 120000, 2, "Giáo Dục", 20000));
        System.out.println("Đã thêm 5 sách mẫu.");
    }
}