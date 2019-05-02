package Utilidades;

import Api.ABBTDA;
import Api.ColaPrioridadTDA;
import Api.ColaTDA;
import Api.ConjuntoTDA;
import Api.PilaTDA;
import Implementaciones.Estatico.Cola;
import Implementaciones.Estatico.Pila;

public class Metodos {

	/**
	 * TRABAJO PRACTICO NRO 1
	 */

	// <---METODOS extras PARA COLAS Y PILAS---> //
	public void pasarPilaCola(PilaTDA O, ColaTDA D) {
		while (!O.PilaVacia()) {
			D.Acolar(O.Tope());
			O.Desapilar();
		}
	}

	public void pasarColaPila(ColaTDA O, PilaTDA D) {
		while (!O.ColaVacia()) {
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

	// <---FIN METODOS extras PARA COLAS Y PILAS---> //

	/////////////////////////////////////////
	// METODOS PARA IMPLEMENTACIONES ESTATICOS
	/////////////////////////////////////////

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
		int sumaFinal = sumarElementosPila(A);
		return sumaFinal / cant;
	}

	// <------FIN METODOS DE PILA----->//

	// <------INICIO METODOS DE COLA----->//

	// 4a)
	public void pasarCola(ColaTDA A, ColaTDA B) {
		while (!A.ColaVacia()) {
			B.Acolar(A.Primero());
			A.Desacolar();
		}
	}

	// 4b)
	public void invertirColaAux(ColaTDA A) {
		PilaTDA aux = new Pila();
		aux.InicializarPila();
		pasarColaPila(A, aux);
		pasarPilaCola(aux, A);
	}

	// 4c)
	public void invertirCola(ColaTDA A) {
		int e = 0;
		if (!A.ColaVacia()) {
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
		pasarColaPila(origen2, auxOrigen2);
		if (auxOrigen.Tope() == auxOrigen2.Tope())
			return true;
		else
			return false;
	}

	// 4e) Determinar si una Cola es capicúa o no. Para ser capicúa debe cumplir
	// que el primer elemento es igual al último,
	// el segundo igual al penúltimo, etc.
	public boolean colaCapicua(ColaTDA origen) {
		ColaTDA aux = new Cola();
		aux.InicializarCola();
		int cant = 0;
		int mitad = 0;
		PilaTDA p = new Pila();
		p.InicializarPila();

		while (!origen.ColaVacia()) {
			aux.Acolar(origen.Primero());
			cant++;
			origen.Desacolar();
		}

		// devuelve la mitad del total de cant de elementos de la cola
		mitad = cant / 2;

		while (!aux.ColaVacia() && mitad > 0) {
			p.Apilar(aux.Primero());
			aux.Desacolar();
			mitad--;
		}

		while (!p.PilaVacia() && !aux.ColaVacia()) {
			if (p.Tope() != aux.Primero()) {
				return false;
			}
			p.Desapilar();
			aux.Desacolar();
		}
		return (p.PilaVacia() && aux.ColaVacia());
	}

	// 4f
	public boolean colaInversa(ColaTDA cola1, ColaTDA cola2, PilaTDA aux) {
		pasarColaPila(cola1, aux);
		while (!aux.PilaVacia() && cola2.ColaVacia()) {
			if (aux.Tope() != cola2.Primero()) {
				return false;
			}
			aux.Desapilar();
			cola2.Desacolar();
		}
		return (aux.PilaVacia() && cola2.ColaVacia());
	}

	// <------FIN METODOS DE COLA----->//

	// <------INICIO METODOS COLA PRIORIDAD------>

	// 6a
	public ColaPrioridadTDA combinarColaPrioridad(ColaPrioridadTDA cola1, ColaPrioridadTDA cola2,
			ColaPrioridadTDA resultado) {
		while (!cola1.colaVacia()) {
			resultado.acolarPrioridad(cola1.primero(), cola1.prioridad());
			cola1.desacolar();
		}
		while (!cola2.colaVacia()) {
			resultado.acolarPrioridad(cola2.primero(), cola2.prioridad());
			cola2.desacolar();
		}
		return resultado;
	}

	// 6b
	public boolean ColaPrioridadIdentica(ColaPrioridadTDA cola1, ColaPrioridadTDA cola2) {

		while (!cola1.colaVacia() && !cola2.colaVacia()) {
			if (cola1.primero() != cola2.primero() || cola1.prioridad() != cola2.prioridad())
				return false;
			cola1.desacolar();
			cola2.desacolar();
		}
		return (cola1.colaVacia() && cola2.colaVacia()); // return true
	}
	// <------FIN METODOS COLA PRIORIDAD------>

	/**
	 * TRABAJO PRACTICO NRO 2
	 */

	/////////////////////////////////////////
	// METODOS PARA IMPLEMENTACIONES DINAMICOS
	/////////////////////////////////////////

	// <------INICIO METODOS CONJUNTO DINAMICO------>

	public void interseccionConjuntoDinamico(ConjuntoTDA A, ConjuntoTDA B, ConjuntoTDA C) {
		int aux;
		while (!A.ConjuntoVacio()) {
			aux = A.Elegir();
			A.Sacar(aux);
			if (B.Pertenece(aux)) {
				C.Agregar(aux);
			}
		}
	}

	public void unionConjuntoDinamico(ConjuntoTDA A, ConjuntoTDA B, ConjuntoTDA C) {
		int aux;
		while (!A.ConjuntoVacio()) {
			aux = A.Elegir();
			A.Sacar(aux);
			C.Agregar(aux);
		}
		while (!B.ConjuntoVacio()) {
			aux = B.Elegir();
			B.Sacar(aux);
			C.Agregar(aux);
		}
	}

	public void diferenciaConjuntoDinamico(ConjuntoTDA A, ConjuntoTDA B) {
		int aux;
		while (!B.ConjuntoVacio()) {
			aux = B.Elegir();
			B.Sacar(aux);
			if (A.Pertenece(aux))
				A.Sacar(aux);
		}
	}
	// <------FIN METODOS CONJUNTO DINAMICO------>

	/**
	 * TRABAJO PRACTICO NRO 3
	 */

	// <------INICIO METODOS PILA------>

	public boolean pilaCapicua(PilaTDA pila) {
		Pila aux = new Pila();
		aux.InicializarPila();
		int cant = 0;
		int mitad = 0;
		ColaTDA C = new Cola();
		C.InicializarCola();

		while (!pila.PilaVacia()) {
			aux.Apilar(pila.Tope());
			cant++;
			pila.Desapilar();
		}

		// devuelve la mitad del total de cant de elementos de la cola
		mitad = cant / 2;

		while (!aux.PilaVacia() && mitad > 0) {
			C.Acolar(aux.Tope());
			aux.Desapilar();
			mitad--;
		}

		while (!C.ColaVacia() && !aux.PilaVacia()) {
			if (C.Primero() != aux.Tope()) {
				return false;
			}
			C.Desacolar();
			aux.Desapilar();
		}
		return (C.ColaVacia() && aux.PilaVacia());
	}

	// <------FIN METODOS PILA------>

	/**
	 * TRABAJO PRACTICO NRO 4
	 */

	// <------INICIO METODOS ARBOLES------>

	// 3a
	public boolean determinarExistencia(ABBTDA a, int valorBuscado) {
		if (a.arbolVacio())
			return false;
		else if (a.raiz() == valorBuscado)
			return true;
		else {
			if (valorBuscado > a.raiz()) // hijo derecho
				return determinarExistencia(a.hijoDer(), valorBuscado);
			else // hijo izquierdo
				return determinarExistencia(a.hijoIzq(), valorBuscado);
		}
	}

	// 3l i
	public void mostrarOrden(ABBTDA a) {
		// mostramos hijo izquiedo despues la raiz y despues el hijo derecho
		if (!a.arbolVacio()) {
			mostrarOrden(a.hijoIzq());
			System.out.println(a.raiz());
			mostrarOrden(a.hijoDer());
		}
	}

	// 3l ii
	public void mostrarPre(ABBTDA a) {
		// mostramos raiz, hijo izquierdo y despues hijo derecho
		if (!a.arbolVacio()) {
			System.out.println(a.raiz());
			mostrarPre(a.hijoIzq());
			mostrarPre(a.hijoDer());
		}
	}

	// 3l iii
	public void mostrarPost(ABBTDA a) {
		// mostramos el hijo izquierdo, hijo derecho y despues la raiz.
		if (!a.arbolVacio()) {
			mostrarPost(a.hijoIzq());
			mostrarPost(a.hijoDer());
			System.out.println(a.raiz());
		}
	}

	// <------FIN METODOS ARBOLES------>

}
