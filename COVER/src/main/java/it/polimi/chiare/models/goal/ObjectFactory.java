//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2016.02.25 alle 02:17:37 PM CET 
//


package it.polimi.chiare.models.goal;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.polimi.chiare.models.goal package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.polimi.chiare.models.goal
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GOALMODEL }
     * 
     */
    public GOALMODEL createGOALMODEL() {
        return new GOALMODEL();
    }

    /**
     * Create an instance of {@link GOALMODEL.GRAPH }
     * 
     */
    public GOALMODEL.GRAPH createGOALMODELGRAPH() {
        return new GOALMODEL.GRAPH();
    }

    /**
     * Create an instance of {@link GOALMODEL.SCENARIO }
     * 
     */
    public GOALMODEL.SCENARIO createGOALMODELSCENARIO() {
        return new GOALMODEL.SCENARIO();
    }

    /**
     * Create an instance of {@link GOALMODEL.GRAPH.NODE }
     * 
     */
    public GOALMODEL.GRAPH.NODE createGOALMODELGRAPHNODE() {
        return new GOALMODEL.GRAPH.NODE();
    }

    /**
     * Create an instance of {@link GOALMODEL.GRAPH.CONNECTOR }
     * 
     */
    public GOALMODEL.GRAPH.CONNECTOR createGOALMODELGRAPHCONNECTOR() {
        return new GOALMODEL.GRAPH.CONNECTOR();
    }

    /**
     * Create an instance of {@link GOALMODEL.SCENARIO.GOAL }
     * 
     */
    public GOALMODEL.SCENARIO.GOAL createGOALMODELSCENARIOGOAL() {
        return new GOALMODEL.SCENARIO.GOAL();
    }

}
