package org.test;
	import java.awt.AWTException;
	import java.awt.Desktop.Action;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.IOException;
	import java.util.List;

	import javax.lang.model.element.Element;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.interactions.internal.MouseAction;
	import org.openqa.selenium.remote.server.handler.SendKeys;
	import org.openqa.selenium.support.ui.Select;

	public class BaseClass {

		public static WebDriver driver;
		Actions acc;
		Select s;
		TakesScreenshot tk;
		Robot r;
		JavascriptExecutor js;
		Alert al;
		
		public WebDriver getdriver() {
			System.setProperty("webdriver.chrome.driver", "E:\\Eclipse\\BaseClass\\ChromeServer\\chromedriver.exe");
			driver=new ChromeDriver();
			return driver;

		}
		public void maximize() {
			driver.manage().window().maximize();

		}
		public void loadUrl(String url) {
			driver.get(url);
	    }
		public void type(WebElement element,String value) {
			element.sendKeys(value);

		}
		public void btnClick(WebElement element) {
			element.click();

		}
		public void quitBrowser() {
			driver.quit();

		}
		private void closeBrowser() {
			driver.close();

		}
	    public void Title() {
			String title = driver.getTitle();
			System.out.println(title);

		}
		public void getCurrentUrl() {
			String currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);

		}
		public void getText(WebElement element) {
			String text = element.getText();
			System.out.println(text);

		}
		public void mouseAction(WebElement element) {
			 acc=new Actions(driver);
			 acc.moveToElement(element).perform();

		}
		public void rightClick(WebElement element) {
		    acc=new Actions(driver);
			acc.contextClick(element).perform();
		}
		public void doubleClick(WebElement element) {
			acc=new Actions(driver);
			acc.doubleClick(element).perform();

	   }
	   public void drogNDrop(WebElement e,WebElement e1) {
		   acc=new Actions(driver);
		  acc.dragAndDrop(e, e1).perform();
	   }
	   
	   
	   public void dropDownByIndex(WebElement e,int index) {	
		s=new Select(e);
		s.selectByIndex(index);

	 }
	   public void dropDownByValue(WebElement e,String value) {
	 		s=new Select(e);
			s.selectByValue(value);
	  }
	   public void dropDownByVisibleText(WebElement e,String text) {
					s=new Select(e);
					s.selectByVisibleText(text);
	  }
	   public void screenshotDefaultLoc() {
		 tk=(TakesScreenshot)driver;
		File s = tk.getScreenshotAs(OutputType.FILE);
	  }
	 public void screenshotUserLoc(String loc) throws IOException {
		 tk=(TakesScreenshot)driver;
	     File s = tk.getScreenshotAs(OutputType.FILE);
	     File d=new File(loc);
	     FileUtils.copyFile(s, d);
	   }
	 public void keyPress(int i) throws AWTException {
		 r=new Robot();
		 r.keyPress(i);
		}
	 public void keyRelease(int i) throws AWTException {
		 r=new Robot();
		 r.keyRelease(i);
		}
	 public void alertAccept() {
		 al=driver.switchTo().alert();
		al.accept();

	}
	 public void alertDismiss() {
		 al=driver.switchTo().alert();
		al.dismiss();


	 }
	 public void alertTextSendAccept(String text) {
	     al=driver.switchTo().alert();
	     al.sendKeys(text);
	     al.accept();

	}
	 public void alertTextSendDismiss(String text) {
	     al=driver.switchTo().alert();
	     al.sendKeys(text);
	     al.dismiss();
	}
	 public void scrollUp(WebElement element) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
	 }
	 public void scrollDown(WebElement element) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
		
	 }
	 public void insertTextJSExecutor(WebElement element,String text) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value',text)", element);
		
	 }
	 public void GetTextJSExecutor(WebElement element) {
		js=(JavascriptExecutor)driver;
		Object obj = js.executeScript("arguments[0].getAttribute('value')", element);
		String s=(String)obj;
		System.out.println(s);
	}
	 public void clickJsExecutor(WebElement element) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
		
	}
	 public String getAttribute(WebElement e) {
		String att = e.getAttribute("value");
		return att;
	}
	 public void multiple(WebElement element) {
		 s=new Select(element);
		 boolean multiple = s.isMultiple();
		 System.out.println(multiple);
	}
	 public void getSize(WebElement element) {
		 s=new Select(element);
		 List<WebElement> options = s.getOptions();
		 System.out.println(options);
		 
	}
	 public void getAllOptionsForLoop(WebElement element) {
		 s=new Select(element);
		 List<WebElement> options = s.getOptions();
		 for (int i = 0; i < options.size(); i++) {
			 WebElement text = options.get(i);
			 System.out.println(text.getText());
	}}
	 public void getAllOptionsForEachLoop(WebElement element,String value)
	 {
		 s=new Select(element);
		 List<WebElement> options = s.getOptions();
		 for (WebElement x : options) {
			 System.out.println(x.getAttribute(value));
			
		}}
	 public void parentId() {
		String parent = driver.getWindowHandle();
		System.out.println(parent);
	}
	 


}
