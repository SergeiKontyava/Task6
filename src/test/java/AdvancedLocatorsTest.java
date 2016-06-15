import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdvancedLocatorsTest {

    private WebDriver Driver = null;

    @BeforeTest
    public void initialize(){
        Driver = new ChromeDriver();

    }
    @Test
    public void advancedCSSLocatorsTest(){
        //a) Selector, which grabs all links and inputs on home page;
        WebElement allLinksAndInputs = Driver.findElement(By.cssSelector("a, input"));

        //b) Selector, which grabs all elements on home page;
        WebElement allElements = Driver.findElement(By.cssSelector("*"));

        //Selector, which grabs all elements near to link for your name on home page (see screenshot a);
        WebElement nearNameElements = Driver.findElement(By.cssSelector("#info a ~ *"));

        //d) Chapaeva 051 link, do not use "href" attribute of link;
        WebElement chapaeva051WithoutHref = Driver.findElement(By.cssSelector(".officeShortInfo.zebraStyle li:first-child a"));

        //e) Chapaeva 424 link, do not use "href" attribute of link;
        //works only on prod. dev env has two more offices
        WebElement chapaeva424WithoutHref = Driver.findElement(By.cssSelector(".officeShortInfo.zebraStyle li:last-child a"));

        //f) Chapaeva 118 link, do not use "href" attribute of link;
        WebElement chapaeva118WithoutHref = Driver.findElement(By.cssSelector("??????????"));

        //g) Selector, which grabs elements together – Chapaeva 111 link, Chapaeva 208 link, Chapaeva 229 link, Chapaeva 401 link, Chapaeva 420 link;
        WebElement chapaevaOffices = Driver.findElement(By.cssSelector(".officeShortInfo.zebraStyle li:nth-of-type(5n+3) a"));

        //h) Selector, which grabs all inputs on vacation page, except of Start Date input.
        WebElement allInputBesidesStartDate = Driver.findElement(By.cssSelector("input:not(#EditVacationRequestStartDate), textarea"));
    }

    @Test
    public void advancedXPathLocatorsTest() {
        //a) Selector, which grabs all links and inputs on home page;
        WebElement allLinksAndInputs = Driver.findElement(By.xpath("?????"));

        //b) Selector, which grabs all elements on home page;
        WebElement allElements = Driver.findElement(By.xpath(".//*"));

        //Selector, which grabs all elements near to link for your name on home page (see screenshot a);
        WebElement nearNameElements = Driver.findElement(By.xpath(".//*[@id='info']/*[not(@class='name')]"));

        //d) Chapaeva 051 link, do not use "href" attribute of link;
        WebElement chapaeva051WithoutHref = Driver.findElement(By.xpath(".//*[@id='officeWidgetContent']/ol/li[position()<2]/a"));

        //e) Chapaeva 424 link, do not use "href" attribute of link;
        //works only on prod. dev env has two more offices
        WebElement chapaeva424WithoutHref = Driver.findElement(By.xpath(".//*[@id='officeWidgetContent']/ol/li[last()]/a"));

        //f) Chapaeva 118 link, do not use "href" attribute of link;
        WebElement chapaeva118WithoutHref = Driver.findElement(By.xpath(".//*[@id='officeWidgetContent']/ol/li[position() = 4]/a"));

        //g) Selector, which grabs elements together – Chapaeva 111 link, Chapaeva 208 link, Chapaeva 229 link, Chapaeva 401 link, Chapaeva 420 link;
        WebElement chapaevaOffices = Driver.findElement(By.xpath("??????"));

        //h) Selector, which grabs all elements with css classes;
        WebElement allInputBesidesStartDate = Driver.findElement(By.xpath(".//*[contains(., \"css\")]"));

        //i) Selector, which grabs all elements with css class, which starts with “widget”;
        WebElement classesStartWithWidget = Driver.findElement(By.xpath(".//*[starts-with(@class,\"widget\")]"));

        //j) Selector, which grabs all elements with id, which ends with “wrapper”;
        WebElement idEndsWithWrapper = Driver.findElement(By.xpath(".//*[contains(@id,\"wrapper\")]"));

        //k) Selector, which grabs all elements with attribute “data-officeid” (attribute should contain “b” letter);
        WebElement dataOfficeIdAttributeContainsB = Driver.findElement(By.xpath(".//*[contains(@data-officeid,\"b\")]"));

        //l) Element with text "Management Belarus";
        WebElement managementBelarusElement = Driver.findElement(By.xpath(".//*[contains(a,\"Management Belarus\")]"));

        //m) Update selector "//span[text()="2"]". Updated selector should point to Company link.
        WebElement companyLinkOne = Driver.findElement(By.xpath("//*[*[span[text()=\"3\"]]]/a"));
        //or
        WebElement companyLinkTwo = Driver.findElement(By.xpath("//span[text()=\"3\"]"));

    }
}
