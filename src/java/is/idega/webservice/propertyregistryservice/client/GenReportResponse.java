/**
 * GenReportResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.webservice.propertyregistryservice.client;

public class GenReportResponse  implements java.io.Serializable {
    private byte[] genReportResult;

    public GenReportResponse() {
    }

    public GenReportResponse(
           byte[] genReportResult) {
           this.genReportResult = genReportResult;
    }


    /**
     * Gets the genReportResult value for this GenReportResponse.
     * 
     * @return genReportResult
     */
    public byte[] getGenReportResult() {
        return genReportResult;
    }


    /**
     * Sets the genReportResult value for this GenReportResponse.
     * 
     * @param genReportResult
     */
    public void setGenReportResult(byte[] genReportResult) {
        this.genReportResult = genReportResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GenReportResponse)) return false;
        GenReportResponse other = (GenReportResponse) obj;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.genReportResult==null && other.getGenReportResult()==null) || 
             (this.genReportResult!=null &&
              java.util.Arrays.equals(this.genReportResult, other.getGenReportResult())));
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
        if (getGenReportResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGenReportResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGenReportResult(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GenReportResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GenReportResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("genReportResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GenReportResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
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
