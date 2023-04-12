/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.daoBarang;
import Model.Barang;
import Model.TabelModelBarang;
import View.FormBarang;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class controllerBarang {
     FormBarang frame;
    List<Barang> listBrg;
    daoBarang daoBrg = new daoBarang();
    Barang brg = new Barang();
    
    public controllerBarang(FormBarang frame) {
        this.frame = frame;
    }
    
    public void tampil_label() {
        TabelModelBarang tabelBrg = new TabelModelBarang(daoBrg.getData());
            frame.getTblBarang().setModel(tabelBrg);
    }
    
    public void tambahData() {
        if (frame.getTextKode().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Barang Belum Diisi");
        } else {
            brg.setKode(frame.getTextKode().getText());
            brg.setNama(frame.getTextNama().getText());
            brg.setJumlah(Integer.parseInt(frame.getTxtJumlah().getText()));
            brg.setHarga(Integer.parseInt(frame.getTxtHarga().getText()));
            brg.setMerk(frame.getTextMerek().getText());
            daoBrg.tambah(brg);
            System.out.println("Berhasil Mengirimkan Data");
            JOptionPane.showMessageDialog(frame,"Berhasil menambahkan data");
        }
    }
    
//    new
//    public void IsiRow(int row) {
//        frame.getTextKode().setText(listBrg.get(row).getKode());
//        frame.getTextNama().setText(listBrg.get(row).getNama());
//        frame.getTxtJumlah().setText(String.valueOf(listBrg.get(row).getJumlah()));
//        frame.getTxtHarga().setText(String.valueOf(listBrg.get(row).getHarga()));
//        frame.getTextMerek().setText(listBrg.get(row).getMerk());
//        
//    }
//    
////    new
    public void ubahData() {
         if (frame.getTextKode().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Barang Belum Diisi");
        } else {
            brg.setKode(frame.getTextKode().getText());
            brg.setNama(frame.getTextNama().getText());
            brg.setJumlah(Integer.parseInt(frame.getTxtJumlah().getText()));
            brg.setHarga(Integer.parseInt(frame.getTxtHarga().getText()));
            brg.setMerk(frame.getTextMerek().getText());
            
            daoBrg.ubah(brg);
            System.out.println("Berhasil update Data");
            JOptionPane.showMessageDialog(frame,"Berhasil update data");
        }
    }
    
    public void hapusData() {
        brg.setKode(frame.getTextKode().getText());
        daoBrg.hapus(brg);
        JOptionPane.showMessageDialog(frame, "Berhasil Menghapus data");
    }
    
    public void bersih() {
        frame.setTxtKode("");
        frame.setTxtNama("");
        frame.setTxtJumlah(0);
        frame.setTxtHarga(0);
        frame.setTxtMerek("");
    }
    
    public void keluar() {
        frame.dispose();
    }
}
