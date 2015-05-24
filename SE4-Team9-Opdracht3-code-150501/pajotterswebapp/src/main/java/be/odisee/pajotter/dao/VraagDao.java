package be.odisee.pajotter.dao;

import be.odisee.pajotter.domain.*;
import java.util.List;

public interface VraagDao {

    public Vraag saveVraag(Vraag aanbieding);
    
   // public Vraag saveVraag(Vraag aanbieding, int partijid);

    public Vraag getVraagById(int aanbiedingId);

    public List<Vraag> getAllVraag(int id);
    
    public List<Vraag> getAllVraag();

    public void updateVraag(Vraag aanbieding);
    
    public void deleteVraag(int aanbiedingId);

}