
package fr.ujfgrenoble.miage.cabinetinfirmier;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.ujfgrenoble.miage.cabinetinfirmier package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetHTML_QNAME = new QName("http://cabinetinfirmier.miage.ujfGrenoble.fr/", "getHTML");
    private final static QName _GetHTMLResponse_QNAME = new QName("http://cabinetinfirmier.miage.ujfGrenoble.fr/", "getHTMLResponse");
    private final static QName _GetNomCabinet_QNAME = new QName("http://cabinetinfirmier.miage.ujfGrenoble.fr/", "getNomCabinet");
    private final static QName _GetNomCabinetResponse_QNAME = new QName("http://cabinetinfirmier.miage.ujfGrenoble.fr/", "getNomCabinetResponse");
    private final static QName _GetStrLength_QNAME = new QName("http://cabinetinfirmier.miage.ujfGrenoble.fr/", "getStrLength");
    private final static QName _GetStrLengthResponse_QNAME = new QName("http://cabinetinfirmier.miage.ujfGrenoble.fr/", "getStrLengthResponse");
    private final static QName _Hello_QNAME = new QName("http://cabinetinfirmier.miage.ujfGrenoble.fr/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://cabinetinfirmier.miage.ujfGrenoble.fr/", "helloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.ujfgrenoble.miage.cabinetinfirmier
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetHTML }
     * 
     */
    public GetHTML createGetHTML() {
        return new GetHTML();
    }

    /**
     * Create an instance of {@link GetHTMLResponse }
     * 
     */
    public GetHTMLResponse createGetHTMLResponse() {
        return new GetHTMLResponse();
    }

    /**
     * Create an instance of {@link GetNomCabinet }
     * 
     */
    public GetNomCabinet createGetNomCabinet() {
        return new GetNomCabinet();
    }

    /**
     * Create an instance of {@link GetNomCabinetResponse }
     * 
     */
    public GetNomCabinetResponse createGetNomCabinetResponse() {
        return new GetNomCabinetResponse();
    }

    /**
     * Create an instance of {@link GetStrLength }
     * 
     */
    public GetStrLength createGetStrLength() {
        return new GetStrLength();
    }

    /**
     * Create an instance of {@link GetStrLengthResponse }
     * 
     */
    public GetStrLengthResponse createGetStrLengthResponse() {
        return new GetStrLengthResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHTML }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cabinetinfirmier.miage.ujfGrenoble.fr/", name = "getHTML")
    public JAXBElement<GetHTML> createGetHTML(GetHTML value) {
        return new JAXBElement<GetHTML>(_GetHTML_QNAME, GetHTML.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHTMLResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cabinetinfirmier.miage.ujfGrenoble.fr/", name = "getHTMLResponse")
    public JAXBElement<GetHTMLResponse> createGetHTMLResponse(GetHTMLResponse value) {
        return new JAXBElement<GetHTMLResponse>(_GetHTMLResponse_QNAME, GetHTMLResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNomCabinet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cabinetinfirmier.miage.ujfGrenoble.fr/", name = "getNomCabinet")
    public JAXBElement<GetNomCabinet> createGetNomCabinet(GetNomCabinet value) {
        return new JAXBElement<GetNomCabinet>(_GetNomCabinet_QNAME, GetNomCabinet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNomCabinetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cabinetinfirmier.miage.ujfGrenoble.fr/", name = "getNomCabinetResponse")
    public JAXBElement<GetNomCabinetResponse> createGetNomCabinetResponse(GetNomCabinetResponse value) {
        return new JAXBElement<GetNomCabinetResponse>(_GetNomCabinetResponse_QNAME, GetNomCabinetResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStrLength }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cabinetinfirmier.miage.ujfGrenoble.fr/", name = "getStrLength")
    public JAXBElement<GetStrLength> createGetStrLength(GetStrLength value) {
        return new JAXBElement<GetStrLength>(_GetStrLength_QNAME, GetStrLength.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStrLengthResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cabinetinfirmier.miage.ujfGrenoble.fr/", name = "getStrLengthResponse")
    public JAXBElement<GetStrLengthResponse> createGetStrLengthResponse(GetStrLengthResponse value) {
        return new JAXBElement<GetStrLengthResponse>(_GetStrLengthResponse_QNAME, GetStrLengthResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cabinetinfirmier.miage.ujfGrenoble.fr/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cabinetinfirmier.miage.ujfGrenoble.fr/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

}
