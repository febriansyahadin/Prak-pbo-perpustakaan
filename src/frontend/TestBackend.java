package frontend;

import backend.Pegawai;

public class TestBackend {
    public static void main(String[] args) {
        Pegawai pgw1 = new Pegawai("Yudi", "Malang", "0987654", "Staff", "yudi123", "password1");
        Pegawai pgw2 = new Pegawai("Budi", "Surabaya", "08765243", "Manager", "budi123", "password2");
        Pegawai pgw3 = new Pegawai("Messi", "Suhat", "07654333", "Supervisor", "messi123", "password3");

        // Test insert
        pgw1.save();
        pgw2.save();
        pgw3.save();

// Test update
        pgw2.setNama("Budianto");
        pgw2.setAlamat("Sidoarjo");
        pgw2.setNoTelp("0812345678");
        pgw2.setJabatan("Senior Manager");
        pgw2.setUsername("budianto123");
        pgw2.setPassword("securepassword");
        pgw2.save();

        // Test delete
        pgw3.delete();

        // Test select all
        System.out.println("Daftar Pegawai:");
        for (Pegawai p : new Pegawai().getAll()) {
            System.out.println("Nama: " + p.getNama() + 
                       ", Alamat: " + p.getAlamat() + 
                       ", Telepon: " + p.getNoTelp() + 
                       ", Jabatan: " + p.getJabatan() + 
                       ", Username: " + p.getUsername());
        }
    }
}