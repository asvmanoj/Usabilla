package seleniumscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Exceldata {
	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--dns-prefetch-disable");
    options.addArguments("--always-authorize-plugins");
    options.addArguments("--incognito");
    options.addArguments("--window-size=800,600");
    options.addArguments("--ignore-certificate-errors");
    options.addArguments("--ignore-ssl-errors");
    options.addArguments("--ssl-protocol=any");
    options.addArguments("--allow-insecure-localhost");
    options.addArguments("--allow-running-insecure-content");
    options.addArguments("--no-sandbox");
    options.addArguments("--v");
    options.addArguments("--disable-setuid-sandbox");
    options.addArguments("--disable-extensions");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--remote-debugging-port=9222");
    options.setExperimentalOption("useAutomationExtension", false);
	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	
	System.setProperty("webdriver.ie.driver", "C:\\Users\\C55586\\IEDriverServer.exe");
	WebDriver driver=new InternetExplorerDriver();
	driver.get("http://portal-c61.nl.eu.abnamro.com:9997/portalserver/my-abnamro/self-service/sign/index.html");
	
	
	driver.findElement(By.xpath("//input[@name='ondertekenCode']")).clear();
	driver.findElement(By.xpath("//input[@name='ondertekenCode']")).click();
    try {
        FileInputStream fis = new FileInputStream("C:\\Users\\C55586\\dataSheet.xlsx");
 
	 XSSFWorkbook workbook = new XSSFWorkbook(fis);
	 XSSFSheet sheet = workbook.getSheetAt(0);
	                         //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
	                         //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
	 Row row = sheet.getRow(2);
	 Cell cell = row.getCell(0);
	 System.out.println(cell);
//	 System.out.println(sheet.getRow(1).getCell(2));
//	
	 String cellval = cell.getStringCellValue();
	 System.out.println(cellval);
	 driver.findElement(By.name("ondertekenCode")).sendKeys(cellval);
	 }
	 catch (FileNotFoundException e) {
	              // TODO Auto-generated catch block
	              e.printStackTrace();
	        }

    driver.findElement(By.xpath("//div[@id='main']/div/div/div/div/div/div/div/div[3]/div/aab-widget/div/div/div[2]/ui-view/aab-widget-module/div/div/form/button/span")).click();
    
    driver.close();

 }
	}

