//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2016.02.25 alle 09:34:39 AM CET 
//


package it.polimi.cover.models.automata.parser;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.polimi.chiare.models.automata.parser package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.polimi.chiare.models.automata.parser
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BAINTPARSER }
     * 
     */
    public BAINTPARSER createBaInt() {
        return new BAINTPARSER();
    }

    /**
     * Create an instance of {@link BAINTPARSER.States }
     * 
     */
    public BAINTPARSER.States createBaIntStates() {
        return new BAINTPARSER.States();
    }

    /**
     * Create an instance of {@link BAINTPARSER.States.State }
     * 
     */
    public BAINTPARSER.States.State createBaIntStatesState() {
        return new BAINTPARSER.States.State();
    }

    /**
     * Create an instance of {@link BAINTPARSER.States.State.Interface }
     * 
     */
    public BAINTPARSER.States.State.Interface createBaIntStatesStateInterface() {
        return new BAINTPARSER.States.State.Interface();
    }

    /**
     * Create an instance of {@link BAINTPARSER.Propositions }
     * 
     */
    public BAINTPARSER.Propositions createBaIntPropositions() {
        return new BAINTPARSER.Propositions();
    }

    /**
     * Create an instance of {@link BAINTPARSER.Transitions }
     * 
     */
    public BAINTPARSER.Transitions createBaIntTransitions() {
        return new BAINTPARSER.Transitions();
    }

    /**
     * Create an instance of {@link Transition }
     * 
     */
    public Transition createTransition() {
        return new Transition();
    }

    /**
     * Create an instance of {@link BAINTPARSER.States.State.Interface.Proposition }
     * 
     */
    public BAINTPARSER.States.State.Interface.Proposition createBaIntStatesStateInterfaceProposition() {
        return new BAINTPARSER.States.State.Interface.Proposition();
    }

    /**
     * Create an instance of {@link BAINTPARSER.Propositions.Proposition }
     * 
     */
    public BAINTPARSER.Propositions.Proposition createBaIntPropositionsProposition() {
        return new BAINTPARSER.Propositions.Proposition();
    }

}
