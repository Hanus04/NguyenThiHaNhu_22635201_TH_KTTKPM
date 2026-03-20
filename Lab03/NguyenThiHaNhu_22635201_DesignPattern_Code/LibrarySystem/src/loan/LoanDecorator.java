package loan;

public abstract class LoanDecorator implements LoanService {
    protected LoanService wrappedLoan;

    public LoanDecorator(LoanService loan) {
        this.wrappedLoan = loan;
    }

    @Override
    public String getServiceInfo() {
        return wrappedLoan.getServiceInfo();
    }
}