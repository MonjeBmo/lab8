import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import controller.controller;

public class Main {
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

    int counter = 0;
    Object[][] data = new Object[0][];
    ArrayList<Object[]> students = new ArrayList<>();


    public void btnActionAddInfo() {
        String name = txt_name.getText();
        String lastname = txt_lastname.getText();
        String email = txt_email.getText();

        if (name.isEmpty() || lastname.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos");
            return;
        }

        int notes[] = new int[]{
                Integer.parseInt(JOptionPane.showInputDialog("Ingrese nota 1")),
                Integer.parseInt(JOptionPane.showInputDialog("Ingrese nota 2")),
                Integer.parseInt(JOptionPane.showInputDialog("Ingrese nota 3")),
                Integer.parseInt(JOptionPane.showInputDialog("Ingrese nota 4")),
        };

        Object[] studentData = new Object[]{name + " " + lastname, email, notes};

        if (counter >= data.length) {
            // Crear una nueva matriz más grande
            Object[][] newData = new Object[data.length + 1][];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[counter] = studentData;
        students.add(new Object[]{name + " " + lastname, email, notes});
        table_info.setModel(new controller().model_info(data));
        counter++;
    }


    DefaultTableModel model_table() {
        DefaultTableModel model_base = new DefaultTableModel();
        model_base.setColumnIdentifiers(new String[]{"No.1","Nombre Completo", "Email", "Nota 1", "Nota 2", "Nota 3", "Nota 4", "Promedio"});
        return model_base;
    }

    public Main() {
        JFrame frame = new JFrame("Elementos de la GUI - Arreglos");
        table_info.setModel(model_table());
        table_info.setEnabled(false);
        jScrollPane1.setViewportView(table_info);

        frame.setContentPane(root);
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnActionAddInfo();
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



