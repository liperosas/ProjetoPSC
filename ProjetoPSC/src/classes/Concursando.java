package classes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
@Entity
@PrimaryKeyJoinColumn (name="id_pessoa")
public class Concursando extends Pessoa {
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name="id_areaconcurso" , insertable=true, updatable=true)
	@Fetch (FetchMode.JOIN)
	@Cascade (CascadeType.SAVE_UPDATE)
	private AreaConcurso areaconcurso;
	

	@OneToMany (mappedBy = "concursando" ,fetch = FetchType.LAZY) 
	@Cascade (CascadeType.ALL)	
	private List<CartaoResposta> cartoesResposta;
	
	public AreaConcurso getConcurso() {
		return areaconcurso;
	}

	public void setConcurso(AreaConcurso areaconcurso) {
		this.areaconcurso = areaconcurso;
	}

	public Concursando(int id, String nome, String cpf, String rg,
			String titulo, String telefone, String celular, Endereco endereco, Concurso concurso) {
		super(id, nome, cpf, rg, titulo, telefone, celular, endereco);
		// TODO Auto-generated constructor stub
	}

	public Concursando() {
		// TODO Auto-generated constructor stub
	}

}
