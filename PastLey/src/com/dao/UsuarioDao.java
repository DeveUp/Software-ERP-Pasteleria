package com.dao;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.*;
import com.entity.*;

/**
 * Implementation UsuarioDao.
 * 
 * @author DeveUp.
 * @phone 3118398189.
 * @email deveup@gmail.com.
 * @version 1.0.0.0.
 */
public class UsuarioDao {

	private Conexion conexion;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	private Usuario usuario;
	private List<Usuario> usuarios;
	private Alerta alerta;

	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
	public UsuarioDao() {
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
	 * 
	 * @return
	 */
	@SuppressWarnings("static-access")
	public List<Rol> roles() {
		List<Rol> roles = new ArrayList<Rol>();
		init("SELECT * FROM rol ORDER BY id");
		try {
			ps = conexion.getConexion().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Rol rol = new Rol(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
				roles.add(rol);
			}
		} catch (SQLException ex) {
			System.out.println("Error {Metodo: roles, Error: " + ex.getMessage() + "}");
		} catch (Exception ex) {
			System.out.println("Error {Metodo: roles, Error: " + ex.getMessage() + "}");
		} finally {
			try {
				ps.close();
				rs.close();
				conexion.close();
			} catch (Exception ex) {
				System.out.println("Error {Metodo: roles, Error: " + ex.getMessage() + "}");
			}
		}
		return roles;
	}

	/**
	 * 
	 * @param u
	 * @return
	 */
	@SuppressWarnings("static-access")
	public boolean actualizarDatosUsuarioLogeado(Usuario u) {
		init("UPDATE usuario SET sesion = ?, cantidad = ? WHERE id =" + usuario.getId());
		this.usuario = null;
		try {
			ps = conexion.getConexion().prepareStatement(sql);
			ps.setBoolean(1, u.isSesion());
			ps.setInt(2, u.getCantidad());
			ps.executeUpdate();
			this.usuario = u;
			return true;
		} catch (SQLException ex) {
			System.out.println("Error {Metodo: actualizarDatosUsuarioLogeado, Error: " + ex.getMessage() + "}");
		} catch (Exception ex) {
			System.out.println("Error {Metodo: actualizarDatosUsuarioLogeado, Error: " + ex.getMessage() + "}");
		} finally {
			try {
				ps.close();
				rs.close();
				conexion.close();
			} catch (Exception ex) {
				System.out.println("Error {Metodo: actualizarDatosUsuarioLogeado, Error: " + ex.getMessage() + "}");
			}
		}
		return false;
	}

	/**
	 * Metodo que permite conocer si existe un usuario mediante una condicion.
	 * 
	 * @param condicion representa la condicion.
	 * @return true si existe false si no.
	 */
	@SuppressWarnings("static-access")
	public boolean existeUsuario(String condicion) {
		PersonaDao dao = new PersonaDao();
		dao.existePersona(condicion);
		if (dao.getPersona() != null) {
			this.usuario = null;
			this.init("SELECT * FROM usuario WHERE persona = ?");
			try {
				this.ps = this.conexion.getConexion().prepareStatement(this.sql);
				this.ps.setInt(1, dao.getPersona().getId());
				this.rs = this.ps.executeQuery();
				this.usuario = new Usuario();
				boolean existe = false;
				this.usuario.setPersona(dao.getPersona());
				while (rs.next()) {
					this.usuario.setId(rs.getInt(1));
					this.usuario.setId_persona(rs.getInt(2));
					this.usuario.setEmail_confirmacion(rs.getString(3));
					this.usuario.setClave(rs.getString(4));
					this.usuario.setUltima_clave(rs.getString(5));
					this.usuario.setEstado(rs.getBoolean(6));
					this.usuario.setSesion(rs.getBoolean(7));
					this.usuario.setFecha_registro(rs.getString(8));
					this.usuario.setFecha_actualizacion(rs.getString(9));
					this.usuario.setFecha_sesion(rs.getString(10));
					this.usuario.setFecha_ultima_sesion(rs.getString(11));
					this.usuario.setRol(rs.getInt(12));
					this.usuario.setCantidad(rs.getInt(13));
					if (!existe) {
						existe = true;
					}
				}
				return existe;
			} catch (SQLException ex) {
				System.out.println("Error {Metodo: existeUsuario, Error: " + ex.getMessage() + "}");
			} catch (Exception ex) {
				System.out.println("Error {Metodo: existeUsuario, Error: " + ex.getMessage() + "}");
			} finally {
				try {
					this.ps.close();
					this.rs.close();
					this.conexion.close();
				} catch (Exception ex) {
					System.out.println("Error {Metodo: existeUsuario, Error: " + ex.getMessage() + "}");
				}
			}
		}
		return false;
	}

	/**
	 * Metodo que permite averiguar si son correctas las credenciales.
	 *
	 * @param email, representa el email.
	 * @param clave, representa la clave.
	 * @return un boolean true si es correcto y false si no.
	 */
	public boolean validarLogin(String email, String clave, int rol) {
		this.usuario = null;
		if (clave != null && email != null && existeUsuario("email = '" + email + "'")) {
			if (this.usuario != null) {
				if (this.usuario.getClave().contentEquals(clave)) {
					if (this.usuario.getRol() == rol) {
						if (this.usuario.isEstado()) {
							this.alerta = new Alerta(Alerta.ALERTA_ICON_SUCCESS, "Credenciales validas!",
									"Las credenciales son correctas.", "Bienvenido.");
							this.alerta.setError(false);
							return true;
						}
						this.alerta = new Alerta(Alerta.ALERTA_ICON_ERROR, "Tu estado es bloqueado!",
								"Este usuario ha ido bloqueado por la empresa.", "Comunicate con nosotros.");
					} else {
						this.alerta = new Alerta(Alerta.ALERTA_ICON_ERROR, "Credenciales NO validas!",
								"Las credenciales no son validas.", "Vuelva a intentarlo.");
					}
				} else {
					this.alerta = new Alerta(Alerta.ALERTA_ICON_ERROR, "Credenciales NO validas!",
							"El email o clave son incorrectos.", "Vuelva a intentarlo.");
				}
			} else {
				this.alerta = new Alerta(Alerta.ALERTA_ICON_ERROR, "Datos incorrectos!",
						"No existe ningun usuario con ese email.", "Vuelva a intentarlo.");
			}
		} else {
			this.alerta = new Alerta(Alerta.ALERTA_ICON_WARN, "Datos incorrectos!",
					"No existe ningun usuario con ese email.", "Vuelva a intentarlo.");
		}
		this.alerta.setError(true);
		return false;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("static-access")
	public byte[] verFoto(int id) {
		byte[] foto = null;
		init("SELECT p.foto FROM persona p JOIN usuario u ON(p.id=" + id + " and u.persona = p.id)");
		try {
			ps = conexion.getConexion().prepareStatement(this.sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				foto = rs.getBytes(1);
			}
			InputStream bos = new ByteArrayInputStream(foto);
			int size = bos.available();
			byte[] datosIMAGEN = new byte[size];
			bos.read(datosIMAGEN, 0, size);
			foto = datosIMAGEN;
			bos.close();
		} catch (SQLException ex) {
			System.out.println("Error {Metodo: verFoto, Error: " + ex.getMessage() + "}");
		} catch (Exception ex) {
			System.out.println("Error {Metodo: verFoto, Error: " + ex.getMessage() + "}");
		} finally {
			try {
				this.ps.close();
				this.rs.close();
				this.conexion.close();
			} catch (Exception ex) {
				System.out.println("Error {Metodo: verFoto, Error: " + ex.getMessage() + "}");
			}
		}
		return foto;
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

	public Alerta getAlerta() {
		return alerta;
	}

	public void setAlerta(Alerta alerta) {
		this.alerta = alerta;
	}

	public ResultSet getRs() {
		return rs;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
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
}
