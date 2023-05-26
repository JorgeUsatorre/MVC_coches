import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JPanel panel1;
    private JButton bCrear;
    private JTextField tModelo;
    private JTextField tMatricula;
    private JLabel eModelo;
    private JLabel eMatricula;
    private JButton button1;
    private JButton button2;


    /**
     * Constructor de la clase GUI.
     */
    public GUI() {
        bCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.crearCoche(tModelo.getText(),tMatricula.getText());
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.bajarVelocidad(tMatricula.getText());
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.aumentarVelocidad(tMatricula.getText());
            }
        });
    }

    /**
     * Crea y muestra la ventana principal de la interfaz gráfica.
     */
    public static void crearVentana() {
        JFrame frame = new JFrame("Ventana coches");
        frame.setContentPane(new GUI().panel1);
        frame.setDefaultCloseOperation(3);
        frame.pack();
        frame.setVisible(true);
    }
}
