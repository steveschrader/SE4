package be.odisee.pajotter.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import be.odisee.pajotter.domain.Partij;
import be.odisee.pajotter.domain.Aanbieding;
import be.odisee.pajotter.utilities.RolNotFoundException;

@Repository("aanbiedingDao")
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class AanbiedingHibernateDao extends HibernateDao implements AanbiedingDao {

	@Override
	public Aanbieding saveAanbieding(Aanbieding aanbieding) {
		sessionSaveObject(aanbieding);
		return aanbieding;
	}

	/*@Override
	public Aanbieding saveAanbieding(Aanbieding aanbieding, int partijid) {
		sessionSaveObject(aanbieding);
		return aanbieding;
	}*/

	@Override
	public Aanbieding getAanbiedingById(int aanbiedingId) {
		return (Aanbieding) sessionGetObjectById("Aanbieding", aanbiedingId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aanbieding> getAllAanbieding(int id) {
		//return (List<Aanbieding>) sessionGetAllObjects("Aanbieding");
		return (List<Aanbieding>) sessionGetAllObjectsBySpecificId("Aanbieding", "partij_id", id);
	}

	@Override
	public void updateAanbieding(Aanbieding aanbieding) {
		sessionUpdateObject(aanbieding);
		
	}

	@Override
	public void deleteAanbieding(int aanbiedingId) {
		Aanbieding prodObj = getAanbiedingById(aanbiedingId);
		sessionDeleteObject(prodObj);
	}
}