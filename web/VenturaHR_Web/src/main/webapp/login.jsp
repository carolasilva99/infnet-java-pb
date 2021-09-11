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

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

<div class="container">
    <c:if test="${not empty mensagem_erro}">
        <div class="alert alert-danger">
            <strong>Erro!</strong> ${mensagem_erro}
        </div>
    </c:if>
    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
                <div class="col-lg-5 d-none d-lg-block bg-login-image"></div>
                <div class="col-lg-7">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">Faça Login!</h1>
                        </div>
                        <form id="form-login" method="post" action="${pageContext.request.contextPath}/login" class="user">
                            <div class="form-group row">
                                <div class="col-sm-12 mb-3 mb-sm-0">
                                    <input type="email" class="form-control form-control-user" id="email" name="email"
                                           placeholder="E-mail">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-12 mb-3 mb-sm-0">
                                    <input type="password" class="form-control form-control-user"
                                           id="senha" name="senha" placeholder="Senha">
                                </div>
                            </div>
                            <button  class="btn btn-primary btn-user btn-block">
                                Login
                            </button>
                            <hr>
                        </form>
                        <hr>
                        <div class="text-center">
                            <a class="small" href="${pageContext.request.contextPath}/candidatos/cadastro-candidato.jsp">É um candidato e não tem uma conta? Cadastre-se!</a>
                        </div>
                        <div class="text-center">
                            <a class="small" href="${pageContext.request.contextPath}/empresas/cadastro-empresa.jsp">É uma empresa e não tem conta? Cadastre-se!</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- Bootstrap core JavaScript-->
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${pageContext.request.contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="${pageContext.request.contextPath}/resources/js/sb-admin-2.min.js"></script>

</body>

</html>