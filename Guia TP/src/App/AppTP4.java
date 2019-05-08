package App;

import Api.ABBTDA;
import Implementaciones.Dinamico.ABB;
import Utilidades.Metodos;

public class AppTP4 {
	public static void main(String args[]) {
		// TRABAJO PRACTICO 4

		// ---INICIO EJERCICIO ABB---

		// ejercicioTP4_3a(); //CORREGIDO
		// ejercicioTP4_3b(); //CORREGIDO
		// ejercicioTP4_3c(); //CORREGIDO
		// ejercicioTP4_3d(); //CORREGIDO
		// ejercicioTP4_3e(); //CORREGIDO
		// ejercicioTP4_3f(); //CORREGIDO
		// ejercicioTP4_3h(); //CORREGIDO
		 ejercicioTP4_3i();
		// ejercicioTP4_3l(); //CORREGIDO
		
		// ---FIN EJERCICIO ABB---
	}

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
	 * Dado un elemento, determinar si es una hoja de un ABB.
	 */
	public static void ejercicioTP4_3b() {
		ABBTDA arbol = new ABB();
		arbol.inicializarArbol();
		arbol.agregar(20);
		arbol.agregar(60);
		arbol.agregar(40);
		arbol.agregar(30);
		arbol.agregar(2);
		arbol.agregar(5);
		arbol.agregar(50);
		arbol.agregar(90);
		arbol.agregar(70);
		arbol.agregar(1000);
		Metodos m = new Metodos();
		int valorBuscado = 1000; // este numero debe modificarse para buscarse en el arbol
		boolean resultado = m.determinarHoja(arbol, valorBuscado);
		if (resultado == true)
			System.out.print("Valor es una hoja");
		else if (resultado == false)
			System.out.print("Valor NO es una hoja");
	}

	/*
	 * Dado un elemento, calcular su profundidad en el ABB
	 */
	public static void ejercicioTP4_3c() {
		ABBTDA arbol = new ABB();
		arbol.inicializarArbol();
		arbol.agregar(20);
		arbol.agregar(60);
		arbol.agregar(40);
		arbol.agregar(30);
		arbol.agregar(2);
		arbol.agregar(5);
		arbol.agregar(50);
		arbol.agregar(90);
		arbol.agregar(70);
		arbol.agregar(1000);
		Metodos m = new Metodos();
		int valorBuscado = 60; // valor puede ser modificado
		System.out.println("La profundidad del valor buscado es:" + m.profundidadValor(arbol, valorBuscado));
	}
	
	/*
	 * Obtener el valor del menor elemento de un ABB.
	 */
	public static void ejercicioTP4_3d() {
		ABBTDA arbol = new ABB();
		arbol.inicializarArbol();
		arbol.agregar(20);
		arbol.agregar(60);
		arbol.agregar(40);
		arbol.agregar(30);
		arbol.agregar(2);
		arbol.agregar(5);
		arbol.agregar(50);
		arbol.agregar(90);
		arbol.agregar(1);
		arbol.agregar(70);
		arbol.agregar(1000);
		Metodos m = new Metodos();
		System.out.println("El valor menor es: " + m.menorValor(arbol));
	}
	
	/*
	 * Calcular la cantidad de elementos que contiene un ABB.
	 */
	public static void ejercicioTP4_3e() {
		ABBTDA arbol = new ABB();
		arbol.inicializarArbol();
		arbol.agregar(20);
		arbol.agregar(60);
		arbol.agregar(40);
		arbol.agregar(30);
		arbol.agregar(2);
		arbol.agregar(5);
		arbol.agregar(50);
		arbol.agregar(90);
		arbol.agregar(1);
		arbol.agregar(70);
		arbol.agregar(1000);
		Metodos m = new Metodos();
		System.out.println("El valor menor es: " + m.cantidadElementos(arbol));
	}
	
	/*
	 * Calcular la suma de los elementos que contiene un ABB.
	 */
	public static void ejercicioTP4_3f() {
		ABBTDA arbol = new ABB();
		arbol.inicializarArbol();
		arbol.agregar(20);
		arbol.agregar(60);
		arbol.agregar(40);
		arbol.agregar(30);
		arbol.agregar(2);
		arbol.agregar(5);
		arbol.agregar(50);
		arbol.agregar(90);
		arbol.agregar(1);
		arbol.agregar(70);
		arbol.agregar(1000);
		Metodos m = new Metodos();
		System.out.println("El valor menor es: " + m.sumatoriaElementos(arbol));
	}
	
	/*
	 * Calcular el cantidad de hojas de un ABB
	 */
	public static void ejercicioTP4_3g() {
		ABBTDA arbol = new ABB();
		arbol.inicializarArbol();
		arbol.agregar(20);
		arbol.agregar(60);
		arbol.agregar(40);
		arbol.agregar(30);
		arbol.agregar(2);
		arbol.agregar(5);
		arbol.agregar(50);
		arbol.agregar(90);
		arbol.agregar(1);
		arbol.agregar(70);
		arbol.agregar(1000);
		Metodos m = new Metodos();
		System.out.println("El valor menor es: " + m.sumatoriaCantHojas(arbol));
	}
	
	/*
	 * Calcular la altura de un ABB.
	 */
	public static void ejercicioTP4_3h() {
		ABBTDA arbol = new ABB();
		arbol.inicializarArbol();
		arbol.agregar(20);
		arbol.agregar(60);
		arbol.agregar(40);
		arbol.agregar(30);
		arbol.agregar(2);
		arbol.agregar(5);
		arbol.agregar(50);
		arbol.agregar(90);
		arbol.agregar(1);
		arbol.agregar(70);
		arbol.agregar(1000);
		Metodos m = new Metodos();
		System.out.println("Altura del arbol es: " + m.alturaArbol(arbol));
	}
	

	/*
	 * Comprobar si dos ABBs tienen la misma forma.
	 */
	public static void ejercicioTP4_3i() {
		ABBTDA arbol = new ABB();
		ABBTDA arbol2 = new ABB();
		arbol.inicializarArbol();
		arbol2.inicializarArbol();
		arbol.agregar(6);
		arbol.agregar(5);
		arbol.agregar(4);
		arbol.agregar(3);
		arbol.agregar(2);
		arbol.agregar(0);
		arbol2.agregar(6);
		arbol2.agregar(5);
		arbol2.agregar(4);
		arbol2.agregar(3);
		arbol2.agregar(2);
		arbol2.agregar(1);
		Metodos m = new Metodos();
		System.out.println(m.igualForma(arbol, arbol2));
	}
	
	/*
	 * Comprobar si dos ABBs son iguales
	 */
	public static void ejercicioTP4_3j() {
		ABBTDA arbol = new ABB();
		ABBTDA arbol2 = new ABB();
		arbol.inicializarArbol();
		arbol2.inicializarArbol();
		arbol.agregar(6);
		arbol.agregar(5);
		arbol.agregar(4);
		arbol.agregar(3);
		arbol.agregar(2);
		arbol.agregar(0);
		arbol2.agregar(6);
		arbol2.agregar(5);
		arbol2.agregar(4);
		arbol2.agregar(3);
		arbol2.agregar(2);
		arbol2.agregar(1);
		Metodos m = new Metodos();
		System.out.println(m.arbolesIguales(arbol, arbol2));
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
