/**
 * CreditCard.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.isd;

public class CreditCard  implements java.io.Serializable {
    private java.lang.String number;  // attribute

    private java.lang.String expiry_date;  // attribute

    private int control_number;  // attribute

    private java.lang.String type;  // attribute

    public CreditCard() {
    }

    public CreditCard(
           java.lang.String number,
           java.lang.String expiry_date,
           int control_number,
           java.lang.String type) {
           this.number = number;
           this.expiry_date = expiry_date;
           this.control_number = control_number;
           this.type = type;
    }


    /**
     * Gets the number value for this CreditCard.
     * 
     * @return number
     */
    public java.lang.String getNumber() {
        return number;
    }


    /**
     * Sets the number value for this CreditCard.
     * 
     * @param number
     */
    public void setNumber(java.lang.String number) {
        this.number = number;
    }


    /**
     * Gets the expiry_date value for this CreditCard.
     * 
     * @return expiry_date
     */
    public java.lang.String getExpiry_date() {
        return expiry_date;
    }


    /**
     * Sets the expiry_date value for this CreditCard.
     * 
     * @param expiry_date
     */
    public void setExpiry_date(java.lang.String expiry_date) {
        this.expiry_date = expiry_date;
    }


    /**
     * Gets the control_number value for this CreditCard.
     * 
     * @return control_number
     */
    public int getControl_number() {
        return control_number;
    }


    /**
     * Sets the control_number value for this CreditCard.
     * 
     * @param control_number
     */
    public void setControl_number(int control_number) {
        this.control_number = control_number;
    }


    /**
     * Gets the type value for this CreditCard.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this CreditCard.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreditCard)) return false;
        CreditCard other = (CreditCard) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.number==null && other.getNumber()==null) || 
             (this.number!=null &&
              this.number.equals(other.getNumber()))) &&
            ((this.expiry_date==null && other.getExpiry_date()==null) || 
             (this.expiry_date!=null &&
              this.expiry_date.equals(other.getExpiry_date()))) &&
            this.control_number == other.getControl_number() &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType())));
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
        if (getNumber() != null) {
            _hashCode += getNumber().hashCode();
        }
        if (getExpiry_date() != null) {
            _hashCode += getExpiry_date().hashCode();
        }
        _hashCode += getControl_number();
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreditCard.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://isd.com/", "creditCard"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("number");
        attrField.setXmlName(new javax.xml.namespace.QName("", "number"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("expiry_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "expiry_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("control_number");
        attrField.setXmlName(new javax.xml.namespace.QName("", "control_number"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
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
