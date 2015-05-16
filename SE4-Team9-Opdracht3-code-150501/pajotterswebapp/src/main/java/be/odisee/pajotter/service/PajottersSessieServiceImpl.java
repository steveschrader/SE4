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
    @Autowired //!!! Dit is zeer belangrijk ofanders is er geen verbinding met de database.
    public void setRolDao(RolDao rolDao)
    {
        this.rolDao = rolDao;
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
	
	
    public Rol voegRolToe(String type, int partijId, String usernaam) throws RolNotFoundException {
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

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public void verwijderRol(int id) {
    	rolDao.deleteRol(id);
		
	}

    //PRODUCTIE
	@Override
	public Productie VoegProductieToe(Productie productie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Productie zoekProductieMetId(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Productie> geefAlleProductie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProductie(Productie productie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verwijderProductie(Productie productie) {
		// TODO Auto-generated method stub
		
	}

	
	
}