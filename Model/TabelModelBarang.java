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
public class TabelModelBarang extends AbstractTableModel{
    List<Barang> ListBrg;

    public TabelModelBarang(List<Barang> ListBrg) {
        this.ListBrg = ListBrg;
    }
    
    @Override
    public int getRowCount() {
        return ListBrg.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int column) {
        return switch(column) {
            case 0 -> ListBrg.get(row).getKode();
            case 1 -> ListBrg.get(row).getNama();
            case 2 -> ListBrg.get(row).getJumlah();
            case 3 -> ListBrg.get(row).getHarga();
            case 4 -> ListBrg.get(row).getMerk();
            default -> null;
        };
    }
      
    @Override
    public String getColumnName(int column) {
        return switch(column) {
            case 0 -> "Kode";
            case 1 -> "Nama";
            case 2 -> "Jumlah";
            case 3 -> "Harga";
            case 4 -> "Merek";
            default -> null;
        };
    }
}
