//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2016.02.25 alle 09:34:39 AM CET 
//


package it.polimi.chiare.models.automata.parser;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="propositions">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="proposition" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="states">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="state" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="interface">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="proposition" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                           &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="initial" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                           &lt;attribute name="accepting" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                           &lt;attribute name="blackbox" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="transitions">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *                   &lt;element ref="{}transition"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "propositions",
    "states",
    "transitions"
})
@XmlRootElement(name = "baInt")
public class BAINTPARSER {

    @XmlElement(required = true)
    protected BAINTPARSER.Propositions propositions;
    @XmlElement(required = true)
    protected BAINTPARSER.States states;
    @XmlElement(required = true)
    protected BAINTPARSER.Transitions transitions;

    /**
     * Recupera il valore della proprietà propositions.
     * 
     * @return
     *     possible object is
     *     {@link BAINTPARSER.Propositions }
     *     
     */
    public BAINTPARSER.Propositions getPropositions() {
        return propositions;
    }

    /**
     * Imposta il valore della proprietà propositions.
     * 
     * @param value
     *     allowed object is
     *     {@link BAINTPARSER.Propositions }
     *     
     */
    public void setPropositions(BAINTPARSER.Propositions value) {
        this.propositions = value;
    }

    /**
     * Recupera il valore della proprietà states.
     * 
     * @return
     *     possible object is
     *     {@link BAINTPARSER.States }
     *     
     */
    public BAINTPARSER.States getStates() {
        return states;
    }

    /**
     * Imposta il valore della proprietà states.
     * 
     * @param value
     *     allowed object is
     *     {@link BAINTPARSER.States }
     *     
     */
    public void setStates(BAINTPARSER.States value) {
        this.states = value;
    }

    /**
     * Recupera il valore della proprietà transitions.
     * 
     * @return
     *     possible object is
     *     {@link BAINTPARSER.Transitions }
     *     
     */
    public BAINTPARSER.Transitions getTransitions() {
        return transitions;
    }

    /**
     * Imposta il valore della proprietà transitions.
     * 
     * @param value
     *     allowed object is
     *     {@link BAINTPARSER.Transitions }
     *     
     */
    public void setTransitions(BAINTPARSER.Transitions value) {
        this.transitions = value;
    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="proposition" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "proposition"
    })
    public static class Propositions {

        protected List<BAINTPARSER.Propositions.Proposition> proposition;

        /**
         * Gets the value of the proposition property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the proposition property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProposition().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BAINTPARSER.Propositions.Proposition }
         * 
         * 
         */
        public List<BAINTPARSER.Propositions.Proposition> getProposition() {
            if (proposition == null) {
                proposition = new ArrayList<BAINTPARSER.Propositions.Proposition>();
            }
            return this.proposition;
        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Proposition {

            @XmlAttribute(name = "name", required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlID
            @XmlSchemaType(name = "ID")
            protected String name;

            /**
             * Recupera il valore della proprietà name.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Imposta il valore della proprietà name.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="state" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="interface">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="proposition" maxOccurs="unbounded" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="initial" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                 &lt;attribute name="accepting" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                 &lt;attribute name="blackbox" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "state"
    })
    public static class States {

        protected List<BAINTPARSER.States.State> state;

        /**
         * Gets the value of the state property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the state property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getState().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BAINTPARSER.States.State }
         * 
         * 
         */
        public List<BAINTPARSER.States.State> getState() {
            if (state == null) {
                state = new ArrayList<BAINTPARSER.States.State>();
            }
            return this.state;
        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="interface">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="proposition" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="initial" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *       &lt;attribute name="accepting" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *       &lt;attribute name="blackbox" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "_interface"
        })
        public static class State {

            @XmlElement(name = "interface", required = true)
            protected BAINTPARSER.States.State.Interface _interface;
            @XmlAttribute(name = "id", required = true)
            protected BigInteger id;
            @XmlAttribute(name = "name", required = true)
            protected String name;
            @XmlAttribute(name = "initial")
            protected Boolean initial;
            @XmlAttribute(name = "accepting")
            protected Boolean accepting;
            @XmlAttribute(name = "blackbox")
            protected Boolean blackbox;

            /**
             * Recupera il valore della proprietà interface.
             * 
             * @return
             *     possible object is
             *     {@link BAINTPARSER.States.State.Interface }
             *     
             */
            public BAINTPARSER.States.State.Interface getInterface() {
                return _interface;
            }

            /**
             * Imposta il valore della proprietà interface.
             * 
             * @param value
             *     allowed object is
             *     {@link BAINTPARSER.States.State.Interface }
             *     
             */
            public void setInterface(BAINTPARSER.States.State.Interface value) {
                this._interface = value;
            }

            /**
             * Recupera il valore della proprietà id.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getId() {
                return id;
            }

            /**
             * Imposta il valore della proprietà id.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setId(BigInteger value) {
                this.id = value;
            }

            /**
             * Recupera il valore della proprietà name.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Imposta il valore della proprietà name.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Recupera il valore della proprietà initial.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isInitial() {
                return initial;
            }

            /**
             * Imposta il valore della proprietà initial.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setInitial(Boolean value) {
                this.initial = value;
            }

            /**
             * Recupera il valore della proprietà accepting.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isAccepting() {
                return accepting;
            }

            /**
             * Imposta il valore della proprietà accepting.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setAccepting(Boolean value) {
                this.accepting = value;
            }

            /**
             * Recupera il valore della proprietà blackbox.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isBlackbox() {
                return blackbox;
            }

            /**
             * Imposta il valore della proprietà blackbox.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setBlackbox(Boolean value) {
                this.blackbox = value;
            }


            /**
             * <p>Classe Java per anonymous complex type.
             * 
             * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="proposition" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "proposition"
            })
            public static class Interface {

                protected List<BAINTPARSER.States.State.Interface.Proposition> proposition;

                /**
                 * Gets the value of the proposition property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the proposition property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getProposition().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link BAINTPARSER.States.State.Interface.Proposition }
                 * 
                 * 
                 */
                public List<BAINTPARSER.States.State.Interface.Proposition> getProposition() {
                    if (proposition == null) {
                        proposition = new ArrayList<BAINTPARSER.States.State.Interface.Proposition>();
                    }
                    return this.proposition;
                }


                /**
                 * <p>Classe Java per anonymous complex type.
                 * 
                 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class Proposition {

                    @XmlAttribute(name = "name", required = true)
                    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
                    @XmlID
                    @XmlSchemaType(name = "ID")
                    protected String name;

                    /**
                     * Recupera il valore della proprietà name.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getName() {
                        return name;
                    }

                    /**
                     * Imposta il valore della proprietà name.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setName(String value) {
                        this.name = value;
                    }

                }

            }

        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
     *         &lt;element ref="{}transition"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "transition"
    })
    public static class Transitions {

        protected List<Transition> transition;

        /**
         * Gets the value of the transition property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the transition property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTransition().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Transition }
         * 
         * 
         */
        public List<Transition> getTransition() {
            if (transition == null) {
                transition = new ArrayList<Transition>();
            }
            return this.transition;
        }

    }

}
