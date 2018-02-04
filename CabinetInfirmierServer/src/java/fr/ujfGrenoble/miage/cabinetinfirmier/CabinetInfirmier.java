/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ujfGrenoble.miage.cabinetinfirmier;

import fr.ujfGrenoble.miage.cabinetinfirmier.resources.XMLUtil.DocumentFactory;
import fr.ujfGrenoble.miage.cabinetinfirmier.resources.XMLUtil.DocumentTransform;
import fr.ujf_grenoble.l3miage.medical.Cabinet;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author diallo
 */
@WebService(serviceName = "CabinetInfirmier")
public class CabinetInfirmier {

    /**
     * This is a sample web service operation
     * @param txt
     * @return 
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     *
     * @param parameter
     * @return
     */
    @WebMethod(operationName = "getStrLength")
    public Integer getStrLength(@WebParam(name = "parameter") final String parameter) {
        //TODO write your implementation code here:
        return parameter.length();
    }

    /**
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "getNomCabinet")
    public String getNomCabinet() {
        //TODO write your implementation code here:
        Cabinet cabinet = fromResource();
        return cabinet.getNom();
    }

    /**
     * Cette méthode : - récupère le document XML contenant l'organisation
     * complète du cabinet infirmier en tant que ressource du Web Service, -
     * réalise un unmarshalling à partir de cette ressource et du JAXB binding
     * produit à partir du XML Schema - renvoie une référence sur l'instance de
     * Cabinet, racine du système d'information
     *
     * @return racine du document XML (instance de la classe Cabinet)
     */
    private Cabinet fromResource() {
        // déclare un cabinet
        Cabinet cabinet = new Cabinet();
        try {
            // récupération  de la ressource à partir du fichier XML
            URL cabinetXMLURL = CabinetInfirmier.class.getResource("resources/cabinet.xml");

            // création du contexte
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(Cabinet.class.getPackage().getName());

            // création d'un unmarshaller 
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();

            // unmarshalling... (utilisation d'un transtypage)
            cabinet = (Cabinet) unmarshaller.unmarshal(cabinetXMLURL); //NOI18N

        } catch (JAXBException ex) {
            Logger.getLogger(CabinetInfirmier.class.getName()).log(Level.SEVERE, null, ex);
        }
        // retourne une instance de cabinet, ou null si le chargement du fichier a 
        return cabinet;
    }

    /**
     * Cette méthode du WS permet de récupérer une resource distante sous la
     * forme d'un flux source (StreamSource) pouvant être utilisée dans les
     * méthodes de XMLUtil (trandformation XSLT ...).
     *
     * @param resourceFile
     * @return
     */
    private StreamSource fromResource(String resourceFile) {
        // crée un flux d'entrée qui récupère la resource distante comme un flux
        InputStream resourceStream = this.getClass().getResourceAsStream(resourceFile);
        // Retourne ce flux d'entrée sous la forme d'un flux source
        return new StreamSource(resourceStream);
    }

    /**
     * Web service operation
     * @param infirmierId
     * @return 
     */
    @WebMethod(operationName = "getHTML")
    public String getHTML(@WebParam(name = "infirmierId") String infirmierId) {
        try {
            // On récupère une instance de cabinet depuis la resource.
            Cabinet c = fromResource();
            
            // Traitements préliminaires éventuels ... en Java
            /*
            * ici sont réalisés les traitements souhaités pour récupérer les informations utiles
            * ex: classement des patients par ordre alphabétique
            * ex: classement de la liste des patients d'une infirmière selon la distance
            */
            
            // On fabrique un document DOM à partir d'un objet, ici un cabinet
            Document doc = DocumentFactory.fromObject(c);
            
            // On récupère ici la feuille de transformation de l'infirmière
            StreamSource xslSource = fromResource("resources/infirmier.xsl"); 
            // !!!!!!!!! ATTENTION, changer le nom si nécessaire
            // On fabrique une processeur de document (Transformer)
            Transformer transformer = TransformerFactory.newInstance().newTransformer(xslSource);
            // On donne un nom au paramètre ; ce nom est celui utilisé dans la feuille de transformation
            String id = "idInfirmier";
            // On indique au processeur de document d'appliquer un paramètre auquel on donne sa valeur.
            transformer.setParameter(id, infirmierId);
            // On applique la transformation
            return DocumentTransform.fromTransformation(transformer, doc);
        } catch (TransformerException ex) {
            Logger.getLogger(CabinetInfirmier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    
}
