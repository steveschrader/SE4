package be.odisee.pajotter.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import be.odisee.pajotter.domain.Partij;
import be.odisee.pajotter.domain.Bestelling;
import be.odisee.pajotter.utilities.RolNotFoundException;

@Repository("bestellingDao")
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class BestellingHibernateDao extends HibernateDao implements BestellingDao {

	@Override
	public Bestelling saveBestelling(Bestelling bestelling) {
		sessionSaveObject(bestelling);
		return bestelling;
	}

	/*@Override
	public Bestelling saveBestelling(Bestelling bestelling, int partijid) {
		sessionSaveObject(bestelling);
		return bestelling;
	}*/

	@Override
	public Bestelling getBestellingById(int bestellingId) {
		return (Bestelling) sessionGetObjectById("Bestelling", bestellingId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bestelling> getAllBestelling(int id, String columnname) {
		return (List<Bestelling>) sessionGetAllObjectsBySpecificId("Bestelling", columnname, id);
		//return (List<Bestelling>) sessionGetAllObjects("Bestelling");
	}

	@Override
	public void updateBestelling(Bestelling bestelling) {
		sessionUpdateObject(bestelling);
		
	}

	@Override
	public void deleteBestelling(int bestellingId) {
		Bestelling prodObj = getBestellingById(bestellingId);
		sessionDeleteObject(prodObj);
	}
}