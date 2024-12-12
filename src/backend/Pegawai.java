/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author ADMIN
 */
public class Pegawai {
    private int idPegawai;
    private String nama;
    private String alamat;
    private String noTelp;
    private String jabatan;
    private String username;
    private String password;

    public Pegawai() {
    }

    public Pegawai(String nama, String alamat, String noTelp, String jabatan, String username, String password) {
        this.nama = nama;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.jabatan = jabatan;
        this.username = username;
        this.password = password;
    }

    public int getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(int idPegawai) {
        this.idPegawai = idPegawai;
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

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Pegawai getById(int id){
        Pegawai peg = new Pegawai();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pegawai " 
                + "WHERE idpegawai = '" + id + "'");

        try {
            while(rs.next()){
                peg = new Pegawai();
                peg.setIdPegawai(rs.getInt("idpegawai"));
                peg.setNama(rs.getString("nama"));
                peg.setAlamat(rs.getString("alamat"));
                peg.setNoTelp(rs.getString("notelp"));
                peg.setJabatan(rs.getString("jabatan"));
                peg.setUsername(rs.getString("username"));
                peg.setPassword(rs.getString("password"));
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
       return peg;
    }
    
    public ArrayList<Pegawai> getAll(){
        ArrayList<Pegawai> ListPegawai = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pegawai");
        
        try {
            while(rs.next()){
                Pegawai peg = new Pegawai();
                peg.setIdPegawai(rs.getInt("idpegawai"));
                peg.setNama(rs.getString("nama"));
                peg.setAlamat(rs.getString("alamat"));
                peg.setNoTelp(rs.getString("notelp"));
                peg.setJabatan(rs.getString("jabatan"));
                peg.setUsername(rs.getString("username"));
                peg.setPassword(rs.getString("password"));
                ListPegawai.add(peg);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListPegawai;
    }
    
    public ArrayList<Pegawai> search(String keyword){
         ArrayList<Pegawai> ListPegawai = new ArrayList<>();

          String sql = "SELECT * FROM pegawai WHERE "
            + "nama LIKE '%" + keyword + "%' "
            + "OR nama LIKE '%" + keyword + "%' "
            + "OR alamat LIKE '%" + keyword + "%' "
            + "OR notelp LIKE '%" + keyword + "%' "
            + "OR jabatan LIKE '%" + keyword + "%' "
            + "OR username LIKE '%" + keyword + "%' "
            + "OR password LIKE '%" + keyword + "%'";
            
         ResultSet rs = DBHelper.selectQuery(sql);
         
          try {
            while(rs.next()){
                Pegawai peg = new Pegawai();
                peg.setIdPegawai(rs.getInt("idpegawai"));
                peg.setNama(rs.getString("nama"));
                peg.setAlamat(rs.getString("alamat"));
                peg.setNoTelp(rs.getString("notelp"));
                peg.setJabatan(rs.getString("jabatan"));
                peg.setUsername(rs.getString("username"));
                peg.setPassword(rs.getString("password"));
                
                ListPegawai.add(peg);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListPegawai;
    }
    
   public void save() {
        if (getById(idPegawai).getIdPegawai()== 0) {
            String SQL = "INSERT INTO pegawai (nama, alamat, notelp, jabatan, username, password) VALUES ("
            + "'" + this.nama + "', "
            + "'" + this.alamat + "', "
            + "'" + this.noTelp + "', "
            + "'" + this.jabatan + "', "
            + "'" + this.username + "', "
            + "'" + this.password + "'"
            + ")";

            this.idPegawai = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE pegawai SET "
            + "nama = '" + this.nama + "', "
            + "alamat = '" + this.alamat + "', "
            + "notelp = '" + this.noTelp + "', "
            + "jabatan = '" + this.jabatan + "', "
            + "username = '" + this.username + "', "
            + "password = '" + this.password + "' "
            + "WHERE idpegawai = '" + this.idPegawai + "'";

            DBHelper.executeQuery(SQL); 
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM pegawai WHERE idpegawai = '" + this.idPegawai + "'";
        DBHelper.executeQuery(SQL);
    }
    
    public boolean isUsernameExists(String username) {
        boolean result = false;
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pegawai WHERE username = '" + username + "'");
        try {
            if (rs.next()) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    @Override
  public String toString(){
        return  nama;
    }

}