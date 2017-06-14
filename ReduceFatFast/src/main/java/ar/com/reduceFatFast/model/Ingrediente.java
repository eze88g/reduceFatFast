package ar.com.reduceFatFast.model;

public class Ingrediente {
	private String oid;
	String name ;
	int calorias;
	
	public Ingrediente(String name, int calorias) {
		super();
		this.name = name;
		this.calorias = calorias;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
}

