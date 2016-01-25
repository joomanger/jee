/**
 * CardValidatorService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.isd;

public interface CardValidatorService extends javax.xml.rpc.Service {
    public java.lang.String getCardValidatorPortAddress();

    public com.isd.Validator getCardValidatorPort() throws javax.xml.rpc.ServiceException;

    public com.isd.Validator getCardValidatorPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
