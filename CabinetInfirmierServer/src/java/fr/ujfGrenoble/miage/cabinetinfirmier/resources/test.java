/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ujfGrenoble.miage.cabinetinfirmier.resources;

import fr.ujf_grenoble.l3miage.medical.Patient;
import java.util.List;

/**
 *
 * @author diallo
 */
public class test {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        CabinetProcessing cabinetInstance=new CabinetProcessing("/home/diallo/NetBeansProjects/CabinetInfirmierServer/src/java/fr/ujfGrenoble/miage/cabinetinfirmier/resources/cabinet.xml");
        cabinetInstance.toXML("/home/diallo/NetBeansProjects/CabinetInfirmierServer/src/java/fr/ujfGrenoble/miage/cabinetinfirmier/resources/cabinetInfirmier.xml");
        System.out.println("*********Test Fonction getNomCabinet qui returne  Le nom du cabinet**********");
        System.out.println(cabinetInstance.getNomCabinet());
        System.out.println();
        System.out.println("*********Test Fonction getListePatientsStr qui returne  String***********");
        System.out.println(cabinetInstance.getListePatientsStr(002));
        System.out.println();
        System.out.println("*********Test Fonction getListePatients qui returne  List<Patient>***********");
        List<Patient> patient=cabinetInstance.getListePatients(001);
        for(int i=0; i<patient.size();i++){
            System.out.println("Patient :["+patient.get(i).getNom()+" "+patient.get(i).getPrénom()+"]");
        }
        System.out.print(cabinetInstance.getHTML("002", "/home/diallo/NetBeansProjects/CabinetInfirmierServer/src/java/fr/ujfGrenoble/miage/cabinetinfirmier/resources/infirmier.xsl"));
        
    }
        
}
