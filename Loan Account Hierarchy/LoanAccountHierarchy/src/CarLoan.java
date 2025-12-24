public class CarLoan extends LoanAccount {
    
    private String vehicleVIN;
    
    public CarLoan(double inputPrincipal, double inputAnnualInterestRate, int inputMonths, String inputVIN) { // Constructor

        super(inputPrincipal, inputAnnualInterestRate, inputMonths);
        this.vehicleVIN = inputVIN; 

    }
    
    public String getVIN() {

        return vehicleVIN;

    }
    
    public String toString() {

        String mainInfo = super.toString();
        return String.format("Car Loan with: %s"
                + "\nVehicle VIN: %s", 
                mainInfo, getVIN());

    }
    
}
