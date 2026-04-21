package fit.iuh.foodservice.controller;


import fit.iuh.foodservice.entity.Food;
import fit.iuh.foodservice.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
@CrossOrigin(origins = "*")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping
    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable Long id) {
        return ResponseEntity.ok(foodService.getFoodById(id));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Food> createFood(@RequestBody Food food) {
        return ResponseEntity.ok(foodService.createFood(food));
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Food> updateFood(@PathVariable Long id, @RequestBody Food food) {
        return ResponseEntity.ok(foodService.updateFood(id, food));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
        return ResponseEntity.ok("Food deleted successfully");
    }

    @GetMapping("/available")
    public List<Food> getAvailableFoods() {
        return foodService.getAvailableFoods();
    }
}