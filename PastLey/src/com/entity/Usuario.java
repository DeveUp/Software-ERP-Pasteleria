package com.entity;

import java.io.Serializable;

/**
 * Implementation Usuario.
 * 
 * @author DeveUp.
 * @phone 3118398189.
 * @email deveup@gmail.com.
 * @version 1.0.0.0.
 */
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int id_persona;
	private Persona persona;
	private String email_confirmacion;
	private String clave;
	private String ultima_clave;
	private boolean estado;
	private boolean sesion;
	private String fecha_registro;
	private String fecha_actualizacion;
	private String fecha_sesion;
	private String fecha_ultima_sesion;
	private int rol;
	private int cantidad;
	
	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
	public Usuario() {
	}
	
	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", id_persona=" + id_persona + ", sesion=" + sesion + ", rol=" + rol
				+ ", cantidad=" + cantidad + "]";
	}
	
	///////////////////////////////////////////////////////
	// Getter and Setters
	///////////////////////////////////////////////////////
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId_persona() {
		return id_persona;
	}
	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public String getEmail_confirmacion() {
		return email_confirmacion;
	}
	public void setEmail_confirmacion(String email_confirmacion) {
		this.email_confirmacion = email_confirmacion;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getUltima_clave() {
		return ultima_clave;
	}
	public void setUltima_clave(String ultima_clave) {
		this.ultima_clave = ultima_clave;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public boolean isSesion() {
		return sesion;
	}
	public void setSesion(boolean sesion) {
		this.sesion = sesion;
	}
	public String getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public String getFecha_actualizacion() {
		return fecha_actualizacion;
	}
	public void setFecha_actualizacion(String fecha_actualizacion) {
		this.fecha_actualizacion = fecha_actualizacion;
	}
	public String getFecha_sesion() {
		return fecha_sesion;
	}
	public void setFecha_sesion(String fecha_sesion) {
		this.fecha_sesion = fecha_sesion;
	}
	public String getFecha_ultima_sesion() {
		return fecha_ultima_sesion;
	}
	public void setFecha_ultima_sesion(String fecha_ultima_sesion) {
		this.fecha_ultima_sesion = fecha_ultima_sesion;
	}
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
