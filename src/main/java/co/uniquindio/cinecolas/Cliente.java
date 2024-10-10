package co.uniquindio.cinecolas;

public class Cliente implements Comparable<Cliente>{

    private String nombre;
    private int prioridad; // 1 ---> VIP, 2 ---> Normal

    public Cliente(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Cliente otroCliente) {
        return Integer.compare(this.prioridad, otroCliente.getPrioridad());
    }

    @Override
    public String toString() {
        return nombre + " (La Prioridad es: " + (prioridad == 1 ? "VIP" : "Regular") + ")";
    }
}
