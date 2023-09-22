import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import controller.controller;

public class Main {
    // Declaración de componentes GUI
    private JTextField txt_name;
    private JTable table_info;
    private JButton btn_save;
    private JButton btn_cls;
    private JPanel root;
    private JLabel lb_name;
    private JLabel lb_lastname;
    private JLabel lb_email;
    private JTextField txt_email;
    private JTextField txt_lastname;
    private JScrollPane jScrollPane1;

    // Declaración de variables
    int counter = 0;
    Object[][] data = new Object[0][];
    ArrayList<Object[]> students = new ArrayList<>();

    // Método para agregar información de estudiantes
    public void btnActionAddInfo() {
        // Obtener datos de los campos de texto
        String name = txt_name.getText();
        String lastname = txt_lastname.getText();
        String email = txt_email.getText();

        // Validar que se ingresen todos los datos
        if (name.isEmpty() || lastname.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos");
            return;
        }

        int[] notes = new int[4];  // Crear un arreglo para almacenar 4 notas.

        for (int i = 0; i < 4; i++) {
            boolean validInput = false;

            while (!validInput) {
                String input = JOptionPane.showInputDialog("Ingrese nota " + (i + 1));  // Solicitar al usuario ingresar una nota.

                try {
                    int note = Integer.parseInt(input);  // Intentar convertir la entrada del usuario a un entero.

                    if (note >= 0 && note <= 100) {  // Verificar si la nota está dentro del rango válido (0-100).
                        notes[i] = note;  // Almacenar la nota en el arreglo.
                        validInput = true;  // Marcar la entrada como válida y salir del bucle while.
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese una nota entre 0 y 100.");  // Mostrar un mensaje de error si la nota no está en el rango válido.
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");  // Mostrar un mensaje de error si la entrada no es un número válido.
                }
            }
        }


        // Crear un objeto con los datos del estudiante
        Object[] studentData = new Object[]{name + " " + lastname, email, notes};

        if (counter >= data.length) {
            // Crear una nueva matriz más grande si es necesario
            Object[][] newData = new Object[data.length + 1][];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }

        // Agregar los datos a la matriz y a la lista de estudiantes
        data[counter] = studentData;
        students.add(new Object[]{name + " " + lastname, email, notes});

        // Actualizar el modelo de la tabla
        table_info.setModel(new controller().model_info(data));
        counter++;
    }

    // Método para crear el modelo de la tabla
    DefaultTableModel model_table() {
        DefaultTableModel model_base = new DefaultTableModel();
        model_base.setColumnIdentifiers(new String[]{"No.1", "Nombre Completo", "Email", "Nota 1", "Nota 2", "Nota 3", "Nota 4", "Promedio"});
        return model_base;
    }

    void Btn_cls() {
        // Limpiar los campos de texto
        txt_name.setText("");
        txt_lastname.setText("");
        txt_email.setText("");
    }


    // Constructor de la clase
    public Main() {
        // Configuración de la ventana principal
        JFrame frame = new JFrame("Elementos de la GUI - Arreglos");
        table_info.setModel(model_table());
        table_info.setEnabled(false);
        jScrollPane1.setViewportView(table_info);

        frame.setContentPane(root);
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Configuración del botón "Guardar"
        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnActionAddInfo();
            }
        });
        btn_cls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Btn_cls();
            }
        });
    }

    public static void main(String[] args) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc="Code Setting View">

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Main main = new Main();
    }

}



