import java.util.ArrayList;

public class Bank
{
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName)
    {
        // if this is a new branch / we did not find the branch in the array list
        if(findBranch(branchName) == null)
        {
            // creating a new object Branch and passing in branchName as a parameter
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount)
    {
        Branch branch = findBranch(branchName);
        // we can only add a customer if the branch name exists
        if(branch != null)
        {
            // this calls the boolean method newCustomer and returns true or false if it was successful
            // remember that newCustomer was boolean type
            return branch.newCustomer(customerName,initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount)
    {
        Branch branch = findBranch(branchName);
        if (branch != null)
        {
            return branch.addCustomerTransaction(customerName,amount);
        }
        return false;
    }

    private Branch findBranch(String branchName)
    {
        for(int i = 0; i < this.branches.size(); i++)
        {
            if (this.branches.get(i).getName().equals(branchName))
            {
                return this.branches.get(i);
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions)
    {
        Branch branch = findBranch(branchName);
        if(branch != null)
        {
            System.out.println("customers in branch " + branch.getName());
            // created a list from the getter method from Branch class
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++)
            {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("customer " + branchCustomer.getName());
                if (showTransactions)
                {
                    System.out.println("transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for(int j = 0; j < transactions.size(); j++)
                    {
                        System.out.println("amount = " + transactions.get(j));
                    }
                }
            }
            return true;
        }
        return false;
    }

}
