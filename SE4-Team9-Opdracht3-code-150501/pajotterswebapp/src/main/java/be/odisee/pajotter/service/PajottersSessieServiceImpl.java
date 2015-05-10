package be.odisee.pajotter.service;


import be.odisee.pajotter.utilities.RolNotFoundException;
import be.odisee.pajotter.domain.*;
import be.odisee.pajotter.dao.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

@Service("pajottersSessieService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class PajottersSessieServiceImpl implements PajottersSessieService {
	private PartijDao partijDao;
	private RolDao rolDao;
	
	public PajottersSessieServiceImpl(){}

    @Autowired
    public void setPartijDao(PartijDao partijDao)
    {
        this.partijDao = partijDao;
    }
    
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public Partij voegPartijToe(String voornaam, String familienaam,
			String emailadres, String paswoord) {
		return partijDao.savePartij("actief", voornaam, familienaam, emailadres, paswoord);	
	}
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public Partij voegPartijToe(String voornaam, String familienaam, String emailadres, String paswoord, String rol) {
		return partijDao.savePartij("actief", voornaam, familienaam, emailadres, paswoord, rol);	
	}


    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public Partij zoekPartijMetId(int id) {
		 return partijDao.getPartijById(id);
	}

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public void verwijderPartij(int partijid) {
		partijDao.deletePartij(partijid);
		
	}

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public void updatePartij(Partij partijid) {
		partijDao.updatePartij(partijid);
		
	}

    //@Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public List<Partij> geefAllePartijen() {
		return partijDao.getAllPartijen();
	}

	
	public List<Rol> geefAlleRollen(int id) {
		return rolDao.getAllRollen(id);
	}
	
	@Override
    public Rol voegRolToe(String type, int partijId, String usernaam) throws RolNotFoundException {
       // Sessie deSessie = zoekSessieMetId(sessieId);
        Partij dePartij = zoekPartijMetId(partijId);
        Rol deRol = dePartij.voegRolToe(type, "actief", usernaam);
        deRol = rolDao.saveRol(deRol);
        return deRol;
    }

    public Rol zoekRolMetId(int id) {
        return rolDao.getRolById(id);
    }

    public Rol zoekRolMetUserid(String userid) {
        return rolDao.getRolByUserid(userid);
    }

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
	
}