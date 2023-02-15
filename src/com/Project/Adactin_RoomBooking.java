package com.Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class Adactin_RoomBooking 
{
	static WebDriver app; 
	public static void broswerLaunch() throws InterruptedException  
	{
		System.setProperty("webdriver.chrome.driver", "D:\\TESTING AND AUTOMATION\\JAVA\\ECLIPSE 2019-12\\S.AProjectTask_Adactin\\Driver\\chromedriver.exe");
		app=new ChromeDriver();
		app.manage().window().maximize();
		app.get("https://adactinhotelapp.com/");
		Thread.sleep(2000);	
	}
	public static void newRegister() throws InterruptedException 
	{
		app.findElement(By.xpath("//a[text()='New User Register Here']")).click();
		app.findElement(By.xpath("//input[@id='username']")).sendKeys("breadHHalwaa1000");
		app.findElement(By.xpath("//input[@id='password']")).sendKeys("Thalapakatti500");
		app.findElement(By.xpath("//input[@id='re_password']")).sendKeys("Thalapakatti500");
		app.findElement(By.xpath("//input[@id='full_name']")).sendKeys("RamPrasath");
		app.findElement(By.xpath("//input[@id='email_add']")).sendKeys("ramtvlogin01@gmail.com");
		Thread.sleep(15000);
		app.findElement(By.xpath("//input[@id='tnc_box']")).click();
		Thread.sleep(3000);
		app.findElement(By.xpath("//input[@id='Submit']")).click();
		Thread.sleep(15000);
		app.findElement(By.xpath("//a[text()='Click here to login']")).click();	
	}
	public static void login()
	{
		app.findElement(By.xpath("//input[@name='username']")).sendKeys("breadHHalwaa1000");
		app.findElement(By.xpath("//input[@name='password']")).sendKeys("Thalapakatti500");
		app.findElement(By.xpath("//input[@name='login']")).click();
	}
	public static void roomDetails() throws InterruptedException
	{
		WebElement area=app.findElement(By.xpath("//select[@name='location']"));
		Select loc=new Select(area);
		loc.selectByIndex(7);
		
		WebElement h=app.findElement(By.xpath("//select[@name='hotels']"));
		Select hotel=new Select(h);
		hotel.selectByIndex(2);
		
		WebElement r=app.findElement(By.xpath("//select[@name='room_type']"));
		Select room=new Select(r);
		room.selectByIndex(4);
		
		WebElement no=app.findElement(By.xpath("//select[@name='room_nos']"));
		Select noroom=new Select(no);
		noroom.selectByIndex(2);
		
		app.findElement(By.xpath("//input[@name='datepick_in']")).sendKeys("13/02/2023");
		app.findElement(By.xpath("//input[@name='datepick_out']")).sendKeys("15/02/2023");
		
		WebElement adult=app.findElement(By.xpath("//select[@name='adult_room']"));
		Select noadult=new Select(adult);
		noadult.selectByIndex(2);
		Thread.sleep(4000);
		
		app.findElement(By.xpath("//input[@name='Submit']")).click();
		Thread.sleep(3000);
		app.findElement(By.xpath("//input[@name='radiobutton_0']")).click();
		app.findElement(By.xpath("//input[@name='continue']")).click();
	}
	public static void roomBook() throws InterruptedException
	{

		app.findElement(By.xpath("//input[@name='first_name']")).sendKeys("RAM PRASATH");
		app.findElement(By.xpath("//input[@name='last_name']")).sendKeys("M");
		app.findElement(By.xpath("//textarea[@name='address']")).sendKeys("7-G, RainbowColony, Aathipatti, Chennai-18");
		app.findElement(By.xpath("//input[@name='cc_num']")).sendKeys("987456123012365478");
		
		WebElement c=app.findElement(By.xpath("//select[@name='cc_type']"));
		Select card=new Select(c);
		card.selectByIndex(2);
		
		WebElement mon=app.findElement(By.xpath("//select[@name='cc_exp_month']"));
		Select emon=new Select(mon);
		emon.selectByIndex(6);
		
		WebElement yr=app.findElement(By.xpath("//select[@name='cc_exp_year']"));
		Select eyear=new Select(yr);
		eyear.selectByVisibleText("2022");
		
		app.findElement(By.xpath("//input[@name='cc_cvv']")).sendKeys("108");
		Thread.sleep(4000);
		app.findElement(By.xpath("//input[@name='book_now']")).click();
		
		Thread.sleep(6000);
		app.findElement(By.xpath("//a[text()='Booked Itinerary']")).click();
	}
	
	public static void scrnshot() throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		TakesScreenshot fina=(TakesScreenshot) app;
		File ot=fina.getScreenshotAs(OutputType.FILE);
		File desi=new File("D:\\TESTING AND AUTOMATION\\JAVA\\ECLIPSE 2019-12\\S.AProjectTask_Adactin\\ScrnShott\\room.png");
		FileHandler.copy(ot, desi);
		Thread.sleep(1000);
	}
	public static void main(String[] args) throws InterruptedException, IOException
	{
		broswerLaunch();
//		newRegister();
		login();
		roomDetails();
		roomBook();
		scrnshot();
		
		app.findElement(By.xpath("//input[@name='logout']")).click();
		
		Thread.sleep(3000);
		TakesScreenshot log=(TakesScreenshot) app;
		File ott=log.getScreenshotAs(OutputType.FILE);
		File desii=new File("D:\\TESTING AND AUTOMATION\\JAVA\\ECLIPSE 2019-12\\S.AProjectTask_Adactin\\ScrnShott\\logout.png");
		FileHandler.copy(ott, desii);
		Thread.sleep(3000);
		app.navigate().refresh();
		app.quit();
	}

}
