package be.odisee.pajotter.domain;
import java.util.List;

import javax.persistence.*;


@Entity
@DiscriminatorValue("Administrator")
public class Administrator extends Rol {
	//Dit word niet gepersisteerd, dit is een rol en er wordt niet overbij gehouden in de DD.
	public Administrator(){}

    public Administrator(String status, String usernaam, Partij partij){
        super(status,usernaam,partij);
    }

    public Administrator(int id, String status, String usernaam, Partij partij){
        super(id,status,usernaam,partij);
    }
	
	@Override
	public String getType() {
		return "Administrator";
	}

}
