package com.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Implementation Conexion.
 * 
 * @author DeveUp.
 * @phone 3118398189.
 * @email deveup@gmail.com.
 * @version 1.0.0.0.
 */
public class Conexion implements Serializable{

	private static final long serialVersionUID = 1L;

	private static Connection c;

	private static String url = "jdbc:mysql://localhost/";
	private static String time = "?useTimezone=True&serverTimezone=UTC";
	private static String dbName = "pastley";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String password = "";

	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
	public Conexion() {
	}

	///////////////////////////////////////////////////////
	// Methods
	///////////////////////////////////////////////////////
	/**
	 * Metodo que activa la conexión.
	 * 
	 * @return representa la conexión.
	 */
	public static Connection getConexion() {
		try {
			Class.forName(driver);
			c = (Connection) DriverManager.getConnection(url + dbName + time, user, password);
			//System.out.println("Exitosa");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return c;
	}

	/**
	 * Metodo que permite cerrar la conexión.
	 */
	public void close() {
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	///////////////////////////////////////////////////////
	// Getter y Setters
	///////////////////////////////////////////////////////
	public static Connection getC() {
		return c;
	}

	public static void setC(Connection c) {
		Conexion.c = c;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		Conexion.url = url;
	}

	public static String getTime() {
		return time;
	}

	public static void setTime(String time) {
		Conexion.time = time;
	}

	public static String getDbName() {
		return dbName;
	}

	public static void setDbName(String dbName) {
		Conexion.dbName = dbName;
	}

	public static String getDriver() {
		return driver;
	}

	public static void setDriver(String driver) {
		Conexion.driver = driver;
	}

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		Conexion.user = user;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Conexion.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
