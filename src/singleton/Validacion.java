package singleton;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import biblioteca.Usuarios;

public class Validacion {
	
	public static boolean validacion() {
		
		try {
			
			//nombre de hoja del libro
			String excelFilePath = "C:\\Users\\EDUTECNO\\Documents\\Stefano Marin\\Biblioteca\\Usuarios.xlsx";
			String hoja1 = "usuarios";
			
		    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		    
		    //Instancia de libro
		    XSSFWorkbook libro1 = new XSSFWorkbook(inputStream);
		    XSSFSheet primeraHoja = libro1.getSheet(hoja1);
		    
		    XSSFCell celda1;
		    XSSFCell celda2;
		    XSSFCell celda3;
		    
		    ArrayList<Usuarios> validacion = new ArrayList <Usuarios>();
		    
		    String  ingreso; //variables de opcion e ingreso
		    //double z;
			boolean a=true;
		    boolean b=true;
		    boolean c=true;
		    boolean usuarioValido=false;
	        Scanner sc = new Scanner(System.in);
	        int ingresoclave=0, d=-1; //variables y contador
	        
	    	for (int i = 0 ; i < 4 ; i++ ) {
	       		XSSFRow fila = primeraHoja.getRow(i);
	    		
	       			celda1 = fila.getCell(0);
	       			celda2 = fila.getCell(1);
	       			celda3 = fila.getCell(2);
//	System.out.println(fila.getCell(1));
	       			/*System.out.println(celda1.getStringCellValue());
	       			System.out.println(celda2.getNumericCellValue());
	       			System.out.println(celda3.getNumericCellValue());*/

	    			Usuarios filaX = new Usuarios(celda1.getStringCellValue(), celda2.getNumericCellValue(), celda3.getNumericCellValue());
	    			validacion.add(filaX);
	    			System.out.println(filaX.toString());
	       			}
	        
	    	do {
	    	   	System.out.println("Por favor ingrese su nombre (Ingrese \"Stefano\" para probar)");
	    	    ingreso = sc.nextLine();
	    	   	for (Usuarios x: validacion) {   
	    	   		d++;
	    	   		if(x.getNombre().equals(ingreso)) {
	    	   			a=false;
	    	   			do {System.out.println("Por favor ingrese su clave numerica (Ingrese \"1111\" para probar)");
	    	   				do {
	    	   				try {ingresoclave = Integer.parseInt(sc.nextLine());}
	    	   				catch (Exception e) {}
	    	   				finally {c=false;}
	    	   				}while(c);
	
	    	   			if(x.getClave()==ingresoclave) {
	    	   				b=false;
	    	   				usuarioValido=true;
	    	   				//z=x.getRut();
	    	   				}
	    	   			if (b) { //validacion de clave
	    	   				System.out.println("La clave es incorrecta, intentelo denuevo");
	    	           		}
	    	   			}while(b);
	    	   		}
	    	   	} 
	    	   	if (a) {
	    	   		System.out.println("El nombre no está registrado, intentelo denuevo");
	    	   		d=-1;
	    	   	}
	    	   }while(a);
	        

		    libro1.close();
		    inputStream.close();
		    
		    //return validacion;
		    return usuarioValido;
		    
			} catch (Exception e) {
			      System.out.println("");
			      return false;
			}

		}
		

	
}