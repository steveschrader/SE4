package be.odisee.pajotter.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Index;

import be.odisee.pajotter.domain.*;

@Entity
@Table(name = "rollen")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Rol")
public abstract class Rol implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;
	
	@Column
	protected String status;
	
	@Column(unique = true)
	@Index(name = "IRol_usernaam", columnNames = "usernaam")
	protected String usernaam;
	
	@ManyToOne
	@JoinColumn(name = "partij_id")
	protected Partij partij;
	
	public Rol(){}
	
	public Rol(String status, String usernaam, Partij partij) {
	    this.status = status;
	    this.usernaam = usernaam;
	    this.partij = partij;
	}
	
	public Rol(int id, String status, String usernaam, Partij partij) {
	    this.id = id;
	    this.status = status;
	    this.usernaam = usernaam;
	    this.partij = partij;
	}
	
	public int getId() {
	    return id;
	}
	
	public String getUsernaam() {
	    return usernaam;
	}
	
	public abstract String getType();
	
	public Partij getPartij() {
	    return partij;
	}
	
	public void setPartij(Partij partij) {
	    this.partij = partij;
	}
}
