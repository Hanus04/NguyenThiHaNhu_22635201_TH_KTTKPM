import observer.Investor;
import observer.TeamMember;
import subject.Stock;
import subject.Task;

public class Main {
    public static void main(String[] args) {

        // ===== STOCK EXAMPLE =====
        Stock stock = new Stock("AAPL", 150);

        Investor inv1 = new Investor("Alice");
        Investor inv2 = new Investor("Bob");

        stock.attach(inv1);
        stock.attach(inv2);

        stock.setPrice(155);
        stock.setPrice(160);

        // ===== TASK EXAMPLE =====
        Task task = new Task("Implement Observer Pattern", "Pending");

        TeamMember mem1 = new TeamMember("John");
        TeamMember mem2 = new TeamMember("Emma");

        task.attach(mem1);
        task.attach(mem2);

        task.setStatus("In Progress");
        task.setStatus("Completed");
    }
}