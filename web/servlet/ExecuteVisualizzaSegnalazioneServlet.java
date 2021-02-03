package it.prova.progettoprovajpawebmaven.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.progettoprovajpawebmaven.model.Segnalazione;
import it.prova.progettoprovajpawebmaven.service.MyServiceFactory;

@WebServlet("/ExecuteVisualizzaSegnalazioneServlet")
public class ExecuteVisualizzaSegnalazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idSegnalazioneParam = request.getParameter("idSegnalazione");

		if (!NumberUtils.isCreatable(idSegnalazioneParam)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			Segnalazione segnalazioneDaVisualizzare = MyServiceFactory.getSegnalazioneServiceInstance().caricaSingoloElemento(Long.parseLong(idSegnalazioneParam));
			if (segnalazioneDaVisualizzare.getStato().equals(MyServiceFactory.getStatoServiceInstance().caricaSingoloElemento(1L))) {
				segnalazioneDaVisualizzare.setStato(MyServiceFactory.getStatoServiceInstance().caricaSingoloElemento(2L));
				MyServiceFactory.getSegnalazioneServiceInstance().aggiorna(segnalazioneDaVisualizzare);
			}
			
			request.setAttribute("visualizza_segnalazione_attr", segnalazioneDaVisualizzare);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/segnalazione/show.jsp").forward(request, response);
	}

}
