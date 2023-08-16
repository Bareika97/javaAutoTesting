package pages.practiceform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultTable extends BasePage {
    private WebElement tableElement;
    private final By rowsSel = By.xpath(".//tr");
    private final By headingsSel = By.xpath(".//tr[1]"); // заголовки
    private final By columnsSel = By.xpath(".//th");
    private final By rowWithColSel = By.xpath(".//td");
    public ResultTable(WebDriver driver, WebElement tableElement) {
        super(driver);
        this.tableElement = tableElement;
    }

    public List<WebElement> getRows(){
        List<WebElement> rows = tableElement.findElements(rowsSel);
        rows.remove(0); // удаляем заголовки, их выделяем отдельно
        return rows;
    }
    public List<WebElement> getHeadings(){
        WebElement headingRow = tableElement.findElement(headingsSel); // строка со всеми заголовками
        List<WebElement> headingsColumns = headingRow.findElements(columnsSel);
        return headingsColumns;
    }
    //разбиваем строки на столбцы
    public List<List<WebElement>> getRowsWithColumns(){
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<>();
        for (WebElement row : rows){
            List<WebElement> rowWithColumns = row.findElements(rowWithColSel);
            rowsWithColumns.add(rowWithColumns);
        }
        return rowsWithColumns;
    }
    // ключ - заголовок, value - ячейка по данному заголовку
    public List<Map<String, WebElement>> getRowsWithColumnsByHeadings() {
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns(); // список всех строк разбитые на колонки
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = new ArrayList<>();
        Map<String, WebElement> rowByHeadings; // 1 строка разбитая на столбцы по заголовкам
        List<WebElement> headingColumns = getHeadings();

        for (List<WebElement> row : rowsWithColumns) {
            rowByHeadings = new HashMap<>();
            for (int i = 0; i < headingColumns.size(); i++) {
                String heading = headingColumns.get(i).getText();
                WebElement cell = row.get(i);
                rowByHeadings.put(heading, cell);
            }
            rowsWithColumnsByHeadings.add(rowByHeadings);

        }
        return rowsWithColumnsByHeadings;
    }
    public String getValueFromCell(int rowNumber, int columnNumber){
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        WebElement cell = rowsWithColumns.get(rowNumber - 1).get(columnNumber - 1);
        return cell.getText();
    }
    public String getValueFromCell(int rowNumber, String columnName){
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = getRowsWithColumnsByHeadings();
        return rowsWithColumnsByHeadings.get(rowNumber - 1).get(columnName).getText();
    }
}
