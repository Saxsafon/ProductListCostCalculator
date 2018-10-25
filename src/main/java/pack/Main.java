package pack;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws WrongDataTypeException {

        List<Product> productList = new ArrayList<Product>();

        Money newZeland = new Money(400000, Currancy.Currency.USD);
        productList.add(new Product("Велингтон", newZeland));

        Money amsterdam = new Money(895000, Currancy.Currency.EUR);
        productList.add(new Product("Амстердам", amsterdam));

        Money novosibirsk = new Money(4000000, Currancy.Currency.RUB);
        productList.add(new Product("Новосибирск", novosibirsk));

        // https://github.com/Saxsafon/ProductListCostCalculator.git
        // Задавать путь до папки с файлами здесь
        // Исключительные ситуации
        // Наименования изменить на понятные
        // Мавен покрыть
        // Все в Git

        double productListCost;

        productListCost = ProductCostCalculator.calculateCosts(productList,Currancy.Currency.RUB,"25.10.2018","D:\\Java\\texts\\");
        System.out.println(productListCost);

    }
}
