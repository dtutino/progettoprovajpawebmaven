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
		                        <% if (item.getTipoSegnalazione() != null) { %>
		                        <td><%=item.getTipoSegnalazione().getDescrizione() %></td>
		                        <% } else { %>
		                        <td></td>
		                        <% } %>
		                        <% if (item.getDescrizione() != null) { %>
		                        <td><%=item.getDescrizione() %></td>
		                        <% } else { %>
		                        <td></td>
		                        <% } %>
		                        <% if (item.getLocalita() != null) { %>
		                        <td><%=item.getLocalita().getDescrizione() %></td>
		                        <% } else { %>
		                        <td></td>
		                        <% } %>
		                        <% if (item.getStato() != null) { %>
		                        <td><%=item.getStato().getDescrizione() %></td>
		                        <% } else { %>
		                        <td></td>
		                        <% } %>
		                        <td>
		                        	<a class="btn  btn-sm btn-outline-secondary" href="ExecuteVisualizzaSegnalazioneServlet?idSegnalazione=<%=item.getId() %>">Visualizza</a>
									<a class="btn  btn-sm btn-outline-warning" href="PrepareEditSegnalazioneServlet?idSegnalazione=<%=item.getId() %>">Modifica</a>
									<a class="btn btn-outline-danger btn-sm" href="PrepareDeleteSegnalazioneServlet?idSegnalazione=<%=item.getId() %>">Rimuovi</a>
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