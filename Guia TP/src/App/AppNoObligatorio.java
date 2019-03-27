package App;


import Api.ColaTDA;
import Api.PilaTDA;
import Implementaciones.Estatico.Pila;
import Implementaciones.Estatico.Cola;
import Utilidades.Metodos;

public class AppNoObligatorio {
	
		public static void main(String args []){
			// TODO Auto-generated method stub
			
			//EJERCICIO PILAS
			//ejercicio12a();
			//ejercicio12b();
			
			//EJERCICIO COLAS
			//ejercicio34a();
			ejercicio34e();

		}
		
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
			System.out.println("Ejercicio 12a PasarPila");
			while(!destino.PilaVacia()) {
				System.out.print("Pila" + destino.Tope() + " ");
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
			System.out.println("Ejercicio 12b Pila copiada");
			while(!destino.PilaVacia()) {
				System.out.print("Pila" + destino.Tope() + " ");
				destino.Desapilar();
			}
			System.out.println();
			
		}
		
		
		//<---EJERCICIO TDA COLA--->
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
			while(!destino.ColaVacia()) {
				System.out.print("Cola" + destino.Primero() + " ");
				destino.Desacolar();
			}
			System.out.println();
			
		}
		
		/*
		public static void ejercicio34b() {
			ColaTDA origen = new Cola();
			ColaTDA aux = new Cola();
			origen.InicializarCola();
			aux.InicializarCola();
			origen.Acolar(1);
			origen.Acolar(2);
			origen.Acolar(3);
			origen.Acolar(4);
			Metodos m = new Metodos();
			m.colaCoincidencia(origen, aux);
			while(!aux.ColaVacia()) {
				System.out.print("Cola" + aux.Primero() + " ");
				aux.Desacolar();
			}
			System.out.println();
			
		}
		*/
		
		public static void ejercicio34e() {
			ColaTDA origen = new Cola();
			origen.InicializarCola();
			origen.Acolar(1);
			origen.Acolar(2);
			origen.Acolar(5);
			origen.Acolar(1);
			Metodos m = new Metodos();
			if (m.colaCapicua(origen)) 
				System.out.println("Cola capicua!");
			else
				System.out.println("Cola NO capicua!");
			
		}
		
}
