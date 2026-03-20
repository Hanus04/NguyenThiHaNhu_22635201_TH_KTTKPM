package loan;

public class SpecialEditionDecorator extends LoanDecorator {
    public SpecialEditionDecorator(LoanService loan) {
        super(loan);
    }

    @Override
    public String getServiceInfo() {
        return super.getServiceInfo() + " + Special Edition";
    }
}