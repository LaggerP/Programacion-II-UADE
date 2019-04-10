package Api;

public interface DiccionarioMultipleTDA {
	 void inicializarDiccionario();
	 void agregar(int c, int x);
	 void eliminar (int c);
	 ConjuntoTDA claves();
	 ConjuntoTDA recuperar (int c);
	 void EliminarElem(int c, int x);
}
