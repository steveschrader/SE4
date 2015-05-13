package be.odisee.pajotter.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import be.odisee.pajotter.domain.Partij;
import be.odisee.pajotter.domain.Rol;
import be.odisee.pajotter.domain.Teler;
import be.odisee.pajotter.utilities.RolNotFoundException;

@Repository("rolDao")
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class RolHibernateDao extends HibernateDao implements RolDao {

    
    @SuppressWarnings("unchecked")
	public List<Rol> getAllRollen(int partijId) {
		return (List<Rol>) sessionGetAllObjectsById("Rol", partijId);
	}
    
    public Rol saveRol(Rol rol) {
        sessionSaveObject(rol);
        return rol;
    }

    public Rol getRolById(int id) {
        return (Rol) sessionGetObjectByIdROL("Rol", id);
    }

    public Rol getRolByUserid(String userid) {

        String qstr = "from Rol where usernaam = :userid";
        String parameter = "userid";
        String value=userid;

        return (Rol) sessionGetObjectBy1StringParameterNamedQuery(qstr,parameter,userid);
    }


	public void deleteRol(int id) {
		Rol rol = getRolById(id);
		sessionDeleteObject(rol);		
	}

	
		
	
}
