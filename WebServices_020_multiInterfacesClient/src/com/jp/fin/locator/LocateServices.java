package com.jp.fin.locator;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.jp.fin.exceptions.FinException;
import com.jp.hr.interfaces.EmpSoapServicesUpdate;
import com.jp.hr.interfaces.EmpSoapServicesView;

public class LocateServices {

	public static EmpSoapServicesView getEmpServices() throws FinException {
		try {
			URL url = new URL("http://localhost:9898/viewHr?wsdl");
			QName qname = new QName("http://soap.hr.jp.com/", "EmpSoapServicesViewImplService");
			Service service = Service.create(url, qname);
			EmpSoapServicesView viewServices = service.getPort(EmpSoapServicesView.class);
			return viewServices;
		} catch (MalformedURLException e) {
			throw new FinException("View Soap service link not established.", e);
		}
	}

	public static EmpSoapServicesUpdate getEmpUpdateServices() throws FinException {
		try {
			URL url = new URL("http://localhost:9898/updateHr?wsdl");
			QName qname = new QName("http://soap.hr.jp.com/", "EmpSoapServicesUpdateImplService");
			Service service = Service.create(url, qname);
			EmpSoapServicesUpdate updateServices = service.getPort(EmpSoapServicesUpdate.class);
			return updateServices;
		} catch (MalformedURLException e) {
			throw new FinException("Update Soap service link not established.", e);
		}
	}

}
