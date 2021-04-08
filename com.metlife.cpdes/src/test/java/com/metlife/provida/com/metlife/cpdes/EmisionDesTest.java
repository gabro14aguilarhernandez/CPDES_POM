package com.metlife.provida.com.metlife.cpdes;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class EmisionDesTest {
	
	private WebDriver driver;
	
	CpDesPage cpDesPage;
		

	@Before
	public void setUp() throws Exception {
		
		cpDesPage = new CpDesPage(driver);
		 driver = cpDesPage.chromeDriverConnection();
		 cpDesPage.visit("https://qa.des.metlife.com/siteminderagent/forms/login.fcc?TYPE=33554433&REALMOID=06-000b658e-e0b3-1cd1-9874-676cac18f081&GUID=&SMAUTHREASON=0&METHOD=GET&SMAGENTNAME=-SM-bn0XuXYLjMjbjG7rOQsvMxqyJML9f1COY95TRujXyImDZja2DrQ%2bNsBaVPwHDRZC&TARGET=-SM-https%3a%2f%2fqa%2edes%2emetlife%2ecom%2fdes%2f");
	        driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception  {
	}

	@Test
	public void test() throws IOException, InterruptedException {
		cpDesPage.loginCpdes();
		cpDesPage.menuPrincipal();
		cpDesPage.nuevoNegocio();
		cpDesPage.acordion();		
		cpDesPage.seccionTitular();
	}

}
