package principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import biblioteca.*;

import singleton.*;

public class Main {

	public static void main(String[] args) throws IOException {

		// Singleton usuarios
		if (Validacion.validacion() == true) {
			System.out.println("El usuario está registrado");
		}

		// Metodos desde clase Excel
		System.out.println(Excel.Libros());
		System.out.println(Excel.Pelis());

		// Variable para leer datos ingresados por usuario
		Scanner sc = new Scanner(System.in);

		// Booleans para salidas y entradas del menu
		boolean menuSalir = true;

		// Ints y Strings para asignaciones e interaciones
		int menu = 0;
		String busqueda = "";
		int codigo;

		while (menuSalir == true) {

			// Menu Principal
			System.out.println("1.- Reservar un articulo");
			System.out.println("2.- Buscar un articulo");
			System.out.println("0.- Salir");
			menu = Integer.parseInt(sc.nextLine());

			// Ejecutamos los IF segun opcion elegida por usuario

			if (menu == 0) {
				menuSalir = false;
				System.out.println("Saliendo del Programa");
				System.exit(0);
			}

			if (menu == 1) {

				System.out.println("Ingrese el código del artículo.");
				codigo = Integer.parseInt(sc.nextLine());

				// Recorremos el Array e instanciamos nuevamente el excel para obtener el codigo
				// del articulo
				for (int i = 0; i < Excel.Libros().size(); i++) {

					// Trabajando con Hoja de LIBROS
					String excelFilePath = "C:\\Users\\EDUTECNO\\Documents\\Stefano Marin\\Biblioteca\\Articulos.xlsx";
					String hoja1 = "Libros";

					FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

					XSSFWorkbook libro1 = new XSSFWorkbook(inputStream);
					XSSFSheet primeraHoja = libro1.getSheet(hoja1);
					XSSFRow filaL = primeraHoja.getRow(i);
					XSSFCell celdaL = filaL.getCell(2);

					// Comparamos el codigo ingresado por el usuario con el que está en el excel
					if (codigo == celdaL.getNumericCellValue()) {

						XSSFCell reservaL = filaL.getCell(1);

						// En caso de que la celda tenga un valor FALSO, se procede a hacer la reserva
						if (reservaL.getBooleanCellValue() == false) {
							reservaL.setCellValue(true);
							System.out.println("Reserva Finalizada");
							FileOutputStream guardar = new FileOutputStream(excelFilePath);
							libro1.write(guardar);
							guardar.flush();
							guardar.close();
							libro1.close();
							inputStream.close();
							break;

							// Si el articulo está reservado, se le solicita al usuario reservar articulo
							// disponible
						} else {
							System.out.println("El Libro ya se encuentra reservado");
							System.out.println("Favor reservar libro que se encuentre disponible");
							break;
						}
					}

					// TRABAJANDO CON HOJA PELICULAS
					String hoja2 = "Peliculas";
					XSSFSheet segundaHoja = libro1.getSheet(hoja2);
					XSSFRow filaP = segundaHoja.getRow(i);
					XSSFCell celdaP = filaP.getCell(2);

					// Comparamos el codigo ingresado por el usuario con el que está en el excel
					if (codigo == celdaP.getNumericCellValue()) {

						XSSFCell reservaP = filaP.getCell(1);

						// En caso de que la celda tenga un valor FALSO, se procede a hacer la reserva
						if (reservaP.getBooleanCellValue() == false) {
							reservaP.setCellValue(true);
							System.out.println("Reserva Finalizada");
							FileOutputStream guardar = new FileOutputStream(excelFilePath);
							libro1.write(guardar);
							guardar.flush();
							guardar.close();
							libro1.close();
							inputStream.close();
							break;

							// Si el articulo está reservado, se le solicita al usuario reservar articulo
							// disponible
						} else {
							System.out.println("La pelicula ya se encuentra reservada");
							System.out.println("Favor reservar pelicula que se encuentre disponible");
							break;
						}
					}
				}

			}

			// Opcion de busqueda
			if (menu == 2) {
				System.out.println("Ingrese un nombre para buscar en la lista.");
				busqueda = sc.nextLine();
				System.out.println("Buscando articulos con " + busqueda + " en su nombre");

				// Recorremos el ArrayList, obtenemos el nombre y validamos si contiene lo
				// ingresado por usuario
				for (int i = 0; i < Excel.Libros().size(); i++) {
					if (Excel.Libros().get(i).getNombre().toLowerCase().contains(busqueda)) {
						// Imprimimos los resultados
						System.out.println(Excel.Libros().get(i));
					}

					if (Excel.Pelis().get(i).getNombre().toLowerCase().contains(busqueda)) {
						System.out.println(Excel.Pelis().get(i));
						System.out.println("Busqueda finalizada");
					}
				}
			}

		}
	}
}
