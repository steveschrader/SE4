package be.odisee.pajotter.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import be.odisee.pajotter.domain.Partij;
import be.odisee.pajotter.domain.Productie;
import be.odisee.pajotter.utilities.RolNotFoundException;

@Repository("productieDao")
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class ProductieHibernateDao extends HibernateDao implements ProductieDao {

	@Override
	public Productie saveProductie(Productie productie) {
		sessionSaveObject(productie);
		return productie;
	}

	@Override
	public Productie getProductieById(int productieId) {
		return (Productie) sessionGetObjectById("Productie", productieId);
	}

	@Override
	public List<Productie> getAllProductie() {
		return (List<Productie>) sessionGetAllObjects("Productie");
	}

	@Override
	public void updateProductie(Productie productie) {
		sessionUpdateObject(productie);
		
	}

	@Override
	public void deleteProductie(int productieId) {
		Productie prodObj = getProductieById(productieId);
		sessionDeleteObject(prodObj);
	}
}