package com.jp.fin.locator;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.jp.fin.exceptions.FinException;
import com.jp.hr.interfaces.EmpSoapServices;

public class LocateServices {

	public static EmpSoapServices getEmpServices() throws FinException{
		try {
			URL url = new URL("http://localhost:9898/hr?wsdl");
			QName qname = new QName("http://soap.hr.jp.com/", "EmpSoapServicesImplService");
			Service service = Service.create(url, qname);
			EmpSoapServices soapServices = service.getPort(EmpSoapServices.class);
			return soapServices;
		} catch (MalformedURLException e) {
			throw new FinException("Soap service link not established.",e);
		}
	}
}
