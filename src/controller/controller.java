package controller;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


public class controller {


    public DefaultTableModel model_info(Object[][] students) {
        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(new String[]{"Nombre Completo", "Email", "Nota 1", "Nota 2", "Nota 3", "Nota 4", "Promedio"});

        for (Object[] student : students) {

            int[] notes = (int[]) student[2];
            double pro = 0;
            for (int note : notes) {
                pro += note;
            }

            model.addRow(new Object[]{student[0], student[1], notes[0], notes[1], notes[2], notes[3], (pro / notes.length)});
        }
        return model;
    }


}
