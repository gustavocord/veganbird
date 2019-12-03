package juego;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;
import listas.ListaInt;
import java.util.Random;
import javax.sound.sampled.Clip;
import java.awt.Image;
import java.io.IOException;


public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	
	//variables de las clases-------------------------------------------------------
	private Pajaro pajaro;
	private PisoTecho piso;
	private PisoTecho techo;
	private Tubos tubo1, tubo2, tubo3, tubo4, tubo5, tubo6;
	private Hamburguesa hambu1, hambu2, hambu3;
	private int contador;
	private Puntos puntos;
	private Rayo rayo;
	private Grafica grafica;
	private Fondo nube1, nube2, nube3, nube4;
	private Arbol arbol1, arbol2, arbol3;
	private Arbol arbolTrasero1, arbolTrasero2, arbolTrasero3;
	private Arbol arbusto1, arbusto2;
	private Cueva cueva, entrada;
	//---------------------------------------------------------------------------------
	
	//variables de la clase juego------------------------------------------------------
	private boolean primerPresionTecla, estadoDelJuego;
	private double tubo_y1, tubo_y2, tubo_y3;
	private double destino_pajaro_y;
	private Random random_y;
	private Random random;
	private int tipo;
	private Image portada;
	private boolean comenzar;
	Clip inicio; //SONIDO DE INICIO
	Clip gameOver;//SONIDO CUANDO PIERDE
	private boolean disparando;
	private boolean oscuro, esLadrillo;
	private String Puntajes;
	private Image gameover;
	private boolean enterParaSalir;
	private int record;
	//---------------------------------------------------------------------------------
	
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno  = new Entorno(this, "Vegan Bird V0.01", 800, 600);
		this.pajaro   = new Pajaro(250,300);
		
		this.piso     = new PisoTecho(400, 610);	
		this.techo    = new PisoTecho(400, -10);	
		
		this.random_y = new Random();
		this.random   = new Random();
		
		this.tubo_y1  = (double) (random_y.nextInt(250) + 500); 
		this.tubo_y2  = (double) (random_y.nextInt(250) + 500);
		this.tubo_y3  = (double) (random_y.nextInt(250) + 500);
		
		
		this.tubo1 = new Tubos(1000, tubo_y1);
		this.tubo2 = new Tubos(1300, tubo_y2);
		this.tubo3 = new Tubos(1600, tubo_y3);
		this.tubo4 = new Tubos(1000, (tubo_y1 - 600) );
		this.tubo5 = new Tubos(1300, (tubo_y2 - 600) );
		this.tubo6 = new Tubos(1600, (tubo_y3 - 600) );
		
		this.tipo   = random.nextInt(10)+1;
		this.hambu1 = new Hamburguesa(tubo1.get_X(), tubo1.get_y() - ((double)random.nextInt(150)+220), tipo); 
		this.hambu2 = new Hamburguesa(tubo2.get_X(), tubo2.get_y() - ((double)random.nextInt(150)+220), tipo);
		this.hambu3 = new Hamburguesa(tubo3.get_X(), tubo3.get_y() - ((double)random.nextInt(150)+220), tipo);
		
		this.destino_pajaro_y = 600; 
		this.contador = 0;
		this.puntos   = new Puntos();
		this.rayo     = new Rayo();
		this.grafica  = new Grafica();

		
		this.nube1 = new Fondo(700, 150);
		this.nube2 = new Fondo(100, 100);
		this.nube3 = new Fondo(600, 190);
		this.nube4 = new Fondo(950, 130);
		this.arbol1= new Arbol(1150, 300, 1);
		this.arbol2= new Arbol(1600, 230, 2);
		this.arbol3= new Arbol(2050, 270, 3);
		this.arbolTrasero1 = new Arbol(1300, 250, 4);
		this.arbolTrasero2 = new Arbol(1750, 265, 4);
		this.arbolTrasero3 = new Arbol(2200, 250, 4);
		this.arbusto1 = new Arbol(1400, 50, 5);
		this.arbusto2 = new Arbol(2250, 50, 5);
		
		this.portada = grafica.getPortada();
		this.comenzar= false;
		inicio=Herramientas.cargarSonido("inicio.wav");
		gameOver =Herramientas.cargarSonido("game over.wav");
		
		this.disparando = false;
		this.cueva   = new Cueva(1250, 300);
		this.entrada = new Cueva(850, 300);
		this.oscuro  = false;
		this.esLadrillo = false;
		this.gameover = grafica.getGameover();
		this.enterParaSalir = false;
		
				// Inicializar lo que haga falta para el juego
				// ...
				
				// Inicia el juego!
				this.entorno.iniciar();
	}

	
	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		musica_y_manipulacion_de_archivo_txt();
	
		//consulta que tipo de enter presiono------------------------------
		consultar_tipo_de_enter();
		//-----------------------------------------------------------------
		
		if(!comenzar) 

			entorno.dibujarImagen(portada, 400, 300, 0);

		else //este else abarca el resto del tick
		{
			//Dibuja el fondo------------------------------------------------
			animacion_del_fondo();
			//----------------------------------------------------------------

			// cartel "Presiona arriba para volar"
			if(contador == 0 && !this.enterParaSalir)
				nube1.dibujarPresiona(entorno);
			
			//Obstaculos aleatorios---------------------------------------------------------------------
			obstaculos_aleatorios();
			//--------------------------------------------------------------------------------------
			//Hamburguesas aleatorias---------------------------------------------------------------
			hamburguesas_aleatorias();
			//--------------------------------------------------------------------------------------		
	
			if(entrada.get_x() <= 200) //cuando cruzas la entrada de la cueva se oscurece
			{
				oscuro = true;
				esLadrillo = true;
			}
			
			dibujar_objetos();
			
			//Espera a que presiones arriba para volar y actviar estadoDelJuego-------------------------
			tecla_arriba_para_saltar();
			//------------------------------------------------------------------------------------------

			//COLISION OBSTACULO CON PAJARO---------------------------------------------------------------------
			if(pajaroChocaObstaculo()) {

				this.estadoDelJuego = false;
				entorno.dibujarImagen(gameover, 570, 300, 0);
				this.enterParaSalir = true;
				puntos.dibujarResultados(entorno, puntos.getPuntos(), record);
				
			}
			//--------------------------------------------------------------------------------------------

			//COLISION HAMBURGUESA CON PAJARO-------------------------------------------------------------
			algoritmo_colisionHamburguesaConPajaro();
			//--------------------------------------------------------------------------------------------

			//Cuando se presione la tecla arriba----------------------------------------------------------
			algoritmo_de_salto();
			//--------------------------------------------------------------------------------------------	

			//Cuando se presiona espacio------------------------------------------------------------------
			algortimo_de_disparo();
			//--------------------------------------------------------------------------------------------

			//colision rayo con obstaculo-----------------------------------------------------------------
			if(rayoChocaObstaculo()) 
			{
				rayo.set_y(-100);
				this.disparando = false;
			}
			//--------------------------------------------------------------------------------------------

			//colision hamburguesa con rayo---------------------------------------------------------------
			colision_hamburguesa_rayo();
			//--------------------------------------------------------------------------------------------
			
		} //llave de !comenzar

	}
	
	//FIN DE TICK--------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------
	
	
	public boolean pajaroChocaObstaculo() 
	{
		if(this.tubo1.toca(pajaro.get_x(),pajaro.get_y(),pajaro.get_ancho() ,pajaro.get_alto())||
				this.tubo2.toca(pajaro.get_x(),pajaro.get_y(),pajaro.get_ancho() ,pajaro.get_alto())||
				this.tubo3.toca(pajaro.get_x(),pajaro.get_y(),pajaro.get_ancho() ,pajaro.get_alto())||
				this.tubo4.toca(pajaro.get_x(),pajaro.get_y(),pajaro.get_ancho() ,pajaro.get_alto())||
				this.tubo5.toca(pajaro.get_x(),pajaro.get_y(),pajaro.get_ancho() ,pajaro.get_alto())||
				this.tubo6.toca(pajaro.get_x(),pajaro.get_y(),pajaro.get_ancho() ,pajaro.get_alto())||
				//ACA EVALUA LA COLISION CON EL PISO DE ARRIBA Y ABAJO
				this.pajaro.toca(this.piso.get_X(),this.piso.get_y(),this.piso.get_ancho() , this.piso.get_alto())||
				this.pajaro.toca(techo.get_X(),techo.get_y(),techo.get_ancho() ,techo.get_alto())) 
		
			return true;
		else
			return false;	
	}
	
	public boolean rayoChocaObstaculo() 
	{
		if(this.tubo1.toca(rayo.get_x(), rayo.get_y(), rayo.get_ancho(), rayo.get_alto()) ||
				this.tubo2.toca(rayo.get_x(), rayo.get_y(), rayo.get_ancho(), rayo.get_alto()) ||
				this.tubo3.toca(rayo.get_x(), rayo.get_y(), rayo.get_ancho(), rayo.get_alto()) ||
				this.tubo4.toca(rayo.get_x(), rayo.get_y(), rayo.get_ancho(), rayo.get_alto()) ||
				this.tubo5.toca(rayo.get_x(), rayo.get_y(), rayo.get_ancho(), rayo.get_alto()) ||
				this.tubo6.toca(rayo.get_x(), rayo.get_y(), rayo.get_ancho(), rayo.get_alto())) 
			return true;
		else
			return false;			
	}
	
	
	public void dibujarTubos() 
	{
		tubo1.dibujarTubo(entorno,"abajo", esLadrillo);
		tubo2.dibujarTubo(entorno,"abajo", esLadrillo);
		tubo3.dibujarTubo(entorno,"abajo", esLadrillo);
		tubo4.dibujarTubo(entorno,"arriba", esLadrillo);
		tubo5.dibujarTubo(entorno,"arriba", esLadrillo);
		tubo6.dibujarTubo(entorno,"arriba", esLadrillo);
	}	
		
	public void dibujarHamburguesas() 
	{
		hambu1.dibujarHamburguesa(entorno);
		hambu2.dibujarHamburguesa(entorno);
		hambu3.dibujarHamburguesa(entorno);
	}
	
	public void moverTubos() 
	{
		tubo1.moverTubo(puntos.getNivel());
		tubo2.moverTubo(puntos.getNivel());
		tubo3.moverTubo(puntos.getNivel());
		tubo4.moverTubo(puntos.getNivel());
		tubo5.moverTubo(puntos.getNivel());
		tubo6.moverTubo(puntos.getNivel());
	}	
	public void moverHamburguesas() 
	{
		hambu1.moverHamburguesa(puntos.getNivel());
		hambu2.moverHamburguesa(puntos.getNivel());
		hambu3.moverHamburguesa(puntos.getNivel());
	}
	
	public void dibujarNubes() 
	{
		nube3.dibujar(entorno, 3);
		nube4.dibujar(entorno, 4);
		nube1.dibujar(entorno, 1);
		nube2.dibujar(entorno, 2);
		
		nube1.mover();
		nube2.mover();
		nube3.moverLento();
		nube4.moverLento();
	}
	
	public void dibujarArboles() 
	{
		arbolTrasero1.dibujarArbol(entorno);
		arbolTrasero2.dibujarArbol(entorno);
		arbolTrasero3.dibujarArbol(entorno);
		arbusto1.dibujarArbol(entorno);
		arbusto2.dibujarArbol(entorno);
		arbol3.dibujarArbol(entorno);
		arbol2.dibujarArbol(entorno);
		arbol1.dibujarArbol(entorno);
		if(estadoDelJuego) {
			arbol1.mover();
			arbol2.mover();
			arbol3.mover();
			arbolTrasero1.moverLento();
			arbolTrasero2.moverLento();
			arbolTrasero3.moverLento();
			arbusto1.mover();
			arbusto2.mover();
		}
	}
	
	public void algoritmo_colisionHamburguesaConPajaro() 
	{
		if(this.pajaro.toca(hambu1.get_x(), hambu1.get_y(), hambu1.get_ancho(), hambu1.get_alto())) 
		{
			hambu1.set_y(-1000);
			puntos.calcularPuntaje(hambu1.getTipo());
			if(hambu1.getTipo())
				Herramientas.play("comer.wav");
			else
				Herramientas.play("no.wav");
		}
		if(this.pajaro.toca(hambu2.get_x(), hambu2.get_y(), hambu2.get_ancho(), hambu2.get_alto())) 
		{
			hambu2.set_y(-1000);
			puntos.calcularPuntaje(hambu2.getTipo());
			if(hambu2.getTipo())
				Herramientas.play("comer.wav");
			else
				Herramientas.play("no.wav");
		}
		if(this.pajaro.toca(hambu3.get_x(), hambu3.get_y(), hambu3.get_ancho(), hambu3.get_alto())) 
		{
			hambu3.set_y(-1000);
			puntos.calcularPuntaje(hambu3.getTipo());
			if(hambu3.getTipo())
				Herramientas.play("comer.wav");
			else
				Herramientas.play("no.wav");
		}
	}
	
	public void hamburguesas_aleatorias() 
	{
		if(hambu1.getCruzo()) { //si cruzo el extremo izquierdo
			hambu1.setCruzo(false);				
			hambu1.aleatorio(tubo1.get_X(), tubo_y1);
		}
		if(hambu2.getCruzo()) {	
			hambu2.setCruzo(false);
			hambu2.aleatorio(tubo2.get_X(), tubo_y2);
		}		
		if(hambu3.getCruzo()) {
			hambu3.setCruzo(false);
			hambu3.aleatorio(tubo3.get_X(), tubo_y3);
		}
	}
	
	public void obstaculos_aleatorios() 
	{
		if(tubo1.getCruzo()) 
		{
			tubo1.setCruzo(false);
			this.tubo_y1 = (double) (random_y.nextInt(250) + 500);
			this.tubo1 = new Tubos(900, tubo_y1);
			this.tubo4 = new Tubos(900,  (tubo_y1 - 600) );	
		}

		if(tubo2.getCruzo()) 
		{
			tubo2.setCruzo(false);
			this.tubo_y2 = (double) (random_y.nextInt(250) + 500);
			this.tubo2 = new Tubos(900, tubo_y2);
			this.tubo5 = new Tubos(900,  (tubo_y2 - 600) );	
		}

		if(tubo3.getCruzo()) 
		{
			tubo3.setCruzo(false);
			this.tubo_y3 = (double) (random_y.nextInt(250) + 500);
			this.tubo3 = new Tubos(900, tubo_y3);
			this.tubo6 = new Tubos(900,  (tubo_y3 - 600) );	
		}
	}
	
	public void animacion_del_fondo() 
	{
		nube1.dibujarFondo(entorno);
		if(estadoDelJuego)
			nube1.moverFondo();

		dibujarNubes();

		if(puntos.getPuntos() >= 25 && puntos.getPuntos() < 50 && puntos.getNivel() != 3) 
			puntos.setNivel(2);
		if(puntos.getNivel() >= 2) //controlar ( ==2 )
			dibujarArboles();

		if(puntos.getPuntos() >= 50)
			puntos.setNivel(3);
		if(puntos.getNivel() == 3) {

			cueva.dibujar(entorno, 1);
			entrada.dibujar(entorno, 2);

			if(estadoDelJuego) {
				cueva.moverCueva();
				entrada.moverEntrada();
			}
		}
	}
	
	public void dibujar_objetos() 
	{
		dibujarTubos();

		dibujarHamburguesas();

		rayo.dibujarRayo(entorno);

		pajaro.dibujarPajaro(entorno, oscuro);

		puntos.dibujarPuntos(entorno);
	}
	
	public void algoritmo_de_salto() 
	{
		if(estadoDelJuego) //si es true comienzan a moverse los tubos y se cae el pajaro
		{ 
			moverTubos();
			moverHamburguesas();

			//ALGORITMO PARA QUE EL PAJARO SALTE------------------------------------------------------
			pajaro.terminoSaltar(destino_pajaro_y,pajaro.get_y());

			if(entorno.sePresiono(entorno.TECLA_ARRIBA)) 
			{
				this.destino_pajaro_y = pajaro.get_y() - 100; //100 es el alcance del salto
				pajaro.setEnProceso(true);
				pajaro.saltar();
			}
			else if(!pajaro.enProceso() )
				pajaro.caer();
			else 
				pajaro.saltar();
			//--------------------------------------------------------------------------------------
		}
	}
	
	public void algortimo_de_disparo() 
	{
		if(rayo.get_x() >= 800)
			this.disparando = false;

		if(entorno.sePresiono(entorno.TECLA_ESPACIO) && contador == 1 && estadoDelJuego && !disparando) 
		{
			rayo.setDisparo(true);
			this.disparando = true;
			Herramientas.play("laser.wav");
		}
		if(rayo.getDisparo() ) 
		{
			rayo.setDisparo(false);
			rayo.set_x(pajaro.get_x());
			rayo.set_y(pajaro.get_y()-13);
		}
		rayo.avanzar();
	}
	
	public void colision_hamburguesa_rayo() 
	{
		if(this.hambu1.toca(rayo.get_x(), rayo.get_y(), rayo.get_ancho(), rayo.get_alto())) 
		{
			if(!hambu1.getTipo()) 
			{
				rayo.set_y(-100);
				hambu1.setTipo(true);
				puntos.setPuntos(3);
				this.disparando = false;
			}
		} 

		if(this.hambu2.toca(rayo.get_x(), rayo.get_y(), rayo.get_ancho(), rayo.get_alto()) )
		{
			if(!hambu2.getTipo()) 
			{
				rayo.set_y(-100);
				hambu2.setTipo(true);
				puntos.setPuntos(3);
			}
		}

		if(this.hambu3.toca(rayo.get_x(), rayo.get_y(), rayo.get_ancho(), rayo.get_alto())) 
		{
			if(!hambu3.getTipo()) 
			{
				rayo.set_y(-100);
				hambu3.setTipo(true);
				puntos.setPuntos(3);
			}
		}
	}
	
	public void consultar_tipo_de_enter() 
	{
		if(entorno.sePresiono(entorno.TECLA_ENTER))	
			comenzar = true;
		
		if(entorno.sePresiono(entorno.TECLA_ENTER) && this.enterParaSalir)
			System.exit(0);
	}
	
	public void musica_y_manipulacion_de_archivo_txt() 
	{
		if (estadoDelJuego==true) {inicio.loop(Clip.LOOP_CONTINUOUSLY);} // si es true reproduce el sonido inicio
		else if(contador>=1 && estadoDelJuego==false)
		{
			inicio.stop();gameOver.start();
			Puntajes=String.valueOf(puntos.getPuntos());
			  ManejoDeArchivos.escribir(Puntajes);
	            contador =-1;//para que salga del contador y no entre en ninguna otra condicion
	            
	          try {
	            ManejoDeArchivos.guardarLista("puntaje.txt");
	            ListaInt puntos = ManejoDeArchivos.guardarLista("puntaje.txt");
	             record=ManejoDeArchivos.record(puntos);
	           
	            
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		} //si es false reproduce el gameOver
	}
	
	public void tecla_arriba_para_saltar() 
	{
		if(entorno.sePresiono(entorno.TECLA_ARRIBA) && !primerPresionTecla) 
		{
			if (contador < 1) {

				this.estadoDelJuego = true;
				this.contador  +=1;
			}
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}