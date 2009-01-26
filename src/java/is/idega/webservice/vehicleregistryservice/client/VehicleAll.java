/**
 * VehicleAll.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.webservice.vehicleregistryservice.client;

public class VehicleAll  implements java.io.Serializable {
    private is.idega.webservice.vehicleregistryservice.client.Vehicle vehicle;

    private is.idega.webservice.vehicleregistryservice.client.VehicleExtra vehicleExtra;

    public VehicleAll() {
    }

    public VehicleAll(
           is.idega.webservice.vehicleregistryservice.client.Vehicle vehicle,
           is.idega.webservice.vehicleregistryservice.client.VehicleExtra vehicleExtra) {
           this.vehicle = vehicle;
           this.vehicleExtra = vehicleExtra;
    }


    /**
     * Gets the vehicle value for this VehicleAll.
     * 
     * @return vehicle
     */
    public is.idega.webservice.vehicleregistryservice.client.Vehicle getVehicle() {
        return vehicle;
    }


    /**
     * Sets the vehicle value for this VehicleAll.
     * 
     * @param vehicle
     */
    public void setVehicle(is.idega.webservice.vehicleregistryservice.client.Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    /**
     * Gets the vehicleExtra value for this VehicleAll.
     * 
     * @return vehicleExtra
     */
    public is.idega.webservice.vehicleregistryservice.client.VehicleExtra getVehicleExtra() {
        return vehicleExtra;
    }


    /**
     * Sets the vehicleExtra value for this VehicleAll.
     * 
     * @param vehicleExtra
     */
    public void setVehicleExtra(is.idega.webservice.vehicleregistryservice.client.VehicleExtra vehicleExtra) {
        this.vehicleExtra = vehicleExtra;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VehicleAll)) return false;
        VehicleAll other = (VehicleAll) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.vehicle==null && other.getVehicle()==null) || 
             (this.vehicle!=null &&
              this.vehicle.equals(other.getVehicle()))) &&
            ((this.vehicleExtra==null && other.getVehicleExtra()==null) || 
             (this.vehicleExtra!=null &&
              this.vehicleExtra.equals(other.getVehicleExtra())));
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
        if (getVehicle() != null) {
            _hashCode += getVehicle().hashCode();
        }
        if (getVehicleExtra() != null) {
            _hashCode += getVehicleExtra().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(VehicleAll.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://ws.lt.is/VehicleRegistryService", "VehicleAll"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehicle");
        elemField.setXmlName(new javax.xml.namespace.QName("https://ws.lt.is/VehicleRegistryService", "Vehicle"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://ws.lt.is/VehicleRegistryService", "Vehicle"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehicleExtra");
        elemField.setXmlName(new javax.xml.namespace.QName("https://ws.lt.is/VehicleRegistryService", "VehicleExtra"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://ws.lt.is/VehicleRegistryService", "VehicleExtra"));
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
