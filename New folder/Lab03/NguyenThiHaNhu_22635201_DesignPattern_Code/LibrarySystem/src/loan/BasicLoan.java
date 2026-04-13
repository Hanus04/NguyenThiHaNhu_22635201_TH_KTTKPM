package loan;

public class BasicLoan implements LoanService {
    @Override
    public String getServiceInfo() {
        return "Basic Loan Service";
    }
}