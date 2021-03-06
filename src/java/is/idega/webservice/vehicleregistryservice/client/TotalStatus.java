/**
 * TotalStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package is.idega.webservice.vehicleregistryservice.client;

public class TotalStatus  implements java.io.Serializable {
    private is.idega.webservice.vehicleregistryservice.client.ExtensionDataObject extensionData;

    private is.idega.webservice.vehicleregistryservice.client.AutomobileTaxClass automobileTaxes;

    public TotalStatus() {
    }

    public TotalStatus(
           is.idega.webservice.vehicleregistryservice.client.ExtensionDataObject extensionData,
           is.idega.webservice.vehicleregistryservice.client.AutomobileTaxClass automobileTaxes) {
           this.extensionData = extensionData;
           this.automobileTaxes = automobileTaxes;
    }


    /**
     * Gets the extensionData value for this TotalStatus.
     * 
     * @return extensionData
     */
    public is.idega.webservice.vehicleregistryservice.client.ExtensionDataObject getExtensionData() {
        return extensionData;
    }


    /**
     * Sets the extensionData value for this TotalStatus.
     * 
     * @param extensionData
     */
    public void setExtensionData(is.idega.webservice.vehicleregistryservice.client.ExtensionDataObject extensionData) {
        this.extensionData = extensionData;
    }


    /**
     * Gets the automobileTaxes value for this TotalStatus.
     * 
     * @return automobileTaxes
     */
    public is.idega.webservice.vehicleregistryservice.client.AutomobileTaxClass getAutomobileTaxes() {
        return automobileTaxes;
    }


    /**
     * Sets the automobileTaxes value for this TotalStatus.
     * 
     * @param automobileTaxes
     */
    public void setAutomobileTaxes(is.idega.webservice.vehicleregistryservice.client.AutomobileTaxClass automobileTaxes) {
        this.automobileTaxes = automobileTaxes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TotalStatus)) return false;
        TotalStatus other = (TotalStatus) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.extensionData==null && other.getExtensionData()==null) || 
             (this.extensionData!=null &&
              this.extensionData.equals(other.getExtensionData()))) &&
            ((this.automobileTaxes==null && other.getAutomobileTaxes()==null) || 
             (this.automobileTaxes!=null &&
              this.automobileTaxes.equals(other.getAutomobileTaxes())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getExtensionData() != null) {
            _hashCode += getExtensionData().hashCode();
        }
        if (getAutomobileTaxes() != null) {
            _hashCode += getAutomobileTaxes().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TotalStatus.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://ws.lt.is/VehicleRegistryService", "TotalStatus"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extensionData");
        elemField.setXmlName(new javax.xml.namespace.QName("https://ws.lt.is/VehicleRegistryService", "ExtensionData"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://ws.lt.is/VehicleRegistryService", "ExtensionDataObject"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("automobileTaxes");
        elemField.setXmlName(new javax.xml.namespace.QName("https://ws.lt.is/VehicleRegistryService", "AutomobileTaxes"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://ws.lt.is/VehicleRegistryService", "AutomobileTaxClass"));
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
