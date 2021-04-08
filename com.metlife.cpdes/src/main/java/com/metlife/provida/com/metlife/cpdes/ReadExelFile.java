package com.metlife.provida.com.metlife.cpdes;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExelFile {

	// este metodo lee una hoja de exel fila por fila y cada una de las celdas por fila
	    public void readExel(String filepath, String sheetName) throws IOException {
	       // filepath=el camino del fichero      Sheetname=Nombre de la hoja
	        File file = new File (filepath);
	        FileInputStream inputStream = new FileInputStream(file);
	       // objedo dond ese uarda el libro de Exel
	        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
	        // objedo donde se guarda la hoja con la que estamos trabajando
	        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
	        // valiable rowcount=# de filas del exel
	        int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();
	        for (int i=0; i <= rowCount; i ++ ){
	           // se crea el objeto fila que va leyendo fila a fila de la hoja
	            XSSFRow row = newSheet.getRow(i);
	            // ya estando en la fila se itera sobre todas las celdas de esa fila, row.getLastCellNum=cantidad de celdas que tiene la fila
	            for (int j=0; j < row.getLastCellNum(); j ++ ){
	                // dame el valor de la celda
	                System.out.println(row.getCell(j).getStringCellValue() + "||");
	            }
	        }
	    }
	 // Metodo que permite leer una celda especifica
	    public String getCellValue(String filepath, String sheetName, int rowNumber, int cellNumber) throws IOException {
	        // Se crea el archivo, filepath=el camino del fichero      Sheetname=Nombre de la hoja
	        File file = new File (filepath);
	        FileInputStream inputStream = new FileInputStream(file);
	        // Se crea el libro y se le pasa el dato, objedo dond ese guarda el libro de Exel
	        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
	        // Se crea la hoja y se le pasa el nombre de la hoja, objedo donde se guarda la hoja con la que estamos trabajando
	        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
	        // para leer el dato de una celda especifica se crea
	        XSSFRow row = newSheet.getRow(rowNumber);  // filla

	        XSSFCell cell = row.getCell(cellNumber);   // #celda
	        return cell.getStringCellValue() ;



	    }

}
