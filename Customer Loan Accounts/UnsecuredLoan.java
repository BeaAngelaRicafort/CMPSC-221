public class UnsecuredLoan extends LoanAccount {
    
    public UnsecuredLoan(double inputPrincipal, double inputAnnualInterestRate, int inputMonths) { // Constructor

        super(inputPrincipal, inputAnnualInterestRate, inputMonths);

    }
    
    public String toString() {

        String mainInfo = super.toString();
        return String.format("\n\nUnsecured Loan with: %s", mainInfo);

    }
    
}
