/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.daoPegawai;
import Model.Pegawai;
import Model.TabelModelPegawai;
import View.FormPegawai;
import java.util.List;

/**
 *
 * @author User
 */
public class controllerPegawai {
    FormPegawai frame;
    List<Pegawai> listBrg;
    daoPegawai daoPegawai = new daoPegawai();
    Pegawai pegawai= new Pegawai();
    
    public controllerPegawai(FormPegawai frame) {
        this.frame = frame;
    }
    
    public void tampil_label() {
        TabelModelPegawai tabelPegwai = new TabelModelPegawai(daoPegawai.getData());
//            frame.getTblPegawai().setModel(tabelPegawai);
    }
    
    
}
