<!-- navbar -->
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">

	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
       <span class="navbar-toggler-icon"></span>
     </button>

  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdownSegnalazione" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Segnalazione</a>
        <div class="dropdown-menu" aria-labelledby="dropdownSegnalazione">
          <a class="dropdown-item" href="ListaSegnalazioneServlet">Lista segnalazioni</a>
          <a class="dropdown-item" href="PrepareInsertSegnalazioneServlet">Inserisci nuova segnalazione</a>
          <a class="dropdown-item" href="PrepareSearchSegnalazioneServlet">Cerca una segnalazione</a>
        </div>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdownCommon" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Gestione</a>
        <div class="dropdown-menu" aria-labelledby="dropdownCommon">
          <a class="dropdown-item" href="ListTipiSegnalazioneServlet">Tipi segnalazione</a>
          <a class="dropdown-item" href="ListaLocalitaServlet">Località</a>
          <a class="dropdown-item" href="ListaStatiServlet">Stati segnalazione</a>
        </div>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
