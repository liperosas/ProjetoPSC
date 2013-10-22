package negocios;

import java.util.List;

import classes.Concursando;
import daoImpl.ConcursandoDAOImpl;
import factory.FactoryDAO;

public class RNConcursando extends RNPessoa {

	ConcursandoDAOImpl dao;

	public void inserir(Concursando concursando) throws Exception {
		this.validarInserir(concursando);
		dao.inserir(concursando);
	}

	public void atualizar(Concursando concursando) throws Exception {
		this.validarAlterar(concursando);
		dao.atualizar(concursando);
	}

	public void remover(long id) throws Exception {
		this.validarRemover(id);
		dao.remover(id);
	}

	public Concursando consultarPorId(long id) throws Exception {
		return dao.consultarPorId(id);
	}

	public List<Concursando> consultarTodos() throws Exception {
		return dao.consultarTodos();
	}

	public RNConcursando() {
		// TODO Auto-generated constructor stub
		dao = FactoryDAO.getCocursandoDAOImpl();
	}

}
