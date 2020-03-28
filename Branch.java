import java.util.ArrayList;

public class Branch
{
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initialAmount)
    {
        // if we did not find an existing customer with this same name then continue
        // meaning this is a NEW customer
        if(findCustomer(customerName) == null)
        {
            // creating a new object Customer with the parameters passed into the method and adding to the array list
            this.customers.add(new Customer(customerName, initialAmount));
            return true;
        }
        // if the customer already exists and findCustomer found a matching name
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount)
    {
        // using an object to access findCustomer method
        Customer existingCustomer = findCustomer(customerName);
        // if we have found an existing customer then continue
        if (existingCustomer != null)
        {
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String customerName)
    {
        for(int i = 0; i < this.customers.size(); i++)
        {
            if (this.customers.get(i).getName().equals(customerName))
            {
                return this.customers.get(i);
            }
        }
        return null;
    }
}
