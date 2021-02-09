package Framework.Artifact;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class Demo extends Capability {
	AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void bt() throws IOException, InterruptedException {
		//driver = capabilities(appPackage,appActivity,deviceName,platformName,chromeExecutable);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(5000);
	}
	
	@Test(enabled=false)
		public void testcase1() throws InterruptedException
	{
		//driver.findElementByAccessibilityId("radioFemale").click();
		WebElement female = driver.findElements(By.className("android.widget.RadioButton")).get(1);
		female.click();
		WebElement Name = driver.findElements(By.className("android.widget.EditText")).get(0);
		Name.sendKeys("Test");
		//driver.findElementByAccessibilityId("android:id/text1").click();
		//driver.findElementByClassName("android.widget.TextView").click();
		driver.findElement(By.className("android.widget.Spinner")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
		
		String Actual = Name.getText();
		String Expected = "Test";
		Assert.assertEquals(Actual,Expected);	
		}
	
	
	@Test(enabled=false)
	
	public void testcase2() throws InterruptedException
	{
		//driver.findElementByAccessibilityId("radioFemale").click();
		WebElement female = driver.findElements(By.className("android.widget.RadioButton")).get(1);
		female.click();
		driver.findElement(By.className("android.widget.Spinner")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
		driver.findElement(By.className("android.widget.Button")).click();
		String error = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		System.out.println(error);
	
		}

	@Test(enabled=false)
	
	public void testcase3() throws InterruptedException
	{
		//driver.findElementByAccessibilityId("radioFemale").click();
		WebElement female = driver.findElements(By.className("android.widget.RadioButton")).get(1);
		female.click();
		WebElement Name = driver.findElements(By.className("android.widget.EditText")).get(0);
		Name.sendKeys("Test");
		driver.findElement(By.className("android.widget.Spinner")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
		driver.findElement(By.className("android.widget.Button")).click();
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"))");
		//int l = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		//System.out.println(l);
		//driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\").instance(0)).scrollIntoView(text(\"Air Jordan 9 Retro\").instance(0)");
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Air Jordan 9 Retro\"))");
		//driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
		int l = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i=0;i<l; i++)
		{
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(productName.equalsIgnoreCase("Air Jordan 9 Retro"))
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		String Name1 = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		System.out.println(Name1);
		String productname = "Air Jordan 9 Retro";
		Assert.assertEquals(Name1, productname);
	}
	
@Test
	
	public void testcase4() throws InterruptedException, IOException
	{
		service = startServer();
		driver = capabilities(appPackage,appActivity,deviceName,platformName,chromeExecutable);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.findElementByAccessibilityId("radioFemale").click();
		WebElement female = driver.findElements(By.className("android.widget.RadioButton")).get(1);
		female.click();
		WebElement Name = driver.findElements(By.className("android.widget.EditText")).get(0);
		Name.sendKeys("Test");
		driver.findElement(By.className("android.widget.Spinner")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
		driver.findElement(By.className("android.widget.Button")).click();
		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		String amt1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		amt1 = amt1.substring(1);
		Double amount1 = Double.parseDouble(amt1);
		//System.out.println(amount1);
		String amt2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		amt2 = amt2.substring(1);
		Double amount2 = Double.parseDouble(amt2);
		//System.out.println(amount2);
	
		Double Actual = amount1 + amount2;
		//System.out.println(Actual);
		
		String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		total = total.substring(1);
		Double total1 = Double.parseDouble(total);
		//System.out.println(total1);
		Assert.assertEquals(total1, Actual);
		
		TouchAction t = new TouchAction(driver);
		//driver.findElement(By.className("android.widget.CheckBox")).click();
		WebElement Checkbox = driver.findElement(By.className("android.widget.CheckBox"));
		t.tap(tapOptions().withElement(element(Checkbox))).perform();
		
		
		WebElement TC = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		
		t.longPress(longPressOptions().withElement(element(TC)).withDuration(ofSeconds(3))).release().perform();
	
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(5000);
		
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
		    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
	}

		driver.context("WEBVIEW_com.androidsample.generalstore");
		//driver.findElement(By.id("Search")).sendKeys("IBM");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("IBM");
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		service.stop();
}
}