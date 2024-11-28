package frontend;

import backend.Anggota;

public class TestBackend {
    public static void main(String[] args) {
        // Membuat objek Anggota
        Anggota ang1 = new Anggota("yudi", "malang", "0987654");
        Anggota ang2 = new Anggota("budi", "surabaya", "08765243");
        Anggota ang3 = new Anggota("messi", "suhat", "07654333");
        
        // Test insert
        ang1.save();
        ang2.save();
        ang3.save();

        // Test update
        ang2.setNama("budianto");
        ang2.setAlamat("sidoarjo");
        ang2.setTelepon("0812345678");
        ang2.save();

        // Test delete
        ang3.delete();

        // Test select all
        System.out.println("Daftar Anggota:");
        for (Anggota a : new Anggota().getAll()) {
            System.out.println("Nama: " + a.getNama() + ", Alamat: " + a.getAlamat() + ", Telepon: " + a.getTelepon());
        }
    }
}
