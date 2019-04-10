package Utilidades;

import Api.ColaTDA;
import Api.PilaTDA;
import Implementaciones.Estatico.Cola;
import Implementaciones.Estatico.Pila;

public class Metodos {
	

	// <------INICIO METODOS DE PILA----->//

	// 2a)
	public void pasarPila(PilaTDA a, PilaTDA aux) {
		while (!a.PilaVacia()) {
			aux.Apilar(a.Tope());
			a.Desapilar();
		}
	}

	// 2b)
	public void copiarPila(PilaTDA A, PilaTDA C) {
		PilaTDA aux = new Pila();
		aux.InicializarPila();
		pasarPila(A, aux);
		while (!aux.PilaVacia()) {
			C.Apilar(aux.Tope());
			A.Apilar(aux.Tope());
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
	
	
	// <---METODOS extras PARA INVERTIR PILA---> //
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

	// <---FIN METODOS extras PARA INVERTIR PILA---> //
	
	
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
	public void invertirCola(ColaTDA A, ColaTDA C) {
		ColaTDA aux = new Cola();
		aux.InicializarCola();
		pasarCola(A, aux);
		while (!aux.ColaVacia()) {
			C.Acolar(aux.Primero());
			A.Acolar(aux.Primero());
			aux.Desacolar();
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

	public void colaCapicua(ColaTDA origen) {
		PilaTDA aux = new Pila();
		aux.InicializarPila();
		PilaTDA aux2 = new Pila();
		aux2.InicializarPila();
		pasarColaPila(origen,aux);
		pasarColaPila(origen,aux2);
		pasarPilaCola(aux2,origen);
		System.out.println(origen.Primero());
		System.out.println(aux.Tope());
		while(!origen.ColaVacia() && !aux.PilaVacia()) {
			if (origen.Primero() == aux.Tope()) {
				origen.Desacolar();
				aux.Desapilar();
			}
			System.out.println(origen.Primero());
			System.out.println(aux.Tope());
		}
	}
	
	// <------FIN METODOS DE COLA----->//
}
