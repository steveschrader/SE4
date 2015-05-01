package be.odisee.pajotter.dao;

import be.odisee.pajotter.domain.*;
import java.util.List;

public interface TelerDao {

    public Teler saveTeler(int id, String status, String voornaam, String familienaam, String emailadres, String paswoord);

    public Teler saveTeler(String string, String voornaam, String familienaam, String emailadres, String paswoord);
    
    public Teler saveTeler(String string, String voornaam, String familienaam, String emailadres, String paswoord, String adres, String telefoon);

    public Teler getTelerById(int telerId);

    public List<Teler> getAllTelers();

    public void updateTeler(Teler teler);
    
    public void deleteTeler(int telerId);

}
