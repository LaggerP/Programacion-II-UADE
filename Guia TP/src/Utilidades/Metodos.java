package Utilidades;

import Api.ColaTDA;
import Api.PilaTDA;
import Implementaciones.Cola;
import Implementaciones.Pila;

public class Metodos {
	
	int cantCola = 0;

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
	public void invertirPila(PilaTDA A) {
		PilaTDA aux = new Pila();
		PilaTDA aux2 = new Pila();
		aux.InicializarPila();
		aux2.InicializarPila();
		pasarPila(A, aux);
		pasarPila(aux, aux2);
		pasarPila(aux2, A);
	}

	// 2d)
	public int contarElementosPila(PilaTDA A) {
		PilaTDA aux = new Pila();
		int cant = 0;

		while (!A.PilaVacia()) {
			cant++;
			aux.Apilar(A.Tope());
			A.Desapilar();
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
		int valor = 0, sumador = 0;

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
		int total = sumarElementosPila(A);
		return total / cant;
	}

	// <------FIN METODOS DE PILA----->//

	// <------INICIO METODOS DE COLA----->//

	// 4a
	public void pasarCola(ColaTDA A, ColaTDA B) {
		while (!A.ColaVacia()) {
			B.Acolar(A.Primero());
			A.Desacolar();
		}
	}

	// 4b
	public void invertirColaAux(ColaTDA A, ColaTDA C) {
		ColaTDA aux = new Cola();
		aux.InicializarCola();
		pasarCola(A, aux);
		
		while (!aux.ColaVacia()) {
			C.Acolar(aux.Primero());
			A.Acolar(aux.Primero());
			aux.Desacolar();
			cantCola++;
		}
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

	// 4d)
	/*
	public void colaCoincidencia(ColaTDA A, ColaTDA aux) {
		int primerElemento = A.Primero();
		while (!A.ColaVacia()) {
			aux.Acolar(A.Primero());
			A.Desacolar();
		}
	}*/

	// 4d)
	public boolean colaCapicua(ColaTDA A) {
		ColaTDA aux = new Cola();
		aux.InicializarCola();
		invertirColaAux(A,aux);
		while (!A.ColaVacia() && !aux.ColaVacia()) {
			for (int i = 0; i<=cantCola; i++) {
				if (A.Primero() == aux.Primero()) {
					A.Desacolar();
					aux.Desacolar();
				}
			}
			return true;
		}
		return false;
	}
	
	// <------FIN METODOS DE COLA----->//
}
