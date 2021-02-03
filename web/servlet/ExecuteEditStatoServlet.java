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

@WebServlet("/ExecuteEditStatoServlet")
public class ExecuteEditStatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// estraggo input
		String idArrivoStringParam = request.getParameter("idStato");
		String descrizioneInputParam = request.getParameter("descrizione");

		Long idArrivoParsed = Utility.parseIdArrivoFromString(idArrivoStringParam);

		if (!Utility.validateCommonEntity(descrizioneInputParam)) {
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/stato/edit.jsp").forward(request, response);
			return;
		}

		Stato statoInstance;
		try {
			statoInstance = MyServiceFactory.getStatoServiceInstance().caricaSingoloElemento(idArrivoParsed);
			statoInstance.setDescrizione(descrizioneInputParam);

			MyServiceFactory.getStatoServiceInstance().aggiorna(statoInstance);
			request.setAttribute("listaStatiAttribute", MyServiceFactory.getStatoServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/stato/edit.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/stato/results.jsp").forward(request, response);
	}

}
