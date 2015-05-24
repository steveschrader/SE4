package be.odisee.pajotter.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Index;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import be.odisee.pajotter.domain.*;
import be.odisee.pajotter.utilities.RolNotFoundException;

@Entity
@Table(name = "partijen")

public class Partij implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String status;

    @Column
    @Index(name = "IPartij_naam", columnNames = "familienaam, voornaam")
    @NotEmpty(message = "Vul voornaam in aub")
    private String voornaam;

    @Column
    @NotEmpty(message = "Vul achternaam in aub")
    private String familienaam;

    @Column
    @Index(name = "IPartij_email", columnNames = "emailadres")
    @Pattern(regexp = ".+@.+\\..+", message = "Email is niet correct")
    private String emailadres;

    @Column
    @Length(min = 8, max = 80, message = "Wachtwoord moet tussen 8 en 80 karakters lang zijn")
    private String paswoord;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "partij")
    private Set<Rol> m_Rollen = new HashSet<Rol>();
    
    public Partij() {
    	this.status = "Actief";
    }

    public Partij(String status, String voornaam, String familienaam, String emailadres, String paswoord) {
        this.status = status;
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.emailadres = emailadres;
        this.paswoord = paswoord;
    }

    public Partij(int id, String status, String voornaam, String familienaam, String emailadres, String paswoord) {
        this.id = id;
        this.status = status;
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.emailadres = emailadres;
        this.paswoord = paswoord;
    }
    
    public int getId() {
        return id;
    }

    public String getEmailadres() {
        return emailadres;
    }

    public String getPaswoord() {
        return paswoord;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public Set<Rol> getRollen(){
        return m_Rollen;
    }

    public void setEmailadres(String emailadres) {
        this.emailadres = emailadres;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setM_Rollen(Set<Rol> m_Rollen) {
        this.m_Rollen = m_Rollen;
    }

    public void setPaswoord(String paswoord) {
        this.paswoord = paswoord;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getStatus() {
    	return this.status;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }
    
    public String getTypes() {
    	String types = new String();
    	Rol[] rollen = m_Rollen.toArray(new Rol[m_Rollen.size()]);
    	
    	for (int i = 0; i < rollen.length; i++)
    	{
    		types += rollen[i].getType() + ", ";
    	}
    	int vermindering = 2;
    	if (types.length() <= 1) vermindering = 0;
    	return types.substring(0, types.length() - vermindering);
    }
    
    public Rol voegRolToe(String type, String status, String usernaam) throws RolNotFoundException{
        Rol newRol = null;
        if (type.toLowerCase().equals("administrator")) newRol = new Administrator(status, usernaam, this);
        if (type.toLowerCase().equals("teler")) newRol = new Teler(status, usernaam, this);
        if (type.toLowerCase().equals("pajotter")) newRol = new Pajotter(status, usernaam, this);
        if (type.toLowerCase().equals("leverancier")) newRol = new Leverancier(status, usernaam, this);
        if (type.toLowerCase().equals("industrie")) newRol = new Industrie(status, usernaam, this);
        if (type.toLowerCase().equals("koper")) newRol = new Koper(status, usernaam, this);
        if (newRol==null) throw new RolNotFoundException("Type '" + type + "' is geen bekende Rol.");
        m_Rollen.add(newRol);
        return newRol;
    }
}
