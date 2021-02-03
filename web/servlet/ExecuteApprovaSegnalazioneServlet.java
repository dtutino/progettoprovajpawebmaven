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

@WebServlet("/ExecuteApprovaSegnalazioneServlet")
public class ExecuteApprovaSegnalazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idSegnalazioneParam = request.getParameter("idSegnalazione");

		if (!NumberUtils.isCreatable(idSegnalazioneParam)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			Segnalazione segnalazioneDaApprovare = MyServiceFactory.getSegnalazioneServiceInstance().caricaSingoloElemento(Long.parseLong(idSegnalazioneParam));
			segnalazioneDaApprovare.setStato(MyServiceFactory.getStatoServiceInstance().caricaSingoloElemento(3L));
			MyServiceFactory.getSegnalazioneServiceInstance().aggiorna(segnalazioneDaApprovare);
			request.setAttribute("listaSegnalazioneAttribute", MyServiceFactory.getSegnalazioneServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/segnalazione/results.jsp").forward(request, response);
	}

}
