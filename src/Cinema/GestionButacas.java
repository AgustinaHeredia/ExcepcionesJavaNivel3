package Cinema;

import java.util.ArrayList;

public class GestionButacas {

private ArrayList<Butaca> butacas;
    
    
    public GestionButacas() {
        butacas = new ArrayList<Butaca>();
    }
    
    
    public ArrayList<Butaca> getButacas() {
        return butacas;
    }
    
    
    public void añadirButaca(Butaca butaca) throws ExcepcioButacaOcupada {
       
        if (buscarButaca(butaca.getNumFila(), butaca.getNumAsiento()) != -1) {
            throw new ExcepcioButacaOcupada("La butaca ya está ocupada.");
        }
        butacas.add(butaca);
    }
    
   
    public void eliminarButaca(int fila, int asiento) throws ExcepcioButacaLibre {
        int posicion = buscarButaca(fila, asiento);
        if (posicion == -1) {
            throw new ExcepcioButacaLibre("La butaca ya está libre.");
        }
        butacas.remove(posicion);
    }
    
    public int buscarButaca(int fila, int asiento) {
        for (int i = 0; i < butacas.size(); i++) {
            Butaca butaca = butacas.get(i);
            if (butaca.getNumFila() == fila && butaca.getNumAsiento() == asiento) {
                return i;
            }
        }
        return -1;
    }
    
    /*public int buscarButacaPersona(String nombre) {
        for (int i = 0; i < butacas.size(); i++) {
            Butaca butaca = butacas.get(i);
            if (butaca.getPersona() == nombre ) {
                return i;
            }
        }
        return -1;
    }*/
}
