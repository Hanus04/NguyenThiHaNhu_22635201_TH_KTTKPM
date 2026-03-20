package loan;
public class ExtensionDecorator extends LoanDecorator {
    public ExtensionDecorator(LoanService loan) {
        super(loan);
    }

    @Override
    public String getServiceInfo() {
        return super.getServiceInfo() + " + Extension";
    }
}