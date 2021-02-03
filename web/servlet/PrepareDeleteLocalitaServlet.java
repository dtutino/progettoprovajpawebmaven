package it.prova.progettoprovajpawebmaven.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.progettoprovajpawebmaven.model.Localita;
import it.prova.progettoprovajpawebmaven.service.MyServiceFactory;
import it.prova.progettoprovajpawebmaven.utility.Utility;

@WebServlet("/PrepareDeleteLocalitaServlet")
public class PrepareDeleteLocalitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idLocalitaParam = request.getParameter("idLocalita");

		Long idLocalita = Utility.parseIdArrivoFromString(idLocalitaParam);

		try {
			Localita localitaDaInviare = MyServiceFactory.getLocalitaServiceInstance()
					.caricaSingoloElemento(idLocalita);
			request.setAttribute("elimina_localita_attr", localitaDaInviare);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/localita/delete.jsp").forward(request, response);
	}

}
