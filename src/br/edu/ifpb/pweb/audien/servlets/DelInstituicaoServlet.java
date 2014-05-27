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

@WebServlet(value="/delinstituicao.do")
public class DelInstituicaoServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {

	private void doRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Long idInstituicao  = Long.valueOf(request.getParameter("idinstituicao"));
		
		EntityManager em = PersistenceUtil.getEntityManager();
		
		InstituicaoDAO tDAO = new InstituicaoDAO(em);
		Instituicao Instituicao = tDAO.find(idInstituicao);
		tDAO.beginTransaction();
		tDAO.delete(Instituicao);
		tDAO.commit();
		
		em.close();
		
		RequestDispatcher d = request.getRequestDispatcher("listainstituicao.do");
		d.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
}