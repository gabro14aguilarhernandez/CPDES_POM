package com.metlife.provida.com.metlife.cpdes;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CpDesPage extends BaseCpdes { 
	
	
	public CpDesPage(WebDriver driver) {
		super(driver);
		
	}

	private ReadExelFile readFile;

	// Se copy los elementos del Login
	By usuario = By.id("UserIdInput");
	By contraseña = By.id("pwdtxt");
	By iniciarSesion = By.id("SignInButtonText");
	By txcontraseña = By.id("PASSWORD");
	// elementos de menu principal
	By etiquetaCpdes = By.cssSelector("#DES > div > div.card-body > h5");
	By ingresarCpdes = By.cssSelector("#DES .ml-button-primary");
	// elementos submenu
	By etiquetaInicio = By.xpath("/html/body/div[3]/div/div/div[1]/a[2]");
	By nuevoNegocio = By.xpath("//a[contains(text(),'NUEVOS NEGOCIOS')]");
	By etiquetaProvidaNuevoNegocio = By.cssSelector("#ngviewContainer > h3");
	// elementos inicio solicitud
	By abrirAcordion = By.cssSelector("#accordion-controller");
	// Informacion General del Solicitante titular
	By paternoTitular = By.id("lastNameText");
	By maternoTitular = By.id("secondLastNameText");
	By nombreTitular = By.id("firstNameText");
	By fechaNac = By.cssSelector("#titularDatepicker");
    By rfcTitular = By.id("rfcTitular");
    By botonRfc = By.id("rfcAcceptBtn");
    By sexoTitular = By.id("titularGender");
    By estadoCivilTitular = By.name("estadoCivil");
    By paisTitular = By.name("birthPlace"); 
    By nacionalidadTitular = By.name("nationalityCode");
    By numFijoTitular = By.id("fixedPhoneTitular");
    By numCelularTitular = By.id("cellPhoneTitular");
    By correoTitular = By.id("email");
    By confirmacionCorreoTitular = By.id("emailConfirmation");
    By sinCorreoTitular = By.id("noMail");
    By infoCorreoSi = By.id("receivedInfoYes");
    By calleTitular = By.id("streetTitular");
    By numExtTitular = By.id("exteriorNumberTitular");
    By numIntTitular = By.id("interiorNumberTitular");
    By codigoPostalTitular = By.id("zipCodeTitular");
    
    
    		
    		
    
	// Se agregan los Metodos con los pasos
	public void loginCpdes() throws IOException, InterruptedException {
	    readFile = new ReadExelFile();
	    String filepath = "C:\\Gabriel\\ProyectosIntellit\\src\\test\\Files\\Test.xlsx";
	    String user = readFile.getCellValue(filepath,"login",0,0);
	    String pass = readFile.getCellValue(filepath,"login",0,1);
	    System.out.println(user + " " + pass + "||");
	    type(user,usuario);
	    click(contraseña);
	    type(pass,txcontraseña);
	    click(iniciarSesion);
	    explicitWaitElementVisible(etiquetaCpdes);
	
	    String nomMenu  = getText(etiquetaCpdes);
	          
	    System.out.println(nomMenu);
	    Assert.assertEquals("CP-DES",nomMenu);
	    Thread.sleep(1500);
	
	}
	public void menuPrincipal () throws InterruptedException {
	   
	    click(ingresarCpdes);    // CLIC EN CP DES  
	    explicitWaitElementVisible(etiquetaInicio);
	    String nomSubMenu =getText(etiquetaInicio);
	    System.out.println(nomSubMenu + "||");
	    Assert.assertEquals("INICIO",nomSubMenu);
	    Thread.sleep(1500);
	}
	
	public void nuevoNegocio() {
		click(nuevoNegocio);
		explicitWaitElementVisible(etiquetaProvidaNuevoNegocio);
		String nuevoNegocio = getText(etiquetaProvidaNuevoNegocio);
		System.out.println(nuevoNegocio + "||");
		Assert.assertEquals("Provida Nuevo Negocio",nuevoNegocio);
	}
	
	public void acordion() throws InterruptedException {
	    click(abrirAcordion);  // abrir acordion
        Thread.sleep(5000);
	}
	
	public void seccionTitular() throws IOException, InterruptedException {
	
		String filepath = "C:\\Gabriel\\ProyectosIntellit\\src\\test\\Files\\Test.xlsx";
		String ApePatTitular = readFile.getCellValue(filepath,"login",0,2);
        String ApeMatTitular = readFile.getCellValue(filepath,"login",0,3);
        String NomTitular = readFile.getCellValue(filepath,"login",0,4);
        System.out.println(ApePatTitular + " " + ApeMatTitular+ " " + NomTitular+ "||");

        type(ApePatTitular, paternoTitular); // Apellido paterno
        type(ApeMatTitular, maternoTitular);  // Apellido materno
        type(NomTitular, nombreTitular); // Nombre

        String FecNacTitular = readFile.getCellValue(filepath,"login",0,5);
        String RfcTitular = readFile.getCellValue(filepath,"login",0,6);
        System.out.println(FecNacTitular + " " + RfcTitular + "||");
        
        type(FecNacTitular, fechaNac); // fecha Nacimiento
        type(RfcTitular, rfcTitular);  // rfc
        tab(rfcTitular);
        Thread.sleep(3000);
        click(botonRfc);
        
        String SexoTitular = readFile.getCellValue(filepath,"login",0,7);
        String EdoCivTitular = readFile.getCellValue(filepath,"login",0,8);
        System.out.println(SexoTitular + " " + EdoCivTitular + "||");
        Thread.sleep(1000);
        type(SexoTitular, sexoTitular); // sexo
        type(EdoCivTitular, estadoCivilTitular); // estado civil

        String PaisTitular = readFile.getCellValue(filepath,"login",0,9);
        String NacionalidadTitular = readFile.getCellValue(filepath,"login",0,10);
        System.out.println(PaisTitular + " " + NacionalidadTitular + "||");
        type(PaisTitular, paisTitular); // país 
        type(NacionalidadTitular, nacionalidadTitular); // nacionalidad
        
        String NumFijoTitular = readFile.getCellValue(filepath,"login",0,11);
        String NumCelTitular = readFile.getCellValue(filepath,"login",0,12);
        System.out.println(NumFijoTitular + " " + NumCelTitular + "||");
        type(NumFijoTitular, numFijoTitular);  // Num Fijo
        type(NumCelTitular, numCelularTitular); // celular

        String CorreoTitular = readFile.getCellValue(filepath,"login",0,13);
        System.out.println(CorreoTitular + "||");
        //driver.findElement(By.name("noMail")).sendKeys(Keys.SPACE); // sin correo

        type(CorreoTitular, correoTitular); //correo
        type(CorreoTitular, confirmacionCorreoTitular);   //confirmacion correo
        tab(confirmacionCorreoTitular);
        tab(sinCorreoTitular);
        Thread.sleep(1000);
        click(infoCorreoSi);
        Thread.sleep(1000);
      //  driver.findElement(By.id("receivedInfoYes")).sendKeys(Keys.TAB);

        String CalleTitular = readFile.getCellValue(filepath,"login",0,14);
        String NumExTitular = readFile.getCellValue(filepath,"login",0,15);
        String NumIntTitular = readFile.getCellValue(filepath,"login",0,16);
        String CPTitular = readFile.getCellValue(filepath,"login",0,17);
        System.out.println(CalleTitular + " " + NumExTitular + "||");
        System.out.println(NumIntTitular + " " + CPTitular + "||");
        type(CalleTitular, calleTitular); // calle
        type(NumExTitular, numExtTitular);  // numero
        type(NumIntTitular, numIntTitular); // numero Interior
        type(CPTitular, codigoPostalTitular); // codigo postal
  //      Thread.sleep(1000);
        tab(codigoPostalTitular);
        Thread.sleep(1000); 
        

	}
	
	
	
	
}
