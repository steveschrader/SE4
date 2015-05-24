package be.odisee.pajotter.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import be.odisee.pajotter.domain.Partij;
import be.odisee.pajotter.domain.Antwoord;
import be.odisee.pajotter.utilities.RolNotFoundException;

@Repository("antwoordDao")
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class AntwoordHibernateDao extends HibernateDao implements AntwoordDao {

	@Override
	public Antwoord saveAntwoord(Antwoord antwoord) {
		sessionSaveObject(antwoord);
		return antwoord;
	}

	/*@Override
	public Antwoord saveAntwoord(Antwoord antwoord, int partijid) {
		sessionSaveObject(antwoord);
		return antwoord;
	}*/

	@Override
	public Antwoord getAntwoordById(int antwoordId) {
		return (Antwoord) sessionGetObjectBySpecificId("Antwoord", "reactie_op_id", antwoordId);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Antwoord> getAllAntwoord(int id) {
		//return (List<Antwoord>) sessionGetAllObjects("Antwoord");
		return (List<Antwoord>) sessionGetAllObjectsBySpecificId("Antwoord", "partij_id", id);
	}

	@Override
	public void updateAntwoord(Antwoord antwoord) {
		sessionUpdateObject(antwoord);
		
	}

	@Override
	public void deleteAntwoord(int antwoordId) {
		Antwoord prodObj = getAntwoordById(antwoordId);
		sessionDeleteObject(prodObj);
	}
}