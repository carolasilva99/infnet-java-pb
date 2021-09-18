<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${pageContext.request.contextPath}/empresas/consulta-vagas.jsp">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">VenturaHR <sup>empresa</sup></div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
        Vagas
    </div>

    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item">
        <form method="get" action="${pageContext.request.contextPath}/empresas/consulta-vaga">
            <a onclick="parentNode.submit()" class="nav-link">
                <i class="fas fa-fw fa-search"></i>
                <span>Minhas Vagas</span>
            </a>
        </form>
    </li>

    <li class="nav-item">
        <a  class="nav-link" href="${pageContext.request.contextPath}/empresas/cadastro-vaga.jsp">
            <i class="fas fa-fw fa-plus"></i>
            <span>Cadastrar Vaga</span>
        </a>
    </li>

    <!-- Candidaturas -->
    <div class="sidebar-heading">
        Candidaturas
    </div>

    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

</ul>
<!-- End of Sidebar -->