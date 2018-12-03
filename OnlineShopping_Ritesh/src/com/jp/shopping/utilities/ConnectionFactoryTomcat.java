package com.jp.shopping.utilities;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.jp.shopping.exceptions.ShoppingException;


public class ConnectionFactoryTomcat {
	private static ConnectionFactoryTomcat factory = null;
	private DataSource dataSource = null;

	private ConnectionFactoryTomcat() throws ShoppingException {
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/myoracle");
		} catch (NamingException e) {
			throw new ShoppingException("Problem in connecting to JNDI",e);
		}

	}

	public static ConnectionFactoryTomcat getConnectionFactory() throws ShoppingException {
		if (factory == null) {
			factory = new ConnectionFactoryTomcat();
		}
		return factory;
	}
	
	
	public DataSource getDataSource() {
		return this.dataSource;
	}


}
