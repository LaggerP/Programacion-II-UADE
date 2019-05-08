package App;

import Api.ColaPrioridadTDA;
import Api.ColaTDA;
import Api.ConjuntoTDA;
import Api.DiccionarioMultipleTDA;
import Api.PilaTDA;
import Implementaciones.Dinamico.Conjunto;
import Implementaciones.Dinamico.DiccionarioMultiple;
import Implementaciones.Estatico.Cola;
import Implementaciones.Estatico.ColaPrioridad;
import Implementaciones.Estatico.Pila;
import Utilidades.Metodos;

public class AppTP3 {
	public static void main(String args[]) {
		// TRABAJO PRACTICO 3

		// ---INICIO EJERCICIO PILA---

		ejercicioTP3_1a(); // CORREGIDO
		ejercicioTP3_1b(); // CORREGIDO
		ejercicioTP3_1c(); // CORREGIDO
		//ejercicioTP3_1d();

		// ---FIN EJERCICIO PILA---

		// ---INICIO EJERCICIO COLA---

		ejercicioTP3_2a(); // CORREGIDO
		ejercicioTP3_2b(); // CORREGIDO
		ejercicioTP3_2c(); // CORREGIDO

		// ---FIN EJERCICIO COLA---

		// ---INICIO EJERCICIOS CONJUNTOS---

		ejercicioTP3_3d(); // CORREGIDO
		ejercicioTP3_3e(); // CORREGIDO
		ejercicioTP3_3f(); // CORREGIDO
		ejercicioTP3_3g(); // CORREGIDO

		// ---FIN EJERCICIOS CONJUNTOS---

		// ---INICIO EJERCICIOS COLA PRIORIDAD---

		ejercicioTP3_4a(); // CONSULTAR

		// ---FIN EJERCICIOS COLA PRIORIDAD---

		// ---INICIO EJERCICIOS DICCIONARIO MULTIPLE---

		ejercicioTP3_5();

		// ---FIN EJERCICIOS DICCIONARIO MULTIPLE---
	}

	// <---INICIO EJERCICIOS TDA PILA--->
	/*
	 * Comprobar si una Pila P es capicúa (el elemento del tope es igual al de la
	 * base, el segundo igual al anteúltimo, etc.)
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
	 * Eliminar de una Pila P las repeticiones de elementos, dejando un
	 * representante de cada uno de los elementos presentes originalmente. Se deberá
	 * respetar el orden original de los elementos, y en el caso de los repetidos se
	 * conservará el primero que haya ingresado en P.
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
		while (!pila.PilaVacia()) {
			System.out.println(pila.Tope());
			pila.Desapilar();
		}
	}

	/*
	 * Repartir una Pila P en dos mitades M1 y M2 de elementos consecutivos,
	 * respetando el orden. Asumir que la Pila P contiene un número par de
	 * elementos.
	 */
	public static void ejercicioTP3_1c() {
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
		pila.Apilar(10);
		pila.Apilar(51);
		Metodos m = new Metodos();
		m.repartirPila(pila, M1, M2);
		while (!M1.PilaVacia()) {
			System.out.println(M1.Tope());
			M1.Desapilar();
		}
		while (!M2.PilaVacia()) {
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
		m.conjuntoDeRepeticiones_pila(pila, resultado);
		System.out.println("Conjunto resultante");
		while (!resultado.ConjuntoVacio()) {
			int valor = resultado.Elegir();
			System.out.println(valor);
			resultado.Sacar(valor);
		}
	}

	// <---FIN EJERCICIOS TDA PILA--->

	// <---INICIO EJERCICIOS TDA COLA--->

	/*
	 * Eliminar de una Cola C las repeticiones de elementos, dejando un
	 * representante de cada uno de los elementos presentes originalmente. Se deberá
	 * respetar el orden original de los elementos, y en el caso de los repetidos se
	 * conservará el primero que haya ingresado en C.
	 */
	public static void ejercicioTP3_2a() {
		ColaTDA cola = new Cola();
		cola.InicializarCola();
		cola.Acolar(3);
		cola.Acolar(10);
		cola.Acolar(5);
		cola.Acolar(20);
		cola.Acolar(1);
		cola.Acolar(19);
		cola.Acolar(5);
		Metodos m = new Metodos();
		m.colaSinRepeticiones(cola);
		while (!cola.ColaVacia()) {
			System.out.println(cola.Primero());
			cola.Desacolar();
		}
	}

	/*
	 * Repartir una Cola C en dos mitades M1 y M2 de elementos consecutivos,
	 * respetando el orden. Asumir que la cantidad de elementos de C es par.
	 */
	public static void ejercicioTP3_2b() {
		ColaTDA cola = new Cola();
		ColaTDA M1 = new Cola();
		ColaTDA M2 = new Cola();
		cola.InicializarCola();
		M1.InicializarCola();
		M2.InicializarCola();
		cola.Acolar(1);
		cola.Acolar(2);
		cola.Acolar(3);
		cola.Acolar(4);
		cola.Acolar(5);
		cola.Acolar(6);
		Metodos m = new Metodos();
		m.repartirCola(cola, M1, M2);
		System.out.println("Cola M1");
		while (!M1.ColaVacia() && !M2.ColaVacia()) {
			System.out.println(M1.Primero());
			M1.Desacolar();
		}
		System.out.println("Cola M2");
		while (!M2.ColaVacia()) {
			System.out.println(M2.Primero());
			M2.Desacolar();
		}
	}

	public static void ejercicioTP3_2c() {
		ColaTDA cola = new Cola();
		ConjuntoTDA resultado = new Conjunto();
		cola.InicializarCola();
		resultado.InicializarConjunto();
		cola.Acolar(1);
		cola.Acolar(2);
		cola.Acolar(3);
		cola.Acolar(3);
		cola.Acolar(2);
		cola.Acolar(6);
		Metodos m = new Metodos();
		m.conjuntoRepeticiones_cola(cola, resultado);
		while (!resultado.ConjuntoVacio()) {
			int valor = resultado.Elegir();
			System.out.println(valor);
			resultado.Sacar(valor);
		}
	}

	// <---FIN EJERCICIOS TDA COLA--->

	// <---INICIO METODOS CONJUNTOS TDA--->

	/*
	 * Determinar si dos conjuntos son iguales.
	 */
	public static void ejercicioTP3_3d() {
		ConjuntoTDA C1 = new Conjunto();
		ConjuntoTDA C2 = new Conjunto();
		C1.InicializarConjunto();
		C2.InicializarConjunto();
		C1.Agregar(1);
		C1.Agregar(2);
		C1.Agregar(3);
		C1.Agregar(4);
		C1.Agregar(5);
		C2.Agregar(1);
		C2.Agregar(2);
		C2.Agregar(3);
		C2.Agregar(4);
		C2.Agregar(5);
		Metodos m = new Metodos();
		boolean resultado = m.conjuntosIguales(C1, C2);
		if (resultado == true)
			System.out.print("conjuntos iguales");
		else if (resultado == false)
			System.out.print("conjuntos NO iguales");
	}

	/*
	 * Calcular la cardinalidad (cantidad de elementos) de un conjunto.
	 */
	public static void ejercicioTP3_3e() {
		ConjuntoTDA C = new Conjunto();
		C.InicializarConjunto();
		C.Agregar(1);
		C.Agregar(2);
		C.Agregar(3);
		C.Agregar(4);
		C.Agregar(5);
		int cardinalidad = 0;
		Metodos m = new Metodos();
		cardinalidad = m.cardinalidadConjunto(C, cardinalidad);
		System.out.println("La cardinalidad del conjunto es: " + cardinalidad);
	}

	/*
	 * Generar el conjunto de elementos que están tanto en la Pila P y en la Cola C.
	 */
	public static void ejercicioTP3_3f() {
		ConjuntoTDA resultado = new Conjunto();
		PilaTDA P = new Pila();
		ColaTDA C = new Cola();
		resultado.InicializarConjunto();
		P.InicializarPila();
		C.InicializarCola();
		P.Apilar(1);
		P.Apilar(2);
		P.Apilar(3);
		P.Apilar(4);
		C.Acolar(5);
		C.Acolar(6);
		C.Acolar(7);
		C.Acolar(8);
		Metodos m = new Metodos();
		m.conjuntoGenerado_PilaCola(resultado, P, C);
		while (!resultado.ConjuntoVacio()) {
			int valor = resultado.Elegir();
			System.out.println(valor);
			resultado.Sacar(valor);
		}
	}

	/*
	 * Determinar si los elementos de una Pila P son los mismos que los de una Cola
	 * C. No interesa el orden ni si están repetidos o no.
	 */
	public static void ejercicioTP3_3g() {
		PilaTDA P = new Pila();
		ColaTDA C = new Cola();
		P.InicializarPila();
		C.InicializarCola();
		P.Apilar(1);
		P.Apilar(2);
		P.Apilar(3);
		P.Apilar(4);
		C.Acolar(1);
		C.Acolar(2);
		C.Acolar(3);
		C.Acolar(4);
		Metodos m = new Metodos();
		boolean res = m.elementosIguales_PilaCola(P, C);
		if (res == true)
			System.out.println("valores iguales");
		else if (res == false)
			System.out.println("valores NO iguales");
	}
	// <---FIN METODOS CONJUNTOS TDA--->

	// <---INICIO METODOS COLA PRIORIDAD TDA--->

	/*
	 * Escribir un método externo que permita generar un Diccionario Múltiple que
	 * permita, para cada valor presente en la ColaPrioridad C recuperar todas las
	 * prioridades que tiene asociadas en C.
	 */
	public static void ejercicioTP3_4a() {
		ColaPrioridadTDA C = new ColaPrioridad();
		DiccionarioMultipleTDA DM = new DiccionarioMultiple();
		DM.inicializarDiccionario();
		C.inicializarCola();
		C.acolarPrioridad(10, 30);
		C.acolarPrioridad(30, 20);
		C.acolarPrioridad(1, 10);
		C.acolarPrioridad(8, 5);
		C.acolarPrioridad(2, 300);
		Metodos m = new Metodos();
		m.generarRecuperarColaPrioridad(C, DM);

		ConjuntoTDA claves = new Conjunto();
		claves.InicializarConjunto();
		ConjuntoTDA valores = new Conjunto();
		valores.InicializarConjunto();

		claves = DM.claves();
		while (!claves.ConjuntoVacio()) {
			int claveUnitaria = claves.Elegir();
			valores = DM.recuperar(claveUnitaria);
			while (!valores.ConjuntoVacio()) {
				int valorUnitario = valores.Elegir();
				System.out.println(valorUnitario);
			}

		}

	}

	// <---FIN METODOS COLA PRIORIDAD TDA--->

	// <---INICIO METODOS DICCIONARIO MULTUPLE TDA--->

	/*
	 * Dados dos DiccionarioMultipleTDA D1 y D2, generar un DiccionarioMultipleTDA
	 * que contenga: a) las claves presentes en D1 y D2, con todos los elementos
	 * asociados a cada clave. b) las claves presentes en D1 y D2, con todos los
	 * elementos comunes a las claves coincidentes en ambos. c) las claves comunes
	 * de D1 y D2, con todos los elementos asociados a cada clave.
	 */
	public static void ejercicioTP3_5() {
		DiccionarioMultipleTDA D1 = new DiccionarioMultiple();
		DiccionarioMultipleTDA D2 = new DiccionarioMultiple();
		DiccionarioMultipleTDA Dgenerado = new DiccionarioMultiple();
		DiccionarioMultipleTDA DMpuntoB = new DiccionarioMultiple();
		DiccionarioMultipleTDA DMpuntoC = new DiccionarioMultiple();
		D1.inicializarDiccionario();
		D2.inicializarDiccionario();
		Dgenerado.inicializarDiccionario();
		DMpuntoB.inicializarDiccionario();
		DMpuntoC.inicializarDiccionario();
		D1.agregar(10, 200);
		D1.agregar(1, 300);
		D1.agregar(15, 400);
		D1.agregar(5, 500);
		D1.agregar(5, 200);
		D1.agregar(5, 60);
		D1.agregar(9, 600);
		D1.agregar(20, 20);
		D1.agregar(5, 3000);
		D2.agregar(20, 20);
		D2.agregar(20, 30);
		D2.agregar(20, 10);
		D2.agregar(5, 3000);
		D2.agregar(7, 50);
		D2.agregar(30, 60);
		Metodos m = new Metodos();
		System.out.println("\nEjercicio 5a):");
		// ejercicio a)
		m.generarDiccionarioMultiple(D1, D2, Dgenerado);
		m.mostrarDiccionarioMultiple(Dgenerado);
		System.out.println("\nEjercicio 5b):");
		// ejercicio b)
		m.generarDiccionarioCoincidente(D1, D2, DMpuntoB);
		m.mostrarDiccionarioMultiple(DMpuntoB);
		System.out.println("\nEjercicio 5c):");
		// ejercicio c)
		m.generarDiccionarioElementos_A_Clave(D1, D2, DMpuntoC);
		m.mostrarDiccionarioMultiple(DMpuntoC);

	}
	// <---FIN METODOS DICCIONARIO MULTUPLE TDA--->
}
