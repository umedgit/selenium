package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CheckingValuesTestNG {

    private WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.get( "file:///D:/Project/seleniumWorking/src/day3/resources/form.html" );
    }

    @AfterClass
    public void cleaning(){
        driver.quit();
    }

//    @Test
//    public void test() {
//
//        Map<String, String> testValues = new HashMap<>(  );
//        testValues.put( "h1",  "#0000ff");
//        testValues.put( "h2",  "#ff00001");
//        testValues.put( "h3",  "#00ff00");
//        for(String key: testValues.keySet()){
//            checkElementColorByName( driver, key, testValues.get( key ));
//        }
//
//    }

    @DataProvider
    public Object[][] colorProvider(){
        Object[][] data = new Object[3][2];

        data[0][0] = "h1";
        data[0][1] = "#0000ff";

        data[1][0] = "h2";
        data[1][1] = "#ff0000";

        data[2][0] = "h3";
        data[2][1] = "#00ff00";

        return data;
    }

    @Test(dataProvider = "colorProvider")
    public void checkElementColorByName(String myTag, String testColor) {
        WebElement h1 = driver.findElement( By.tagName( myTag ) );
        String h1Color = h1.getCssValue( "color" );
        String hex = Color.fromString(h1Color).asHex();
        Assert.assertEquals( hex, testColor );
    }
}
