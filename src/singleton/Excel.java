package singleton;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import biblioteca.Libros;
import biblioteca.Peliculas;

public class Excel {

	public static ArrayList<Libros> Libros() { // Metodo para crear Array de libros

		try {

			// Importamos Excel

			String excelFilePath = "C:\\Users\\EDUTECNO\\Documents\\Stefano Marin\\Biblioteca\\Articulos.xlsx";
			String hoja1 = "Libros";

			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

			// Instancia de libro
			// Trabajando con Hoja de Libros
			XSSFWorkbook libro1 = new XSSFWorkbook(inputStream);
			XSSFSheet primeraHoja = libro1.getSheet(hoja1);

			// Creamos las celdas
			XSSFCell celda1;
			XSSFCell celda2;
			XSSFCell celda3;
			XSSFCell celda4;
			XSSFCell celda5;
			XSSFCell celda6;

			ArrayList<Libros> librosF = new ArrayList<Libros>();

			// Iteracion para recorrer hoja excel, extraer las celdas y agregarlas a un
			// arreglo de libros.
			for (int i = 0; i < 6; i++) {
				XSSFRow fila1 = primeraHoja.getRow(i);

				for (int j = 0; j < 1; j++) {
					// ArrayList<XSSFCell> libros = new ArrayList<XSSFCell>();
					celda1 = fila1.getCell(j);
					celda2 = fila1.getCell(j + 1);
					celda3 = fila1.getCell(j + 2);
					celda4 = fila1.getCell(j + 3);
					celda5 = fila1.getCell(j + 4);
					celda6 = fila1.getCell(j + 5);

					Libros libro = new Libros(celda1.getStringCellValue(), celda2.getBooleanCellValue(),
							celda3.getNumericCellValue(), celda4.getNumericCellValue(), celda5.getNumericCellValue(),
							celda6.getStringCellValue());
					librosF.add(libro);

				}
			}

			// libro1.flush();
			libro1.close();
			inputStream.close();

			return librosF;

		} catch (Exception e) {
			System.out.println("");
			return null;
		}

	}

	public static ArrayList<Peliculas> Pelis() {

		try {

			// nombre de hoja del libro
			String excelFilePath2 = "C:\\Users\\EDUTECNO\\Documents\\Stefano Marin\\Biblioteca\\Articulos.xlsx";
			String hoja2 = "Peliculas";

			FileInputStream inputStream2 = new FileInputStream(new File(excelFilePath2));

			// Instancia de libro
			// Trabajando con Hoja de PELICULAS
			XSSFWorkbook libro2 = new XSSFWorkbook(inputStream2);
			XSSFSheet segundaHoja = libro2.getSheet(hoja2);

			// Creamos las celdas
			XSSFCell celda11;
			XSSFCell celda22;
			XSSFCell celda33;
			XSSFCell celda44;
			XSSFCell celda55;
			XSSFCell celda66;

			ArrayList<Peliculas> peliculasF = new ArrayList<Peliculas>();

			// Iteracion para recorrer hoja excel, extraer las celdas y agregarlas a un
			// arreglo de libros.
			for (int i = 0; i < 6; i++) {
				XSSFRow fila2 = segundaHoja.getRow(i);

				for (int j = 0; j < 1; j++) {
					// ArrayList<XSSFCell> peliculas = new ArrayList<XSSFCell>();
					celda11 = fila2.getCell(j);
					celda22 = fila2.getCell(j + 1);
					celda33 = fila2.getCell(j + 2);
					celda44 = fila2.getCell(j + 3);
					celda55 = fila2.getCell(j + 4);
					celda66 = fila2.getCell(j + 5);

					Peliculas pelicula = new Peliculas(celda11.getStringCellValue(), celda22.getBooleanCellValue(),
							celda33.getNumericCellValue(), celda44.getNumericCellValue(), celda55.getNumericCellValue(),
							celda66.getStringCellValue());
					peliculasF.add(pelicula);
				}
			}
			// Cerramos las instancias de excel
			libro2.close();
			inputStream2.close();

			return peliculasF;

		} catch (Exception e) {
			System.out.println("");
			return null;
		}

	}

}