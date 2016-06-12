
package com.dengun.ejb.webservice.library.beans;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "LibraryService", targetNamespace = "http://beans.library.webservice.ejb.dengun.com/", wsdlLocation = "http://localhost:8080/LibraryService/LibraryPersistenceBean?wsdl")
public class LibraryService
    extends Service
{

    private final static URL LIBRARYSERVICE_WSDL_LOCATION;
    private final static WebServiceException LIBRARYSERVICE_EXCEPTION;
    private final static QName LIBRARYSERVICE_QNAME = new QName("http://beans.library.webservice.ejb.dengun.com/", "LibraryService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/LibraryService/LibraryPersistenceBean?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        LIBRARYSERVICE_WSDL_LOCATION = url;
        LIBRARYSERVICE_EXCEPTION = e;
    }

    public LibraryService() {
        super(__getWsdlLocation(), LIBRARYSERVICE_QNAME);
    }

    public LibraryService(WebServiceFeature... features) {
        super(__getWsdlLocation(), LIBRARYSERVICE_QNAME, features);
    }

    public LibraryService(URL wsdlLocation) {
        super(wsdlLocation, LIBRARYSERVICE_QNAME);
    }

    public LibraryService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, LIBRARYSERVICE_QNAME, features);
    }

    public LibraryService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LibraryService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns LibraryPersistenceBean
     */
    @WebEndpoint(name = "LibraryPersistenceBeanPort")
    public LibraryPersistenceBean getLibraryPersistenceBeanPort() {
        return super.getPort(new QName("http://beans.library.webservice.ejb.dengun.com/", "LibraryPersistenceBeanPort"), LibraryPersistenceBean.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LibraryPersistenceBean
     */
    @WebEndpoint(name = "LibraryPersistenceBeanPort")
    public LibraryPersistenceBean getLibraryPersistenceBeanPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://beans.library.webservice.ejb.dengun.com/", "LibraryPersistenceBeanPort"), LibraryPersistenceBean.class, features);
    }

    private static URL __getWsdlLocation() {
        if (LIBRARYSERVICE_EXCEPTION!= null) {
            throw LIBRARYSERVICE_EXCEPTION;
        }
        return LIBRARYSERVICE_WSDL_LOCATION;
    }

}
