package be.odisee.pajotter.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.IndexColumn;
import be.odisee.pajotter.domain.*;

@Entity
@Table(name="berichten")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Bericht")
public class Bericht {
	
		@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    protected int id;

	    @Column
	    protected String status;
	    
	    /*@Column
		private String type;*/

	    @Column
	    protected String tekst;

	    @ManyToOne
	    @JoinColumn(name="partij_id")
	   protected Partij m_Partij;

	    //@ManyToOne
	    //@JoinColumn(name="onderwerp_id",nullable=false)
	    //private Onderwerp onderwerp;

	    // hebben we nodig om IndexColumn te kunnen gebruien (bag vermijden)
	   // @Column
	    //private int rangId;

	    @ManyToOne
	    @JoinColumn(name="reactie_op_id")
	    protected Bericht reactieOp;

	    @OneToMany(fetch=FetchType.EAGER,mappedBy="reactieOp")
	    @IndexColumn(name="id")
	    private List<Bericht> m_Antwoorden = new ArrayList<Bericht>();


	    public Bericht(){}

	    public Bericht(int id, String status, /*String type,*/ Partij m_Partij, String tekst) {
	        this.id = id;
	        this.status = status;
	        this.m_Partij = m_Partij;
	        this.tekst = tekst;
	       // this.setType(type);
	        //this.type = type;
	        //this.onderwerp = onderwerp;
	        //this.rangId = onderwerp.getBijdragen().size()+1;
	    }

	    public Bericht(String status, Partij m_Partij, String tekst) {
	        this.status = status;
	        this.m_Partij = m_Partij;
	        this.tekst = tekst;
	        //this.onderwerp = onderwerp;
	        //this.rangId = onderwerp.getBijdragen().size()+1;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getTekst() {
	        return tekst;
	    }

	    public String getUserid(){
	        //return m_Partij.getUsernaam();
	        return ""+ m_Partij.getId();
	    }

	    
	    //Om een antwoord te kunnen geven
	    public int getReactieOpBijdrageId() {
	        if (reactieOp != null) return reactieOp.getId();
	        else return 0;
	    }

	    public String getType(){
	        String fullyQualifiedClassname = this.getClass().toString();
	        if (fullyQualifiedClassname.contains("Idee")) return("Idee");
	        else if(fullyQualifiedClassname.contains("Reactie")) return ("Reactie");
	        else throw new RuntimeException();
	    }

	    public Antwoord voegAntwoordToe(int id, Partij partij, String tekst) throws Exception{
	        Antwoord newReactie=null;
	        newReactie= new Antwoord(id, "actief", partij, this, tekst);
	        m_Antwoorden.add(newReactie);
	        return newReactie;
	    }

	    public Antwoord voegReactieToe(Partij partij, String tekst) throws Exception{
	        Antwoord newReactie=null;
	        newReactie= new Antwoord("actief", partij, this, tekst);
	        m_Antwoorden.add(newReactie);
	        return newReactie;
	    }

	    public List<Bericht> getReacties() {
	        return m_Antwoorden;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public void setM_Partij(Partij m_Partij) {
	        this.m_Partij = m_Partij;
	    }

	    public void setM_Antwoorden(List<Bericht> m_Antwoorden) {
	        this.m_Antwoorden = m_Antwoorden;
	    }

	   

	    public void setReactieOp(Bericht reactieOp) {
	        this.reactieOp = reactieOp;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public void setTekst(String tekst) {
	        this.tekst = tekst;
	    }


	    public boolean verwijderBijdrage(){
	        /* moet nog uitgewerkt worden */
	        return false;
	    }

	    public boolean verwijderReactie(Antwoord hetAntwoord){
	        /* moet nog uitgewerkt worden */
	        return false;
	    }

		/*public void setType(String type) {
			this.type = type;
		}*/

}
