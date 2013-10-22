package daoImpl;

import java.util.List;

import javax.persistence.Query;

import classes.Concursando;
import dao.IConcursandoDAO;

public class ConcursandoDAOImpl extends GenericDAOImpl<Concursando> implements IConcursandoDAO {
    
	public ConcursandoDAOImpl(){}
	@Override
	public void inserir(Concursando entidade) throws Exception {
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
	public void atualizar(Concursando entidade) throws Exception {
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
	Concursando c = this.getManager().getReference(Concursando.class,
				new Long(id));
		try {
			this.getManager().getTransaction().begin();
			this.getManager().remove(c);
			this.getManager().getTransaction().commit();
		} catch (Exception ex) {
			this.getManager().getTransaction().rollback();
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	public List<Concursando> consultarTodos() throws Exception {
		// TODO Auto-generated method stub
		Query query = this.getManager().createQuery(
				"SELECT c FROM Concursando c");
		List<Concursando> Concursandos = (List<Concursando>) query
				.getResultList();
		return Concursandos ;
	}

	@Override
	public Concursando consultarPorId(long id) throws Exception {
		// TODO Auto-generated method stub
		Concursando c = this.getManager().find(Concursando.class, new Long(id));
		return c;
	}

}
