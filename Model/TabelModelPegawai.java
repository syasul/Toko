/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class TabelModelPegawai extends AbstractTableModel{
    List<Pegawai> ListPegawai;

    public TabelModelPegawai(List<Pegawai> ListPegawai) {
        this.ListPegawai = ListPegawai;
    }
    
    @Override
    public int getRowCount() {
        return ListPegawai.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int row, int column) {
        return switch(column) {
            case 0 -> ListPegawai.get(row).getNik();
            case 1 -> ListPegawai.get(row).getNama();
            case 2 -> ListPegawai.get(row).getAlamat();
            case 3 -> ListPegawai.get(row).getJabatan();
            case 4 -> ListPegawai.get(row).getJenkel();
            case 5 -> ListPegawai.get(row).getUsername();
            case 6 -> ListPegawai.get(row).getPassword();
            default -> null;
        };
    }
      
    @Override
    public String getColumnName(int column) {
        return switch(column) {
            case 0 -> "NIK";
            case 1 -> "Nama";
            case 2 -> "Alamat";
            case 3 -> "Jabatan";
            case 4 -> "Jenis Kelamin";
            case 5 -> "Username";
            case 6 -> "Password";
            default -> null;
        
        };
    }
}
