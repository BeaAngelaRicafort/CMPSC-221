import java.math.BigDecimal; 

public class LoanAccount {  

    private static double annualInterestRate;

    private static void setAnnualInterestRate(double newAnnualInterestRate) {       // Calculates Annual Interest Rate

        if (newAnnualInterestRate >= 0.0) {                                         // Interest Must Be Positive

            annualInterestRate = newAnnualInterestRate; 

        }

        else {

            throw new IllegalArgumentException(
                "Annual interest rate is out of range.");

        }
    }
    
    private double principal;                                                       // Principal = Original Amount of Money Borrowed
    
    public LoanAccount(double inputPrincipal) {                                     // Constructor

        int numberOfDecimals = (BigDecimal.valueOf(inputPrincipal)).scale();        // Finds Number of Decimals in Principal

        if (inputPrincipal >= 0.0 || numberOfDecimals <= 2){                        // If Principal in Range (Not Negative, Number of Decimals <= 2)

            this.principal = inputPrincipal;

        }

        else {

            throw new IllegalArgumentException(
                "Principal is out of range.");

        }
    }
    
    public double calculateMonthlyPayment(int numberOfPayments) {                   // Calculates Monthly Payment

        double InterestDecimal = annualInterestRate / 100;                          // Converts Interest Rate to Decimal
        double monthlyInterest = InterestDecimal / 12;

        if (numberOfPayments >= 0) {                                                

            double monthlyPayment = this.principal * (monthlyInterest / (1 - Math.pow(1 + monthlyInterest, -numberOfPayments))); 
            return monthlyPayment;

        }
        else {

            throw new IllegalArgumentException(
                "Number of payments is out of range.");

        }
    } 
    
    public static void main(String args[]) {

        LoanAccount loan1 = new LoanAccount(5000); 
        LoanAccount loan2 = new LoanAccount(31000);
        
        setAnnualInterestRate(1); 
        
        System.out.printf("Monthly payments for loan1 of $%,.2f"
                + " and loan2 $%,.2f for 3, 5, and 6 year loans at 1%% interest.",
                loan1.principal, loan2.principal, annualInterestRate);

        System.out.printf("\nLoan    3 years   5 years   6 years");

        System.out.printf("\nLoan1   %,.2f    %,.2f     %,.2f",
                loan1.calculateMonthlyPayment(36),
                loan1.calculateMonthlyPayment(60),
                loan1.calculateMonthlyPayment(72));

        System.out.printf("\nLoan2   %,.2f    %,.2f    %,.2f",
                loan2.calculateMonthlyPayment(36),
                loan2.calculateMonthlyPayment(60),
                loan2.calculateMonthlyPayment(72));
        
        setAnnualInterestRate(5);
        
        System.out.printf("\n\nMonthly payments for loan1 of $%,.2f"
                + " and loan2 $%,.2f for 3, 5, and 6 year loans at 5%% interest.",
                loan1.principal, loan2.principal, annualInterestRate);

        System.out.printf("\nLoan    3 years   5 years   6 years");

        System.out.printf("\nLoan1   %,.2f    %,.2f     %,.2f",
                loan1.calculateMonthlyPayment(36),
                loan1.calculateMonthlyPayment(60),
                loan1.calculateMonthlyPayment(72));

        System.out.printf("\nLoan2   %,.2f    %,.2f    %,.2f",
                loan2.calculateMonthlyPayment(36),
                loan2.calculateMonthlyPayment(60),
                loan2.calculateMonthlyPayment(72));
        
        }
          
    }