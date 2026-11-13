import java.util.ArrayList;

// Lớp Sach (không dùng public vì chung file với lớp Test)
class Sach {
    String maSach;
    String tieuDe;
    String tacGia;
    int namXuatBan;
    int soLuong;

    // Yêu cầu 2: in thông tin chi tiết của một cuốn sách
    public void hienThiThongTin() {
        System.out.println("Mã sách     : " + maSach);
        System.out.println("Tiêu đề     : " + tieuDe);
        System.out.println("Tác giả     : " + tacGia);
        System.out.println("Năm xuất bản: " + namXuatBan);
        System.out.println("Số lượng    : " + soLuong);
        System.out.println("-----------------------------");
    }
}

public class BTT7 {
    public static void main(String[] args) {
        // Yêu cầu 3: tạo đối tượng từ lớp Sach
        Sach s1 = new Sach();
        s1.maSach = "S001";
        s1.tieuDe = "Lập trình Java cơ bản";
        s1.tacGia = "Nguyễn Văn A";
        s1.namXuatBan = 2020;
        s1.soLuong = 10;

        Sach s2 = new Sach();
        s2.maSach = "S002";
        s2.tieuDe = "Cấu trúc dữ liệu và giải thuật";
        s2.tacGia = "Trần Thị B";
        s2.namXuatBan = 2018;
        s2.soLuong = 5;

        Sach s3 = new Sach();
        s3.maSach = "S003";
        s3.tieuDe = "Cơ sở dữ liệu";
        s3.tacGia = "Lê Văn C";
        s3.namXuatBan = 2022;
        s3.soLuong = 8;

        // Yêu cầu 4: tạo và quản lý danh sách sách bằng ArrayList
        ArrayList<Sach> danhSach = new ArrayList<>();
        danhSach.add(s1);
        danhSach.add(s2);
        danhSach.add(s3);

        System.out.println("===== DANH SÁCH SÁCH TRONG THƯ VIỆN =====");
        for (Sach s : danhSach) {
            s.hienThiThongTin();
        }
        System.out.println("Tổng số đầu sách: " + danhSach.size());
    }
}