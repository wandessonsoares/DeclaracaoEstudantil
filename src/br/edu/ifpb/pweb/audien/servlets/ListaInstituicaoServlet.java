package br.edu.ifpb.pweb.audien.servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import br.edu.ifpb.pweb.audien.dao.InstituicaoDAO;
import br.edu.ifpb.pweb.audien.dao.PersistenceUtil;
import br.edu.ifpb.pweb.audien.model.Instituicao;

@WebServlet(value = "/listainstituicao.do")
public class ListaInstituicaoServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	private static Logger logger = Logger.getLogger(ListaInstituicaoServlet.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EntityManager em = PersistenceUtil.getEntityManager();
		
		List<Instituicao> instituicoes = new InstituicaoDAO(em).findAll();
		
		request.setAttribute("instituicoes", instituicoes);
		
		RequestDispatcher d = request.getRequestDispatcher("instituicoes.jsp");
		d.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
}