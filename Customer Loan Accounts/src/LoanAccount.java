import java.math.BigDecimal;

public class LoanAccount {

    private double principal; 
    private double annualInterestRate; 
    private int months; 
    
    public LoanAccount(double inputPrincipal, double inputAnnualInterestRate, int inputMonths) {        // Constructor

        int numberOfDecimals = (BigDecimal.valueOf(inputPrincipal)).scale();                            // Finds Number of Decimals
        
        if (inputPrincipal >= 0.0 && numberOfDecimals <= 2) {                                           // If Principal in Range (Not Negative, # of Decimals <= 2)
        
            this.principal = inputPrincipal;

            }       

        else {

            throw new IllegalArgumentException(
                "Principal is out of range.");

            }
        
        if (inputAnnualInterestRate >= 0) {                                                             // Interst Rate Must Be Positive
        
            this.annualInterestRate = inputAnnualInterestRate;

            }

        else {

            throw new IllegalArgumentException(
                "Annual interest rate is out of range.");

            }

        if (0 < inputMonths) {                                                                          // Months Must Be 0-12
        
            this.months = inputMonths;

            }
            
        else {

            throw new IllegalArgumentException(
                "Month(s) is/are out of range.");

            }
        }
    
    public double getPrincipal() {

        return principal; 

    }
    
    public double getAnnualInterestRate() {

        return annualInterestRate;

    }
    
    public int getMonths() {

        return months;

    }
    
    public double calculateMonthlyPayment() {                                                           // Getters

        double CMPPrincipal = getPrincipal(); 
        double CMPInterest = getAnnualInterestRate(); 
        int CMPMonths = getMonths(); 
        
        double InterestDecimal = CMPInterest / 100;                                                     // Converts Interest Rate to Decimal
        double monthlyInterest = InterestDecimal / 12; 
        
        if (CMPMonths >= 0) {

            double monthlyPayment = CMPPrincipal * (monthlyInterest / (1 - Math.pow(1 + monthlyInterest, -CMPMonths))); 
            return monthlyPayment;

        }

        else {

            throw new IllegalArgumentException(
                "Number of payments is out of range.");

        }
        
    } 
    
    public String toString() {

        return String.format("\nPrincipal: $%,.2f"
                + "\nAnnual Interest Rate: %,.2f%%"
                + "\nTerm of Loan in Months: %d"
                + "\nMonthly Payment: $%,.2f",
                getPrincipal(), getAnnualInterestRate(), 
                getMonths(), calculateMonthlyPayment());

    }  
   
}
    
    
