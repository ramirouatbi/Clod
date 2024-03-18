package com.rentit.project.services;

import com.rentit.project.models.ArticleEntity;
import com.rentit.project.models.CategoryEntity;
import com.rentit.project.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@SpringBootTest
class CategoryServiceTest {

    private CategoryService categoryService;
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        categoryRepository = mock(CategoryRepository.class);
        categoryService = new CategoryService();
        categoryService.categoryRepository = categoryRepository;
    }

    //Komentar

    @Test
    void testAddCategory() {

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName("Test Category");

        when(categoryRepository.save(any(CategoryEntity.class))).thenReturn(categoryEntity);

        CategoryEntity result = categoryService.addCategory(categoryEntity);

        assertEquals("Test Category", result.getName());

        verify(categoryRepository, times(1)).save(any(CategoryEntity.class));
    }

    @Test
    void testGetAllCategories() {
        List<CategoryEntity> mockCategories = new ArrayList<>();
        CategoryEntity category1 = new CategoryEntity(1L, "Category 1", "Description 1", new ArrayList<>());
        CategoryEntity category2 = new CategoryEntity(2L, "Category 2", "Description 2", new ArrayList<>());

        mockCategories.add(category1);
        mockCategories.add(category2);

        when(categoryRepository.findAll()).thenReturn(mockCategories);

        List<CategoryEntity> result = categoryService.getAllCategories();

        assertEquals(2, result.size());
        assertEquals("Category 1", result.get(0).getName());

        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    public void demoTestMethod(){
        assertTrue(true);
    }

}
