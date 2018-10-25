package pack;

import java.util.List;

public class ProductCostCalculator {
    public static double calculateCosts (List<Product> productList,
                                        Currancy.Currency cur,
                                        String date, String folderWay) throws WrongDataTypeException  {

        TextFileReader coursesReading = new TextFileReader();
        double[] exchange;
        exchange = coursesReading.readTextFile(folderWay,date);
        System.out.print("This is exchange ");
        System.out.println(exchange);


        if (exchange.length == 1) {
            System.out.println("I'm in if");
            Load.loadTextFile(folderWay,date);
            exchange = coursesReading.readTextFile(folderWay,date);
        }

        CurrencyConverter today = new CurrencyConverter(exchange[0],exchange[1], exchange[2]);
        CurrencyConverter twenty = new CurrencyConverter(1,67.0098,1.1767);

        double todayCost =  calculateCosts(productList, cur, today);
        double twentyCost =  calculateCosts(productList, cur, twenty);



        System.out.println("Twenty:  " + twentyCost);
        System.out.println("Today:  " + todayCost);

        return todayCost - twentyCost;

    }

    public static double calculateCosts(List<Product> productList, Currancy.Currency costsCurrency,
                                        CurrencyConverter currencyConverter) {
        double summ = 0;
        for (Product i : productList) {
            System.out.println("product: " + i);
            summ += currencyConverter.convertByCurrencty(i.price, costsCurrency).value;
            System.out.println(currencyConverter.convertByCurrencty(i.price, costsCurrency));
        }
        return summ;
    }

}
