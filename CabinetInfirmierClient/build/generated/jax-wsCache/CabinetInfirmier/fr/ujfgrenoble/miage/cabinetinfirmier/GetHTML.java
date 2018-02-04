
package fr.ujfgrenoble.miage.cabinetinfirmier;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getHTML complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getHTML"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="infirmierId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getHTML", propOrder = {
    "infirmierId"
})
public class GetHTML {

    protected String infirmierId;

    /**
     * Gets the value of the infirmierId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfirmierId() {
        return infirmierId;
    }

    /**
     * Sets the value of the infirmierId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfirmierId(String value) {
        this.infirmierId = value;
    }

}
