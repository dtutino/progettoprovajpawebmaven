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

@WebServlet("/ExecuteDeleteLocalitaServlet")
public class ExecuteDeleteLocalitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idArrivoStringParam = request.getParameter("idLocalita");

		Long idArrivoParsed = Utility.parseIdArrivoFromString(idArrivoStringParam);

		try {
			Localita localitaInstance = MyServiceFactory.getLocalitaServiceInstance()
					.caricaSingoloElemento(idArrivoParsed);
			MyServiceFactory.getLocalitaServiceInstance().rimuovi(localitaInstance);

			request.setAttribute("listaLocalitaAttribute", MyServiceFactory.getLocalitaServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/localita/delete.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/localita/results.jsp").forward(request, response);
	}

}
