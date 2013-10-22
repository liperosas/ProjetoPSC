package classes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class CartaoResposta {
	
	@Id @GeneratedValue
	private long id;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "questao_cartaoresposta",
	joinColumns = @JoinColumn(name = "id_cartaoresposta"),
	inverseJoinColumns = @JoinColumn(name = "id_questao"))
	private List<Questao> questoes;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_concursando", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Concursando concursando;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_prova", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Prova prova;
	
	public CartaoResposta() {
		// TODO Auto-generated constructor stub
	}

}
