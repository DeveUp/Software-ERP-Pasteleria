package com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.*;
import com.google.gson.Gson;
import com.util.*;
import com.entity.*;

/**
 * Implementation LoginController.
 * 
 * @author DeveUp.
 * @phone 3118398189.
 * @email deveup@gmail.com.
 * @version 1.0.0.0.
 */
@WebServlet(name = "LoginController", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
	public LoginController() {
	}

	///////////////////////////////////////////////////////
	// Methods Servlet
	///////////////////////////////////////////////////////
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ENROOOO login ajjaja");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");
		switch (accion) {
		case "login":
			login(request, response);
			break;
		default:
			break;
		}
	}

	///////////////////////////////////////////////////////
	// Methods
	///////////////////////////////////////////////////////
	/**
	 * Metodo que permite validar el login.
	 * @throws ServletException 
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession inicio = request.getSession(true);
		Map<String, Object> data = new HashMap<String, Object>();
		UsuarioDao dao = new UsuarioDao();
		String email = request.getParameter("email");
		String clave = request.getParameter("clave");
		String tipo = request.getParameter("tipo");
		boolean error = true;
		if (Validar.cadena(email)) {
			if (Validar.cadena(clave)) {
				if (Validar.cadena(tipo)) {
					if (dao.validarLogin(email, clave, Integer.parseInt(tipo))) {
						Usuario u=dao.getUsuario();
						u.setSesion(true);
						u.setCantidad(u.getCantidad()+1);
						if(dao.actualizarDatosUsuarioLogeado(u)) {
							data.put("rol", tipo);
							data.put("error", dao.getAlerta().isError());
							inicio.setAttribute("usuario_logeado", u);
							error = false;
						}else {
							data.put("title", "No se ha podido actualizar usuario!");
							data.put("icon", Alerta.ALERTA_ICON_ERROR);
							data.put("text", "Se ha presentado un error al momento de estar actualizando los datos de logedo del usuario.");
							data.put("footer", Alerta.ALERT_FOOTER);
							data.put("error", true);
							error = false;
						}
					}else {
						data.put("title", dao.getAlerta().getTitulo());
						data.put("icon", dao.getAlerta().getIcon());
						data.put("text", dao.getAlerta().getDescripcion());
						data.put("footer", dao.getAlerta().getAdicional());
						data.put("error", dao.getAlerta().isError());
						error = false;
					}
				} else {
					data.put("text", "El campo rol no puede estar vacio.");
				}
			} else {
				data.put("text", "El campo clave no puede estar vacio.");
			}
		} else {
			data.put("text", "El campo email no puede estar vacio.");
		}
		if (error) {
			data.put("title", "Faltaron campos llenar!");
			data.put("icon", Alerta.ALERTA_ICON_WARN);
			data.put("footer", "Esta información es importante.");
			data.put("error", true);
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(data));
	}
}
