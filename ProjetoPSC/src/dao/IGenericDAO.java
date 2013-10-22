/**
 * 
 */
package dao;

import java.util.List;

/**
 * @author Ant�nio
 * @param <T>
 *
 */
public interface IGenericDAO<T> {

void inserir(T entidade) throws Exception;
	
	void atualizar(T entidade) throws Exception;
	
	void remover(long id) throws Exception;
	
	List<T> consultarTodos() throws Exception;
	
	T consultarPorId(long id) throws Exception;
	
}
