package be.odisee.pajotter.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import be.odisee.pajotter.domain.Teler;

@Repository("telerDao")
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class TelerHibernateDao extends HibernateDao implements TelerDao {

    public Teler saveTeler(int id, String status, String voornaam, String familienaam, String emailadres, String paswoord) {
        Teler teler = new Teler(id, status, voornaam, familienaam, emailadres, paswoord);
        sessionSaveObject(teler);
        return teler;
    }

    public Teler saveTeler(String status, String voornaam, String familienaam, String emailadres, String paswoord) {
        Teler teler = new Teler(status, voornaam, familienaam, emailadres, paswoord);
        sessionSaveObject(teler);
        return teler;
    }
    
    public Teler saveTeler(String status, String voornaam, String familienaam, String emailadres, String paswoord, String adres, String telefoon) {
        Teler teler = new Teler(status, voornaam, familienaam, emailadres, paswoord, adres, telefoon);
        sessionSaveObject(teler);
        return teler;
    }

    public Teler getTelerById(int telerId) {
        return (Teler) sessionGetObjectById("Teler", telerId);
    }

    @SuppressWarnings("unchecked")
	public List<Teler> getAllTelers() {
        return (List<Teler>) sessionGetAllObjects("Teler");
    }

    public void updateTeler(Teler teler) {
        sessionUpdateObject(teler);
    }
    
    public void deleteTeler(int telerID) {
    	Teler telerObj = getTelerById(telerID);
    	sessionDeleteObject(telerObj);
    }
}
