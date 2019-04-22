package App;


import Api.ColaPrioridadTDA;
import Api.ColaTDA;
import Api.PilaTDA;
import Implementaciones.Estatico.Pila;
import Implementaciones.Estatico.ColaPrioridad;
import Implementaciones.Estatico.Cola;
import Utilidades.Metodos;

public class AppNoObligatorio {
	
		public static void main(String args []){
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
			//ejercicio34e();
			//ejercicio34f();
			
			//FIN EJERCICIO COLAS

			//EJERCICIO COLA PRIORIDAD
			//ejercicio56a();
			ejercicio56b();
			
			//FIN EJERCICIO COLA PRIORIDAD
		}
		
		//<---EJERCICIOS TDA PILA--->
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
		//<---FIN EJERCICIOS TDA PILA--->
		
		
		//<---EJERCICIOS TDA COLA--->
		
		/*
		 * Pasar una Cola a otra
		 * */
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
		
		/*
		 * Invertir el contenido de una Cola (pueden usarse Pilas auxiliares)
		 * */
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
		
		/*
		 * Determinar si el final de la Cola C1 coincide o no con la Cola C2.
		 * */
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
		 * Determinar si una Cola es capicúa o no. Para ser capicúa debe cumplir
		 * que el primer elemento es igual al último, el segundo igual al penúltimo, etc.
		 * */
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
			}else {
				System.out.print("Cola NO Capicua");
			}
		}
		
		/*
		 * Determinar si la Cola C1 es la inversa de la Cola C2. Dos Colas serán
		 * inversas, si tienen los mismos elementos pero en orden inverso.
		 * */
		public static void ejercicio34f() {
			ColaTDA origen = new Cola();
			origen.InicializarCola();
			origen.Acolar(1);
			origen.Acolar(2);
			origen.Acolar(3);
			origen.Acolar(4);
			Metodos m = new Metodos();
			boolean resultado = m.colaInversa(origen);
			System.out.println("-----Ejercicio 34f Cola Inversa-----");
			if (resultado == true)
				System.out.print("Cola inversa correcta");
			else if (resultado == false)
				System.out.print("Cola inversa NO correcta");
		}
		
		//<---FIN EJERCICIOS TDA COLA--->
		
		//<---INICIO EJERCICIOS TDA COLA PRIORIDAD--->
		
		
		/*
		 * Combinar dos colas con prioridades CP1 y CP2, generando una nueva
		 * cola con prioridades. Considerar que a igual prioridad, los elementos de la CP1
		 * son más prioritarios que los de la CP2.
		 */
		public static void ejercicio56a() {
			ColaPrioridadTDA cola1 = new ColaPrioridad();
			ColaPrioridadTDA cola2 = new ColaPrioridad();
			ColaPrioridadTDA resultado = new ColaPrioridad();
			cola1.inicializarCola();
			cola2.inicializarCola();
			resultado.inicializarCola();
			//primer parametro = prioridad
			//segundo parametro = valor
			cola1.acolarPrioridad(5, 1);
			cola1.acolarPrioridad(4, 2);
			cola1.acolarPrioridad(3, 3);
			cola2.acolarPrioridad(2, 4);
			cola2.acolarPrioridad(1, 5);
			Metodos m = new Metodos();
			m.combinarColaPrioridad(cola1,cola2);
			System.out.println("-----Ejercicio 56a Cola Inversa-----");
			while(!resultado.colaVacia()) {
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
			//acolarPrioridad(prioridad, valor);
			cola1.acolarPrioridad(5, 1);
			cola1.acolarPrioridad(4, 2);
			cola1.acolarPrioridad(3, 3);
			cola2.acolarPrioridad(5, 1);
			cola2.acolarPrioridad(4, 2);
			cola2.acolarPrioridad(3, 3);
			Metodos m = new Metodos();
			boolean resultado = m.ColaPrioridadIdentica(cola1,cola2);
			System.out.println("-----Ejercicio 56b Cola Inversa-----");
			if (resultado == true) 
				System.out.print("Cola prioridad identica");
			else if (resultado == false)
				System.out.print("Cola prioridad NO identica");
		}
		
		//<---FIN EJERCICIOS TDA COLA PRIORIDAD--->
}
