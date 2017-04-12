package co.edu.udea.iw.dto;

/**
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
 * 
 * La clase Ciudad corresponde al DTO Para la tabla ciudad
 */
public class Ciudad {

	private int codigo;
	private String nombre;
	private String codigoArea;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int i) {
		this.codigo = i; 
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}
	
	
	
}
