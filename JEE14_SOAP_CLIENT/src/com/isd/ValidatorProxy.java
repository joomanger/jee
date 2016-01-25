package com.isd;

public class ValidatorProxy implements com.isd.Validator {
  private String _endpoint = null;
  private com.isd.Validator validator = null;
  
  public ValidatorProxy() {
    _initValidatorProxy();
  }
  
  public ValidatorProxy(String endpoint) {
    _endpoint = endpoint;
    _initValidatorProxy();
  }
  
  private void _initValidatorProxy() {
    try {
      validator = (new com.isd.CardValidatorServiceLocator()).getCardValidatorPort();
      if (validator != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)validator)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)validator)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (validator != null)
      ((javax.xml.rpc.Stub)validator)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.isd.Validator getValidator() {
    if (validator == null)
      _initValidatorProxy();
    return validator;
  }
  
  public boolean validate(com.isd.CreditCard arg0) throws java.rmi.RemoteException{
    if (validator == null)
      _initValidatorProxy();
    return validator.validate(arg0);
  }
  
  
}