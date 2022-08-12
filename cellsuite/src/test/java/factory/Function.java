package factory;

import java.util.List;

import org.openqa.selenium.WebElement;

public class Function {

    public static WebElement choose(List<WebElement> elements, String elementText) {
        WebElement choosenElement = null;
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            String label = element.getText();
            if (label.equals(elementText)) {
                choosenElement = element;
            }
        }
        return choosenElement;
    }
}
