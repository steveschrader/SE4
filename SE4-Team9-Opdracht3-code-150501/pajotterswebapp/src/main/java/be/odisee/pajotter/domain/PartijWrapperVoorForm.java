package be.odisee.pajotter.domain;

public class PartijWrapperVoorForm {
	
	public Partij partij;
	public String rol;
	
	public PartijWrapperVoorForm() {}
	
	public PartijWrapperVoorForm(Partij partij, String rol) {
		this.partij = partij;
		this.rol = rol;
	}

	public Partij getPartij() {
		return partij;
	}

	public void setPartij(Partij partij) {
		this.partij = partij;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}