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
      <div class="container ml-5">
        <c:if test="${not empty mensagem_erro}">
          <div class="alert alert-danger">
            <strong>Erro!</strong> ${mensagem_erro}
          </div>
        </c:if>

        <c:if test="${not empty vaga}">
            <div class="vaga mt-4">
              <input type="hidden" id="vaga.id" name="vaga.id" value="${vaga.id}">
              <h1>Vaga</h1>
              <p><b>Cargo: </b> ${vaga.cargo}</p>
              <p><b>Status: </b> ${vaga.status}</p>
              <p><b>Data de expiração: </b> ${vaga.dataInicio}</p>
              <div class="criterios mt-4">
                <h3>Critérios</h3>
                <table class="table mt-4">
                  <thead>
                    <tr>
                      <th>Nome</th>
                      <th>Descrição</th>
                      <th>PMD</th>
                      <th>Peso</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="criterio" items="${vaga.criterios}">
                    <tr>
                      <td>${criterio.nome}</td>
                      <td>${criterio.descricao}</td>
                      <td>
                        <select disabled class="form-control" name="criterios.pmd">
                          <option <c:if test="${criterio.pmd == 'DESEJAVEL'}">selected</c:if> value="DESEJAVEL">Desejável</option>
                          <option <c:if test="${criterio.pmd == 'DIFERENCIAL'}">selected</c:if> value="DIFERENCIAL">Diferencial</option>
                          <option <c:if test="${criterio.pmd == 'RELEVANTE'}">selected</c:if> value="RELEVANTE">Relevante</option>
                          <option <c:if test="${criterio.pmd == 'MUITO_RELEVANTE'}">selected</c:if> value="MUITO_RELEVANTE">Muito Relevante</option>
                          <option <c:if test="${criterio.pmd == 'OBRIGATORIO'}">selected</c:if> value="OBRIGATORIO">Obrigatório</option>
                        </select>
                      </td>
                      <td>${criterio.peso}</td>
                    </tr>
                  </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
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