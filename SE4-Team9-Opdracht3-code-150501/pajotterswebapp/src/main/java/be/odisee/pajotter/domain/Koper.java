package be.odisee.pajotter.domain;
import java.util.List;

import javax.persistence.*;


@Entity
@DiscriminatorValue("Koper")
public class Koper extends Rol {

	public Koper(){}

    public Koper(String status, String usernaam, Partij partij){
        super(status,usernaam,partij);
    }

    public Koper(int id, String status, String usernaam, Partij partij){
        super(id,status,usernaam,partij);
    }
	@Override
	public String getType() {
		return "Koper";
	}

}
