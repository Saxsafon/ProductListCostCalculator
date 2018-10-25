package pack;

public class Money {

    double value;
    Currancy.Currency moneyCurrency;

    public Money(double value, Currancy.Currency moneyCurrency) {
        this.value = value;
        this.moneyCurrency = moneyCurrency;
    }

    @Override
    public String toString() {
        return "Money{" +
                "" + value +
                " " + moneyCurrency +
                '}';
    }
}