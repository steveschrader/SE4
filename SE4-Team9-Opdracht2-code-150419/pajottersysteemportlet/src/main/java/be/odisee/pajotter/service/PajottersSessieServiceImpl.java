package be.odisee.pajotter.service;

import be.odisee.pajotter.dao.*;
import be.odisee.pajotter.domain.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

@Service("brainstormSessieService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class PajottersSessieServiceImpl implements PajottersSessieService {

    private TelerDao telerDao;

    public PajottersSessieServiceImpl(){}

    @Autowired
    public void setTelerDao(TelerDao telerDao)
    {
        this.telerDao = telerDao;
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public Teler voegTelerToe(String voornaam, String familienaam, String emailadres, String paswoord)
    {
        return telerDao.saveTeler("actief", voornaam, familienaam, emailadres, paswoord);
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public Teler voegTelerToe(String voornaam, String familienaam, String emailadres, String paswoord, String adres, String telefoon)
    {
        return telerDao.saveTeler("actief", voornaam, familienaam, emailadres, paswoord, adres, telefoon);
    }
    
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public Teler zoekTelerMetId(int id)
    {
        return telerDao.getTelerById(id);
    }
    
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public void verwijderTeler(int teler){
        telerDao.deleteTeler(teler);
    }
    
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public void updateTeler(Teler teler)
    {
        telerDao.updateTeler(teler);
    }

    public List<Teler> geefAlleTelers()
    {
        return telerDao.getAllTelers();
    }

}