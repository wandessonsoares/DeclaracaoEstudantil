package br.edu.ifpb.pweb.audien.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.pweb.audien.dao.PeriodoDAO;
import br.edu.ifpb.pweb.audien.model.PeriodoLetivo;

@WebServlet(value="/delperiodo.do")
 public class DelPeriodoServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
		private void doRequest(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException{

			Long idPeriodoLetivo  = Long.valueOf(request.getParameter("idperiodo"));
			
			EntityManager em = br.edu.ifpb.pweb.audien.dao.PersistenceUtil.getEntityManager();
			
			PeriodoDAO aDAO = new PeriodoDAO(em);
			PeriodoLetivo delPeriodoLetivo = aDAO.find(idPeriodoLetivo);
			
			aDAO.beginTransaction();
			aDAO.delete(delPeriodoLetivo);
			aDAO.commit();
			
			em.close();
			
			RequestDispatcher d = request.getRequestDispatcher("editinstituicao.do?idinstituicao="+delPeriodoLetivo.getInstituicao().getId());
			d.forward(request, response);

		}
	 
	 protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			doRequest(request, response);
		}

		protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			doRequest(request, response);
		}   
}