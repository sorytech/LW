
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diallo
 */
public class TestCabinetInfirmier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        System.out.println(getNomCabinet());
        //System.out.println(getHTML("001"));
         try {
            // get the html content and record it into a file (a cache)
            FileUtil.stringToFile(getHTML("002"), "myHtmlFile.html");
            // view this file in a browser
            BrowserUtil.launch("myHtmlFile.html");
        } catch (IOException ex) {
            Logger.getLogger(TestCabinetInfirmier.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        
    }
    private static String getNomCabinet() {
        fr.ujfgrenoble.miage.cabinetinfirmier.CabinetInfirmier_Service service = new fr.ujfgrenoble.miage.cabinetinfirmier.CabinetInfirmier_Service();
        fr.ujfgrenoble.miage.cabinetinfirmier.CabinetInfirmier port = service.getCabinetInfirmierPort();
        return port.getNomCabinet();
    }

    private static String getHTML(java.lang.String infirmierId) {
        fr.ujfgrenoble.miage.cabinetinfirmier.CabinetInfirmier_Service service = new fr.ujfgrenoble.miage.cabinetinfirmier.CabinetInfirmier_Service();
        fr.ujfgrenoble.miage.cabinetinfirmier.CabinetInfirmier port = service.getCabinetInfirmierPort();
        return port.getHTML(infirmierId);
    }
    
    
    
}
