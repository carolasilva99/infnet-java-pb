<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-BR">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>VenturaHR</title>

  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.css" rel="stylesheet">

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

  <c:import url="/empresas/sidebar.jsp"/>

  <!-- Content Wrapper -->
  <div id="content-wrapper" class="d-flex flex-column">

    <!-- Main Content -->
    <div id="content">

      <c:import url="/topbar.jsp"/>

      <!-- Begin Page Content -->
      <div class="container align-content-center justify-content-center text-center">
        <c:if test="${not empty mensagem_erro}">
          <div class="alert alert-danger">
            <strong>Erro!</strong> ${mensagem_erro}
          </div>
        </c:if>

        <c:if test="${not empty mensagem_sucesso}">
          <div class="alert alert-success">
              ${mensagem_sucesso}
          </div>
        </c:if>

        <form method="get" action="${pageContext.request.contextPath}/consulta-vaga-empresa"  class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search" >
          <div class="input-group col-sm-12 mb-3 mb-sm-0">
            <label class="mr-2" for="status">Status: </label>
            <select class="form-control mr-3 ml-3 bg-light border-0 large" name="status" id="status">
              <option value="">-</option>
              <option value="ABERTA">Aberta</option>
              <option value="EXPIRADA">Expirada</option>
              <option value="RENOVADA">Renovada</option>
              <option value="FINALIZADA">Finalizada</option>
            </select>
            <input type="text" class="form-control bg-light border-0 large" placeholder="Cargo" name="cargo" id="cargo"
                   aria-label="Search" aria-describedby="basic-addon2">
            <div class="input-group-append">
              <button class="btn btn-primary">
                <i class="fas fa-search fa-sm"></i>
              </button>
            </div>
          </div>
        </form>
        <c:if test="${not empty vagas}">
          <table class="table mt-4">
            <thead>
              <tr>
                <th>Id</th>
                <th>Cargo</th>
                <th>Status</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach var="vaga" items="${vagas}">
              <tr onclick="window.location='${pageContext.request.contextPath}/detalhe-vaga?id=${vaga.id}'">
                <td>${vaga.id}</td>
                <td>${vaga.cargo}</td>
                <td>${vaga.status}</td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </c:if>
      </div>
      <!-- /.container-fluid -->

    <!-- End of Main Content -->

      <c:import url="/footer.jsp"/>

  </div>
  <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<c:import url="/logout-modal.jsp"/>

<!-- Bootstrap core JavaScript-->
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${pageContext.request.contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="${pageContext.request.contextPath}/resources/js/sb-admin-2.min.js"></script>

</body>

</html>