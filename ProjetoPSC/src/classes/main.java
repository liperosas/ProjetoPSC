package classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import daoImpl.FuncionarioDAOImpl;
import factory.FactoryDAO;

public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("Projeto_PSC");
		EntityManager manager = factory.createEntityManager();
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Maria do Carmo");
		funcionario.setRg("12332-132");
		funcionario.setTelefone("3333-3333");
		funcionario.setSalario(20000.00);
		funcionario.setTitulo("53245-1232");
		funcionario.setCpf("123.123.203-23");
		funcionario.setCelular("8888-8888");
		// funcionario.setCtps("12345678901988");
		Calendar c = Calendar.getInstance();
		c.set(1991, 8, 25);
		funcionario.setData_nasc(c);
		Endereco endereco = new Endereco();
		endereco.setBairro("Ararepinga");
		endereco.setCep("12345-623");
		endereco.setCidade("Caetés");
		endereco.setComplemento("425-113");
		endereco.setLogradouro("Fim do mundo");
		endereco.setNumero("225");
		endereco.setUf("PE");
		funcionario.setEndereco(endereco);
		try{
		//funcionario.setId(4);
		FuncionarioDAOImpl fdi = FactoryDAO.getFuncionarioDAOImpl();
		 //fdi.inserir(funcionario);
		//fdi.atualizar(funcionario);
		// funcionario = new Funcionario();
		// funcionario = fdi.consultarPorId(1);
		// System.out.println(funcionario.getNome());
		
		  List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		  funcionarios = fdi.consultarTodos(); for (Funcionario funcionario2 :
		  funcionarios) { System.out.println(funcionario2.getId()); }
		 
		//fdi.remover(4);
		
		
		//System.out.println(funcionario.getId());
		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	}

}
