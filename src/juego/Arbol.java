package juego;

import java.awt.Image;
import entorno.Entorno;

public class Arbol {
	
	private double arbol_x, arbol_y;
	private Grafica grafica;
	private Image arbol1, arbol2, arbol3, arbolTrasero, arbusto;
	private int id; //el tipo de arbol
	
	Arbol(double eje_x, double eje_y, int id)
	{
		this.grafica = new Grafica();
		this.arbol_x = eje_x;
		this.arbol_y = eje_y;
		this.arbol1  = grafica.getArbol1();
		this.arbol2  = grafica.getArbol2();
		this.arbol3  = grafica.getArbol3();
		this.arbolTrasero = grafica.getArbolTrasero();
		this.arbusto = grafica.getArbusto();
		this.id = id;
	}
	
	public void dibujarArbol(Entorno entorno) 
	{
		if(this.id == 1)
			entorno.dibujarImagen(arbol1, this.arbol_x, this.arbol_y, 0);
		if(this.id == 2)
			entorno.dibujarImagen(arbol2, this.arbol_x, this.arbol_y, 0);
		if(this.id == 3)
			entorno.dibujarImagen(arbol3, this.arbol_x, this.arbol_y, 0);
		if(this.id == 4)
			entorno.dibujarImagen(arbolTrasero, this.arbol_x, this.arbol_y, 0);
		if(this.id == 5)
			entorno.dibujarImagen(arbusto, this.arbol_x, this.arbol_y, 0);
	}
	
	public void mover() 
	{
		if(this.arbol_x <= -300) 
		{
			this.arbol_x = 1100;
		}
		else 
			this.arbol_x -= 3;
	}
	
	public void moverLento() 
	{
		if(this.arbol_x <= -300) 
		{
			this.arbol_x = 1100;
		}
		else 
			this.arbol_x -= 2;
	}
}
