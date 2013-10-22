package classes;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class Concurso {

	@Id @GeneratedValue
	private long id;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name="id_empresa" , insertable=true, updatable=true)
	@Fetch (FetchMode.JOIN)
	@Cascade (CascadeType.SAVE_UPDATE)
	private Empresa empresa;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar datainscricao;
	
	@OneToMany (mappedBy = "concurso" ,fetch = FetchType.LAZY) 
	@Cascade (CascadeType.ALL)
	private List<AreaConcurso> areasConcurso;
	
	
	public Concurso(long id, Empresa empresa, Calendar datainscricao) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.datainscricao = datainscricao;
		
	}

	public Concurso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Calendar getData() {
		return datainscricao;
	}

	public void setData(Calendar data) {
		this.datainscricao = data;
	}

	public List<AreaConcurso> getAreasConcurso() {
		return areasConcurso;
	}

	public void setAreasConcurso(List<AreaConcurso> areasConcurso) {
		this.areasConcurso = areasConcurso;
	}
	
	
}
