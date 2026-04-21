package fit.iuh.foodservice.service;

import fit.iuh.foodservice.entity.Food;
import fit.iuh.foodservice.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    public Food getFoodById(Long id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));
    }

    public Food createFood(Food food) {
        return foodRepository.save(food);
    }

    public Food updateFood(Long id, Food newFood) {
        Food food = getFoodById(id);
        food.setName(newFood.getName());
        food.setDescription(newFood.getDescription());
        food.setPrice(newFood.getPrice());
        food.setAvailable(newFood.isAvailable());
        return foodRepository.save(food);
    }

    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }


    public List<Food> getAvailableFoods() {
        return foodRepository.findByAvailableTrue();
    }
}