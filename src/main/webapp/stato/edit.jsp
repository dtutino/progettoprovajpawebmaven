<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.progettoprovajpawebmaven.model.Stato"%>
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
	
	<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Modifica stato</h5> 
		    </div>
		    
		    <% Stato statoInPagina = (Stato)request.getAttribute("modifica_stato_attr"); %>
		    
		    <div class='card-body'>

					<form action="ExecuteEditStatoServlet?idStato=<%=statoInPagina.getId() %>" method="post" novalidate="novalidate">
					
						<div class="form-row">
							
							<div class="form-group col-md-6">
								<label>Descrizione</label>
								<input type="text" name="descrizione" id="descrizione" class="form-control" value="<%=statoInPagina.getDescrizione() %>" required>
							</div>
							
						</div>
							
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
					

					</form>

		    
		    
			<!-- end card-body -->			   
		    </div>
		</div>
		
		</main>
	<jsp:include page="../footer.jsp" />	

</body>
</html>