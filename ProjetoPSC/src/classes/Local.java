package classes;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Local {

	@Id @GeneratedValue
	private int id;
	
	private boolean disponivel;
	
	@Embedded
	private Endereco endereco;
	
	/*@OneToMany (mappedBy="local", fetch = FetchType.LAZY)
	@Cascade (CascadeType.ALL)
	private List<LocaisAreaConcurso> locaisareaconcurso;*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/*public List<LocaisAreaConcurso> getConcursos() {
		return locaisareaconcurso;
	}

	public void setConcursos(List<LocaisAreaConcurso> locaisareaconcurso) {
		this.locaisareaconcurso = locaisareaconcurso;
	}
*/
	public Local(int id, boolean disponivel, Endereco endereco,
			List<LocaisFaseConcurso> locaisareaconcurso) {
		super();
		this.id = id;
		this.disponivel = disponivel;
		this.endereco = endereco;
		//this.locaisareaconcurso = locaisareaconcurso;
	}

	public Local() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
