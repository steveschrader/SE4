package be.odisee.pajotter.service;


import be.odisee.pajotter.utilities.RolNotFoundException;
import be.odisee.pajotter.domain.*;

import java.util.List;

public interface PajottersSessieService {

    //Partijen
    public Partij voegPartijToe(String voornaam, String familienaam, String emailadres, String paswoord, String rol);
    
    public Partij voegPartijToe(String voornaam, String familienaam, String emailadres, String paswoord);
    
    public Partij zoekPartijMetId(int id);
    
    public void verwijderPartij(int partijid);
    
    public void updatePartij(Partij partijid);

    public List<Partij> geefAllePartijen();
    
    public Partij zoekPartijMetEmailadres(String username);
    
    	//Toevoegen van rollen aan partijen
    
    public List<Rol> geefAlleRollen(int id);
    
    public Rol voegRolToe(String type, int partijId, String usernaam) throws RolNotFoundException;

    public Rol zoekRolMetId(int id);

    public Rol zoekRolMetUserid(String userid);
    
    public void verwijderRol(int id);
    
    //Productie aanbieden
    public Productie VoegProductieToe(String status, Partij partij, String tekst, int aantal);

    public Productie zoekProductieMetId(int productieId);

    public List<Productie> geefAlleProductie(int id);

    public void updateProductie(Productie productie);
    
    public void verwijderProductie(int productieID);
    
  //Aanbieding aanbieden
    public Aanbieding VoegAanbiedingToe(String status, Partij partij, String tekst, int aantal);

    public Aanbieding zoekAanbiedingMetId(int aanbiedingId);

    public List<Aanbieding> geefAlleAanbiedingen(int id);

    public void updateAanbieding(Aanbieding aanbieding);
    
    public void verwijderAanbieding(int aanbiedingID);
    
  //Bestelling aan leverancier
    public Bestelling VoegBestellingToe(String status, Partij partij, String tekst, int aantal, int LeverancierId);

    public Bestelling zoekBestellingMetId(int bestellingId);

    public List<Bestelling> geefAlleBestellingen(int id, String Columnname);

    public void updateBestelling(Bestelling bestelling);
    
    public void verwijderBestelling(int bestellingID);
}