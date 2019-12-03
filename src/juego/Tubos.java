package juego;

//import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;


public class Tubos {
	
	private double ancho, alto;
	private double tubo_x, tubo_y;
	private boolean cruzo;
	private Grafica grafica;
	private Image arbol_Abajo;
	private Image arbol_Arriba;
	private Image ladrillo;
	
	Tubos(double eje_x, double eje_y)
	{
		this.tubo_x = eje_x;
		this.tubo_y = eje_y;
		this.ancho  = 100;
		this.alto   = 400;
		this.cruzo  = false;
		
		this.grafica      = new Grafica();
		this.arbol_Abajo  = grafica.getArbol_abajo(); 
		this.arbol_Arriba = grafica.getArbol_arriba();
		this.ladrillo     = grafica.getLadrillo();
	}
	
	public void dibujarTubo(Entorno entorno, String orientacion, boolean esLadrillo) 
	{
		if(!esLadrillo) {
			if(orientacion.equals("arriba"))
				entorno.dibujarImagen(arbol_Arriba, tubo_x, tubo_y, 0);
			else 
				entorno.dibujarImagen(arbol_Abajo, tubo_x, tubo_y, 0);
		}
		else 
			entorno.dibujarImagen(ladrillo, tubo_x, tubo_y, 0);
	}

	
//GETTERS & SETTERS----------------------------------------------------------------------------------------	
	public double get_X() {return this.tubo_x;}
	
	public double get_y() {return this.tubo_y;}
	
	public double get_ancho() {return this.ancho;}
	
	public double get_alto() {return this.alto;}
	
	public boolean getCruzo() {return this.cruzo;}
	
	public void setCruzo(boolean estado) {this.cruzo = estado;}
//---------------------------------------------------------------------------------------------------------	

	public void moverTubo(int puntos) 
	{
		if(this.tubo_x <= 0 - this.ancho) //limite izquierdo de la pantalla
		{
			this.cruzo = true;
			this.tubo_x = 800; //limite derecho de la pantalla
		}
		else if(puntos == 1)
			this.tubo_x -= 2;
		else if(puntos >= 2)
			this.tubo_x -= 3;
	} 
//---------------------------------------------------------------------------------------------------------	
	public boolean toca( double x, double y, double ancho, double alto ) 
	{
		double distanciaX= Math.abs( x  -  this.tubo_x);	//Da la distancia en X entre algun objeto y el tubo
		
		double distanciaY= Math.abs( y  - this.tubo_y );	//Da la distancia en Y entre algun objeto y el tubo
		
		if(distanciaX <= ancho/2 + this.ancho /2 && distanciaY <= alto/2 + this.alto/2)
			
			return true;
		
		else
	
			return false;
	}
	
	
}
