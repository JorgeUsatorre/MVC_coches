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
    private JButton mostrarCocheButton;

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
        mostrarCocheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.buscarCoche(tMatricula.getText());
            }
        });
    }

    /***
     * Inicia la interfaz grafica
     */
    public static void crearVentana() {
        JFrame frame = new JFrame("Ventana coches");
        frame.setContentPane(new GUI().panel1);
        frame.setDefaultCloseOperation(3);
        frame.pack();
        frame.setVisible(true);
    }
}
