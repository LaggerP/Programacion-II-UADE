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
			
			//ejercicio12a(); //CORREGIDO
			//ejercicio12b(); //CORREGIDO
			//ejercicio12c(); //CORREGIDO
			//ejercicio12d(); //CORREGIDO
			//ejercicio12e(); //CORREGIDO
			//ejercicio12f(); //CORREGIDO
			
			//FIN EJERCICIO PILAS
			
			//EJERCICIO COLAS
			
			//ejercicio34a(); //CORREGIDO
			//ejercicio34b(); //CORREGIDO
			//ejercicio34d(); //CORREGIDO
			ejercicio34e();
			
			//FIN EJERCICIO COLAS

		}
		
		//<---EJERCICIO TDA PILA--->
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
			while(!destino.PilaVacia()) {
				System.out.print(destino.Tope() + " ");
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
			while(!destino.PilaVacia()) {
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
			m.invertirPila(origen,destino);
			System.out.println("-----Ejercicio 12c Pila Invertida-----");
			System.out.println("Pila Invertida");
			while(!destino.PilaVacia()) {
				System.out.print(destino.Tope() + " ");
				destino.Desapilar();
			}
			System.out.println();
		}
		
		public static void ejercicio12d() {
			PilaTDA origen = new Pila();
			origen.InicializarPila();
			int cant =0;
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
			int sumador =0;
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
			int promedio =0;
			origen.Apilar(1);
			origen.Apilar(2);
			origen.Apilar(3);
			origen.Apilar(4);
			Metodos m = new Metodos();
			promedio = m.calcularPromedioPila(origen);
			System.out.println("-----Ejercicio 12f Promedio Elementos Pila-----");
			System.out.println("Promedio de los elementos de la pila: " + promedio);
		}
		//<---FIN EJERCICIO TDA PILA--->
		
		
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
			System.out.println("-----Ejercicio 31a Pasar Cola-----");
			while(!destino.ColaVacia()) {
				System.out.print(destino.Primero() + " ");
				destino.Desacolar();
			}
			System.out.println();
			
		}
		
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
			while(!origen.ColaVacia()) {
				System.out.print(origen.Primero() + " ");
				origen.Desacolar();
			}
			System.out.println();
		}
		
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
		
		public static void ejercicio34e() {
			ColaTDA origen = new Cola();
			origen.InicializarCola();
			origen.Acolar(1);
			origen.Acolar(3);
			origen.Acolar(2);
			origen.Acolar(4);
			Metodos m = new Metodos();
			int flag = 0;
			m.colaCapicua(origen);

		}
		
		//<---FIN EJERCICIO TDA COLA--->
}
