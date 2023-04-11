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
import java.sql.SQLException;

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
    
    public void tambah(Pegawai brg) {
            PreparedStatement statement = null;
            try {
                statement = connection.prepareStatement(insert);
                statement.setString(1, brg.getNik());
                statement.setString(2, brg.getNama());
                statement.setInt(3, brg.getAlamat());
                statement.setInt(4, brg.getHarga());
                statement.setString(5, brg.getMerk());
                statement.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    
    
}
