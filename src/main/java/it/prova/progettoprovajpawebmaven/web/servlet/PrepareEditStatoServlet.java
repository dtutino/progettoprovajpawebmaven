package it.prova.progettoprovajpawebmaven.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.progettoprovajpawebmaven.model.Stato;
import it.prova.progettoprovajpawebmaven.service.MyServiceFactory;
import it.prova.progettoprovajpawebmaven.utility.Utility;

@WebServlet("/PrepareEditStatoServlet")
public class PrepareEditStatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStatoParam = request.getParameter("idStato");

		Long idArticolo = Utility.parseIdArrivoFromString(idStatoParam);

		try {
			Stato statoDaInviare = MyServiceFactory.getStatoServiceInstance()
					.caricaSingoloElemento(idArticolo);
			request.setAttribute("modifica_articolo_attr", statoDaInviare);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/stato/edit.jsp").forward(request, response);
	}

}
