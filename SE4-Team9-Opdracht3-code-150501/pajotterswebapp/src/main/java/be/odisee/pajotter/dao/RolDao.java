package be.odisee.pajotter.dao;


import be.odisee.pajotter.domain.*;

import java.util.List;

public interface RolDao {
	
	public List<Rol> getAllRollen(int partijId);
	
	//public Rol saveRol(String status, String usernaam, Partij partij, String rol);

	public Rol saveRol(Rol rol);

    public Rol getRolById(int id);

    public Rol getRolByUserid(String userid);
}
