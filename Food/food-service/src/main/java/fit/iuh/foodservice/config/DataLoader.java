package fit.iuh.foodservice.config;

import fit.iuh.foodservice.entity.Food;
import fit.iuh.foodservice.repository.FoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final FoodRepository foodRepository;

    public DataLoader(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public void run(String... args) {
        if (foodRepository.count() == 0) {
            foodRepository.save(new Food("Com Ga", "Com ga xoi mo", 35000, true));
            foodRepository.save(new Food("Pho Bo", "Pho bo tai chin", 40000, true));
            foodRepository.save(new Food("Banh Mi", "Banh mi thit nuong", 25000, true));
        }
    }
}