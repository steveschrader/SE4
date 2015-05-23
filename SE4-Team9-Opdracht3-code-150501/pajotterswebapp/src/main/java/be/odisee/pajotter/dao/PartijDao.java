package be.odisee.pajotter.dao;

import be.odisee.pajotter.domain.*;

import java.util.List;

public interface PartijDao {

    public Partij savePartij(int id, String status, String voornaam, String familienaam, String emailadres, String paswoord);

    public Partij savePartij(String status, String voornaam, String familienaam, String emailadres, String paswoord);

    public Partij savePartij(String status, String voornaam, String familienaam, String emailadres, String paswoord, String rol);

    public Partij getPartijById(int partijId);

    public List<Partij> getAllPartijen();

    public void updatePartij(Partij partij);
    
    public void deletePartij(int partijId);
    
    public Partij getPartijByEmailadres(String emailadres);
}