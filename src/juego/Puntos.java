package juego;
import java.awt.Color;

import entorno.Entorno;

public class Puntos {
	
	private int puntos;
	private int nivel;
	private int record;
	
	Puntos()
	{
		this.puntos = 0;
		this.nivel  = 1;
		this.record = 0;
		
	}
	
	public void dibujarPuntos(Entorno entorno) 
	{
		entorno.cambiarFont("Consolas", 50, Color.WHITE);
		entorno.escribirTexto(" " + this.puntos, 50, 550);
	}
	
	public void dibujarResultados(Entorno entorno, int puntos, int record) 
	{
		entorno.cambiarFont("Consolas", 20, Color.WHITE);
		entorno.escribirTexto("Tu puntaje " + puntos, 500, 300);
		entorno.escribirTexto("Mejor marca " + record, 500, 340);
	}
	

	
	public void calcularPuntaje(boolean tipo) 
	{
		if(tipo)
			this.puntos = this.puntos + 5;
		else
			this.puntos = this.puntos - 5;
	}
	
//GETTERS & SETTERS-----------------------------------------------------------
	
	public int getPuntos() {return this.puntos;}
	
	public void setPuntos(int puntos) {this.puntos = this.puntos + puntos;}
	
	public int getNivel() {return this.nivel;}
	
	public void setNivel(int nivel) {this.nivel = nivel;}
	
	public int getRecord() {return this.record;}
	
	public void setRecord(int marca) 
	{
		this.record = marca;
		}
	
//----------------------------------------------------------------------------
}
