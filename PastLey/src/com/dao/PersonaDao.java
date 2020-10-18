package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.entity.*;
import com.util.*;

/**
 * Implementation PersonaDao.
 * 
 * @author DeveUp.
 * @phone 3118398189.
 * @email deveup@gmail.com.
 * @version 1.0.0.0.
 */
public class PersonaDao {
	private Conexion conexion;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	private Persona persona;

	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
	public PersonaDao() {
	}

	///////////////////////////////////////////////////////
	// Init
	///////////////////////////////////////////////////////
	/**
	 * Metodo que inicializa los parametros.
	 */
	public void init(String sql) {
		this.conexion = new Conexion();
		this.ps = null;
		this.rs = null;
		this.sql = sql;
	}

	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
	/**
	 * Metodo que permite averiguar si existe una persona con una condición.
	 *
	 * @param condicion, representa la condicion.
	 * @return true si existe false si no.
	 */
	@SuppressWarnings("static-access")
	public boolean existePersona(String condicion) {
		this.init("SELECT * FROM persona WHERE " + condicion);
		this.persona = null; 
		try {
			this.ps = this.conexion.getConexion().prepareStatement(this.sql);
			this.rs = this.ps.executeQuery();
			this.persona = new Persona();
			boolean existe = false;
			while (rs.next()) {
				this.persona.setId(rs.getInt(1));
				this.persona.setDocumento(rs.getInt(2));
				this.persona.setTipo_documento(rs.getInt(3));
				this.persona.setNombre(rs.getString(4));
				this.persona.setApellido(rs.getString(5));
				this.persona.setTelefono(rs.getString(6));
				this.persona.setEmail(rs.getString(7));
				this.persona.setGenero(rs.getString(8));
				this.persona.setDirrecion(rs.getString(9));
				this.persona.setFecha_nacimiento(rs.getString(10));
				this.persona.setFoto(rs.getAsciiStream(11));
				this.persona.setFecha_registro(rs.getString(12));
				this.persona.setFecha_actualizacion(rs.getString(13));
				if (!existe) {
					existe = true;
				}
			}
			return existe;
		} catch (SQLException ex) {
			System.out.println("Error {Metodo: existePersona, Error: " + ex.getMessage() + "}");
		} catch (Exception ex) {
			System.out.println("Error {Metodo: existePersona, Error: " + ex.getMessage() + "}");
		} finally {
			try {
				this.ps.close();
				this.rs.close();
				this.conexion.close();
			} catch (Exception ex) {
				System.out.println("Error {Metodo: existePersona, Error: " + ex.getMessage() + "}");
			}
		}
		return false;
	}

	///////////////////////////////////////////////////////
	// Getter y Setters
	///////////////////////////////////////////////////////
	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

	public PreparedStatement getPs() {
		return ps;
	}

	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
