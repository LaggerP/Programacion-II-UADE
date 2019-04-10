package Api;

public interface ColaPrioridadTDA {
	void acolarPrioridad (int p,int x);
    void desacolar();
    int primero();
    int prioridad();
    boolean colaVacia();
    void inicializarCola();
}
