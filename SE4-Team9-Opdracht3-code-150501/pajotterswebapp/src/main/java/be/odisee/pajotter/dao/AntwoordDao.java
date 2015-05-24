package be.odisee.pajotter.dao;

import be.odisee.pajotter.domain.*;
import java.util.List;

public interface AntwoordDao {

    public Antwoord saveAntwoord(Antwoord aanbieding);
    
   // public Antwoord saveAntwoord(Antwoord aanbieding, int partijid);

    public Antwoord getAntwoordById(int aanbiedingId);

    public List<Antwoord> getAllAntwoord(int id);

    public void updateAntwoord(Antwoord aanbieding);
    
    public void deleteAntwoord(int aanbiedingId);

}