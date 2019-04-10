package Implementaciones.Estatico;

import Api.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {
	
	class Elem {
        int pr, valor;
    }
    Elem []v;
    int ult;

    public void inicializarCola(){
        ult = 0;
        v = new Elem [100];
    }

    public boolean colaVacia(){
        return (ult == 0);
    }

    public int primero(){
        return v[ult-1].valor;
    }
    
    public int prioridad(){
        return v[ult-1].pr;
    }

    public void desacolar(){
        ult--;
    }

    public void acolarPrioridad(int p, int x){
        Elem aux;
        boolean noCambio = false;
        v[ult] = new Elem();
        v[ult].pr = p;
        v[ult].valor = x;
        for (int i = ult; i>0 && !noCambio; i--){
            if (v[i].pr <= v[i-1].pr){
                aux = v[i];
                v[i] = v[i-1];
                v[i-1] = aux;
            }
            else
                noCambio=true;
        }
    }
	
}
