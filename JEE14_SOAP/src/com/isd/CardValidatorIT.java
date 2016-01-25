package com.isd;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

import org.junit.Assert;
import org.junit.Test;

public class CardValidatorIT {
	@Test
	public void shouldCheckCreditCardValidity() throws MalformedURLException {
		// Публикует веб-службу SOAP
		Endpoint endpoint = Endpoint.publish("http://localhost:8080/cardValidator", new CardValidator());
		Assert.assertTrue(endpoint.isPublished());
		Assert.assertEquals("http://schemas.xmlsoap.org/wsdl/soap/http", endpoint.getBinding().getBindingID());
		// Необходимые свойства для доступа к веб-службе
		URL wsdlDocumentLocation = new URL("http://localhost:8080/cardValidator?wsdl");
		String namespaceURI = "http://isd.com/";
		String servicePart = "CardValidatorService";
		String portName = "CardValidatorPort";
		QName serviceQN = new QName(namespaceURI, servicePart);
		QName portQN = new QName(namespaceURI, portName);
		// Создает объект службы
		Service service = Service.create(wsdlDocumentLocation, serviceQN);
		Validator cardValidator = service.getPort(portQN, Validator.class);
		// Вызывает веб-службу
		CreditCard creditCard = new CreditCard("1234 1234", "10/10", 1234, "VISA");
		Assert.assertTrue("Кредитная карта действительна", cardValidator.validate(creditCard));
		creditCard.setNumber("1234 1233");
		Assert.assertFalse("Кредитная карта недействительна", cardValidator.validate(creditCard));
		// Отключает видимость веб-службы SOAP
		endpoint.stop();
		Assert.assertFalse(endpoint.isPublished());
	}
}
