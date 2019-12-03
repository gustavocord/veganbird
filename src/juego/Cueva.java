package juego;

import java.awt.Image;
import entorno.Entorno;

public class Cueva {
	
	private double cueva_x1, cueva_y, cueva_x2;
	private Grafica grafica;
	private Image cueva, entrada;
	
	Cueva(double eje_x, double eje_y)
	{
		this.cueva_x1 = eje_x;
		this.cueva_y  = eje_y;
		this.cueva_x2 = eje_x + 800;
		this.grafica = new Grafica();
		this.cueva   = grafica.getCueva();
		this.entrada = grafica.getEntrada();
	}
	
	public void dibujar(Entorno entorno, int tipoImagen) 
	{
		if(tipoImagen == 1) {
			entorno.dibujarImagen(cueva, cueva_x1, cueva_y, 0);
			entorno.dibujarImagen(cueva, cueva_x2, cueva_y, 0);
		}
		if(tipoImagen == 2)
			entorno.dibujarImagen(entrada, cueva_x1, cueva_y, 0);
	}
	
	public void moverCueva() 
	{
		if(this.cueva_x1 <= -400 ) 
		{
			this.cueva_x1 = 400;
			this.cueva_x2 = 1200;
		}
		else 
		{
			this.cueva_x1 -= 3;
			this.cueva_x2 -= 3;
		}
	}

	public void moverEntrada() 
	{
		this.cueva_x1 -= 3;
	}
	
	public double get_x() {return this.cueva_x1;}
}
