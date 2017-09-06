
package com.convertspeed;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SpeedUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SpeedUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="centimetersPersecond"/>
 *     &lt;enumeration value="metersPersecond"/>
 *     &lt;enumeration value="feetPersecond"/>
 *     &lt;enumeration value="feetPerminute"/>
 *     &lt;enumeration value="milesPerhour"/>
 *     &lt;enumeration value="kilometersPerhour"/>
 *     &lt;enumeration value="furlongsPermin"/>
 *     &lt;enumeration value="knots"/>
 *     &lt;enumeration value="leaguesPerday"/>
 *     &lt;enumeration value="Mach"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SpeedUnit")
@XmlEnum
public enum SpeedUnit {

    @XmlEnumValue("centimetersPersecond")
    CENTIMETERS_PERSECOND("centimetersPersecond"),
    @XmlEnumValue("metersPersecond")
    METERS_PERSECOND("metersPersecond"),
    @XmlEnumValue("feetPersecond")
    FEET_PERSECOND("feetPersecond"),
    @XmlEnumValue("feetPerminute")
    FEET_PERMINUTE("feetPerminute"),
    @XmlEnumValue("milesPerhour")
    MILES_PERHOUR("milesPerhour"),
    @XmlEnumValue("kilometersPerhour")
    KILOMETERS_PERHOUR("kilometersPerhour"),
    @XmlEnumValue("furlongsPermin")
    FURLONGS_PERMIN("furlongsPermin"),
    @XmlEnumValue("knots")
    KNOTS("knots"),
    @XmlEnumValue("leaguesPerday")
    LEAGUES_PERDAY("leaguesPerday"),
    @XmlEnumValue("Mach")
    MACH("Mach"),
    @XmlEnumValue("Test")
    TEST("Test");
    private final String value;

    SpeedUnit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SpeedUnit fromValue(String v) {
        for (SpeedUnit c: SpeedUnit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
