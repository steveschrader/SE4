package be.odisee.pajotter.service;

import be.odisee.pajotter.domain.*;

import java.util.List;

public interface PajottersSessieService {

    public Teler voegTelerToe(String voornaam, String familienaam, String emailadres, String paswoord);
    public Teler voegTelerToe(String voornaam, String familienaam, String emailadres, String paswoord, String adres, String telefoon);

    public Teler zoekTelerMetId(int id);
    
    public void verwijderTeler(int telerid);
    
    public void updateTeler(Teler telerid);

    public List<Teler> geefAlleTelers();

}