package it.prova.progettoprovajpawebmaven.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.progettoprovajpawebmaven.service.MyServiceFactory;

@WebServlet("/ListaSegnalazioneServlet")
public class ListaSegnalazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("listaSegnalazioneAttribute",
					MyServiceFactory.getSegnalazioneServiceInstance().listAll());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/segnalazione/results.jsp").forward(request, response);
	}

}
