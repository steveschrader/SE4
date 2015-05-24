package be.odisee.pajotter.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import be.odisee.pajotter.domain.Partij;
import be.odisee.pajotter.domain.Vraag;
import be.odisee.pajotter.utilities.RolNotFoundException;

@Repository("vraagDao")
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class VraagHibernateDao extends HibernateDao implements VraagDao {

	@Override
	public Vraag saveVraag(Vraag vraag) {
		sessionSaveObject(vraag);
		return vraag;
	}

	/*@Override
	public Vraag saveVraag(Vraag vraag, int partijid) {
		sessionSaveObject(vraag);
		return vraag;
	}*/

	@Override
	public Vraag getVraagById(int vraagId) {
		return (Vraag) sessionGetObjectById("Vraag", vraagId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vraag> getAllVraag(int id) {
		//return (List<Vraag>) sessionGetAllObjects("Vraag");
		return (List<Vraag>) sessionGetAllObjectsBySpecificId("Vraag", "partij_id", id);
	}
	
	public List<Vraag> getAllVraag() {
		//return (List<Vraag>) sessionGetAllObjects("Vraag");
		return (List<Vraag>) sessionGetAllObjects("Vraag");
	}

	@Override
	public void updateVraag(Vraag vraag) {
		sessionUpdateObject(vraag);
		
	}

	@Override
	public void deleteVraag(int vraagId) {
		Vraag prodObj = getVraagById(vraagId);
		sessionDeleteObject(prodObj);
	}
}