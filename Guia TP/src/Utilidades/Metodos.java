package Utilidades;

import Api.ColaPrioridadTDA;
import Api.ColaTDA;
import Api.PilaTDA;
import Implementaciones.Estatico.Cola;
import Implementaciones.Estatico.Pila;
import Implementaciones.Estatico.ColaPrioridad;

public class Metodos {
	

	// <------INICIO METODOS DE PILA----->//

	// 2a)
	public void pasarPila(PilaTDA origen, PilaTDA destino) {
		while (!origen.PilaVacia()) {
			destino.Apilar(origen.Tope());
			origen.Desapilar();
		}
	}

	// 2b)
	public void copiarPila(PilaTDA origen, PilaTDA destino) {
		PilaTDA aux = new Pila();
		aux.InicializarPila();
		pasarPila(origen, aux);
		while (!aux.PilaVacia()) {
			destino.Apilar(aux.Tope());
			origen.Apilar(aux.Tope());
			aux.Desapilar();
		}
	}

	// 2c)
	public void invertirPila(PilaTDA A, PilaTDA B) {
		PilaTDA aux = new Pila();
		aux.InicializarPila();
		pasarPila(A, aux);
		pasarPila(aux, B);
		pasarPila(aux, A);
	}

	// 2d)
	public int contarElementosPila(PilaTDA A) {
		PilaTDA aux = new Pila();
		aux.InicializarPila();
		int cant = 0;
		while (!A.PilaVacia()) {
			aux.Apilar(A.Tope());
			A.Desapilar();
			cant++;
		}

		while (!aux.PilaVacia()) {
			A.Apilar(aux.Tope());
			aux.Desapilar();
		}

		return cant;
	}

	// 2e)
	public int sumarElementosPila(PilaTDA A) {
		PilaTDA aux = new Pila();
		aux.InicializarPila();
		int valor = 0, sumador=0;

		while (!A.PilaVacia()) {
			aux.Apilar(A.Tope());
			valor = A.Tope();
			A.Desapilar();
			sumador = sumador + valor;
		}

		while (!aux.PilaVacia()) {
			A.Apilar(aux.Tope());
			aux.Desapilar();
		}
		return sumador;
	}

	// 2f)
	public int calcularPromedioPila(PilaTDA A) {
		int cant = contarElementosPila(A);
		int sumaFinal = sumarElementosPila(A);
		return sumaFinal/cant;
	}

	// <------FIN METODOS DE PILA----->//

	// <------INICIO METODOS DE COLA----->//
	
	
	// <---METODOS extras PARA COLAS---> //
	public void pasarPilaCola(PilaTDA O, ColaTDA D) {
		while (!O.PilaVacia()){
			D.Acolar(O.Tope());
			O.Desapilar();
		}
	}
	
	public void pasarColaPila(ColaTDA O, PilaTDA D) {
		while (!O.ColaVacia()){
			D.Apilar(O.Primero());
			O.Desacolar();
		}
	}
	
	public void copiarCola(ColaTDA origen, ColaTDA destino) {
		ColaTDA aux = new Cola();
		aux.InicializarCola();
		pasarCola(origen, aux);
		while (!aux.ColaVacia()) {
			destino.Acolar(aux.Primero());
			origen.Acolar(aux.Primero());
			aux.Desacolar();
		}
	}

	// <---FIN METODOS extras PARA COLAS---> //
	
	
	// 4a
	public void pasarCola(ColaTDA A, ColaTDA B) {
		while (!A.ColaVacia()) {
			B.Acolar(A.Primero());
			A.Desacolar();
		}
	}

	// 4b
	public void invertirColaAux(ColaTDA A) {
		PilaTDA aux = new Pila();
		aux.InicializarPila();
		pasarColaPila(A, aux);
		pasarPilaCola(aux,A);
	}
	
	// 4c)
	public void invertirCola(ColaTDA A) {
		int e = 0;
		if(!A.ColaVacia()){
			e = A.Primero();
			A.Desacolar();
			invertirCola(A);
			A.Acolar(e);
		}
	}

	// 4d) Determinar si el final de la Cola C1 coincide o no con la Cola C2.
	public boolean colaCoincidencia(ColaTDA origen, ColaTDA origen2) {
		PilaTDA auxOrigen = new Pila();
		auxOrigen.InicializarPila();
		PilaTDA auxOrigen2 = new Pila();
		auxOrigen2.InicializarPila();
		pasarColaPila(origen, auxOrigen);
		pasarColaPila(origen2,auxOrigen2);
		if (auxOrigen.Tope() == auxOrigen2.Tope())
			return true;
		else 
			return false;
	}
	

	// 4e) Determinar si una Cola es capicúa o no. Para ser capicúa debe cumplir
	//	   que el primer elemento es igual al último, 
	//	   el segundo igual al penúltimo, etc.

	public boolean colaCapicua(ColaTDA origen) {
		ColaTDA aux = new Cola();
		aux.InicializarCola();
		int cant = 0;
		int mitad = 0;
		PilaTDA p = new Pila();
		p.InicializarPila();
		
		while(!origen.ColaVacia()){
			aux.Acolar(origen.Primero());
			cant++;
			origen.Desacolar();
		}
		
		//devuelve la mitad del total de cant de elementos de la cola
		mitad = cant / 2;
		
		while (!aux.ColaVacia() && mitad > 0) {
			p.Apilar(aux.Primero());
			aux.Desacolar();
			mitad--;
		}
		
		while (!p.PilaVacia() && !aux.ColaVacia()) {
			if (p.Tope()!=aux.Primero()) {
				return false;
			}
			p.Desapilar();
			aux.Desacolar();
		}
		return (p.PilaVacia() && aux.ColaVacia());
	}
	
	//4f
	
	public boolean colaInversa (ColaTDA origen) {
		return false;

	}
	
	// <------FIN METODOS DE COLA----->//
	
	// <------INICIO METODOS COLA PRIORIDAD------>
	
	//6a
	public ColaPrioridadTDA combinarColaPrioridad (ColaPrioridadTDA cola1, ColaPrioridadTDA cola2) {
		ColaPrioridadTDA ColaCombinada = new ColaPrioridad();
		ColaCombinada.inicializarCola();
		while(!cola1.colaVacia()){
			ColaCombinada.acolarPrioridad(cola1.primero(), cola1.prioridad());
			cola1.desacolar();
		}
		while(!cola2.colaVacia()){
			ColaCombinada.acolarPrioridad(cola2.primero(), cola2.prioridad());
			cola2.desacolar();
		}
		return ColaCombinada;
	}
	
	//6b
	public boolean ColaPrioridadIdentica (ColaPrioridadTDA cola1,ColaPrioridadTDA cola2) {

		while(!cola1.colaVacia() && !cola2.colaVacia()) {
			if (cola1.primero() != cola2.primero() || cola1.prioridad() != cola2.prioridad())
				return false;
			cola1.desacolar();
			cola2.desacolar();
		}
		return (cola1.colaVacia() && cola2.colaVacia()); //return true
	}
	// <------FIN METODOS COLA PRIORIDAD------>
}
