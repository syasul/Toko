/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.Koneksi;
import Model.Barang;
import Model.Pegawai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class daoPegawai {
    Connection connection;
    final String insert = "INSERT into pegawai(nik, nama, alamat, jabatan, jenkel, username, password) VALUES (?,?,?,?,?,?,?);";
    final String update = "UPDATE pegawai SET nama=?, alamat=?, jabatan=?, jenkel=?, username=?, password=? WHERE nik=?;";
    final String delete = "DELETE * FROM pegawai WHERE nik=?;";
    final String select = "SELECT * FROM pegawai ORDER BY nik ASC;";
    final String selectData = "SELECT * FROM pegawai where nik=?;";
    
    public daoPegawai(){
        connection = Koneksi.connection();
    }
    
    public void tambah(Pegawai pegawai) {
            PreparedStatement statement = null;
            try {
                statement = connection.prepareStatement(insert);
                statement.setString(1, pegawai.getNik());
                statement.setString(2, pegawai.getNama());
                statement.setString(3, pegawai.getAlamat());
                statement.setString(4, pegawai.getJabatan());
                statement.setString(5, pegawai.getJenkel());
                statement.setString(6, pegawai.getUsername());
                statement.setString(7, pegawai.getPassword());
                statement.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    
        public void ubah(Pegawai pegawai) {
            PreparedStatement statement = null;
            try {
                statement = connection.prepareStatement(update);
                statement.setString(1, pegawai.getNik());
                statement.setString(2, pegawai.getNama());
                statement.setString(3, pegawai.getAlamat());
                statement.setString(4, pegawai.getJabatan());
                statement.setString(5, pegawai.getJenkel());
                statement.setString(6, pegawai.getUsername());
                statement.setString(7, pegawai.getPassword());
                statement.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        
        public void hapus(Pegawai pegawai) {
            PreparedStatement statement = null;
            try {
                statement = connection.prepareStatement(delete);
                statement.setString(1, pegawai.getNik());
                statement.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        
        public void tampil(Pegawai pegawai) {
            PreparedStatement statement = null;
            try {
                statement = connection.prepareStatement(delete);
                statement.setString(1, pegawai.getNik());
                statement.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        
        public List<Pegawai> getData() {
                List<Pegawai> listPegawai = null;
                try {
                    listPegawai = new ArrayList<>();
                    Statement st = connection.createStatement();
                    ResultSet rs = st.executeQuery(select);
                    while (rs.next()) {
                        Pegawai pegawai = new Pegawai();
                        pegawai.setNik(rs.getString("nik"));
                        pegawai.setNama(rs.getString("nama"));
                        pegawai.setAlamat(rs.getString("alamat"));
                        pegawai.setJabatan(rs.getString("jabatan"));
                        pegawai.setJenkel(rs.getString("jenkel"));
                        pegawai.setUsername(rs.getString("username"));
                        pegawai.setPassword(rs.getString("password"));
                        listPegawai.add(pegawai);
                    }
                } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null, ex);
                }
                return listPegawai;
            }
            
        public int cekNik(String nik) {
                PreparedStatement statement = null;
                int ketemu = 0;
                try {
                    statement = connection.prepareStatement(selectData);
                    statement.setString(1, nik);
                    ResultSet rs = statement.executeQuery();
                    while(rs.next()) {
                        ketemu++;
                    }
                } catch (SQLException ex) {
                    System.out.print(ex.getMessage());
                }
                return ketemu;
            }
    
}
