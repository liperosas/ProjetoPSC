package classes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Prova {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_genero", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Genero genero;


	@OneToMany (mappedBy = "prova" ,fetch = FetchType.LAZY) 
	@Cascade (CascadeType.ALL)
	private List<CartaoResposta> cartoesResposta;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "questao_prova",
	joinColumns = @JoinColumn(name = "id_prova"),
	inverseJoinColumns = @JoinColumn(name = "id_questao"))
	private List<Questao> questoes;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_fase", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Fase fase;

	public Prova() {
		// TODO Auto-generated constructor stub
	}

}
