package be.odisee.pajotter.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@DiscriminatorValue("Aanbieding")
public class Aanbieding extends Bericht implements Serializable{
	public Aanbieding(){}
	
	@Column
	//@NotEmpty(message="Vul een aantal in AUB")
	private int aantal;
	
    public Aanbieding(int id, String status, Partij partij, String tekst, int aantal) throws Exception {
        super(id, status, partij, tekst);
        this.aantal = aantal;
      //  if (reactieOp == null) throw new Exception("FOUT");
       // this.reactieOp = reactieOp;
    }
    
    public Aanbieding(String status, Partij partij, String tekst, int aantal) throws Exception {
        super(status, partij, tekst);
        this.aantal = aantal;
      //  if (reactieOp == null) throw new Exception("FOUT");
       // this.reactieOp = reactieOp;
    }

    public Aanbieding(String status, Partij partij, String tekst) throws Exception {
        super(status, partij, tekst);
        
    }

    public Bericht getReactieOp(){
        return reactieOp;
    }

    public void setReactieOp(Bericht newVal){
        reactieOp = newVal;
    }
    

	public int getAantal() {
		return aantal;
	}

	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

	
}
