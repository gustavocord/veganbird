package juego;

import java.awt.Image;

import entorno.Entorno;

public class Fondo {
	
	private Grafica grafica;
	private Image nube1, nube2, nube3, nube4;
	private Image presiona;
	private Image bg;
	private double nube_x, nube_y;
	private double bg_x1, bg_y, bg_x2; 
	
	Fondo(double eje_x, double eje_y)
	{
		//this.ancho_bg   = 800;
		//this.alto_bg    = 600;
		this.bg_x1 = 400;
		this.bg_y = 300;
		this.bg_x2 = 1199;
		
		this.nube_x     = eje_x;
		this.nube_y     = eje_y;
		this.grafica    = new Grafica();
		this.nube1      = grafica.getNube1();
		this.nube2      = grafica.getNube2();
		this.nube3      = grafica.getNube3();
		this.nube4      = grafica.getNube4();
		this.presiona   = grafica.getPresiona();
		this.bg         = grafica.getFondo();
	}
	

	public void dibujar(Entorno entorno, int id_Nube) 
	{
		if(id_Nube == 1)
			entorno.dibujarImagen(nube1, nube_x, nube_y, 0);
		else if(id_Nube == 2)
			entorno.dibujarImagen(nube2, nube_x, nube_y, 0);
		else if(id_Nube == 3)
			entorno.dibujarImagen(nube3, nube_x, nube_y, 0);
		else if(id_Nube == 4)
			entorno.dibujarImagen(nube4, nube_x, nube_y, 0);	
	}
	public void dibujarPresiona(Entorno entorno) 
	{
		entorno.dibujarImagen(presiona, 350, 350, 0);
	}
	
	
	
	public void dibujarFondo(Entorno entorno) 
	{
		entorno.dibujarImagen(bg, bg_x2, bg_y, 0);
		entorno.dibujarImagen(bg, bg_x1, bg_y, 0);	
	}
	//GETTERS & SETTERS----------------------------------------------------
	public double get_x() {return this.nube_x;}
	public double get_y() {return this.nube_y;}
	public void set_x(double x) {this.nube_x = x;}
	public void set_y(double y) {this.nube_y = y;}
	//---------------------------------------------------------------------
	
	public void mover() 
	{
		if(this.nube_x <= -100)
			this.nube_x = 900;
		else
			this.nube_x -= 1.7;
	}
	public void moverLento() 
	{
		if(this.nube_x <= -100)
			this.nube_x = 900;
		else
			this.nube_x -= 0.9;
	}
	
	public void moverFondo() 
	{
		if(this.bg_x1 == -400) 
		{
			this.bg_x1 = 400;
			this.bg_x2 = 1199;
		}
		else 
		{
			this.bg_x1 -= 2;
			this.bg_x2 -= 2;
		}
	}
	
	
}
