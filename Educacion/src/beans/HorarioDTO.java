package beans;

import java.sql.Date;


public class HorarioDTO {


	int IdHorario;
	String DiaSemana;
	Date HoraInicio;
	Date HoraFin;
	
	public int getIdHorario() {
		return IdHorario;
	}
	public void setIdHorario(int idHorario) {
		IdHorario = idHorario;
	}
	public String getDiaSemana() {
		return DiaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		DiaSemana = diaSemana;
	}
	public Date getHoraInicio() {
		return HoraInicio;
	}
	public void setHoraInicio(Date horaInicio) {
		HoraInicio = horaInicio;
	}
	public Date getHoraFin() {
		return HoraFin;
	}
	public void setHoraFin(Date horaFin) {
		HoraFin = horaFin;
	}

	
}
