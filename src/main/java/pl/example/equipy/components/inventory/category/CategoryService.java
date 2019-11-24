package pl.example.equipy.components.inventory.category;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class CategoryService {
    
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
    List<String> findAllNames() {
        return categoryRepository.findAll()
                .stream()
                .map(Category::getName)
                .collect(Collectors.toList());
    }
}