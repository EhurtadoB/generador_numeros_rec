/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Eleana Hurtado
 */
public class MetodosExcel {

    // Función para importar y leer el archivo excel
    public String[][] leerExcel(File archivo) throws FileNotFoundException, IOException {

        // Nombre del archivo
        String fileName = archivo.getName();

        // Tabla matríz para guardar los datos del Excel
        String[][] datatable = null;

        try {
            InputStream myFile = new FileInputStream(archivo);

            // Si el archivo es de tipo xls se utiliza la librería HSSF
            if (fileName.endsWith(".xls")) {

                // Creamos el libro a partir del archivo
                HSSFWorkbook wb = new HSSFWorkbook(myFile);

                // Establecemos la hoja
                HSSFSheet sheet = wb.getSheetAt(0);

                // Establecemos las celdas y las columnas
                HSSFCell cell;
                HSSFRow row;

                // Obtenemos el número de filas y de columnas
                int numRows = sheet.getLastRowNum() + 1;
                int numCols = sheet.getRow(0).getLastCellNum();

                // Creamos la matriz del tamaño correspondiente
                datatable = new String[numRows][numCols];

                // Llenamos la matríz con cada elemento del Excel
                for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
                    row = sheet.getRow(i);
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        cell = row.getCell(j);
                        datatable[i][j] = cell.toString();
                    }
                }

                // Si el archivo es de tipo xlsx se utiliza la librería XSSF
            } else if (fileName.endsWith(".xlsx")) {

                // Creamos el libro a partir del archivo
                XSSFWorkbook wb = new XSSFWorkbook(myFile);

                // Establecemos la hoja
                XSSFSheet sheet = wb.getSheetAt(0);

                // Establecemos las celdas y las columnas
                XSSFCell cell;
                XSSFRow row;

                // Obtenemos el número de filas y de columnas
                int numRows = sheet.getLastRowNum() + 1;
                int numCols = sheet.getRow(0).getLastCellNum();

                // Creamos la matriz del tamaño correspondiente
                datatable = new String[numRows][numCols];

                // Llenamos la matríz con cada elemento del Excel
                for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
                    row = sheet.getRow(i);
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        cell = row.getCell(j);
                        datatable[i][j] = cell.toString();
                    }
                }

            } else {
                // Si no es xls ni xlsx, no es un tipo de archivo compatible
                JOptionPane.showMessageDialog(null, "Error: Tipo de archivo inválido.");
            }

        } catch (IOException e) {
            // En caso de una excepción imprime el error
            System.out.println(e.getMessage());
        }

        // Retornamos la matríz tabla
        return datatable;
    }

    // Función para retornar los valores de la tabla de excel
    public String[][] valoresExcel() throws IOException {

        // Variables para la matrz de la tabla y la matríz traspuesta
        String[][] datatable = null;
        String[][] datatableT = null;

        // Objeto para abrir el explorador de archivos y escoger uno
        JFileChooser fileChooser = new JFileChooser();

        // Muestra archivos y carpetas
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        // Filtramos que los tipos de archivos disponibles sean solo xls y xlsx
        FileNameExtensionFilter archivoFilter = new FileNameExtensionFilter("Excel (*.xls, *.xlsx)", "xls", "xlsx");
        fileChooser.setFileFilter(archivoFilter);

        // Creamos objeto archivo
        File file;

        // Al seleccionar el archivo
        if (fileChooser.showDialog(null, "Seleccionar archivo") == JFileChooser.APPROVE_OPTION) {

            // Nuestro objeto archivo creado es igual al seleccionado
            file = fileChooser.getSelectedFile();

            // Si el archivo es de tipo xls o xlsx
            if (file.getName().endsWith("xls") || file.getName().endsWith("xlsx")) {

                // Llenamos una matríz con los registros del archivo
                datatable = leerExcel(file);

                // Creamos una matríz con las mismas dimensiones que será la traspuesta
                datatableT = new String[datatable[0].length][datatable.length];

                // Si no es el tipo de archivo correcto se notifica al usuario
            } else {
                JOptionPane.showMessageDialog(null, "Elija un formato válido.");
            }
        }

        // Llenamos la matríz traspuesta con los registros de la primera tabla
        // (traspuesta: intercambiamos filas x columnas)
        for (int i = 0; i < datatable.length; i++) {
            for (int j = 0; j < datatable[i].length; j++) {
                datatableT[j][i] = datatable[i][j];
            }
        }

        // Retornamos la matríz traspuesta
        return datatableT;

    }
}
