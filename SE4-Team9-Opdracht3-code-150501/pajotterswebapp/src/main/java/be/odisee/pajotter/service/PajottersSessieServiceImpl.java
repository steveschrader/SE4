package be.odisee.pajotter.service;

import be.odisee.pajotter.domain.*;
import be.odisee.pajotter.dao.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

@Service("pajottersSessieService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class PajottersSessieServiceImpl implements PajottersSessieService {

	//Telers MOET NOG AANGEPAST WORDEN!!!
   /* private TelerDao telerDao;

    public PajottersSessieServiceImpl(){}

    @Autowired
    public void setTelerDao(TelerDao telerDao)
    {
        this.telerDao = telerDao;
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public Teler voegTelerToe(String username, Partij partij, String adres, String telefoon)
    {
    	//String status, String usernaam, Partij partij, String adres, String telefoon
    	
        return telerDao.saveTeler("actief", username, partij, adres, telefoon);
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
    }*/

    //PARTIJEN !!!
	@Override
	public Partij voegPartijToe(String voornaam, String familienaam,
			String emailadres, String paswoord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Partij zoekPartijMetId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void verwijderPartij(int partijid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePartij(Partij partijid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Partij> geefAllePartijen() {
		// TODO Auto-generated method stub
		return null;
	}

	

}