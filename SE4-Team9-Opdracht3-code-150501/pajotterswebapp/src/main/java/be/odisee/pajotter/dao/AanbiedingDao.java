package be.odisee.pajotter.dao;

import be.odisee.pajotter.domain.*;
import java.util.List;

public interface AanbiedingDao {

    public Aanbieding saveAanbieding(Aanbieding aanbieding);
    
   // public Aanbieding saveAanbieding(Aanbieding aanbieding, int partijid);

    public Aanbieding getAanbiedingById(int aanbiedingId);

    public List<Aanbieding> getAllAanbieding();

    public void updateAanbieding(Aanbieding aanbieding);
    
    public void deleteAanbieding(int aanbiedingId);

}