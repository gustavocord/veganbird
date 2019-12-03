package juego;

import java.awt.Color;
import entorno.Entorno;


public class PisoTecho {
	
	private double ancho, alto;
	private double PisoTecho_x, PisoTecho_y;

	
	PisoTecho(double eje_x, double eje_y)
	{
		this.PisoTecho_x = eje_x;
		this.PisoTecho_y = eje_y;
		this.ancho       = 900;
		this.alto        = 20;
	}
	
	public void dibujarPisoTecho(Entorno entorno) 
	{
		entorno.dibujarRectangulo(this.PisoTecho_x, this.PisoTecho_y, this.ancho, this.alto, 0, Color.orange);
	}

//GETTERS-----------------------------------------------------------------------------------------------		
	public double get_X() {return this.PisoTecho_x;}
	
	public double get_y() {return this.PisoTecho_y;}
	
	public double get_ancho() {return this.ancho;}
	
	public double get_alto() {return this.alto;}
	
//-------------------------------------------------------------------------------------------------------	
}
