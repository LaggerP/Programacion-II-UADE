package App;

import Api.ABBTDA;
import Api.ColaPrioridadTDA;
import Api.ColaTDA;
import Api.ConjuntoTDA;
import Api.PilaTDA;
import Implementaciones.Estatico.Pila;
import Implementaciones.Estatico.ColaPrioridad;
import Implementaciones.Dinamico.ABB;
import Implementaciones.Dinamico.Conjunto;
import Implementaciones.Estatico.Cola;
import Utilidades.Metodos;

public class AppNoObligatorio {

	public static void main(String args[]) {

		// TRABAJO PRACTICO 1

		// ---EJERCICIO PILAS---

		// ejercicio12a(); //CORREGIDO
		// ejercicio12b(); //CORREGIDO
		// ejercicio12c(); //CORREGIDO
		// ejercicio12d(); //CORREGIDO
		// ejercicio12e(); //CORREGIDO
		// ejercicio12f(); //CORREGIDO

		// ---FIN EJERCICIO PILAS---

		// ---EJERCICIO COLAS---

		// ejercicio34a(); //CORREGIDO
		// ejercicio34b(); //CORREGIDO
		// ejercicio34d(); //CORREGIDO
		// ejercicio34e(); //CORREGIDO
		// ejercicio34f(); //CORREGIDO

		// FIN EJERCICIO COLAS---

		// ---EJERCICIO COLA PRIORIDAD---

		// ejercicio56a(); //CORREGIDO
		// ejercicio56b(); //CORREGIDO

		// ---FIN EJERCICIO COLA PRIORIDAD---

		// TRABAJO PRACTICO 2

		// ---INICIO EJERCICIO CONJUNTO DINAMICO---

		// ejercicioTP2_6Dinamico_Interseccion(); //CORREGIDO
		// ejercicioTP2_6Dinamico_Union(); //CORREGIDO
		// ejercicioTP2_6Dinamico_Diferencia(); //CORREGIDO

		// ---FIN EJERCICIO CONJUNTO DINAMICO---

		// TRABAJO PRACTICO 3

		// ---INICIO EJERCICIO PILA---

		// ejercicioTP3_1a(); //CORREGIDO
		// ejercicioTP3_1b(); //CORREGIDO
		// ejercicioTP3_1c(); //CORREGIDO
		// ejercicioTP3_1d();

		// ---FIN EJERCICIO PILA---
		
		// ---INICIO EJERCICIO COLA---

		ejercicioTP3_2a();
		
		// ---FIN EJERCICIO COLA---

		// TRABAJO PRACTICO 4

		// ---INICIO EJERCICIO ABB---
		
		//ejercicioTP4_3a(); //CORREGIDO
		//ejercicioTP4_3l(); //CORREGIDO
		
		// ---FIN EJERCICIO ABB---
	}

	/**
	 * TRABAJO PRACTICO NRO 1
	 */

	// <---EJERCICIOS TDA PILA--->
	public static void ejercicio12a() {
		PilaTDA origen = new Pila();
		origen.InicializarPila();
		origen.Apilar(1);
		origen.Apilar(2);
		origen.Apilar(3);
		origen.Apilar(4);
		PilaTDA destino = new Pila();
		destino.InicializarPila();
		Metodos m = new Metodos();
		m.pasarPila(origen, destino);
		System.out.println("-----Ejercicio 12a Pasar Pila-----");
		System.out.println("Pila Pasada");
		while (!destino.PilaVacia()) {
			System.out.println(destino.Tope());
			destino.Desapilar();
		}
		System.out.println();
	}

	public static void ejercicio12b() {
		PilaTDA origen = new Pila();
		origen.InicializarPila();
		origen.Apilar(1);
		origen.Apilar(2);
		origen.Apilar(3);
		origen.Apilar(4);
		PilaTDA destino = new Pila();
		destino.InicializarPila();
		Metodos m = new Metodos();
		m.pasarPila(origen, destino);
		System.out.println("-----Ejercicio 12b Pila copiada-----");
		System.out.println("Pila Copiada ");
		while (!destino.PilaVacia()) {
			System.out.print(destino.Tope() + " ");
			destino.Desapilar();
		}
		System.out.println();
	}

	public static void ejercicio12c() {
		PilaTDA origen = new Pila();
		origen.InicializarPila();
		PilaTDA destino = new Pila();
		destino.InicializarPila();
		origen.Apilar(1);
		origen.Apilar(2);
		origen.Apilar(3);
		origen.Apilar(4);
		Metodos m = new Metodos();
		m.invertirPila(origen, destino);
		System.out.println("-----Ejercicio 12c Pila Invertida-----");
		System.out.println("Pila Invertida");
		while (!destino.PilaVacia()) {
			System.out.print(destino.Tope() + " ");
			destino.Desapilar();
		}
		System.out.println();
	}

	public static void ejercicio12d() {
		PilaTDA origen = new Pila();
		origen.InicializarPila();
		int cant = 0;
		origen.Apilar(1);
		origen.Apilar(2);
		origen.Apilar(3);
		origen.Apilar(4);
		Metodos m = new Metodos();
		cant = m.contarElementosPila(origen);
		System.out.println("-----Ejercicio 12d Contar Elementos Pila-----");
		System.out.println("Cantidad de elementos dentro de la pila: " + cant);
	}

	public static void ejercicio12e() {
		PilaTDA origen = new Pila();
		origen.InicializarPila();
		int sumador = 0;
		origen.Apilar(1);
		origen.Apilar(2);
		origen.Apilar(3);
		origen.Apilar(4);
		Metodos m = new Metodos();
		sumador = m.sumarElementosPila(origen);
		System.out.println("-----Ejercicio 12e Sumar Elementos Pila-----");
		System.out.println("Suma total de los elementos de la pila: " + sumador);
	}

	public static void ejercicio12f() {
		PilaTDA origen = new Pila();
		origen.InicializarPila();
		int promedio = 0;
		origen.Apilar(1);
		origen.Apilar(2);
		origen.Apilar(3);
		origen.Apilar(4);
		Metodos m = new Metodos();
		promedio = m.calcularPromedioPila(origen);
		System.out.println("-----Ejercicio 12f Promedio Elementos Pila-----");
		System.out.println("Promedio de los elementos de la pila: " + promedio);
	}
	// <---FIN EJERCICIOS TDA PILA--->

	// <---EJERCICIOS TDA COLA--->

	/*
	 * Pasar una Cola a otra
	 */
	public static void ejercicio34a() {
		ColaTDA origen = new Cola();
		origen.InicializarCola();
		origen.Acolar(1);
		origen.Acolar(2);
		origen.Acolar(3);
		origen.Acolar(4);
		ColaTDA destino = new Cola();
		destino.InicializarCola();
		Metodos m = new Metodos();
		m.pasarCola(origen, destino);
		System.out.println("-----Ejercicio 31a Pasar Cola-----");
		while (!destino.ColaVacia()) {
			System.out.print(destino.Primero() + " ");
			destino.Desacolar();
		}
		System.out.println();
	}

	/*
	 * Invertir el contenido de una Cola (pueden usarse Pilas auxiliares)
	 */
	public static void ejercicio34b() {
		ColaTDA origen = new Cola();
		origen.InicializarCola();
		origen.Acolar(1);
		origen.Acolar(2);
		origen.Acolar(3);
		origen.Acolar(4);
		Metodos m = new Metodos();
		m.invertirColaAux(origen);
		System.out.println("-----Ejercicio 34b Invertir Cola Aux-----");
		while (!origen.ColaVacia()) {
			System.out.print(origen.Primero() + " ");
			origen.Desacolar();
		}
		System.out.println();
	}

	/*
	 * Determinar si el final de la Cola C1 coincide o no con la Cola C2.
	 */
	public static void ejercicio34d() {
		ColaTDA origen = new Cola();
		origen.InicializarCola();
		origen.Acolar(1);
		origen.Acolar(1);
		origen.Acolar(1);
		origen.Acolar(2);
		ColaTDA origen2 = new Cola();
		origen2.InicializarCola();
		origen2.Acolar(1);
		origen2.Acolar(1);
		origen2.Acolar(1);
		origen2.Acolar(1);
		Metodos m = new Metodos();
		boolean resultado = m.colaCoincidencia(origen, origen2);
		System.out.println("-----Ejercicio 34d Cola coincidencia-----");
		if (resultado == true)
			System.out.println("Cola con coincidencia");
		else if (resultado == false)
			System.out.println("Cola sin coincidencia");
	}

	/*
	 * Determinar si una Cola es capicúa o no. Para ser capicúa debe cumplir que el
	 * primer elemento es igual al último, el segundo igual al penúltimo, etc.
	 */
	public static void ejercicio34e() {
		ColaTDA origen = new Cola();
		origen.InicializarCola();
		origen.Acolar(1);
		origen.Acolar(2);
		origen.Acolar(3);
		origen.Acolar(1);
		Metodos m = new Metodos();
		boolean resultado = m.colaCapicua(origen);
		System.out.print("-----Ejercicio 34e Cola Capicua-----");
		if (resultado == true) {
			System.out.print("Cola Capicua");
		} else {
			System.out.print("Cola NO Capicua");
		}
	}

	/*
	 * Determinar si la Cola C1 es la inversa de la Cola C2. Dos Colas serán
	 * inversas, si tienen los mismos elementos pero en orden inverso.
	 */
	public static void ejercicio34f() {
		ColaTDA cola1 = new Cola();
		cola1.InicializarCola();
		ColaTDA cola2 = new Cola();
		cola2.InicializarCola();
		PilaTDA aux = new Pila();
		aux.InicializarPila();
		cola1.Acolar(4);
		cola1.Acolar(3);
		cola1.Acolar(2);
		cola1.Acolar(1);
		cola2.Acolar(4);
		cola2.Acolar(3);
		cola2.Acolar(2);
		cola2.Acolar(1);
		Metodos m = new Metodos();
		boolean resultado = m.colaInversa(cola1, cola2, aux);
		System.out.println("-----Ejercicio 34f Cola Inversa-----");
		if (resultado == true)
			System.out.print("Cola inversa correcta");
		else if (resultado == false)
			System.out.print("Cola inversa NO correcta");
	}

	// <---FIN EJERCICIOS TDA COLA--->

	// <---INICIO EJERCICIOS TDA COLA PRIORIDAD--->

	/*
	 * Combinar dos colas con prioridades CP1 y CP2, generando una nueva cola con
	 * prioridades. Considerar que a igual prioridad, los elementos de la CP1 son
	 * más prioritarios que los de la CP2.
	 */
	public static void ejercicio56a() {
		ColaPrioridadTDA cola1 = new ColaPrioridad();
		ColaPrioridadTDA cola2 = new ColaPrioridad();
		ColaPrioridadTDA resultado = new ColaPrioridad();
		cola1.inicializarCola();
		cola2.inicializarCola();
		resultado.inicializarCola();
		// acolarPrioridad(prioridad, valor);
		cola1.acolarPrioridad(5, 1);
		cola1.acolarPrioridad(4, 2);
		cola1.acolarPrioridad(3, 3);
		cola2.acolarPrioridad(2, 4);
		cola2.acolarPrioridad(1, 5);
		Metodos m = new Metodos();
		m.combinarColaPrioridad(cola1, cola2, resultado);
		System.out.println("-----Ejercicio 56a Cola Inversa-----");
		while (!resultado.colaVacia()) {
			System.out.print(resultado.primero() + " ");
			resultado.desacolar();
		}
	}

	/*
	 * Determinar si dos Colas con prioridad son idénticas.
	 */
	public static void ejercicio56b() {
		ColaPrioridadTDA cola1 = new ColaPrioridad();
		ColaPrioridadTDA cola2 = new ColaPrioridad();
		cola1.inicializarCola();
		cola2.inicializarCola();
		// acolarPrioridad(prioridad, valor);
		cola1.acolarPrioridad(5, 1);
		cola1.acolarPrioridad(4, 2);
		cola1.acolarPrioridad(3, 3);
		cola2.acolarPrioridad(5, 1);
		cola2.acolarPrioridad(4, 2);
		cola2.acolarPrioridad(3, 3);
		Metodos m = new Metodos();
		boolean resultado = m.ColaPrioridadIdentica(cola1, cola2);
		System.out.println("-----Ejercicio 56b Cola Inversa-----");
		if (resultado == true)
			System.out.print("Cola prioridad identica");
		else if (resultado == false)
			System.out.print("Cola prioridad NO identica");
	}

	// <---FIN EJERCICIOS TDA COLA PRIORIDAD--->

	/**
	 * TRABAJO PRACTICO NRO 2
	 */

	// <---INICIO EJERCICIOS TDA CONJUNTO DINAMICO--->

	/*
	 * Realizar operación que permita realizar intersección de conjuntos
	 */
	public static void ejercicioTP2_6Dinamico_Interseccion() {
		ConjuntoTDA A = new Conjunto();
		ConjuntoTDA B = new Conjunto();
		ConjuntoTDA C = new Conjunto();
		A.InicializarConjunto();
		B.InicializarConjunto();
		C.InicializarConjunto();
		A.Agregar(2);
		A.Agregar(4);
		A.Agregar(1);
		A.Agregar(5);
		B.Agregar(3);
		B.Agregar(1);
		B.Agregar(5);
		B.Agregar(10);
		Metodos m = new Metodos();
		m.interseccionConjuntoDinamico(A, B, C);
		System.out.println("-----Ejercicio TP2 Ej: 6-insersección-----");
		while (!C.ConjuntoVacio()) {
			int valor = C.Elegir();
			System.out.println(valor);
			C.Sacar(valor);
		}
	}

	/*
	 * Realizar operación que permita realizar union de conjuntos
	 */
	public static void ejercicioTP2_6Dinamico_Union() {
		ConjuntoTDA A = new Conjunto();
		ConjuntoTDA B = new Conjunto();
		ConjuntoTDA C = new Conjunto();
		A.InicializarConjunto();
		B.InicializarConjunto();
		C.InicializarConjunto();
		A.Agregar(2);
		A.Agregar(4);
		A.Agregar(1);
		A.Agregar(5);
		B.Agregar(3);
		B.Agregar(1);
		B.Agregar(5);
		B.Agregar(10);
		Metodos m = new Metodos();
		m.unionConjuntoDinamico(A, B, C);
		System.out.println("-----Ejercicio TP2 Ej: 6-union-----");
		while (!C.ConjuntoVacio()) {
			int valor = C.Elegir();
			System.out.println(valor);
			C.Sacar(valor);
		}
	}

	/*
	 * Realizar operación que permita realizar diferencia de conjuntos
	 */
	public static void ejercicioTP2_6Dinamico_Diferencia() {
		ConjuntoTDA A = new Conjunto();
		ConjuntoTDA B = new Conjunto();
		A.InicializarConjunto();
		B.InicializarConjunto();
		A.Agregar(1);
		A.Agregar(2);
		A.Agregar(100);
		A.Agregar(200);
		B.Agregar(5);
		B.Agregar(3);
		B.Agregar(2);
		B.Agregar(1);
		Metodos m = new Metodos();
		m.diferenciaConjuntoDinamico(A, B);
		System.out.println("-----Ejercicio TP2 Ej: 6-diferencia-----");
		while (!A.ConjuntoVacio()) {
			int valor = A.Elegir();
			System.out.println(valor);
			A.Sacar(valor);
		}
	}

	// <---FIN EJERCICIOS TDA CONJUNTO DINAMICO--->

	/**
	 * TRABAJO PRACTICO NRO 3
	 */

	// <---INICIO EJERCICIOS TDA PILA--->
	/*
	 * Comprobar si una Pila P es capicúa (el elemento del tope es igual al de la base,
	 * el segundo igual al anteúltimo, etc.)
	 */
	public static void ejercicioTP3_1a() {
		PilaTDA pila = new Pila();
		pila.InicializarPila();
		pila.Apilar(2);
		pila.Apilar(1);
		pila.Apilar(3);
		pila.Apilar(3);
		pila.Apilar(1);
		pila.Apilar(2);
		Metodos m = new Metodos();
		boolean resultado = m.pilaCapicua(pila);
		System.out.println("-----Ejercicio TP3 1a) Pila Capicua-----");
		if (resultado == true)
			System.out.println("Pila Capicua");
		else
			System.out.println("Pila NO Capicua");
	}
	

	/*
	 * Eliminar de una Pila P las repeticiones de elementos, dejando un representante
	 * de cada uno de los elementos presentes originalmente. Se deberá respetar el
	 * orden original de los elementos, y en el caso de los repetidos se conservará el
	 * primero que haya ingresado en P.
	 */
	public static void ejercicioTP3_1b() {
		PilaTDA pila = new Pila();
		pila.InicializarPila();
		pila.Apilar(2);
		pila.Apilar(3);
		pila.Apilar(1);
		pila.Apilar(5);
		pila.Apilar(6);
		pila.Apilar(1);
		pila.Apilar(5);
		pila.Apilar(6);
		Metodos m = new Metodos();
		m.pilaSinRepeticiones(pila);
		while(!pila.PilaVacia()) {
			System.out.println(pila.Tope());
			pila.Desapilar();
		}
	}
	
	/*
	 * Repartir una Pila P en dos mitades M1 y M2 de elementos consecutivos,
	 * respetando el orden. Asumir que la Pila P contiene un número par de elementos.
	 */
	public static void ejercicioTP3_1c(){
		PilaTDA pila = new Pila();
		pila.InicializarPila();
		PilaTDA M1 = new Pila();
		M1.InicializarPila();
		PilaTDA M2 = new Pila();
		M2.InicializarPila();
		pila.Apilar(2);
		pila.Apilar(3);
		pila.Apilar(1);
		pila.Apilar(5);
		pila.Apilar(51);
		Metodos m = new Metodos();
		m.repartirPila(pila,M1,M2);
		while(!M2.PilaVacia()) {
			System.out.println(M2.Tope());
			M2.Desapilar();
		}
	}
	
	
	/*
	 * Generar el conjunto de elementos que se repiten en una Pila.
	 */
	public static void ejercicioTP3_1d() {
		ConjuntoTDA resultado = new Conjunto();
		resultado.InicializarConjunto();
		PilaTDA pila = new Pila();
		pila.InicializarPila();
		pila.Apilar(2);
		pila.Apilar(5);
		pila.Apilar(10);
		pila.Apilar(3);
		pila.Apilar(2);
		pila.Apilar(100);
		pila.Apilar(5);
		Metodos m = new Metodos();
		m.conjuntoDeRepeticiones_pila(pila,resultado);
		System.out.println("Conjunto resultante");
		while(!resultado.ConjuntoVacio()) {
			int valor = resultado.Elegir();
			System.out.println(valor);
			resultado.Sacar(valor);
		}
	}
	
	// <---FIN EJERCICIOS TDA PILA--->
	
	// <---INICIO EJERCICIOS TDA COLA--->
	
	
	/*
	 * Eliminar de una Cola C las repeticiones de elementos, dejando un representante
	 * de cada uno de los elementos presentes originalmente. Se deberá respetar el
	 * orden original de los elementos, y en el caso de los repetidos se conservará el
	 * primero que haya ingresado en C.
	 */
	public static void ejercicioTP3_2a() {
		ColaTDA cola = new Cola();
		cola.InicializarCola();
		cola.Acolar(3);
		cola.Acolar(10);
		cola.Acolar(5);
		cola.Acolar(20);
		cola.Acolar(1);
		cola.Acolar(2);
		cola.Acolar(5);
		Metodos m = new Metodos();
		m.colaSinRepeticiones(cola);
		while(!cola.ColaVacia()) {
			System.out.println(cola.Primero());
			cola.Desacolar();
		}
	}
	
	// <---FIN EJERCICIOS TDA COLA--->
	
	/**
	 * TRABAJO PRACTICO NRO 4
	 */

	// <---INICIO EJERCICIOS TDA ABB--->

	/*
	 * Dado un elemento, determinar si está o no en un ABB.
	 */
	public static void ejercicioTP4_3a() {
		ABBTDA aux = new ABB();
		aux.inicializarArbol();
		aux.agregar(10);
		aux.agregar(20);
		aux.agregar(5);
		aux.agregar(2);
		aux.agregar(3);
		aux.agregar(50);
		Metodos m = new Metodos();
		int valorBuscado = 5; // este numero debe modificarse para buscarse en el arbol
		boolean resultado = m.determinarExistencia(aux, valorBuscado);
		if (resultado == true)
			System.out.print("El valor se encuentra en el arbol");
		else if (resultado == false)
			System.out.print("El valor NO se encuentra en el arbol");

	}
	
	/*
	 * Mostrar por pantalla todos los elementos que contiene un ABB
	 */
	public static void ejercicioTP4_3l() {
		ABBTDA aux = new ABB();
		aux.inicializarArbol();
		aux.agregar(10);
		aux.agregar(20);
		aux.agregar(5);
		aux.agregar(2);
		aux.agregar(3);
		aux.agregar(50);
		Metodos m = new Metodos();
		System.out.println("Mostrando en ORDEN");
		m.mostrarOrden(aux);
		System.out.println("Mostrando en PRE ORDEN");
		m.mostrarPre(aux);
		System.out.println("Mostrando en POST ORDEN");
		m.mostrarPost(aux);
		

	}

	// <---FIN EJERCICIOS TDA ABB--->

}
