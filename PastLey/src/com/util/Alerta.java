package com.util;

import java.io.Serializable;

/**
 * Implementation Alerta.
 * 
 * @author DeveUp.
 * @phone 3118398189.
 * @email deveup@gmail.com.
 * @version 1.0.0.0.
 */
public class Alerta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String icon;
	private String titulo;
	private String descripcion;
	private String adicional;
	private boolean error;
	
	public static String ALERTA_ICON_SUCCESS ="success";
	public static String ALERTA_ICON_WARN = "warning";
	public static String ALERTA_ICON_ERROR = "error";
	public static String ALERTA_ICON_INFO= "info";
	public static String ALERTA_ICON_QUESTION = "question";
	public static String ALERT_FOOTER ="Esta información es importante";
	
	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
	public Alerta(String icon, String titulo, String descripcion, String adicional) {
		super();
		this.icon = icon;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.adicional = adicional;
	}
	
	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
	@Override
	public String toString() {
		return "Alerta [icon=" + icon + ", titulo=" + titulo + ", descripcion=" + descripcion + ", adicional="
				+ adicional + "]";
	}

	///////////////////////////////////////////////////////
	// Getter and Setetrs
	///////////////////////////////////////////////////////
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAdicional() {
		return adicional;
	}

	public void setAdicional(String adicional) {
		this.adicional = adicional;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getALERTA_ICON_SUCCESS() {
		return ALERTA_ICON_SUCCESS;
	}

	public static void setALERTA_ICON_SUCCESS(String aLERTA_ICON_SUCCESS) {
		ALERTA_ICON_SUCCESS = aLERTA_ICON_SUCCESS;
	}

	public static String getALERTA_ICON_WARN() {
		return ALERTA_ICON_WARN;
	}

	public static void setALERTA_ICON_WARN(String aLERTA_ICON_WARN) {
		ALERTA_ICON_WARN = aLERTA_ICON_WARN;
	}

	public static String getALERTA_ICON_ERROR() {
		return ALERTA_ICON_ERROR;
	}

	public static void setALERTA_ICON_ERROR(String aLERTA_ICON_ERROR) {
		ALERTA_ICON_ERROR = aLERTA_ICON_ERROR;
	}

	public static String getALERTA_ICON_INFO() {
		return ALERTA_ICON_INFO;
	}

	public static void setALERTA_ICON_INFO(String aLERTA_ICON_INFO) {
		ALERTA_ICON_INFO = aLERTA_ICON_INFO;
	}

	public static String getALERTA_ICON_QUESTION() {
		return ALERTA_ICON_QUESTION;
	}

	public static void setALERTA_ICON_QUESTION(String aLERTA_ICON_QUESTION) {
		ALERTA_ICON_QUESTION = aLERTA_ICON_QUESTION;
	}

	public static String getALERT_FOOTER() {
		return ALERT_FOOTER;
	}

	public static void setALERT_FOOTER(String aLERT_FOOTER) {
		ALERT_FOOTER = aLERT_FOOTER;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
}
