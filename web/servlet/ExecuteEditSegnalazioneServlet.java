package it.prova.progettoprovajpawebmaven.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.progettoprovajpawebmaven.model.Localita;
import it.prova.progettoprovajpawebmaven.model.Segnalazione;
import it.prova.progettoprovajpawebmaven.model.Stato;
import it.prova.progettoprovajpawebmaven.model.TipoSegnalazione;
import it.prova.progettoprovajpawebmaven.service.MyServiceFactory;
import it.prova.progettoprovajpawebmaven.utility.Utility;

@WebServlet("/ExecuteEditSegnalazioneServlet")
public class ExecuteEditSegnalazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// estraggo input
		String idArrivoStringParam = request.getParameter("idSegnalazione");
		String tipoSegnalazioneInputStringParam = request.getParameter("tipoSegnalazione");
		String descrizioneInputParam = request.getParameter("descrizione");
		String localitaInputStringParam = request.getParameter("localita");
		String statoInputStringParam = request.getParameter("stato");

		Long idArrivoParsed = Utility.parseIdArrivoFromString(idArrivoStringParam);

		if (!Utility.validateSegnalazione(tipoSegnalazioneInputStringParam, descrizioneInputParam, localitaInputStringParam)) {
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/stato/edit.jsp").forward(request, response);
			return;
		}

		Segnalazione segnalazioneInstance;
		try {
			segnalazioneInstance = MyServiceFactory.getSegnalazioneServiceInstance().caricaSingoloElemento(idArrivoParsed);
			TipoSegnalazione tipoInserito = MyServiceFactory.getTipoSegnalazioneServiceInstance().cercaPerDescrizione(tipoSegnalazioneInputStringParam);
			Localita localitaInserita = MyServiceFactory.getLocalitaServiceInstance().cercaPerDescrizione(localitaInputStringParam);
			Stato statoInserito = MyServiceFactory.getStatoServiceInstance().cercaPerDescrizione(statoInputStringParam);
			segnalazioneInstance.setTipoSegnalazione(tipoInserito);
			segnalazioneInstance.setDescrizione(descrizioneInputParam);
			segnalazioneInstance.setLocalita(localitaInserita);
			segnalazioneInstance.setStato(statoInserito);

			MyServiceFactory.getSegnalazioneServiceInstance().aggiorna(segnalazioneInstance);
			request.setAttribute("listaSegnalazioneAttribute", MyServiceFactory.getSegnalazioneServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/segnalazione/edit.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/segnalazione/results.jsp").forward(request, response);
	}

}
