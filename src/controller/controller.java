package controller;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


public class controller {


    public DefaultTableModel model_info(Object[][] students) {
        // Crear un nuevo modelo de tabla por defecto
        DefaultTableModel model = new DefaultTableModel();

        // Establecer los encabezados de las columnas de la tabla
        model.setColumnIdentifiers(new String[]{"No.", "Nombre Completo", "Email", "Nota 1", "Nota 2", "Nota 3", "Nota 4", "Promedio"});

        // Iterar a través de la matriz de estudiantes
        int i = 0;
        for (Object[] student : students) {
            // Obtener las notas del estudiante (asumiendo que están en el índice 2 del arreglo de objetos)
            int[] notes = (int[]) student[2];

            // Calcular el promedio de las notas
            double pro = 0;
            for (int note : notes) {
                pro += note;
            }

            // Agregar una fila al modelo de tabla con la información del estudiante y su promedio
            model.addRow(new Object[]{(i += 1), student[0], student[1], notes[0], notes[1], notes[2], notes[3], (pro / notes.length)});
        }

        // Devolver el modelo de tabla con los datos de los estudiantes y sus promedios
        return model;
    }


}
