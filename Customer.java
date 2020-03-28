import java.util.ArrayList;

public class Customer
{
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        // adding the initial transaction with the help of the addTransaction method
        addTransaction(initialAmount);
    }

    public void addTransaction(double amount)
    {
        // adding the initial transaction into the transactions array list
        this.transactions.add(amount);
    }

    // we might need these getters in another class
    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
