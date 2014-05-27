<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head> 
	<meta charset="UTF-8"> 
	<title>Audien - Instituições</title> 
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
		  <li><a href="index.jsp">Início</a> <span class="divider">/</span></li>
		  <li class="active">Instituições</li>
		</ul>
				
		<h3>Instituições</h3>

		<form action="addinstituicao.do" method="POST">
		  <fieldset>
		    <legend>Cadastrar Nova Instituição</legend>
		    
		    <label for="nome">Nome do Instituição</label>
		    <input type="text" name="nome" id="nome" placeholder="Digite o nome da Instituição..." required>

		    <label for="sigla">Sigla do Instituição</label>
		    <input type="text" name="sigla" id="sigla" placeholder="Digite a Sigla da Instituição..." required><br>
		    
		    <label for="fone">Fone:</label>
		    <input type="text" name="fone" id="fone" placeholder="Telefone para contato..." required><br>
		    
		    <button type="submit" class="btn btn-danger">Cadastrar</button>
		  </fieldset>
		</form>

		<c:if test="${fn:length(instituicoes) > 0}">
			
			<h3>Instituições Cadastradas</h3>
			
			<table class="table table-hover">
				<tr>
					<th>Instituição</th>
					<th>Sigla</th>
					<th>Fone</th>
					<th>Último Período</th>
					<th></th>
				</tr>

				<c:forEach var="instituicao" items="${instituicoes}">
					<tr>
						<td><a href="editinstituicao.do?idinstituicao=${instituicao.id}">${instituicao.nome}</a></td>
						<td><a href="editinstituicao.do?idinstituicao=${instituicao.id}">${instituicao.sigla}</a></td>
						<td>${instituicao.fone}</td>
						<td>${instituicao.ultimoperiodo}</td>
						<td>
							<a href="delinstituicao.do?idinstituicao=${instituicao.id}" class="btn btn btn-danger btn-sm active" role="button">
								<span class="glyphicon glyphicon-trash"></span> 
								Delete
							</a>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

</body>
</html>