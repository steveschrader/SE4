package be.odisee.pajotter.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@DiscriminatorValue("Bestelling")
public class Bestelling extends Bericht implements Serializable{
	public Bestelling(){}
	
	@Column
	//@NotEmpty(message="Vul een aantal in AUB")
	private int aantal;
	
	@Column
    //@NotEmpty(message = "Vul Leverancier in aub")
	private int LeverancierId;
	
    public Bestelling(int id, String status, Partij partij, String tekst, int aantal) throws Exception {
        super(id, status, partij, tekst);
        this.aantal = aantal;
      //  if (reactieOp == null) throw new Exception("FOUT");
       // this.reactieOp = reactieOp;
    }
    
    public Bestelling(String status, Partij partij, String tekst, int aantal, int LeverancierId) throws Exception {
        super(status, partij, tekst);
        this.aantal = aantal;
        this.LeverancierId=LeverancierId;
      //  if (reactieOp == null) throw new Exception("FOUT");
       // this.reactieOp = reactieOp;
    }

    public Bestelling(String status, Partij partij, String tekst) throws Exception {
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

	public int getLeverancierId() {
		return LeverancierId;
	}

	public void setLeverancierId(int leverancierId) {
		LeverancierId = leverancierId;
	}

	
}
