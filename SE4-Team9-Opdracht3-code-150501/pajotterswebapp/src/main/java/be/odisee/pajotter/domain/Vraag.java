package be.odisee.pajotter.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@DiscriminatorValue("Vraag")
public class Vraag extends Bericht implements Serializable{
	public Vraag(){}
	
	//@Column
	//@NotEmpty(message="Vul een aantal in AUB")
	//private int aantal;
	
    public Vraag(int id, String status, Partij partij, String tekst) throws Exception {
        super(id, status, partij, tekst);
        //this.aantal = aantal;
      //  if (reactieOp == null) throw new Exception("FOUT");
       // this.reactieOp = reactieOp;
    }
    
    public Vraag(String status, Partij partij, String tekst) throws Exception {
        super(status, partij, tekst);
        //this.aantal = aantal;
      //  if (reactieOp == null) throw new Exception("FOUT");
       // this.reactieOp = reactieOp;
    }

  
    public Bericht getReactieOp(){
        return reactieOp;
    }

    public void setReactieOp(Bericht newVal){
        reactieOp = newVal;
    }
    

	/*public int getAantal() {
		return aantal;
	}

	public void setAantal(int aantal) {
		this.aantal = aantal;
	}*/

	
}
