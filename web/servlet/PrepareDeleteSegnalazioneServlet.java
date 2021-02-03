package it.prova.progettoprovajpawebmaven.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.progettoprovajpawebmaven.model.Segnalazione;
import it.prova.progettoprovajpawebmaven.service.MyServiceFactory;
import it.prova.progettoprovajpawebmaven.utility.Utility;

@WebServlet("/PrepareDeleteSegnalazioneServlet")
public class PrepareDeleteSegnalazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idSegnalazioneParam = request.getParameter("idSegnalazione");

		Long idSegnalazione = Utility.parseIdArrivoFromString(idSegnalazioneParam);

		try {
			Segnalazione segnalazioneDaInviare = MyServiceFactory.getSegnalazioneServiceInstance()
					.caricaSingoloElemento(idSegnalazione);
			request.setAttribute("elimina_segnalazione_attr", segnalazioneDaInviare);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/segnalazione/delete.jsp").forward(request, response);
	}

}
