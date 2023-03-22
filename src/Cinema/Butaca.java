package Cinema;

import java.util.Objects;

public class Butaca {
    private int numFila;
    private int numAsiento;
    private String persona;

    public Butaca(int numFila, int numAsiento, String persona) throws IllegalArgumentException {
        if (numFila <= 0 || numAsiento <= 0) {
            throw new IllegalArgumentException("La fila y el número de asiento deben ser mayores que cero.");
        }
        this.numFila = numFila;
        this.numAsiento = numAsiento;
        this.persona = persona;
    }

    public int getNumFila() {
        return numFila;
    }

    public int getNumAsiento() {
        return numAsiento;
    }

    public String getPersona() {
        return persona;
    }
    @Override
	public int hashCode() {
		return Objects.hash(numFila, numAsiento);
	}

    @Override
    public boolean equals(Object obj) {
    	Butaca other = (Butaca) obj;
        if (this.numFila == other.numFila && this.numAsiento == other.numAsiento) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "Fila: " + this.numFila + ", Asiento: " + this.numAsiento + ", Persona: " + this.persona;
    }

    public void asignarPersona(String persona) throws IllegalStateException {
        if (this.persona != null) {
            throw new IllegalStateException("Esta butaca ya está ocupada.");
        }
        this.persona = persona;
    }
}
