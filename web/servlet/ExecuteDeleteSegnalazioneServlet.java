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

@WebServlet("/ExecuteDeleteSegnalazioneServlet")
public class ExecuteDeleteSegnalazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idArrivoStringParam = request.getParameter("idSegnalazione");

		Long idArrivoParsed = Utility.parseIdArrivoFromString(idArrivoStringParam);

		try {
			Segnalazione segnalazioneInstance = MyServiceFactory.getSegnalazioneServiceInstance()
					.caricaSingoloElemento(idArrivoParsed);
			MyServiceFactory.getSegnalazioneServiceInstance().rimuovi(segnalazioneInstance);

			request.setAttribute("listaSegnalazioneAttribute", MyServiceFactory.getSegnalazioneServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/segnalazione/delete.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/segnalazione/results.jsp").forward(request, response);
	}

}
