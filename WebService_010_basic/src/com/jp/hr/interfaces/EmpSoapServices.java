package com.jp.hr.interfaces;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.jp.hr.exceptions.HrException;

@WebService
@SOAPBinding(style=Style.DOCUMENT)
public interface EmpSoapServices {
	public int getTestInteger(int x) throws HrException;
}
