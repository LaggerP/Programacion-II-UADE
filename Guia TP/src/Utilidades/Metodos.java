package Utilidades;

import Api.ABBTDA;
import Api.ColaPrioridadTDA;
import Api.ColaTDA;
import Api.ConjuntoTDA;
import Api.DiccionarioMultipleTDA;
import Api.PilaTDA;
import Implementaciones.Dinamico.Conjunto;
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

	// 1a
	public boolean pilaCapicua(PilaTDA pila) {
		Pila aux = new Pila();
		aux.InicializarPila();
		int cant = 0;
		int mitad = 0;

		while (!pila.PilaVacia()) {
			aux.Apilar(pila.Tope());
			cant++;
			pila.Desapilar();
		}

		// devuelve la mitad del total de cant de elementos de la cola
		mitad = cant / 2;

		while (!aux.PilaVacia() && mitad > 0) {
			pila.Apilar(aux.Tope());
			aux.Desapilar();
			mitad--;
		}

		while (!pila.PilaVacia() && !aux.PilaVacia()) {
			if (pila.Tope() != aux.Tope()) {
				return false;
			}
			pila.Desapilar();
			aux.Desapilar();
		}
		return (pila.PilaVacia() && aux.PilaVacia());
	}

	// 1b
	public void pilaSinRepeticiones(PilaTDA P) {
		PilaTDA aux = new Pila();
		aux.InicializarPila();
		PilaTDA fin = new Pila();
		fin.InicializarPila();
		int comparador = 0;
		while (!P.PilaVacia()) {
			while (!P.PilaVacia()) {
				aux.Apilar(P.Tope());
				P.Desapilar();
			}
			comparador = aux.Tope();
			aux.Desapilar();
			while (!aux.PilaVacia()) {
				/*
				 * en este ciclo comparo el tope de la pila (guardado en la variable
				 * "comparador") con los demas valores de la pila. Si estos difieren lo vuelvo a
				 * apilar en la pila original (P) Si no hay diferencia, desapilo el valor dado
				 * que se tiene que respetar el orden de los elementos repetidos
				 */
				if (comparador != aux.Tope())
					P.Apilar(aux.Tope());
				aux.Desapilar();
			}
			fin.Apilar(comparador);
		}
		// volvemos a ingresar los datos sin los valores repetidos en la pila original
		while (!fin.PilaVacia()) {
			P.Apilar(fin.Tope());
			fin.Desapilar();
		}
	}

	// 1c
	public void repartirPila(PilaTDA P, PilaTDA M1, PilaTDA M2) {
		int cant = 0;
		while (!P.PilaVacia()) {
			M1.Apilar(P.Tope());
			P.Desapilar();
			cant++;
		}
		cant = cant / 2;
		while (cant != 0) {
			cant--;
			M2.Apilar(M1.Tope());
			M1.Desapilar();
		}
		invertirPilaEJERCICIO_1C(M1);
	}

	private void invertirPilaEJERCICIO_1C(PilaTDA A) {
		PilaTDA aux1 = new Pila();
		aux1.InicializarPila();
		while (!A.PilaVacia()) {
			aux1.Apilar(A.Tope());
			A.Desapilar();
		}
		PilaTDA aux2 = new Pila();
		aux2.InicializarPila();
		while (!aux1.PilaVacia()) {
			aux2.Apilar(aux1.Tope());
			aux1.Desapilar();
		}
		while (!aux2.PilaVacia()) {
			A.Apilar(aux2.Tope());
			aux2.Desapilar();
		}
	}

	// 1d

	public void conjuntoDeRepeticiones_pila(PilaTDA pila, ConjuntoTDA resultado) {
		PilaTDA aux = new Pila();
		aux.InicializarPila();
		int valorUnitario = 0;
		while (!pila.PilaVacia()) {
			valorUnitario = pila.Tope();
			pila.Desapilar();
			while (!pila.PilaVacia()) {
				if (valorUnitario == pila.Tope()) {
					if (!resultado.Pertenece(valorUnitario))
						resultado.Agregar(valorUnitario);
					else
						aux.Apilar(pila.Tope());
				}
				pila.Desapilar();
			}
			while (!aux.PilaVacia()) {
				pila.Apilar(aux.Tope());
				aux.Desapilar();
			}
		}
	}

	// <------FIN METODOS PILA------>

	// <------INICIO METODOS COLA------>

	// 2a
	public void colaSinRepeticiones(ColaTDA C) {
		ColaTDA aux = new Cola();
		ColaTDA fin = new Cola();
		aux.InicializarCola();
		fin.InicializarCola();
		int comparador;
		while (!C.ColaVacia()) {
			comparador = C.Primero();
			C.Desacolar();
			while (!C.ColaVacia()) {
				if (comparador != C.Primero())
					aux.Acolar(C.Primero());
				C.Desacolar();
			}

			fin.Acolar(comparador);
			while (!aux.ColaVacia()) {
				C.Acolar(aux.Primero());
				aux.Desacolar();
			}
		}
		while (!fin.ColaVacia()) {
			C.Acolar(fin.Primero());
			fin.Desacolar();
		}

	}

	// 2b
	public void repartirCola(ColaTDA C, ColaTDA M1, ColaTDA M2) {
		int cant = 0;
		while (!C.ColaVacia()) {
			M2.Acolar(C.Primero());
			cant++;
			C.Desacolar();
		}
		cant = cant / 2;
		while (cant != 0) {
			M1.Acolar(M2.Primero());
			M2.Desacolar();
			cant--;
		}
	}

	// 2c
	public void conjuntoRepeticiones_cola(ColaTDA cola, ConjuntoTDA resultado) {
		ColaTDA aux = new Cola();
		aux.InicializarCola();
		int valor;
		while (!cola.ColaVacia()) {
			valor = cola.Primero();
			cola.Desacolar();
			while (!cola.ColaVacia()) {
				if (valor == cola.Primero())
					resultado.Agregar(valor);
				else
					aux.Acolar(cola.Primero());
				cola.Desacolar();
			}
		}
		while (!aux.ColaVacia()) {
			cola.Acolar(aux.Primero());
			aux.Desacolar();
		}
	}

	// <------FIN METODOS COLA------>

	// <------INICIO METODOS CONJUNTOS------>

	// <------FIN METODOS CONJUNTOS------>

	// 3d
	public boolean conjuntosIguales(ConjuntoTDA C1, ConjuntoTDA C2) {
		int aux;
		while (!C2.ConjuntoVacio()) {
			aux = C2.Elegir();
			C2.Sacar(aux);
			if (C1.Pertenece(aux)) {
				C1.Sacar(aux);
			} else
				return false;
		}
		return true;
	}

	// 3e
	public int cardinalidadConjunto(ConjuntoTDA C, int cardinalidad) {
		while (!C.ConjuntoVacio()) {
			int valor = C.Elegir();
			cardinalidad++;
			C.Sacar(valor);
		}
		return cardinalidad;
	}

	// 3f
	public void conjuntoGenerado_PilaCola(ConjuntoTDA resultado, PilaTDA P, ColaTDA C) {
		while (!P.PilaVacia()) {
			resultado.Agregar(P.Tope());
			P.Desapilar();
		}
		while (!C.ColaVacia()) {
			resultado.Agregar(C.Primero());
			C.Desacolar();
		}
	}

	// 3g
	public boolean elementosIguales_PilaCola(PilaTDA P, ColaTDA C) {
		ConjuntoTDA pilaConjunto = new Conjunto();
		ConjuntoTDA colaConjunto = new Conjunto();
		colaConjunto.InicializarConjunto();
		pilaConjunto.InicializarConjunto();
		while (!P.PilaVacia()) {
			pilaConjunto.Agregar(P.Tope());
			P.Desapilar();
		}

		while (!C.ColaVacia()) {
			colaConjunto.Agregar(C.Primero());
			C.Desacolar();
		}

		return conjuntosIguales(pilaConjunto, colaConjunto);
	}

	// <------INICIO METODOS COLA PRIORIDAD------>

	public void generarRecuperarColaPrioridad(ColaPrioridadTDA C, DiccionarioMultipleTDA DM) {
		while (!C.colaVacia()) {
			DM.agregar(C.prioridad(), C.primero());
			C.desacolar();
		}
	}

	// <------FIN METODOS COLA PRIORIDAD------>

	// <------INICIO METODOS DICCIONARIOS MULTIPLES------>

	public void mostrarDiccionarioMultiple(DiccionarioMultipleTDA DM) {
		ConjuntoTDA claves = new Conjunto();
		claves.InicializarConjunto();
		ConjuntoTDA valores = new Conjunto();
		valores.InicializarConjunto();

		claves = DM.claves();
		while (!claves.ConjuntoVacio()) {
			int claveUnitaria = claves.Elegir();
			claves.Sacar(claveUnitaria);
			valores = DM.recuperar(claveUnitaria);
			System.out.println("Clave: " + claveUnitaria);
			while (!valores.ConjuntoVacio()) {
				int valorUnitario = valores.Elegir();
				System.out.print(valorUnitario + ",");
				valores.Sacar(valorUnitario);
			}
			System.out.println();
		}
	}

	// 5a
	public void generarDiccionarioMultiple(DiccionarioMultipleTDA D1, DiccionarioMultipleTDA D2,
			DiccionarioMultipleTDA Dgenerado) {
		int claveUnitaria, valorUnitario;
		ConjuntoTDA claves = new Conjunto();
		claves.InicializarConjunto();
		ConjuntoTDA valores = new Conjunto();
		valores.InicializarConjunto();

		claves = D1.claves();
		while (!claves.ConjuntoVacio()) {
			claveUnitaria = claves.Elegir();
			claves.Sacar(claveUnitaria);
			valores = D1.recuperar(claveUnitaria); // obtenemos un conjunto de valores asociados a la clave del D1
			while (!valores.ConjuntoVacio()) {
				valorUnitario = valores.Elegir();
				Dgenerado.agregar(claveUnitaria, valorUnitario);
				valores.Sacar(valorUnitario);
			}
		}

		claves = D2.claves();
		while (!claves.ConjuntoVacio()) {
			claveUnitaria = claves.Elegir();
			claves.Sacar(claveUnitaria);
			valores = D2.recuperar(claveUnitaria); // obtenemos un conjunto de valores asociados a la clave del D2
			while (!valores.ConjuntoVacio()) {
				valorUnitario = valores.Elegir();
				Dgenerado.agregar(claveUnitaria, valorUnitario);
				valores.Sacar(valorUnitario);
			}
		}
	}

	// 5b
	public void generarDiccionarioCoincidente(DiccionarioMultipleTDA D1, DiccionarioMultipleTDA D2,
			DiccionarioMultipleTDA DMpuntoB) {
		ConjuntoTDA claves1 = D1.claves();
		ConjuntoTDA claves2 = D2.claves();
		int clave;
		while (!claves1.ConjuntoVacio()) {
			clave = claves1.Elegir();
			claves1.Sacar(clave);
			if (claves2.Pertenece(clave)) {
				int valor;
				ConjuntoTDA valores1 = D1.recuperar(clave);
				ConjuntoTDA valores2 = D2.recuperar(clave);
				while (!valores1.ConjuntoVacio()) {
					valor = valores1.Elegir();
					valores1.Sacar(valor);
					if (valores2.Pertenece(valor)) {
						DMpuntoB.agregar(clave, valor);
					}
				}
			}
		}
	}

	// 5c
	public void generarDiccionarioElementos_A_Clave(DiccionarioMultipleTDA D1, DiccionarioMultipleTDA D2,
			DiccionarioMultipleTDA DMpuntoC) {
		ConjuntoTDA claves1 = D1.claves();
		ConjuntoTDA claves2 = D2.claves();
		int clave, valor;
		while (!claves1.ConjuntoVacio()) {
			clave = claves1.Elegir();
			claves1.Sacar(clave);
			if (claves2.Pertenece(clave)) {
				ConjuntoTDA valores1 = D1.recuperar(clave);
				ConjuntoTDA valores2 = D2.recuperar(clave);
				while (!valores1.ConjuntoVacio()) {
					valor = valores1.Elegir();
					valores1.Sacar(valor);
					DMpuntoC.agregar(clave, valor);
				}
				while (!valores2.ConjuntoVacio()) {
					valor = valores2.Elegir();
					valores2.Sacar(valor);
					DMpuntoC.agregar(clave, valor);
				}

			}
		}
	}

	// <------FIN METODOS DICCIONARIOS MULTIPLES------>

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

	// 3b
	public boolean determinarHoja(ABBTDA arbol, int valorBuscado) {
		if (arbol.arbolVacio()) {
			return false; // no existen datos en el arbol
		} else {
			if (arbol.raiz() == valorBuscado) {
				if (arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio())
					return true; // si el valor no posee valores hijos (no es raiz) retorna verdadero
				else
					return false;
			} else {
				if (valorBuscado > arbol.raiz())
					return determinarHoja(arbol.hijoDer(), valorBuscado);
				else
					return determinarHoja(arbol.hijoIzq(), valorBuscado);
			}
		}
	}

	// 3c
	public int profundidadValor(ABBTDA arbol, int valorBuscado) {
		if (arbol.raiz() == valorBuscado)
			return 0;
		else {
			if (valorBuscado > arbol.raiz())
				return 1 + profundidadValor(arbol.hijoDer(), valorBuscado);
			else
				return 1 + profundidadValor(arbol.hijoIzq(), valorBuscado);
		}
	}

	// 3d
	public int menorValor(ABBTDA arbol) {
		if (arbol.arbolVacio())
			return 0;
		else {
			if (!arbol.hijoIzq().arbolVacio()) // si el arbol sigue teniendo valores
				return menorValor(arbol.hijoIzq());
			else
				return arbol.raiz();
		}
	}

	// 3e
	public int cantidadElementos(ABBTDA arbol) {
		if (arbol.arbolVacio())
			return 0;
		else
			return 1 + cantidadElementos(arbol.hijoDer()) + cantidadElementos(arbol.hijoIzq());
	}

	// 3f
	public int sumatoriaElementos(ABBTDA arbol) {
		if (arbol.arbolVacio())
			return 0;
		else {
			return arbol.raiz() + sumatoriaElementos(arbol.hijoDer()) + sumatoriaElementos(arbol.hijoIzq());
		}
	}

	// 3g
	public int sumatoriaCantHojas(ABBTDA arbol) {
		if (arbol.arbolVacio())
			return 0;
		else {
			if (arbol.hijoDer().arbolVacio() && arbol.hijoIzq().arbolVacio())
				return 1;
			else
				return sumatoriaCantHojas(arbol.hijoDer()) + sumatoriaCantHojas(arbol.hijoIzq());
		}
	}

	// 3h
	public int alturaArbol(ABBTDA arbol) {
		if (arbol.arbolVacio())
			return 0;
		else {
			if (alturaArbol(arbol.hijoDer()) > alturaArbol(arbol.hijoIzq()))
				return 1 + alturaArbol(arbol.hijoDer());
			else
				return 1 + alturaArbol(arbol.hijoIzq());
		}
	}

	// 3i
	public boolean igualForma(ABBTDA arbol, ABBTDA arbol2) {
		ColaTDA colaArbol = new Cola();
		ColaTDA colaArbol2 = new Cola();
		colaArbol.InicializarCola();
		colaArbol2.InicializarCola();
		cargarArbol(arbol, colaArbol);
		cargarArbol(arbol2, colaArbol2);
		while (!colaArbol.ColaVacia()) {
			if (colaArbol.Primero() != colaArbol2.Primero())
				return false;
			colaArbol.Desacolar();
			if (!colaArbol.ColaVacia())
				colaArbol2.Desacolar();
		}
		return true;
	}

	private void cargarArbol(ABBTDA arbol, ColaTDA cola) {
		if (!arbol.arbolVacio()) {
			cargarArbol(arbol.hijoDer(), cola);
			cola.Acolar(0);
			cargarArbol(arbol.hijoIzq(), cola);
			cola.Acolar(1);
		}
	}

	public boolean arbolesIguales (ABBTDA arbol, ABBTDA arbol2) {
		return false;
		
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
