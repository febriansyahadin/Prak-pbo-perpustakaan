/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author zanet
 */
public class Anggota {
    private int idAnggota;
    private String nama;
    private String alamat;
    private String telepon;

    public Anggota() {
        
    }

    public Anggota(String nama, String alamat, String telepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
    }

    public int getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(int idAnggota) {
        this.idAnggota = idAnggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
    
    
    public Anggota getById(int id){
        Anggota ang = new Anggota();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM Anggota " 
                + "WHERE idanggota = '" + id + "'");
        
        try {
            while(rs.next()){
                ang = new Anggota();
                ang.setIdAnggota(rs.getInt("idanggota"));
                ang.setNama(rs.getString("nama"));
                ang.setAlamat(rs.getString("alamat"));
                ang.setTelepon(rs.getString("telepon"));
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return ang;
    }
    
    public ArrayList<Anggota> getAll(){
        ArrayList<Anggota> ListAnggota = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM anggota");
        
        try {
            while(rs.next()){
                Anggota ang = new Anggota();
                ang.setIdAnggota(rs.getInt("idanggota"));
                ang.setNama(rs.getString("nama"));
                ang.setAlamat(rs.getString("alamat"));
                ang.setTelepon(rs.getString("telepon"));
                
                ListAnggota.add(ang);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListAnggota;
    }
    
    public ArrayList<Anggota> search(String keyword) {
    ArrayList<Anggota> ListAnggota = new ArrayList<>();
    
    String sql = "SELECT * FROM anggota WHERE "
            + "nama LIKE '%" + keyword + "%' "
            + "OR alamat LIKE '%" + keyword + "%' "
            + "OR telepon LIKE '%" + keyword + "%'";
    
    ResultSet rs = DBHelper.selectQuery(sql);
    
    try {
        while (rs.next()) {
            Anggota ang = new Anggota();
            ang.setIdAnggota(rs.getInt("idanggota"));
            ang.setNama(rs.getString("nama"));
            ang.setAlamat(rs.getString("alamat"));
            ang.setTelepon(rs.getString("telepon"));
            
            ListAnggota.add(ang);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ListAnggota;
}
    
    public void save() {
    if (getById(idAnggota).getIdAnggota() == 0) {
        // Query untuk insert data
        String SQL = "INSERT INTO anggota (nama, alamat, telepon) VALUES ("
                + "'" + this.nama + "', "
                + "'" + this.alamat + "', "
                + "'" + this.telepon + "')";
        this.idAnggota = DBHelper.insertQueryGetId(SQL);
    } else {
        // Query untuk update data
        String SQL = "UPDATE anggota SET "
                + "nama = '" + this.nama + "', "
                + "alamat = '" + this.alamat + "', "
                + "telepon = '" + this.telepon + "' "
                + "WHERE idAnggota = " + this.idAnggota;
        DBHelper.executeQuery(SQL);
    }
}

   public void delete() {
    String SQL = "DELETE FROM anggota WHERE idanggota = '" + this.idAnggota + "'";
    DBHelper.executeQuery(SQL);
    }
}
