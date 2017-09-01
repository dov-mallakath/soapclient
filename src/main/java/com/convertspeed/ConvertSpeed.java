
package com.convertspeed;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="speed" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="FromUnit" type="{http://www.webserviceX.NET/}SpeedUnit"/>
 *         &lt;element name="ToUnit" type="{http://www.webserviceX.NET/}SpeedUnit"/>
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
    "speed",
    "fromUnit",
    "toUnit"
})
@XmlRootElement(name = "ConvertSpeed")
public class ConvertSpeed {

    protected double speed;
    @XmlElement(name = "FromUnit", required = true)
    protected SpeedUnit fromUnit;
    @XmlElement(name = "ToUnit", required = true)
    protected SpeedUnit toUnit;

    /**
     * Gets the value of the speed property.
     * 
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Sets the value of the speed property.
     * 
     */
    public void setSpeed(double value) {
        this.speed = value;
    }

    /**
     * Gets the value of the fromUnit property.
     * 
     * @return
     *     possible object is
     *     {@link SpeedUnit }
     *     
     */
    public SpeedUnit getFromUnit() {
        return fromUnit;
    }

    /**
     * Sets the value of the fromUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedUnit }
     *     
     */
    public void setFromUnit(SpeedUnit value) {
        this.fromUnit = value;
    }

    /**
     * Gets the value of the toUnit property.
     * 
     * @return
     *     possible object is
     *     {@link SpeedUnit }
     *     
     */
    public SpeedUnit getToUnit() {
        return toUnit;
    }

    /**
     * Sets the value of the toUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedUnit }
     *     
     */
    public void setToUnit(SpeedUnit value) {
        this.toUnit = value;
    }

}
