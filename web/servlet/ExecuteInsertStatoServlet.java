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

@WebServlet("/ExecuteInsertStatoServlet")
public class ExecuteInsertStatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// estraggo input
		String descrizioneInputParam = request.getParameter("descrizione");

		if (!Utility.validateCommonEntity(descrizioneInputParam)) {
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/stato/insert.jsp").forward(request, response);
			return;
		}

		// se sono qui i valori sono ok quindi posso creare l'oggetto da inserire
		Stato statoInstance = new Stato(descrizioneInputParam);
		// occupiamoci delle operazioni di business
		try {
			MyServiceFactory.getStatoServiceInstance().inserisciNuovo(statoInstance);
			request.setAttribute("listaStatiAttribute", MyServiceFactory.getStatoServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/stato/insert.jsp").forward(request, response);
			return;
		}

		// andiamo ai risultati
		request.getRequestDispatcher("/stato/results.jsp").forward(request, response);

	}

}
