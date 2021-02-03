package it.prova.progettoprovajpawebmaven.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.progettoprovajpawebmaven.service.MyServiceFactory;

@WebServlet("/PrepareInsertSegnalazioneServlet")
public class PrepareInsertSegnalazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setAttribute("listaTipiSegnalazioneAttribute",
					MyServiceFactory.getTipoSegnalazioneServiceInstance().listAll());
			request.setAttribute("listaLocalitaAttribute",
					MyServiceFactory.getLocalitaServiceInstance().listAll());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/segnalazione/insert.jsp").forward(request, response);
		
	}

}
