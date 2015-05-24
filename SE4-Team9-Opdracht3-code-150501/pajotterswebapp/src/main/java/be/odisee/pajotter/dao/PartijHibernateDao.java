package be.odisee.pajotter.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;


import be.odisee.pajotter.domain.Partij;
import be.odisee.pajotter.domain.Teler;
import be.odisee.pajotter.utilities.RolNotFoundException;

@Repository("partijDao")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PartijHibernateDao extends HibernateDao implements PartijDao {

    public Partij savePartij(String status, String voornaam, String familienaam, String emailadres, String paswoord, String rol) {
        Partij partij = new Partij(status, voornaam, familienaam, emailadres, paswoord);
        try {
			partij.voegRolToe(rol, status, emailadres);
		} catch (RolNotFoundException e) {
			e.printStackTrace();
		}
        sessionSaveObject(partij);
        return partij;
    }
    public Partij savePartij(String status, String voornaam, String familienaam, String emailadres, String paswoord) {
        Partij partij = new Partij(status, voornaam, familienaam, emailadres, paswoord);
        sessionSaveObject(partij);
        return partij;
    }

    public Partij savePartij(int id, String status, String voornaam, String familienaam, String emailadres, String paswoord) {
    	Partij partij = new Partij(id, status, voornaam, familienaam, emailadres, paswoord);
        sessionSaveObject(partij);
        return partij;
	}
    
    public Partij savePartij(Partij partij) {
    	Partij npartij = new Partij(partij.getStatus(), partij.getVoornaam(), partij.getFamilienaam(), partij.getEmailadres(), partij.getPaswoord());
    	sessionSaveObject(npartij);
    	return npartij;
    }
    
    public Partij getPartijById(int partijId) {
        return (Partij) sessionGetObjectById("Partij", partijId);
    }

    @SuppressWarnings("unchecked")
	public List<Partij> getAllPartijen() {
        return (List<Partij>) sessionGetAllObjects("Partij");
    }

    public void updatePartij(Partij partij) {
        sessionUpdateObject(partij);
    }
    
    public void deletePartij(int partijID) {
    	Partij partijObj = getPartijById(partijID);
    	sessionDeleteObject(partijObj);
    }
	@Override
	public Partij getPartijByEmailadres(String emailadres) {
		return (Partij) sessionGetObjectByStringParameterValue("Partij", "emailadres", emailadres);
	}
}