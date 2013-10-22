package daoImpl;

import java.util.List;

import javax.persistence.Query;

import classes.QuestaoDiscussiva;
import dao.IQuestaoDiscussivaDAO;

public class QuestaoDiscussivaDAOImpl extends GenericDAOImpl<QuestaoDiscussiva> implements IQuestaoDiscussivaDAO
{
    
	public QuestaoDiscussivaDAOImpl(){}
	@Override
	public void inserir(QuestaoDiscussiva entidade) throws Exception {
		// TODO Auto-generated method stub
		try {
			this.getManager().getTransaction().begin();
			this.getManager().persist(entidade);
			this.getManager().getTransaction().commit();
		} catch (Exception ex) {
			this.getManager().getTransaction().rollback();
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	public void atualizar(QuestaoDiscussiva entidade) throws Exception {
		// TODO Auto-generated method stub
		try {
			this.getManager().getTransaction().begin();
			this.getManager().merge(entidade);
			this.getManager().getTransaction().commit();
		} catch (Exception ex) {
			this.getManager().getTransaction().rollback();
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	public void remover(long id) throws Exception {
		// TODO Auto-generated method stub
		QuestaoDiscussiva q = this.getManager().getReference(QuestaoDiscussiva.class,
				new Long(id));
		try {
			this.getManager().getTransaction().begin();
			this.getManager().remove(q);
			this.getManager().getTransaction().commit();
		} catch (Exception ex) {
			this.getManager().getTransaction().rollback();
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	public List<QuestaoDiscussiva> consultarTodos() throws Exception {
		// TODO Auto-generated method stub
		Query query = this.getManager().createQuery(
				"SELECT q FROM QuestaoDiscussiva q");
		List<QuestaoDiscussiva> questoesDiscussivas = (List<QuestaoDiscussiva>) query
				.getResultList();
		return questoesDiscussivas;
	}

	@Override
	public QuestaoDiscussiva consultarPorId(long id) throws Exception {
		// TODO Auto-generated method stub
		QuestaoDiscussiva q = this.getManager().find(QuestaoDiscussiva.class, new Long(id));
		return q;
	}

}
