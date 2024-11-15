package lab_5;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MarcoSeleccionMultiple extends JFrame 
{
    private final JList<String> listaJListColores; // lista para guardar los nombres de los colores
    private final JList<String> listaJListCopia; // lista en la que se van a copiar los nombres de los colores
    private JButton botonJButtonCopiar; // botón para copiar los nombres seleccionados
    private static final String[] nombresColores = {"Negro", "Azul", "Cyan", 
        "Gris oscuro", "Gris", "Verde", "Gris claro", "Magenta", 
        "Naranja", "Rosa", "Rojo", "Blanco", "Amarillo"};

    // Constructor de MarcoSeleccionMultiple
    public MarcoSeleccionMultiple()
    {
        super("Adrian y Romario"); // Título de la ventana actualizado
        setLayout(new FlowLayout());
        
        listaJListColores = new JList<String>(nombresColores); // lista de colores
        listaJListColores.setVisibleRowCount(5); // muestra cinco filas
        listaJListColores.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(listaJListColores)); // agrega lista con panel de desplazamiento
        
        botonJButtonCopiar = new JButton("Copiar >>>");
        botonJButtonCopiar.addActionListener(
            new ActionListener() // clase interna anónima 
            { 
                // maneja evento de botón
                @Override
                public void actionPerformed(ActionEvent evento)
                {
                    // coloca los valores seleccionados en listaJListCopia
                    listaJListCopia.setListData(
                        listaJListColores.getSelectedValuesList().toArray(new String[0]));
                } 
            }
        );

        add(botonJButtonCopiar); // agrega el botón copiar a JFrame
        
        listaJListCopia = new JList<String>(); // lista para guardar nombres de colores copiados
        listaJListCopia.setVisibleRowCount(5); // muestra 5 filas
        listaJListCopia.setFixedCellWidth(100); // establece la anchura
        listaJListCopia.setFixedCellHeight(15); // establece la altura
        listaJListCopia.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        add(new JScrollPane(listaJListCopia)); // agrega lista con panel de desplazamiento
    }
}
