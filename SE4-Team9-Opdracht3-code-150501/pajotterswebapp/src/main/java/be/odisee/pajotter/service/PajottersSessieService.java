package be.odisee.pajotter.service;


import be.odisee.pajotter.utilities.RolNotFoundException;
import be.odisee.pajotter.domain.*;

import java.util.List;

public interface PajottersSessieService {
//Telers, MOET NOG AANGEPAST WORDEN
    //public Teler voegTelerToe(String voornaam, String familienaam, String emailadres, String paswoord);
	//public Teler voegTelerToe(String voornaam, String familienaam, String emailadres, String paswoord, String adres, String telefoon);

	//public Teler zoekTelerMetId(int id);
    
	//public void verwijderTeler(int telerid);
    
	//public void updateTeler(Teler telerid);

	//public List<Teler> geefAlleTelers();
    
    
    //partijen
    public Partij voegPartijToe(String voornaam, String familienaam, String emailadres, String paswoord, String rol);
    public Partij voegPartijToe(String voornaam, String familienaam, String emailadres, String paswoord);
   // public Teler voegTelerToe(String voornaam, String familienaam, String emailadres, String paswoord, String adres, String telefoon);

    public Partij zoekPartijMetId(int id);
    
    public void verwijderPartij(int partijid);
    
    public void updatePartij(Partij partijid);

    public List<Partij> geefAllePartijen();
    
    public List<Rol> geefAlleRollen(int id);
    
    public Rol voegRolToe(String type, int partijId, String usernaam) throws RolNotFoundException;

    public Rol zoekRolMetId(int id);

    public Rol zoekRolMetUserid(String userid);
    
    public void verwijderRol(int id);

}