public class AdminObserver implements Observer{
    private String name;

    public AdminObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " Nhan thong bao" + message);
    }
}
