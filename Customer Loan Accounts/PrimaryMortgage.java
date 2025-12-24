import java.math.BigDecimal;

public class PrimaryMortgage extends LoanAccount {
    
    private double PMIMonthlyAmount;
    private Address address; 
       
    public PrimaryMortgage(double inputPrincipal, double inputAnnualInterestRate, int inputMonths, double inputPMI, Address myAddress) { // Constructor

        super(inputPrincipal, inputAnnualInterestRate, inputMonths);
        this.address = myAddress;
        
        int numberOfDecimals = (BigDecimal.valueOf(inputPrincipal)).scale(); // Finds Number of Decimals
        double percentHomeValue = inputPMI / inputPrincipal; 
        
        if (inputPMI >= 0.0 && numberOfDecimals <= 2 && percentHomeValue < 0.2) {       
            // If InputPMI in Range (Not Negative, Number of Decimals <= 2, Not at Least 20% of Home Value)
            this.PMIMonthlyAmount = inputPMI;

            }       

        else {

            throw new IllegalArgumentException(
                "PMI is out of range.");

            }

    }
    
    public Address getAddress() {

        return address;

    }
    
    public double getPMI() {

        return PMIMonthlyAmount;

    }
    
    public String toString() {

        String mainInfo = super.toString();
        return String.format("\n\nPrimary Mortgage Loan with: %s"
                + "\nPMI Monthly Amount: $%s%s",
                mainInfo, getPMI(), getAddress().toString());
                
    }
    
}
