package App;

import Api.ConjuntoTDA;
import Implementaciones.Dinamico.Conjunto;
import Utilidades.Metodos;

public class AppTP2 {

	public static void main(String args[]) {
		// TRABAJO PRACTICO 2

		// ---INICIO EJERCICIO CONJUNTO DINAMICO---

		ejercicioTP2_6Dinamico_Interseccion(); // CORREGIDO
		ejercicioTP2_6Dinamico_Union(); // CORREGIDO
		ejercicioTP2_6Dinamico_Diferencia(); // CORREGIDO

		// ---FIN EJERCICIO CONJUNTO DINAMICO---
	}

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
}
