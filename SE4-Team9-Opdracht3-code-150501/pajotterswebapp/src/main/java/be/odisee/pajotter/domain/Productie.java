package be.odisee.pajotter.domain;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@DiscriminatorValue("Productie")
public class Productie extends Bericht implements Serializable{
	public Productie(){}

    public Productie(int id, String status, Partij partij, Bericht reactieOp, String tekst) throws Exception {
        super(id, status, partij, tekst);
      //  if (reactieOp == null) throw new Exception("FOUT");
       // this.reactieOp = reactieOp;
    }

    public Productie(String status, Partij partij, String tekst) throws Exception {
        super(status, partij, tekst);
        
    }

    public Bericht getReactieOp(){
        return reactieOp;
    }

    public void setReactieOp(Bericht newVal){
        reactieOp = newVal;
    }

	
}
