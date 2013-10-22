package classes;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn (name="id_questao")
public class QuestaoDiscussiva extends Questao{

	public QuestaoDiscussiva() {
		// TODO Auto-generated constructor stub
	}

}
