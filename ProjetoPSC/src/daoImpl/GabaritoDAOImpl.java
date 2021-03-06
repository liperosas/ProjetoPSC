package daoImpl;

import java.util.List;

import javax.persistence.Query;

import classes.Gabarito;
import dao.IGabaritoDAO;

public class GabaritoDAOImpl extends GenericDAOImpl<Gabarito> implements IGabaritoDAO{
    
	public GabaritoDAOImpl(){}
	@Override
	public void inserir(Gabarito entidade) throws Exception {
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
	public void atualizar(Gabarito entidade) throws Exception {
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
		Gabarito g = this.getManager().getReference(Gabarito.class,
				new Long(id));
		try {
			this.getManager().getTransaction().begin();
			this.getManager().remove(g);
			this.getManager().getTransaction().commit();
		} catch (Exception ex) {
			this.getManager().getTransaction().rollback();
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	public List<Gabarito> consultarTodos() throws Exception {
		// TODO Auto-generated method stub
		Query query = this.getManager().createQuery(
				"SELECT g FROM Gabarito g");
		List<Gabarito> gabaritos = (List<Gabarito>) query
				.getResultList();
		return gabaritos;
	}

	@Override
	public Gabarito consultarPorId(long id) throws Exception {
		// TODO Auto-generated method stub
		Gabarito g = this.getManager().find(Gabarito.class, new Long(id));
		return g;
	}

}
