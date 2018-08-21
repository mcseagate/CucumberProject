import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FetchTest {

    
    public WebDriver driver;

    /*
    A test to fetch data from a dynamic table. The table
    is considered dynamic and data is returned from rows
    and columns
     */



    @Given("^i am already signed in and i navigate to the table under test$")
    public void iAmAlreadySignedInAndINavigateToTheTableUnderTest() throws Throwable {
        //Precondition: User is already signed in and is on the table page under test
        driver.navigate().refresh();
        WebElement tab = driver.findElement(By.id("table_Id"));
    }

    @And("^i fetch all rows and column from the table$")
    public List<ArrayList<String>> iFetchAllRowsFromTheTable() throws Throwable {

        WebElement table = null;
        List<WebElement> rows = table.findElements(By.id("tab_ID"));
        List<ArrayList<String>> rowsData = new ArrayList<ArrayList<String>>();

        for(WebElement row:rows){
            List<WebElement> rowElements = row.findElements(By.id("tab_ID2"));

            ArrayList<String> rowData = new ArrayList<String>();

            for(WebElement column:rowElements){
                rowData.add(column.getText().toString());
            }

            rowsData.add(rowData);
        }

        return rowsData;

        }

    @Then("^i close the browser$")
    public void iCloseTheBrowser() throws Throwable {
        driver.quit();

    }
}
