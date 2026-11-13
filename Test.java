import java.time.Year;
import java.util.ArrayList;

 
class Sach {

    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        setNamXuatBan(namXuatBan);
        setSoLuong(soLuong);
    }


    public String getMaSach() {
        return maSach;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public void setNamXuatBan(int namXuatBan) {
        int currentYear = Year.now().getValue();
        if (namXuatBan > 0 && namXuatBan <= currentYear) {
            this.namXuatBan = namXuatBan;
        } else {
            System.out.println("Năm xuất bản không hợp lệ: " + namXuatBan);
        }
    }

    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("Số lượng không hợp lệ: " + soLuong);
        }
    }

    public void hienThiThongTin() {
        System.out.println("Mã sách     : " + maSach);
        System.out.println("Tiêu đề     : " + tieuDe);
        System.out.println("Tác giả     : " + tacGia);
        System.out.println("Năm xuất bản: " + namXuatBan);
        System.out.println("Số lượng    : " + soLuong);
        System.out.println("-----------------------------");
    }
}

public class Test {
    public static void main(String[] args) {
        Sach s1 = new Sach("S001", "Lập trình Java cơ bản", "Nguyễn Văn A", 2020, 10);
        Sach s2 = new Sach("S002", "Cấu trúc dữ liệu và giải thuật", "Trần Thị B", 2018, 5);
        Sach s3 = new Sach("S003", "Cơ sở dữ liệu", "Lê Văn C", 2022, 8);

        ArrayList<Sach> danhSach = new ArrayList<>();
        danhSach.add(s1);
        danhSach.add(s2);
        danhSach.add(s3);

        System.out.println("===== DANH SÁCH SÁCH =====");
        for (Sach s : danhSach) {
            s.hienThiThongTin();
        }

        System.out.println("Tiêu đề sách 1: " + s1.getTieuDe());
        s1.setTieuDe("Lập trình Java nâng cao");
        s1.setSoLuong(15);

        s2.setNamXuatBan(3000);
        s2.setSoLuong(-5);

        System.out.println("\n===== SAU KHI CẬP NHẬT =====");
        for (Sach s : danhSach) {
            s.hienThiThongTin();
        }
    }
}