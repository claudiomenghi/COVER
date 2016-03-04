//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2016.02.25 alle 02:17:37 PM CET 
//


package it.polimi.cover.models.goal;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="SCENARIO" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="GOAL" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="CAPTION" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="DEN" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                             &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="INPUT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="INPUTFORCED" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="OP" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="OUTPUTDEN" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                             &lt;element name="OUTPUTSAT" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                             &lt;element name="SAT" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                             &lt;element name="TOP" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="TYPE" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="LTL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="GRAPH">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NODE" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="BKCOLOR" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                             &lt;element name="DESCRIPTION" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="GOAL" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="H" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="W" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="X" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                             &lt;element name="Y" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="CONNECTOR" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="CTRLPOINT" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                             &lt;element name="ENDNODE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="H" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                             &lt;element name="SAT" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="SHAPE" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="STARTNODE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="TYPE" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="VALUE" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                             &lt;element name="W" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                             &lt;element name="X" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                             &lt;element name="Y" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                           &lt;/sequence>
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
 *       &lt;attribute name="VERSION" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "scenario",
    "graph"
})
@XmlRootElement(name = "GOALMODEL")
public class GOALMODEL {

    @XmlElement(name = "SCENARIO")
    protected List<GOALMODEL.SCENARIO> scenario;
    @XmlElement(name = "GRAPH", required = true)
    protected GOALMODEL.GRAPH graph;
    @XmlAttribute(name = "VERSION")
    protected Float version;

    /**
     * Gets the value of the scenario property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scenario property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSCENARIO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GOALMODEL.SCENARIO }
     * 
     * 
     */
    public List<GOALMODEL.SCENARIO> getSCENARIO() {
        if (scenario == null) {
            scenario = new ArrayList<GOALMODEL.SCENARIO>();
        }
        return this.scenario;
    }

    /**
     * Recupera il valore della proprietà graph.
     * 
     * @return
     *     possible object is
     *     {@link GOALMODEL.GRAPH }
     *     
     */
    public GOALMODEL.GRAPH getGRAPH() {
        return graph;
    }

    /**
     * Imposta il valore della proprietà graph.
     * 
     * @param value
     *     allowed object is
     *     {@link GOALMODEL.GRAPH }
     *     
     */
    public void setGRAPH(GOALMODEL.GRAPH value) {
        this.graph = value;
    }

    /**
     * Recupera il valore della proprietà version.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getVERSION() {
        return version;
    }

    /**
     * Imposta il valore della proprietà version.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setVERSION(Float value) {
        this.version = value;
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
     *         &lt;element name="NODE" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="BKCOLOR" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                   &lt;element name="DESCRIPTION" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="GOAL" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="H" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="W" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="X" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *                   &lt;element name="Y" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="CONNECTOR" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="CTRLPOINT" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element name="ENDNODE" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="H" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *                   &lt;element name="SAT" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="SHAPE" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="STARTNODE" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="TYPE" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="VALUE" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *                   &lt;element name="W" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *                   &lt;element name="X" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *                   &lt;element name="Y" type="{http://www.w3.org/2001/XMLSchema}short"/>
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
        "node",
        "connector"
    })
    public static class GRAPH {

        @XmlElement(name = "NODE")
        protected List<GOALMODEL.GRAPH.NODE> node;
        @XmlElement(name = "CONNECTOR")
        protected List<GOALMODEL.GRAPH.CONNECTOR> connector;

        /**
         * Gets the value of the node property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the node property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNODE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GOALMODEL.GRAPH.NODE }
         * 
         * 
         */
        public List<GOALMODEL.GRAPH.NODE> getNODE() {
            if (node == null) {
                node = new ArrayList<GOALMODEL.GRAPH.NODE>();
            }
            return this.node;
        }

        /**
         * Gets the value of the connector property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the connector property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCONNECTOR().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GOALMODEL.GRAPH.CONNECTOR }
         * 
         * 
         */
        public List<GOALMODEL.GRAPH.CONNECTOR> getCONNECTOR() {
            if (connector == null) {
                connector = new ArrayList<GOALMODEL.GRAPH.CONNECTOR>();
            }
            return this.connector;
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
         *         &lt;element name="CTRLPOINT" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element name="ENDNODE" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="H" type="{http://www.w3.org/2001/XMLSchema}short"/>
         *         &lt;element name="SAT" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="SHAPE" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="STARTNODE" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="TYPE" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="VALUE" type="{http://www.w3.org/2001/XMLSchema}float"/>
         *         &lt;element name="W" type="{http://www.w3.org/2001/XMLSchema}short"/>
         *         &lt;element name="X" type="{http://www.w3.org/2001/XMLSchema}short"/>
         *         &lt;element name="Y" type="{http://www.w3.org/2001/XMLSchema}short"/>
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
            "ctrlpoint",
            "endnode",
            "h",
            "sat",
            "shape",
            "startnode",
            "type",
            "value",
            "w",
            "x",
            "y"
        })
        public static class CONNECTOR {

            @XmlElement(name = "CTRLPOINT")
            protected List<String> ctrlpoint;
            @XmlElement(name = "ENDNODE")
            protected int endnode;
            @XmlElement(name = "H")
            protected short h;
            @XmlElement(name = "SAT")
            protected byte sat;
            @XmlElement(name = "SHAPE")
            protected byte shape;
            @XmlElement(name = "STARTNODE")
            protected int startnode;
            @XmlElement(name = "TYPE")
            protected byte type;
            @XmlElement(name = "VALUE")
            protected float value;
            @XmlElement(name = "W")
            protected short w;
            @XmlElement(name = "X")
            protected short x;
            @XmlElement(name = "Y")
            protected short y;

            /**
             * Gets the value of the ctrlpoint property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the ctrlpoint property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCTRLPOINT().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getCTRLPOINT() {
                if (ctrlpoint == null) {
                    ctrlpoint = new ArrayList<String>();
                }
                return this.ctrlpoint;
            }

            /**
             * Recupera il valore della proprietà endnode.
             * 
             */
            public int getENDNODE() {
                return endnode;
            }

            /**
             * Imposta il valore della proprietà endnode.
             * 
             */
            public void setENDNODE(int value) {
                this.endnode = value;
            }

            /**
             * Recupera il valore della proprietà h.
             * 
             */
            public short getH() {
                return h;
            }

            /**
             * Imposta il valore della proprietà h.
             * 
             */
            public void setH(short value) {
                this.h = value;
            }

            /**
             * Recupera il valore della proprietà sat.
             * 
             */
            public byte getSAT() {
                return sat;
            }

            /**
             * Imposta il valore della proprietà sat.
             * 
             */
            public void setSAT(byte value) {
                this.sat = value;
            }

            /**
             * Recupera il valore della proprietà shape.
             * 
             */
            public byte getSHAPE() {
                return shape;
            }

            /**
             * Imposta il valore della proprietà shape.
             * 
             */
            public void setSHAPE(byte value) {
                this.shape = value;
            }

            /**
             * Recupera il valore della proprietà startnode.
             * 
             */
            public int getSTARTNODE() {
                return startnode;
            }

            /**
             * Imposta il valore della proprietà startnode.
             * 
             */
            public void setSTARTNODE(int value) {
                this.startnode = value;
            }

            /**
             * Recupera il valore della proprietà type.
             * 
             */
            public byte getTYPE() {
                return type;
            }

            /**
             * Imposta il valore della proprietà type.
             * 
             */
            public void setTYPE(byte value) {
                this.type = value;
            }

            /**
             * Recupera il valore della proprietà value.
             * 
             */
            public float getVALUE() {
                return value;
            }

            /**
             * Imposta il valore della proprietà value.
             * 
             */
            public void setVALUE(float value) {
                this.value = value;
            }

            /**
             * Recupera il valore della proprietà w.
             * 
             */
            public short getW() {
                return w;
            }

            /**
             * Imposta il valore della proprietà w.
             * 
             */
            public void setW(short value) {
                this.w = value;
            }

            /**
             * Recupera il valore della proprietà x.
             * 
             */
            public short getX() {
                return x;
            }

            /**
             * Imposta il valore della proprietà x.
             * 
             */
            public void setX(short value) {
                this.x = value;
            }

            /**
             * Recupera il valore della proprietà y.
             * 
             */
            public short getY() {
                return y;
            }

            /**
             * Imposta il valore della proprietà y.
             * 
             */
            public void setY(short value) {
                this.y = value;
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
         *         &lt;element name="BKCOLOR" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *         &lt;element name="DESCRIPTION" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="GOAL" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="H" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="W" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="X" type="{http://www.w3.org/2001/XMLSchema}short"/>
         *         &lt;element name="Y" type="{http://www.w3.org/2001/XMLSchema}short"/>
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
            "bkcolor",
            "description",
            "goal",
            "h",
            "id",
            "w",
            "x",
            "y"
        })
        public static class NODE {

            @XmlElement(name = "BKCOLOR")
            protected boolean bkcolor;
            @XmlElement(name = "DESCRIPTION", required = true)
            protected String description;
            @XmlElement(name = "GOAL")
            protected int goal;
            @XmlElement(name = "H")
            protected byte h;
            @XmlElement(name = "ID")
            protected int id;
            @XmlElement(name = "W")
            protected byte w;
            @XmlElement(name = "X")
            protected short x;
            @XmlElement(name = "Y")
            protected short y;

            /**
             * Recupera il valore della proprietà bkcolor.
             * 
             */
            public boolean isBKCOLOR() {
                return bkcolor;
            }

            /**
             * Imposta il valore della proprietà bkcolor.
             * 
             */
            public void setBKCOLOR(boolean value) {
                this.bkcolor = value;
            }

            /**
             * Recupera il valore della proprietà description.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDESCRIPTION() {
                return description;
            }

            /**
             * Imposta il valore della proprietà description.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDESCRIPTION(String value) {
                this.description = value;
            }

            /**
             * Recupera il valore della proprietà goal.
             * 
             */
            public int getGOAL() {
                return goal;
            }

            /**
             * Imposta il valore della proprietà goal.
             * 
             */
            public void setGOAL(int value) {
                this.goal = value;
            }

            /**
             * Recupera il valore della proprietà h.
             * 
             */
            public byte getH() {
                return h;
            }

            /**
             * Imposta il valore della proprietà h.
             * 
             */
            public void setH(byte value) {
                this.h = value;
            }

            /**
             * Recupera il valore della proprietà id.
             * 
             */
            public int getID() {
                return id;
            }

            /**
             * Imposta il valore della proprietà id.
             * 
             */
            public void setID(int value) {
                this.id = value;
            }

            /**
             * Recupera il valore della proprietà w.
             * 
             */
            public byte getW() {
                return w;
            }

            /**
             * Imposta il valore della proprietà w.
             * 
             */
            public void setW(byte value) {
                this.w = value;
            }

            /**
             * Recupera il valore della proprietà x.
             * 
             */
            public short getX() {
                return x;
            }

            /**
             * Imposta il valore della proprietà x.
             * 
             */
            public void setX(short value) {
                this.x = value;
            }

            /**
             * Recupera il valore della proprietà y.
             * 
             */
            public short getY() {
                return y;
            }

            /**
             * Imposta il valore della proprietà y.
             * 
             */
            public void setY(short value) {
                this.y = value;
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
     *         &lt;element name="GOAL" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="CAPTION" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="DEN" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *                   &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="INPUT" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="INPUTFORCED" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="OP" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="OUTPUTDEN" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *                   &lt;element name="OUTPUTSAT" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *                   &lt;element name="SAT" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *                   &lt;element name="TOP" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="TYPE" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="LTL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "goal"
    })
    public static class SCENARIO {

        @XmlElement(name = "GOAL")
        protected List<GOALMODEL.SCENARIO.GOAL> goal;
        @XmlAttribute(name = "NAME")
        protected String name;

        /**
         * Gets the value of the goal property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the goal property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGOAL().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GOALMODEL.SCENARIO.GOAL }
         * 
         * 
         */
        public List<GOALMODEL.SCENARIO.GOAL> getGOAL() {
            if (goal == null) {
                goal = new ArrayList<GOALMODEL.SCENARIO.GOAL>();
            }
            return this.goal;
        }

        /**
         * Recupera il valore della proprietà name.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNAME() {
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
        public void setNAME(String value) {
            this.name = value;
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
         *         &lt;element name="CAPTION" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="DEN" type="{http://www.w3.org/2001/XMLSchema}float"/>
         *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="INPUT" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="INPUTFORCED" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="OP" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="OUTPUTDEN" type="{http://www.w3.org/2001/XMLSchema}float"/>
         *         &lt;element name="OUTPUTSAT" type="{http://www.w3.org/2001/XMLSchema}float"/>
         *         &lt;element name="SAT" type="{http://www.w3.org/2001/XMLSchema}float"/>
         *         &lt;element name="TOP" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="TYPE" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="LTL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "caption",
            "den",
            "id",
            "input",
            "inputforced",
            "op",
            "outputden",
            "outputsat",
            "sat",
            "top",
            "type",
            "ltl"
        })
        public static class GOAL {

            @XmlElement(name = "CAPTION", required = true)
            protected String caption;
            @XmlElement(name = "DEN")
            protected float den;
            @XmlElement(name = "ID")
            protected int id;
            @XmlElement(name = "INPUT", required = true)
            protected String input;
            @XmlElement(name = "INPUTFORCED")
            protected byte inputforced;
            @XmlElement(name = "OP")
            protected byte op;
            @XmlElement(name = "OUTPUTDEN")
            protected float outputden;
            @XmlElement(name = "OUTPUTSAT")
            protected float outputsat;
            @XmlElement(name = "SAT")
            protected float sat;
            @XmlElement(name = "TOP")
            protected byte top;
            @XmlElement(name = "TYPE")
            protected byte type;
            @XmlElement(name = "LTL")
            protected String ltl;

            /**
             * Recupera il valore della proprietà caption.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCAPTION() {
                return caption;
            }

            /**
             * Imposta il valore della proprietà caption.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCAPTION(String value) {
                this.caption = value;
            }

            /**
             * Recupera il valore della proprietà den.
             * 
             */
            public float getDEN() {
                return den;
            }

            /**
             * Imposta il valore della proprietà den.
             * 
             */
            public void setDEN(float value) {
                this.den = value;
            }

            /**
             * Recupera il valore della proprietà id.
             * 
             */
            public int getID() {
                return id;
            }

            /**
             * Imposta il valore della proprietà id.
             * 
             */
            public void setID(int value) {
                this.id = value;
            }

            /**
             * Recupera il valore della proprietà input.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getINPUT() {
                return input;
            }

            /**
             * Imposta il valore della proprietà input.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setINPUT(String value) {
                this.input = value;
            }

            /**
             * Recupera il valore della proprietà inputforced.
             * 
             */
            public byte getINPUTFORCED() {
                return inputforced;
            }

            /**
             * Imposta il valore della proprietà inputforced.
             * 
             */
            public void setINPUTFORCED(byte value) {
                this.inputforced = value;
            }

            /**
             * Recupera il valore della proprietà op.
             * 
             */
            public byte getOP() {
                return op;
            }

            /**
             * Imposta il valore della proprietà op.
             * 
             */
            public void setOP(byte value) {
                this.op = value;
            }

            /**
             * Recupera il valore della proprietà outputden.
             * 
             */
            public float getOUTPUTDEN() {
                return outputden;
            }

            /**
             * Imposta il valore della proprietà outputden.
             * 
             */
            public void setOUTPUTDEN(float value) {
                this.outputden = value;
            }

            /**
             * Recupera il valore della proprietà outputsat.
             * 
             */
            public float getOUTPUTSAT() {
                return outputsat;
            }

            /**
             * Imposta il valore della proprietà outputsat.
             * 
             */
            public void setOUTPUTSAT(float value) {
                this.outputsat = value;
            }

            /**
             * Recupera il valore della proprietà sat.
             * 
             */
            public float getSAT() {
                return sat;
            }

            /**
             * Imposta il valore della proprietà sat.
             * 
             */
            public void setSAT(float value) {
                this.sat = value;
            }

            /**
             * Recupera il valore della proprietà top.
             * 
             */
            public byte getTOP() {
                return top;
            }

            /**
             * Imposta il valore della proprietà top.
             * 
             */
            public void setTOP(byte value) {
                this.top = value;
            }

            /**
             * Recupera il valore della proprietà type.
             * 
             */
            public byte getTYPE() {
                return type;
            }

            /**
             * Imposta il valore della proprietà type.
             * 
             */
            public void setTYPE(byte value) {
                this.type = value;
            }

            /**
             * Recupera il valore della proprietà ltl.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLTL() {
                return ltl;
            }

            /**
             * Imposta il valore della proprietà ltl.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLTL(String value) {
                this.ltl = value;
            }

        }

    }

}
