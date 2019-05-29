package seleniumscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SuccessfullSigning {

	public static void main(String[] args) throws IOException, InterruptedException {
		
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
	    options.addArguments("disable-infobars");
        options.addArguments("--start-maximized");
	    options.addArguments("--remote-debugging-port=9222");
	    options.setExperimentalOption("useAutomationExtension", false);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		
		System.setProperty("webdriver.ie.driver", "C:\\Users\\C55586\\IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		
		
		
	    try {
	        FileInputStream fis = new FileInputStream("C:\\Users\\C55586\\dataSheet.xlsx");
	 
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		                         //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
		                         //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
		 Row row = sheet.getRow(2);
		 Cell cell = row.getCell(0);
		 
		 Row row1 = sheet.getRow(1);
		 Cell url	=row1.getCell(1);
		 System.out.println(cell);
//		 System.out.println(sheet.getRow(1).getCell(2));
	//	
		 String cellval = cell.getStringCellValue();
		 String url_value =url.getStringCellValue();
		 System.out.println(cellval);
		 driver.get(url_value);
		 
		 driver.manage().timeouts().implicitlyWait(40 , TimeUnit.SECONDS);
		 
		 driver.findElement(By.name("ondertekenCode")).clear();
		 driver.findElement(By.name("ondertekenCode")).click();
		 
		 driver.findElement(By.name("ondertekenCode")).sendKeys(cellval);
	 
		 driver.findElement(By.xpath("//button[@label='button:labelSubmitButton' ]")).click();
		 
		 driver.manage().timeouts().implicitlyWait(40 , TimeUnit.SECONDS);
		 
		 driver.findElement(By.xpath("//button[@label='button:next' ]")).click();
		
		 driver.findElement(By.xpath("//button[@label='button:sign' ]")).click();
		 
		 driver.manage().timeouts().implicitlyWait(120 , TimeUnit.SECONDS);
		 
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 
		 driver.findElement(By.xpath("//button[@class='button button-solid button-confirm']")).click();
		 
		 driver.manage().timeouts().implicitlyWait(180 , TimeUnit.SECONDS);
		 
		 driver.close();
		 }
		 catch (FileNotFoundException e) {
		              // TODO Auto-generated catch block
		              e.printStackTrace();
		        }

	    

	}
	
}
