package juego;

//import java.awt.Color;
import java.awt.Image;
import entorno.Entorno;
import java.util.Random;

public class Hamburguesa {
	
	private boolean tipo;
	private double ancho, alto;
	private double hambu_x, hambu_y;
	private boolean cruzo;
	private Random random;
	private int indice;
	private int aleatorio;
	private Grafica grafica;
	private Image carne, vegetal;
	
	Hamburguesa(double eje_x, double eje_y, int tipoDeHamburguesa)
	{
		this.ancho   = 52;
		this.alto    = 34;
		this.hambu_x = eje_x;
		this.hambu_y = eje_y;
		
		if(tipoDeHamburguesa == 0)
		   this.tipo = false;
		else
		   this.tipo = true;
		
		this.cruzo     = false;
		this.random    = new Random();
		this.indice    = 0;
		this.aleatorio = 0;
		this.grafica = new Grafica();
		this.carne = grafica.getCarne();
		this.vegetal = grafica.getVegetal();
	}
	
	public void dibujarHamburguesa(Entorno entorno) 
	{
		if (this.tipo) //true --> vegana
			//entorno.dibujarRectangulo(hambu_x, hambu_y, ancho, alto, 0, Color.CYAN);
			entorno.dibujarImagen(vegetal, hambu_x, hambu_y, 0);
			
		else
			//entorno.dibujarRectangulo(hambu_x, hambu_y, ancho, alto, 0, Color.ORANGE);
			entorno.dibujarImagen(carne, hambu_x, hambu_y, 0);
	}
	
//SETTERS & GETTERS---------------------------------------------------------------------------	
	
	public boolean getCruzo() {return this.cruzo;}
	
	public void setCruzo(boolean estado) {this.cruzo = estado;}
	
	public double get_y() {return this.hambu_y;}
	
	public double get_x() {return this.hambu_x;}
	
	public void set_x(double x) {this.hambu_x = x;}
	
	public void set_y(double y) {this.hambu_y = y;}
	
	public double get_ancho() {return this.ancho;}
	
	public double get_alto() {return this.alto;}
	
	public boolean getTipo() {return this.tipo;}
	
	public void setTipo(boolean tipoDeHamburguesa) {this.tipo = tipoDeHamburguesa;}
	
//--------------------------------------------------------------------------------------------
	
	public void moverHamburguesa(int puntos) 
	{
		if(this.hambu_x <= 0 - this.ancho) //limite izquierdo de la pantalla
		{
			this.cruzo   = true;
			this.hambu_x = 800; //limite derecho de la pantalla
		}
		else if(puntos == 1)
			this.hambu_x -= 2;
		else if(puntos >= 2)
			this.hambu_x -= 3;
	} 
	
	//COLISION--------------------------------------------------------------------------------	
		public boolean toca( double x, double y, double ancho, double alto ) 
		{
			double distanciaX= Math.abs( x  -  this.hambu_x);	//Da la distancia en X entre algun objeto y la hamburguesa
			
			double distanciaY= Math.abs( y  - this.hambu_y );	//Da la distancia en Y entre algun objeto y la hamburguesa
			
			if(distanciaX <= ancho/2 + this.ancho /2 && distanciaY <= alto/2 + this.alto/2)
				
				return true;
			
			else
		
				return false;
		}
		
	//------------------------------------------------------------------------------------------
		
		public void aleatorio(double tuboX, double tuboY) 
		{
			this.aleatorio = random.nextInt(11);
			if(aleatorio < 7) //del 1 al 6 vegano, del 7 al 10 carnívoro
				this.tipo = true;
			else
				this.tipo = false;
			
			indice = random.nextInt(11); //numero al azar de 0 a 2
			
			if(indice >= 7) 
			{
				hambu_y = -1000; //fuera de la pantalla 
				hambu_x = tuboX; //sigue en paralelo para detectar el cruce en x
			}
			else
			{
				hambu_y = tuboY - ((double)random.nextInt(150)+220); //rango de espacio entre tubos
				hambu_x = tuboX; //la hamburguesa va en paralelo con el tubo
			}
	
		}
}
