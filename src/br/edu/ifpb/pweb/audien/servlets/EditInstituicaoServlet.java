package br.edu.ifpb.pweb.audien.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.pweb.audien.dao.InstituicaoDAO;
import br.edu.ifpb.pweb.audien.dao.PersistenceUtil;
import br.edu.ifpb.pweb.audien.model.Instituicao;

@WebServlet(value = "/editinstituicao.do")
public class EditInstituicaoServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long idInstituicao = Long.valueOf(request.getParameter("idinstituicao"));

		EntityManager em = PersistenceUtil.getEntityManager();

		InstituicaoDAO dao = new InstituicaoDAO(em);
		Instituicao instituicao = dao.find(idInstituicao); 

		request.setAttribute("instituicao", instituicao);

		RequestDispatcher d = request.getRequestDispatcher("periodos.jsp");
		d.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
}