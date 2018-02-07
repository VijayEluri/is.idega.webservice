/**
 * SpecialEquipmentChange.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package is.lt.ws.VehicleRegistryService;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SpecialEquipmentChange  implements java.io.Serializable {
    private is.lt.ws.VehicleRegistryService.ExtensionDataObject extensionData;

    private java.lang.String date;

    private java.lang.String description;

    private java.lang.String invalidDate;

    public SpecialEquipmentChange() {
    }

    public SpecialEquipmentChange(
           is.lt.ws.VehicleRegistryService.ExtensionDataObject extensionData,
           java.lang.String date,
           java.lang.String description,
           java.lang.String invalidDate) {
           this.extensionData = extensionData;
           this.date = date;
           this.description = description;
           this.invalidDate = invalidDate;
    }


    /**
     * Gets the extensionData value for this SpecialEquipmentChange.
     *
     * @return extensionData
     */
    public is.lt.ws.VehicleRegistryService.ExtensionDataObject getExtensionData() {
        return extensionData;
    }


    /**
     * Sets the extensionData value for this SpecialEquipmentChange.
     *
     * @param extensionData
     */
    public void setExtensionData(is.lt.ws.VehicleRegistryService.ExtensionDataObject extensionData) {
        this.extensionData = extensionData;
    }


    /**
     * Gets the date value for this SpecialEquipmentChange.
     *
     * @return date
     */
    public java.lang.String getDate() {
        return date;
    }


    /**
     * Sets the date value for this SpecialEquipmentChange.
     *
     * @param date
     */
    public void setDate(java.lang.String date) {
        this.date = date;
    }


    /**
     * Gets the description value for this SpecialEquipmentChange.
     *
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this SpecialEquipmentChange.
     *
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the invalidDate value for this SpecialEquipmentChange.
     *
     * @return invalidDate
     */
    public java.lang.String getInvalidDate() {
        return invalidDate;
    }


    /**
     * Sets the invalidDate value for this SpecialEquipmentChange.
     *
     * @param invalidDate
     */
    public void setInvalidDate(java.lang.String invalidDate) {
        this.invalidDate = invalidDate;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SpecialEquipmentChange)) {
			return false;
		}
        SpecialEquipmentChange other = (SpecialEquipmentChange) obj;
        if (obj == null) {
			return false;
		}
        if (this == obj) {
			return true;
		}
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.extensionData==null && other.getExtensionData()==null) ||
             (this.extensionData!=null &&
              this.extensionData.equals(other.getExtensionData()))) &&
            ((this.date==null && other.getDate()==null) ||
             (this.date!=null &&
              this.date.equals(other.getDate()))) &&
            ((this.description==null && other.getDescription()==null) ||
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.invalidDate==null && other.getInvalidDate()==null) ||
             (this.invalidDate!=null &&
              this.invalidDate.equals(other.getInvalidDate())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    @Override
	public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getExtensionData() != null) {
            _hashCode += getExtensionData().hashCode();
        }
        if (getDate() != null) {
            _hashCode += getDate().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getInvalidDate() != null) {
            _hashCode += getInvalidDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SpecialEquipmentChange.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://ws.lt.is/VehicleRegistryService", "SpecialEquipmentChange"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extensionData");
        elemField.setXmlName(new javax.xml.namespace.QName("https://ws.lt.is/VehicleRegistryService", "ExtensionData"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://ws.lt.is/VehicleRegistryService", "ExtensionDataObject"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date");
        elemField.setXmlName(new javax.xml.namespace.QName("https://ws.lt.is/VehicleRegistryService", "Date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("https://ws.lt.is/VehicleRegistryService", "Description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("invalidDate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://ws.lt.is/VehicleRegistryService", "InvalidDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType,
           java.lang.Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType,
           java.lang.Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
