//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.04 at 04:08:43 AM CET 
//


package fr.ujf_grenoble.l3miage.medical;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Infirmiers complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Infirmiers">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="infirmier" type="{http://www.ujf-grenoble.fr/l3miage/medical}Infirmier" maxOccurs="unbounded" minOccurs="3"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Infirmiers", propOrder = {
    "infirmiers"
})
public class Infirmiers {

    @XmlElement(name = "infirmier", required = true)
    protected List<Infirmier> infirmiers;

    /**
     * Gets the value of the infirmiers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infirmiers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfirmiers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Infirmier }
     * 
     * 
     */
    public List<Infirmier> getInfirmiers() {
        if (infirmiers == null) {
            infirmiers = new ArrayList<Infirmier>();
        }
        return this.infirmiers;
    }

}
