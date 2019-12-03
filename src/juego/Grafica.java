package juego;

import java.awt.Image;

import entorno.Herramientas;


public class Grafica {
	
	private Image fondo;
	private Image arbol_Abajo;
	private Image arbol_Arriba;
	private Image pajaro;
	private Image carne;
	private Image vegetal;
	private Image disparo;
	private Image nube1, nube2, nube3, nube4;
	private Image presiona;
	private Image portada;
	private Image oscuro;
	private Image arbol1, arbol2, arbol3;
	private Image tronco;
	private Image arbolTrasero;
	private Image arbusto;
	private Image cueva, entrada, ladrillo;
	private Image gameover;
	
	Grafica()
	{
		this.fondo = Herramientas.cargarImagen("Fondo.jpg");
		this.arbol_Abajo  = Herramientas.cargarImagen("arbolAbajo.png");
		this.arbol_Arriba = Herramientas.cargarImagen("arbolArriba.png");
		this.pajaro  = Herramientas.cargarImagen("pajaro2.gif");
		this.carne   = Herramientas.cargarImagen("carne.png");
		this.vegetal = Herramientas.cargarImagen("vegetal.png");
		this.disparo = Herramientas.cargarImagen("disparo.png");
		this.nube1   = Herramientas.cargarImagen("nube1.png");
		this.nube2   = Herramientas.cargarImagen("nube2.png");
		this.nube3   = Herramientas.cargarImagen("nube3.png");
		this.nube4   = Herramientas.cargarImagen("nube4.png");
		this.presiona= Herramientas.cargarImagen("presiona.png");
		this.portada = Herramientas.cargarImagen("boceto-bienvenida.gif");
		this.oscuro  = Herramientas.cargarImagen("oscuro.png");
		this.arbol1  = Herramientas.cargarImagen("roble1.png");
		this.arbol2  = Herramientas.cargarImagen("roble2.png");
		this.arbol3  = Herramientas.cargarImagen("roble3.png");
		this.tronco  = Herramientas.cargarImagen("tronco pixel.png");
		this.arbolTrasero = Herramientas.cargarImagen("arbol trasero.png");
		this.arbusto = Herramientas.cargarImagen("arbustos.png");
		this.cueva   = Herramientas.cargarImagen("textura4.jpg");
		this.entrada = Herramientas.cargarImagen("entrada.png");
		this.ladrillo= Herramientas.cargarImagen("ladrillo.jpg");
		this.gameover= Herramientas.cargarImagen("game-over.gif");
	}
	
	public Image getFondo() {return this.fondo;}
	public Image getArbol_abajo() {return this.arbol_Abajo;}
	public Image getArbol_arriba() {return this.arbol_Arriba;}
	public Image getPajaro() {return this.pajaro;}
	public Image getCarne() {return this.carne;}
	public Image getVegetal() {return this.vegetal;}
	public Image getDisparo() {return this.disparo;}
	public Image getNube1() {return this.nube1;}
	public Image getNube2() {return this.nube2;}
	public Image getNube3() {return this.nube3;}
	public Image getNube4() {return this.nube4;}
	public Image getPresiona() {return this.presiona;}
	public Image getPortada() {return this.portada;}
	public Image getOscuro() {return this.oscuro;}
	public Image getArbol1() {return this.arbol1;}
	public Image getArbol2() {return this.arbol2;}
	public Image getArbol3() {return this.arbol3;}
	public Image getTronco() {return this.tronco;}
	public Image getArbolTrasero() {return this.arbolTrasero;}
	public Image getArbusto() {return this.arbusto;}
	public Image getCueva() {return this.cueva;}
	public Image getEntrada() {return this.entrada;}
	public Image getLadrillo() {return this.ladrillo;}
	public Image getGameover() {return this.gameover;}
}
