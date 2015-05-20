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
	
	//Autowiren met de DAO zeer belangrijk ofanders worden er null objecten door gestuurd naar de databank!
	private PartijDao partijDao;
	
	private RolDao rolDao;
	
	private ProductieDao productieDao;
	
	public PajottersSessieServiceImpl(){}

    @Autowired
    public void setPartijDao(PartijDao partijDao)
    {
        this.partijDao = partijDao;
    }
    
    @Autowired 
    public void setRolDao(RolDao rolDao)
    {
        this.rolDao = rolDao;
    }
    
    @Autowired 
    public void setProductieDao(ProductieDao productieDao)
    {
        this.productieDao = productieDao;
    }
    
    //PARTIJEN
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
   
	public Partij zoekPartijMetEmailadres(String emailadres) {
		  return partijDao.getPartijByEmailadres(emailadres);
	}

    //PRODUCTIE
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public Productie VoegProductieToe(String status, Partij partij, String tekst, int aantal) {
		Productie deproductie = null;
		try {
			deproductie = new Productie(status,partij, tekst, aantal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		productieDao.saveProductie(deproductie);
		return deproductie;
	}

	public Productie zoekProductieMetId(int productieId) {
		Productie deproductie = productieDao.getProductieById(productieId);
		return deproductie;
	}

	@Override
	public List<Productie> geefAlleProductie() {
		return productieDao.getAllProductie();
	}

	@Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public void updateProductie(Productie productie) {
		
		productieDao.updateProductie(productie);
	}

	@Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public void verwijderProductie(int productieId) {
		
		productieDao.deleteProductie(productieId);
		
	}

	
}