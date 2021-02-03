<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.progettoprovajpawebmaven.model.Segnalazione"%>
<%@page import="java.util.List"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Pagina dei risultati</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
	
		<div class="alert alert-success alert-dismissible fade show ${successMessage==null?'d-none': ''}" role="alert">
		  ${successMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Segnalazioni</h5> 
		    </div>
		    <div class='card-body'>
		    	<a class="btn btn-primary " href="PrepareInsertSegnalazioneServlet">Add New</a>
		    
		        <div class='table-responsive'>
		            <table class='table table-striped ' >
		                <thead>
		                    <tr>
		                        <th>Id</th>
		                        <th>Tipo segnalazione</th>
		                        <th>Descrizione</th>
		                        <th>Località</th>
		                        <th>Stato</th>
		                        <th>Azioni</th>
		                    </tr>
		                </thead>
		                <tbody>
		                	<% List<Segnalazione> listaSegnalazione = (List<Segnalazione>)request.getAttribute("listaSegnalazioneAttribute");
		                		for(Segnalazione item:listaSegnalazione){ %>
		                    <tr >
		                        <td><%=item.getId() %></td>
		                        <td><%=item.getTipoSegnalazione().getDescrizione() %></td>
		                        <td><%=item.getDescrizione() %></td>
		                        <td><%=item.getLocalita().getDescrizione() %></td>
		                        <td><%=item.getStato().getDescrizione() %></td>
		                        <td>
		                        	<a class="btn  btn-sm btn-outline-secondary" href="ExecuteVisualizzaSegnalazioneServlet?idSegnalazione=<%=item.getId() %>">Visualizza</a>
									<a class="btn  btn-sm btn-outline-primary ml-2 mr-2" href="PrepareEditSegnalazioneServlet?idLocalita=<%=item.getId() %>">Edit</a>
									<a class="btn btn-outline-danger btn-sm" href="PrepareDeleteSegnalazioneServlet?idLocalita=<%=item.getId() %>">Delete</a>
								</td>
		                    </tr>
		                    <% } %>
		                </tbody>
		            </table>
		        </div>
		   
			<!-- end card-body -->			   
		    </div>
		</div>	
	
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>