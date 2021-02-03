<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.progettoprovajpawebmaven.model.Segnalazione"%>
<%@page
	import="it.prova.progettoprovajpawebmaven.model.TipoSegnalazione"%>
<%@page import="it.prova.progettoprovajpawebmaven.model.Localita"%>
<%@page import="it.prova.progettoprovajpawebmaven.model.Stato"%>
<%@page import="java.util.List"%>
<html>
<head>
<jsp:include page="../header.jsp" />
<title>Insert title here</title>

<!-- style per le pagine diverse dalla index -->
<link href="./assets/css/global.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="../navbar.jsp" />

	<main role="main" class="container">

		<div
			class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}"
			role="alert">
			${errorMessage}
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

		<div class='card'>
			<div class='card-header'>
				<h5>Modifica segnalazione</h5>
			</div>

			<% Segnalazione segnalazioneInPagina = (Segnalazione)request.getAttribute("modifica_segnalazione_attr"); %>

			<div class='card-body'>

				<form
					action="ExecuteEditSegnalazioneServlet?idSegnalazione=<%=segnalazioneInPagina.getId() %>"
					method="post" novalidate="novalidate">

					<div class="form-row">

						<div class="form-group col-md-6">
							<label>Tipo segnalazione</label>
							<select class="form-select" name="tipoSegnalazione"
								aria-label="Tipo segnalazione select">
								<% List<TipoSegnalazione> listaTipiSegnalazione = (List<TipoSegnalazione>)request.getAttribute("listaTipiSegnalazioneAttribute");
		                		for(TipoSegnalazione item:listaTipiSegnalazione){ %>
								<option><%=item.getDescrizione() %></option>
								<% } %>
							</select>
						</div>

						<div class="form-group col-md-6">
							<label>Descrizione</label> <input type="text" name="descrizione"
								id="descrizione" class="form-control"
								value="<%=segnalazioneInPagina.getDescrizione() %>" required>
						</div>

					</div>

					<div class="form-row">
						<div class="form-group col-md-6">
							<label>Località</label> <select
								class="form-select" name="localita" aria-label="Localita select">
								<% List<Localita> listaLocalita = (List<Localita>)request.getAttribute("listaLocalitaAttribute");
		                		for(Localita item:listaLocalita){ %>
								<option><%=item.getDescrizione() %></option>
								<% } %>
							</select>
						</div>

						<div class="form-group col-md-6">
							<label>Località</label> <select
								class="form-select" name="stato" aria-label="Stato select">
								<% List<Stato> listaStati = (List<Stato>)request.getAttribute("listaStatiAttribute");
		                		for(Stato item:listaStati){ %>
								<option><%=item.getDescrizione() %></option>
								<% } %>
							</select>
						</div>

					</div>

					<button type="submit" name="submit" value="submit" id="submit"
						class="btn btn-primary">Conferma</button>


				</form>



				<!-- end card-body -->
			</div>
		</div>

	</main>
	<jsp:include page="../footer.jsp" />

</body>
</html>