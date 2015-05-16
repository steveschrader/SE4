package be.odisee.pajotter.domain;
import java.io.Serializable;

import javax.persistence.*;


import be.odisee.pajotter.domain.*;

@Entity
@DiscriminatorValue("Antwoord")
public class Antwoord extends Bericht implements Serializable{
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	public Antwoord(){}

    public Antwoord(int id, String status, Partij partij, Bericht reactieOp, String tekst) throws Exception {
        super(id, status, partij, tekst);
        if (reactieOp == null) throw new Exception("FOUT");
        this.reactieOp = reactieOp;
    }

    public Antwoord(String status, Partij partij, Bericht reactieOp, String tekst) throws Exception {
        super(status, partij, tekst);
        if (reactieOp == null) throw new Exception("FOUT");
        this.reactieOp = reactieOp;
    }

    public Bericht getReactieOp(){
        return reactieOp;
    }

    public void setReactieOp(Bericht newVal){
        reactieOp = newVal;
    }

	
}
