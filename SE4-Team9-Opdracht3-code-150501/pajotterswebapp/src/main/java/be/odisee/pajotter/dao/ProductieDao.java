package be.odisee.pajotter.dao;

import be.odisee.pajotter.domain.*;
import java.util.List;

public interface ProductieDao {

    public Productie saveProductie(Productie productie);

    public Productie getProductieById(int productieId);

    public List<Productie> getAllProductie();

    public void updateProductie(Productie productie);
    
    public void deleteProductie(int productieId);

   // public void updateBijdrageRangId(Bijdrage bijdrage, int rangId);
}