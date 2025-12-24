public class Address {
    
    private String street;
    private String city;
    private String state;
    private String zipcode; 
    
    public Address(String inputStreet, String inputCity, String inputState, String inputZipcode) { // Constructor

        this.street = inputStreet;
        this.city = inputCity;
        this.state = inputState;
        this.zipcode = inputZipcode; 

    }
    
    public String getStreet() {

        return street; 

    }
    
    public String getCity() {

        return city; 

    }
    
    public String getState() {

        return state; 

    }
    
    public String getZipcode() {

        return zipcode; 

    }
    
    public String toString() {

        return String.format("\nProperty Address:"
                + "\n    %s"
                + "\n    %s, %s %s",
                getStreet(), getCity(), 
                getState(), getZipcode());

    }  
    
}
