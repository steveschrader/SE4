package be.odisee.pajotter.domain;
import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Leverancier")
public class Leverancier extends Rol {
	//Dit word niet gepersisteerd, dit is een rol en er wordt niet overbij gehouden in de DD.
		public Leverancier(){}

	    public Leverancier(String status, String usernaam, Partij partij){
	        super(status,usernaam,partij);
	    }

	    public Leverancier(int id, String status, String usernaam, Partij partij){
	        super(id,status,usernaam,partij);
	    }
		
	@Override
	public String getType() {
		return "Leverancier";
	}

}
