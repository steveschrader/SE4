package be.odisee.pajotter.dao;

import be.odisee.pajotter.domain.*;
import java.util.List;

public interface BestellingDao {

    public Bestelling saveBestelling(Bestelling bestelling);
    
   // public Bestelling saveBestelling(Bestelling bestelling, int partijid);

    public Bestelling getBestellingById(int bestellingId);

    public List<Bestelling> getAllBestelling(int id, String columnname);

    public void updateBestelling(Bestelling bestelling);
    
    public void deleteBestelling(int bestellingId);

}