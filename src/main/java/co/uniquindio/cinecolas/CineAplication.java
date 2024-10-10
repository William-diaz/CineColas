package co.uniquindio.cinecolas;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.PriorityQueue;

public class CineAplication extends Application {

    private Cine cine;
    private ListView<String> listaClientes;

//----------------------------------------------------------------------------------------------------------------------
        //ESPECIFICACIONES DE LA INTERFAZ://
//----------------------------------------------------------------------------------------------------------------------

    @Override
    public void start(Stage primaryStage) {
        cine = new Cine();

        // Título
        Label tituloLabel = new Label("COLA DE CINE UNIQUINDIO");
        tituloLabel.setFont(Font.font("Arial", FontWeight.BOLD, 25));

        // Label y campo de texto para el nombre del cliente
        Label nombreLabel = new Label("Nombre del Cliente:");
        TextField nombreField = new TextField();
        nombreField.setPromptText("Ingrese el nombre del cliente");

        // Colocar el label y el campo de texto en un HBox
        HBox nombreLayout = new HBox(10, nombreLabel, nombreField);

        // Combobox para la prioridad del cliente
        ComboBox<String> prioridadBox = new ComboBox<>();
        prioridadBox.getItems().addAll("VIP", "Normal");
        prioridadBox.setValue("Normal");

        // Botón para agregar cliente
        Button agregarButton = new Button("Agregar Cliente");
        agregarButton.setOnAction(e -> agregarCliente(nombreField.getText(), prioridadBox.getValue()));

        // ListView para mostrar los clientes
        listaClientes = new ListView<>();

        // Botón para atender cliente
        Button atenderButton = new Button("Atender Cliente");
        atenderButton.setOnAction(e -> atenderCliente());

        // Layout principal con padding y más espacio entre los elementos
        VBox layout = new VBox(15, tituloLabel, nombreLayout, prioridadBox, agregarButton, listaClientes,
                atenderButton);

        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 450);

        primaryStage.setTitle("Gestión de Clientes Cine UQ  :D ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

//----------------------------------------------------------------------------------------------------------------------
    // METODOS IMPORTANTES PARA LA APLICACIÓN:  //
//----------------------------------------------------------------------------------------------------------------------

    // Funcion para agregar clientes
    private void agregarCliente(String nombre, String prioridad) {
        int priori = prioridad.equals("VIP") ? 1 : 2;
        Cliente cliente = new Cliente(nombre, priori);
        cine.agregarCliente(cliente);
        actualizarLista();
    }

//----------------------------------------------------------------------------------------------------------------------

    private void atenderCliente() {

        Cliente atendido = cine.atenderAlCliente();
        if (atendido != null) {
            mostrarMensaje("El Cliente ha sido Atendido", "Se atendió al cliente llamado "
                    + atendido.getNombre());
        }
        actualizarLista();
    }


//----------------------------------------------------------------------------------------------------------------------

    // Función para actualizar la lista con los nombres
    private void actualizarLista() {

        listaClientes.getItems().clear();
        PriorityQueue<Cliente> cola = cine.obtenerLaCola();
        for (Cliente cliente : cola) {
            listaClientes.getItems().add(cliente.toString());
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    //Se muestra un mensaje cuando se atiende un cliente
    private void mostrarMensaje(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

//----------------------------------------------------------------------------------------------------------------------

    //Ejecutar la app
    public static void main(String[] args) {
        launch(args);
    }
}
