public class Main
{
    public static void main(String [] args)
    {
        Bank bank = new Bank("wells fargo");
        bank.addBranch("fremont");
        bank.addCustomer("fremont", "mike", 100.00);
        bank.listCustomers("fremont",true);
    }
}
