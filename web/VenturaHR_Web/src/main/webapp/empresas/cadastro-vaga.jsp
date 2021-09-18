<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
          type="text/css">
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

                <form method="post" action="${pageContext.request.contextPath}/cadastro-vaga">
                    <h1>Cadastro de vaga</h1>
                    <div class="vaga mt-4">
                        <div class="form-group row">
                            <div class="col-sm-10 mb-3 mb-sm-0">
                                <input type="text" class="form-control form-control-user" id="cargo" name="cargo"
                                       placeholder="Cargo">
                            </div>
                        </div>
                        <script type="text/javascript">
                            var i = 0;

                            function add() {
                                var clone = document.getElementById('criterio').cloneNode(true); // "deep" clone
                                clone.id = "criterio" + ++i;
                                // or clone.id = ""; if the divs don't need an ID
                                document.getElementById('criterio').parentNode.appendChild(clone);
                            }

                            function remove() {
                                var toDelete = document.getElementById('criterio' + i);
                                toDelete.remove();
                                i--;
                            }
                        </script>
                        <div id="criterios">
                            <h4>Critérios</h4>
                            <div id="criterio">
                                <div class="form-group row">
                                    <div class="col-sm-10 mb-3 mb-sm-0">
                                        <input class="form-control" name="criterios.nome" type="text"
                                               placeholder="Nome"/>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-10 mb-3 mb-sm-0">
                                        <input class="form-control" name="criterios.descricao" type="text"
                                               placeholder="Descrição"/>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-5 mb-3 mb-sm-0">
                                        <select class="form-control" name="criterios.pmd">
                                            <option value="">Selecione - PMD</option>
                                            <option value="DESEJAVEL">Desejável</option>
                                            <option value="DIFERENCIAL">Diferencial</option>
                                            <option value="RELEVANTE">Relevante</option>
                                            <option value="MUITO_RELEVANTE">Muito Relevante</option>
                                            <option value="OBRIGATORIO">Obrigatório</option>
                                        </select>
                                    </div>
                                    <div class="col-sm-5 mb-3 mb-sm-0">
                                        <input class="form-control" name="criterios.peso" type="number"
                                               placeholder="Peso"/>
                                    </div>
                                </div>
                                <hr style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid rgba(0, 0, 0, 0.1);"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-5 mb-3 mb-sm-0">
                            <input class="btn btn-success" type="button" id="addrows" name="addrows"
                                   value="Adicionar Critério" onclick="add();">
                        </div>
                        <div class="col-sm-5 mb-3 mb-sm-0">
                            <input class="btn btn-danger" type="button" id="removerows" name="removerows"
                                   value="Remover critério" onclick="remove();">
                        </div>
                    </div>

                    <div class="text-left mt-3">
                        <button type="submit" class="btn btn-primary">Cadastrar</button>
                    </div>

                </form>
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