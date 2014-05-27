<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
	<meta charset="UTF-8"> 
	<title>Audien - Per�odos Letivos</title> 
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script> 
	<script>window.jQuery || document.write('<script src="js/jquery-1.7.1.min.js"><\/script>')</script> 
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" /> 
	<link href="css/audien.css" rel="stylesheet" type="text/css" />
	<link rel="shortcut icon" href="img/icon_transp.png">
	<script src="js/bootstrap.min.js"></script> 
</head>

<body>
	<div class="navbar navbar-inverse">
	  <div class="navbar-inner">
	    <a class="brand" href="index.jsp"><img src="img/audien_logo.png" height="50px" width="50px"></a>
	  </div>
	</div>

	<div class="container">
		<ul class="breadcrumb">
		  <li><a href="index.jsp">In�cio</a> <span class="divider">/</span></li>
		  <li><a href="listainstituicao.do">Institui��es</a> <span class="divider">/</span></li>
		  <li class="active">Per�odos</li>
		</ul>
		
		<h3 class="titulo">Per�odos Letivos - ${instituicao.nome}</h3>

		<form action="addperiodo.do" method="POST">
		  <fieldset>
		    <legend>Cadastrar Novo Per�odo Letivo</legend>

		    <input type="hidden" name="idinstituicao" value="${instituicao.id}">
		    
		    <label for="ano">Ano:</label>
		    <input type="text" name="ano" id="ano" placeholder="Ano relativo ao per�odo..." required>

		    <label for="periodo">Per�odo</label>
		    <input type="text" name="periodo" id="periodo" placeholder="Per�odo..." required><br>

		    <label for="dataInicio">Data de In�cio</label>
		    <input type="date" name="dataInicio" id="dataInicio" required><br>

		    <label for="dataFim">Data de T�rmino</label>
		    <input type="date" name="dataFim" id="dataFim" required><br>
		    
		    <button type="submit" class="btn btn-danger">Cadastrar</button>
		  </fieldset>
		</form>

		  <c:if test="${fn:length(instituicao.periodos) > 0}">

				<h3>Per�odos Cadastrados</h3>

				<table class="table table-striped table-hover">
					<tr>
						<th>Ano</th>
						<th>Per�odo</th>
						<th>Data de In�cio</th>
						<th>Data de T�rmino</th>
						<th></th>
					</tr>

					<c:forEach var="periodo" items="${instituicao.periodos}">
						<tr class="dados">
							<td>${periodo.ano}</td>
							<td>${periodo.periodo}</td>
							<td>${periodo.dataInicio}</td>
							<td>${periodo.dataFim}</td>
							<td>
							<a href="delperiodo.do?idperiodo=${periodo.id}" class="btn btn-danger btn-sm active" role="button">
							<span class="glyphicon glyphicon-trash"></span> Delete</a>
						</tr>
					</c:forEach>
				</table>
			</c:if>

	</div>
</body>
</html>