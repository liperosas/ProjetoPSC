package classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Entity
public class Genero {

	@Id
	@GeneratedValue
	public long id;
    @Column(length=30,nullable=false)
	public String genero;
	
	@OneToMany (mappedBy = "genero" ,fetch = FetchType.LAZY) 
	@Cascade (CascadeType.ALL)	
	public List<Questao> questoes;

	@OneToMany (mappedBy = "genero" ,fetch = FetchType.LAZY) 
	@Cascade (CascadeType.ALL)	
	public List<Prova> provas;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Genero(long id, String genero) {
		super();
		this.id = id;
		this.genero = genero;
	}

	public Genero() {
		// TODO Auto-generated constructor stub
	}

}
