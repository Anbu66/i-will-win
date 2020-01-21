import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.FileChooserUI;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class mytra {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.myntra.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		File des=new File("D:\\Screenshots\\ss"+System.currentTimeMillis()+".png");
		
		FileUtils.copyFile(src, des);
		
		
		WebElement searchbox = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
		searchbox.sendKeys("Ray Ban Coolers"+Keys.ENTER);
		
		WebElement title = driver.findElement(By.xpath("(//a[@href='sunglasses/ray-ban/ray-ban-unisex-aviator-sunglasses-0rb3689914831/9855599/buy'])[2]"));
		String t = title.getText();
		System.out.println(t);
		
		/*File str=new File("D:\\file\\1.xlsx");
		//FileOutputStream str=new FileOutputStream("");
		Workbook w=new XSSFWorkbook();
		Sheet s = w.createSheet("Anbu");
		Row r = s.createRow(0);
		Cell c = r.createCell(0);
		c.setCellValue(t);
		
		FileOutputStream o=new FileOutputStream(str);
		w.write(o);*/
		
		Actions a=new Actions(driver);
		WebElement img = driver.findElement(By.xpath("//img[@title='Ray-Ban Unisex Aviator Sunglasses 0RB3689914831']"));
		a.moveToElement(img).build().perform();
		
		Thread.sleep(5000);
		
		WebElement addtocard = driver.findElement(By.xpath("(//span[@class='product-actionsButton product-addToBag'])[1]"));
		addtocard.click();
		Thread.sleep(5000);
		
		WebElement size = driver.findElement(By.xpath("(//button[@class='product-sizeButton'])[1]"));
		size.click();
		
		WebElement bag = driver.findElement(By.xpath("//span[@class='myntraweb-header-sprite desktop-iconBag sprites-headerBag']"));
		bag.click();
		Thread.sleep(5000);
		
		WebElement bagtitle = driver.findElement(By.xpath("//a[@class='itemContainer-base-itemLink']"));
		String res = bagtitle.getText();
		System.out.println(res);
	}

}
