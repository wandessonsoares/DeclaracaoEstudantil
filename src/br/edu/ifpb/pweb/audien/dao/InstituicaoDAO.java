package br.edu.ifpb.pweb.audien.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.jboss.logging.Logger;

import br.edu.ifpb.pweb.audien.model.Instituicao;

public class InstituicaoDAO extends GenericDAOJPAImpl<Instituicao, Long> {

	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(InstituicaoDAO.class);
	
	public InstituicaoDAO(EntityManager em) {
		super(em); 
	}

	@SuppressWarnings("unchecked")
	public List<Instituicao> findAll() throws DAOException{
		List<Instituicao> instituicoes = null;
		try {
			Query q = this.getEntityManager().createQuery("from Instituicao t");
			instituicoes = (List<Instituicao>) q.getResultList();
		} catch (HibernateException e) {
			throw new DAOException("Erro ao tentar pegar Instituições.", e);
		}
		return instituicoes;
	}

}
