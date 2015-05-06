package be.odisee.pajotter.service;

import be.odisee.pajotter.domain.*;
import java.util.List;

public interface PajottersSessieService {
//Telers, MOET NOG AANGEPAST WORDEN
    public Teler voegTelerToe(String voornaam, String familienaam, String emailadres, String paswoord);
    public Teler voegTelerToe(String voornaam, String familienaam, String emailadres, String paswoord, String adres, String telefoon);

    public Teler zoekTelerMetId(int id);
    
    public void verwijderTeler(int telerid);
    
    public void updateTeler(Teler telerid);

    public List<Teler> geefAlleTelers();
    
    
    //partijen
    public Partij voegPartijToe(String voornaam, String familienaam, String emailadres, String paswoord);
   // public Teler voegTelerToe(String voornaam, String familienaam, String emailadres, String paswoord, String adres, String telefoon);

    public Partij zoekPartijMetId(int id);
    
    public void verwijderPartij(int partijid);
    
    public void updatePartij(Partij partijid);

    public List<Partij> geefAllePartijen();

}