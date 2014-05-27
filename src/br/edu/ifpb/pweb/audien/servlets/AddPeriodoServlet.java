package br.edu.ifpb.pweb.audien.servlets;

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.pweb.audien.dao.InstituicaoDAO;
import br.edu.ifpb.pweb.audien.model.Instituicao;
import br.edu.ifpb.pweb.audien.model.PeriodoLetivo;

@WebServlet(value="/addperiodo.do")
 public class AddPeriodoServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
		private void doRequest(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException{
			
			Long idInstituicao = Long.valueOf(request.getParameter("idinstituicao"));
			int ano = Integer.parseInt(request.getParameter("ano"));
			int periodo = Integer.parseInt(request.getParameter("periodo"));
			String dataInicio = request.getParameter("dataInicio");
			String dataFim = request.getParameter("dataFim");
			
			PeriodoLetivo novoPeriodo = new PeriodoLetivo();
			novoPeriodo.setAno(ano);
			novoPeriodo.setPeriodo(periodo);
			novoPeriodo.setDataInicio(dataInicio);
			novoPeriodo.setDataFim(dataFim);
			
			String ultimoperiodo = ano + "." + periodo;
			
			EntityManager em = br.edu.ifpb.pweb.audien.dao.PersistenceUtil.getEntityManager();			
			
			InstituicaoDAO tDAO = new InstituicaoDAO(em);
			Instituicao instituicao = tDAO.find(idInstituicao);
			instituicao.setUltimoperiodo(ultimoperiodo);
			
			tDAO.beginTransaction();
			instituicao.addPeriodo(novoPeriodo);
			tDAO.commit();
			
			request.setAttribute("instituicao", instituicao);
			
			RequestDispatcher d = request.getRequestDispatcher("editinstituicao.do");
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