<%@page import="it.prova.progettoprovajpawebmaven.model.TipoSegnalazione"%>
<%@page import="it.prova.progettoprovajpawebmaven.model.Localita"%>
<%@page import="java.util.List"%>
<!doctype html>
<html lang="it">
<head>
<jsp:include page="../header.jsp" />
<title>Inserisci nuovo</title>

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
				<h5>Inserisci nuovo elemento</h5>
			</div>
			<div class='card-body'>

				<h6 class="card-title">
					I campi con <span class="text-danger">*</span> sono obbligatori
				</h6>

				<form method="post" action="ExecuteInsertSegnalazioneServlet"
					novalidate="novalidate">

					<div class="form-row">
						<div class="form-group col-md-6">
						    <label>Tipo segnalazione<span class="text-danger">*</span></label>
							<select class="form-select" name="tipoSegnalazione" aria-label="Tipo segnalazione select">
								<% List<TipoSegnalazione> listaTipiSegnalazione = (List<TipoSegnalazione>)request.getAttribute("listaTipiSegnalazioneAttribute");
		                		for(TipoSegnalazione item:listaTipiSegnalazione){ %>
								<option><%=item.getDescrizione() %></option>
							<% } %>
							</select>
						</div>

						<div class="form-group col-md-6">
							<label>Descrizione <span class="text-danger">*</span></label> <input
								type="text" name="descrizione" id="descrizione"
								class="form-control" placeholder="Inserire la descrizione"
								required>
						</div>
					</div>

					<div class="form-row">
						<div class="form-group col-md-6">
						    <label>Località<span class="text-danger">*</span></label>
							<select class="form-select" name="localita" aria-label="Localita select">
								<% List<Localita> listaLocalita = (List<Localita>)request.getAttribute("listaLocalitaAttribute");
		                		for(Localita item:listaLocalita){ %>
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


		<!-- end container -->
	</main>
	<jsp:include page="../footer.jsp" />

</body>
</html>