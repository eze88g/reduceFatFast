package ar.com.reduceFatFast.exception;

public class ParametrosInvalidos extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2491239709576399862L;
	
	private String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public ParametrosInvalidos(String mensaje) {
		super(mensaje);
	}
	
}
