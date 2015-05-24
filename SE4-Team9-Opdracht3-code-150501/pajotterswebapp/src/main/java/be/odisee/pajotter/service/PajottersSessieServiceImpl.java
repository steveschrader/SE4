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
	
	private AanbiedingDao aanbiedingDao;
	
	private BestellingDao bestellingDao;
	
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
    
    @Autowired 
    public void setAanbiedingDao(AanbiedingDao aanbiedingDao)
    {
        this.aanbiedingDao = aanbiedingDao;
    }
    
    @Autowired 
    public void setBestellingDao(BestellingDao bestellingDao)
    {
        this.bestellingDao = bestellingDao;
    }
    
    //PARTIJEN
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public Partij voegPartijToe(String voornaam, String familienaam, String emailadres, String paswoord) {
		return partijDao.savePartij("actief", voornaam, familienaam, emailadres, paswoord);	
	}
    
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public Partij voegPartijToe(String voornaam, String familienaam, String emailadres, String paswoord, String rol) {
		return partijDao.savePartij("actief", voornaam, familienaam, emailadres, paswoord, rol);	
	}
    
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public Partij voegPartijToe(Partij partij) {
		return partijDao.savePartij(partij);
	}

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public Partij zoekPartijMetId(int id) {
		 return partijDao.getPartijById(id);
	}

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public void verwijderPartij(int partijid) {
    	//Eerst alle rollen zoeken waar deze partij in zit en dan de partij verwijderen
    	Rol rol = zoekRolMetId(partijid);
    	System.out.println("de rol met username wordt verwijderd: " + rol.getUsernaam());
    	rolDao.deleteRol(rol.getId());
    	System.out.println("Partij met id wordt verwijderd: " + partijid);
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

    //Productie
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
	public List<Productie> geefAlleProductie(int id) {
		return productieDao.getAllProductie(id);
	}

	@Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public void updateProductie(Productie productie) {
		
		productieDao.updateProductie(productie);
	}

	@Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public void verwijderProductie(int productieId) {
		
		productieDao.deleteProductie(productieId);
		
	}

    //Aanbieding
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public Aanbieding VoegAanbiedingToe(String status, Partij partij, String tekst, int aantal) {
		Aanbieding deaanbieding = null;
		try {
			deaanbieding = new Aanbieding(status,partij, tekst, aantal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aanbiedingDao.saveAanbieding(deaanbieding);
		return deaanbieding;
	}

	public Aanbieding zoekAanbiedingMetId(int aanbiedingId) {
		Aanbieding deaanbieding = aanbiedingDao.getAanbiedingById(aanbiedingId);
		return deaanbieding;
	}

	@Override
	public List<Aanbieding> geefAlleAanbiedingen(int id) {
		return aanbiedingDao.getAllAanbieding(id);
	}

	@Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public void updateAanbieding(Aanbieding aanbieding) {
		
		aanbiedingDao.updateAanbieding(aanbieding);
	}

	@Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public void verwijderAanbieding(int aanbiedingId) {
		
		aanbiedingDao.deleteAanbieding(aanbiedingId);
		
	}
	
    //Bestelling aan leverancier
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public Bestelling VoegBestellingToe(String status, Partij partij, String tekst, int aantal, int leverancierId) {
		Bestelling debestelling = null;
		try {
			debestelling = new Bestelling(status,partij, tekst, aantal, leverancierId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bestellingDao.saveBestelling(debestelling);
		return debestelling;
	}

	public Bestelling zoekBestellingMetId(int Bestelling) {
		Bestelling debestelling = bestellingDao.getBestellingById(Bestelling);
		return debestelling;
	}

	@Override
	public List<Bestelling> geefAlleBestellingen(int id, String Columnname) {
		return bestellingDao.getAllBestelling(id, Columnname);
	}

	@Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public void updateBestelling(Bestelling bestelling) {
		
		bestellingDao.updateBestelling(bestelling);
	}

	@Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public void verwijderBestelling(int bestellingId) {
		
		bestellingDao.deleteBestelling(bestellingId);
		
	}

	
}