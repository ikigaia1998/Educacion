package beans;


public class MatriculaDTO {

	private int idMatricula;
	private int idApoderado; 
	private int idAlumno;
	private int idCurso;
	private double pago;
	private String nombreApo;
	private String nombreAlu;
	private String descripCurso;
	public int getIdMatricula() {
		return idMatricula;
	}
	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}
	public int getIdApoderado() {
		return idApoderado;
	}
	public void setIdApoderado(int idApoderado) {
		this.idApoderado = idApoderado;
	}
	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public double getPago() {
		return pago;
	}
	public void setPago(double pago) {
		this.pago = pago;
	}
	public String getNombreApo() {
		return nombreApo;
	}
	public void setNombreApo(String nombreApo) {
		this.nombreApo = nombreApo;
	}
	public String getNombreAlu() {
		return nombreAlu;
	}
	public void setNombreAlu(String nombreAlu) {
		this.nombreAlu = nombreAlu;
	}
	public String getDescripCurso() {
		return descripCurso;
	}
	public void setDescripCurso(String descripCurso) {
		this.descripCurso = descripCurso;
	}
	
	
	
}
