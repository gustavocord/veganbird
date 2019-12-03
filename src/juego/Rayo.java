package juego;

import java.awt.Image;

import entorno.Entorno;
public class Rayo {
	
	private double rayo_x, rayo_y;
	private int ancho, alto;
	private boolean disparo;
	private Grafica grafica;
	private Image rayo;
	
	Rayo()
	{
		this.rayo_x  = -100;
		this.rayo_y  = -100;
		this.ancho   = 60;
		this.alto    = 13;
		this.grafica = new Grafica();
		this.rayo    = grafica.getDisparo();
	}

	public void dibujarRayo(Entorno entorno) 
	{
		entorno.dibujarImagen(rayo, rayo_x, rayo_y, 0);
	}
	
	public void avanzar() 
	{
		this.rayo_x += 5;
	}
	
	//GETTERS & SETTERS-------------------------------------------------------------------------------
	
	public double get_x() {return this.rayo_x;}
	
	public double get_y() {return this.rayo_y;}
	
	public void set_x(double x) {this.rayo_x = x;}
	
	public void set_y(double y) {this.rayo_y = y;}
	
	public boolean getDisparo() {return this.disparo;}
	
	public void setDisparo(boolean d) {this.disparo = d;}
	
	public int get_alto() {return this.alto;}
	
	public int get_ancho() {return this.ancho;}
	
	//------------------------------------------------------------------------------------------------

}
