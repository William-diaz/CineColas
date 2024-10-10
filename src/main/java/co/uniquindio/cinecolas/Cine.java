package co.uniquindio.cinecolas;

import java.util.PriorityQueue;

public class Cine {

    private PriorityQueue<Cliente> colaClientes;

    public Cine() {
        colaClientes = new PriorityQueue<>();
    }

    public void agregarCliente(Cliente cliente){
        colaClientes.add(cliente);
    }

    public Cliente atenderAlCliente(){
        return colaClientes.poll();
    }
    public PriorityQueue<Cliente> obtenerLaCola(){
        return new PriorityQueue<>(colaClientes);
    }
}
