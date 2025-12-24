import java.util.*;

public class Customer {
    
    private String firstName;
    private String lastName;
    private String SSN;
    ArrayList<LoanAccount> loanAccounts = new ArrayList<LoanAccount>();
    
    public Customer(String inputFirstName, String inputLastName, String inputSSN) {

        this.firstName = inputFirstName;
        this.lastName = inputLastName;
        this.SSN = inputSSN;

    }
    
    public String getFirstName() {

        return firstName;

    }
    
    public String getLastName() {

        return lastName;

    }
    
    public String getSSN() {

        return SSN;

    }
    
    public void addLoanAccount(LoanAccount account) {

        loanAccounts.add(account);

    }
    
    public void printMonthlyReport() {
        
        String customerInfo = String.format
                ("\nAccount Report for Customer: %s %s with SSN %s", 
                getFirstName(), getLastName(), getSSN());
        
        System.out.println(customerInfo);
        
        for(LoanAccount account : loanAccounts)
            System.out.println(account.toString());
    }
    
}
