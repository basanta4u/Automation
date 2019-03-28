package com.my.home.test.Selenium.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Test {


public static void main(String args[]) throws InterruptedException{

System.setProperty("webdriver.chrome.driver", "/Users/dwiba01/sw/"+"chromedriver");

ChromeOptions chromeOptions = new ChromeOptions();
//chromeOptions.s;



for (int i =50000;i<=90000; i++) {
WebDriver wd = new ChromeDriver(chromeOptions);
wd.get("http://dwiba01-w7:8080/QATestApp/helloworld/sendPostRequest.html");

wd.get("http://dwiba01-w7:8080/QATestApp/transactiontraces/ForwardServlet");

String text = Integer.toString(i);

System.out.println(wd.getTitle());

//wd.findElement(By.xpath("//form[@action='SocketServer']/p/input[@name='port']")).clear();
//wd.findElement(By.xpath("//form[@action='SocketServer']/p/input[@name='port']")).sendKeys(text);
//wd.findElement(By.xpath("//form[@action='SocketServer']/p/input[@name='start']")).click();

//wd.get("http://dwiba01-w7:8080/QATestApp/helloworld/SocketClient?&port="+text+"&submit=Start%20Client");

System.out.println("iteration number " + i);
//Thread.sleep(1000);

//wd.get("http://dwiba01-w7:8080/brtmtestapp/spa/#/red");
//Thread.sleep(1000);
//wd.get("http://dwiba01-w7:8080/brtmtestapp/spa/#/blue");
//Thread.sleep(1000);

wd.quit();



}

}
}