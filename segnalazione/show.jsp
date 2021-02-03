<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.progettoprovajpawebmaven.model.Segnalazione"%>
<html lang="it">
<head>
<jsp:include page="../header.jsp" />
<title>Visualizza elemento</title>

<!-- style per le pagine diverse dalla index -->
<link href="./assets/css/global.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="../navbar.jsp" />

	<main role="main" class="container">

		<div class='card'>
			<div class='card-header'>Visualizza dettaglio</div>
			<% Segnalazione segnalazioneInPagina = (Segnalazione)request.getAttribute("visualizza_segnalazione_attr"); %>

			<div class='card-body'>
				<dl class="row">
					<dt class="col-sm-3 text-right">Tipo segnalazione:</dt>
					<% if (segnalazioneInPagina.getTipoSegnalazione() != null) { %>
					<dd class="col-sm-9"><%=segnalazioneInPagina.getTipoSegnalazione().getDescrizione() %></dd>
					<% } else { %>
					<dd></dd>
					<% } %>
				</dl>

				<dl class="row">
					<dt class="col-sm-3 text-right">Descrizione:</dt>
					<% if (segnalazioneInPagina.getDescrizione() != null) { %>
					<dd class="col-sm-9"><%=segnalazioneInPagina.getDescrizione() %></dd>
					<% } else { %>
					<dd></dd>
					<% } %>
				</dl>

				<dl class="row">
					<dt class="col-sm-3 text-right">Località:</dt>
					<% if (segnalazioneInPagina.getLocalita() != null) { %>
					<dd class="col-sm-9"><%=segnalazioneInPagina.getLocalita().getDescrizione() %></dd>
					<% } else { %>
					<dd></dd>
					<% } %>
				</dl>

				<dl class="row">
					<dt class="col-sm-3 text-right">Stato segnalazione:</dt>
					<% if (segnalazioneInPagina.getStato() != null) { %>
					<dd class="col-sm-9"><%=segnalazioneInPagina.getStato().getDescrizione() %></dd>
					<% } else { %>
					<dd></dd>
					<% } %>
				</dl>

			</div>

			<div class='card-footer'>
				<a href="ListaSegnalazioneServlet" class='btn btn-outline-secondary'
					style='width: 80px'> <i class='fa fa-chevron-left'></i> Back
				</a> <a class="btn  btn-sm btn-outline-success ml-2 mr-2"
					href="ExecuteApprovaSegnalazioneServlet?idSegnalazione=<%=segnalazioneInPagina.getId() %>">Approva</a>
				<a class="btn  btn-sm btn-outline-danger ml-2 mr-2"
					href="ExecuteRifiutaSegnalazioneServlet?idSegnalazione=<%=segnalazioneInPagina.getId() %>">Rifiuta</a>
			</div>
		</div>



		<!-- end main container -->
	</main>
	<jsp:include page="../footer.jsp" />

</body>
</html>