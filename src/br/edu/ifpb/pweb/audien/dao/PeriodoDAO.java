package br.edu.ifpb.pweb.audien.dao;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

import br.edu.ifpb.pweb.audien.model.PeriodoLetivo;

public class PeriodoDAO extends GenericDAOJPAImpl<PeriodoLetivo, Long> {

	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(PeriodoDAO.class);
	
	public PeriodoDAO(EntityManager em) {
		super(em); 
	}	

}
