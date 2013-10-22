package classes;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn (name="id_prova")
public class Gabarito extends Prova{
	
	public Gabarito() {
		// TODO Auto-generated constructor stub
	}

}
