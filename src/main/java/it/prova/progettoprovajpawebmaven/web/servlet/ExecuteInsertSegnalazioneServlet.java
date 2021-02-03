package it.prova.progettoprovajpawebmaven.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.progettoprovajpawebmaven.model.Localita;
import it.prova.progettoprovajpawebmaven.model.Segnalazione;
import it.prova.progettoprovajpawebmaven.model.TipoSegnalazione;
import it.prova.progettoprovajpawebmaven.service.MyServiceFactory;
import it.prova.progettoprovajpawebmaven.utility.Utility;

@WebServlet("/ExecuteInsertSegnalazioneServlet")
public class ExecuteInsertSegnalazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// estraggo input
		String tipoSegnalazioneInputStringParam = request.getParameter("tipoSegnalazione");
		String descrizioneInputParam = request.getParameter("descrizione");
		String localitaInputStringParam = request.getParameter("localita");
		
		try {
			if (!Utility.validateSegnalazione(tipoSegnalazioneInputStringParam, descrizioneInputParam, localitaInputStringParam)) {
				request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
				request.setAttribute("listaTipiSegnalazioneAttribute", MyServiceFactory.getTipoSegnalazioneServiceInstance().listAll());
				request.setAttribute("listaLocalitaAttribute", MyServiceFactory.getLocalitaServiceInstance().listAll());
				request.getRequestDispatcher("segnalazione/insert.jsp").forward(request, response);
				return;
			}
			
			TipoSegnalazione tipoInserito = MyServiceFactory.getTipoSegnalazioneServiceInstance().cercaPerDescrizione(tipoSegnalazioneInputStringParam);
			Localita localitaInserita = MyServiceFactory.getLocalitaServiceInstance().cercaPerDescrizione(localitaInputStringParam);
			
			Segnalazione segnalazioneInstance = new Segnalazione(tipoInserito, descrizioneInputParam, localitaInserita);
			segnalazioneInstance.setStato(MyServiceFactory.getStatoServiceInstance().caricaSingoloElemento(1L));
			
			MyServiceFactory.getSegnalazioneServiceInstance().inserisciNuovo(segnalazioneInstance);
			request.setAttribute("listaSegnalazioneAttribute", MyServiceFactory.getSegnalazioneServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
			
		} catch (Exception e) {
//			System.out.println(tipoSegnalazioneInputStringParam);
//			System.out.println(localitaInputStringParam);
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}

		// andiamo ai risultati
		request.getRequestDispatcher("/segnalazione/results.jsp").forward(request, response);
	}

}
