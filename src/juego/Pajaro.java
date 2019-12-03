package juego;

//import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;

public class Pajaro {
	Entorno entorno;
	double pajaro_x, pajaro_y;
	double ancho, alto;
	boolean enProceso;
	private Grafica grafica;
	private Image pajaro;
	private Image oscuro;
	
	
	Pajaro(double eje_x, double eje_y){
		this.pajaro_x  = eje_x;
		this.pajaro_y  = eje_y;
		this.ancho     = 40;
		this.alto      = 40;
		this.enProceso = false;
		this.grafica = new Grafica();
		this.pajaro  = grafica.getPajaro();
		this.oscuro  = grafica.getOscuro();
		
						
	}
	
	public void dibujarPajaro(Entorno entorno, boolean ponerOscuro) 
	{
		//debe preguntar si set escuro == false o true
		if(!ponerOscuro)
			entorno.dibujarImagen(pajaro, pajaro_x, pajaro_y, 0);
		else
		{
			entorno.dibujarImagen(pajaro, pajaro_x, pajaro_y, 0);
			entorno.dibujarImagen(oscuro, pajaro_x, pajaro_y, 0);
		}
		
		
	}

//SETTERS & GETTERS--------------------------------------------------------------------------------------	
	
	public double get_x() {return this.pajaro_x;}
	
	public double get_y() {return this.pajaro_y;}
	
	public void set_x(double x) {this.pajaro_x = x;}
	
	public void set_y(double y) {this.pajaro_y = y;}
	
	public double get_ancho() {return this.ancho;}
	
	public double get_alto() {return this.alto;}
	
	public boolean enProceso() {return this.enProceso;}
	
	public void setEnProceso(boolean proceso) {this.enProceso = proceso;}

	
//-------------------------------------------------------------------------------------------------------	

//MOVIMIENTO PAJARO----------------------------------------------------------------------------------------

	public void saltar() {this.pajaro_y -= 4;}
	
	public void caer() {this.pajaro_y += 4;}
	
//-------------------------------------------------------------------------------------------------------
	
	public boolean terminoSaltar(double limite, double pos_actual) 
	{
		
		if(pos_actual < limite) 
		{
			this.enProceso = false;
			return true;
		}
		else 
			return false;	
	}
	
	
	
	public boolean toca( double x, double y, double ancho, double alto ) 
	{
		double distanciaX= Math.abs( x  -  this.pajaro_x);	//Da la distancia en X entre algun objeto y el pajaro
		
		double distanciaY= Math.abs( y  - this.pajaro_y );	//Da la distancia en Y entre algun objeto y el pajaro
		
		if(distanciaX <= ancho/2 + this.ancho /2 && distanciaY <= alto/2 + this.alto/2)
			
			return true;
		
		else
	
			return false;
	}
	
	
}