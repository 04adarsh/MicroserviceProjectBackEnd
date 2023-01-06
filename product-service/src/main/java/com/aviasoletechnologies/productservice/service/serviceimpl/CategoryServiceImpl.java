package com.aviasoletechnologies.productservice.service.serviceimpl;

import com.aviasoletechnologies.productservice.exception.CustomException;
import com.aviasoletechnologies.productservice.model.Category;
import com.aviasoletechnologies.productservice.repository.CategoryRepository;
import com.aviasoletechnologies.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    public CategoryRepository categoryRepository;

    /*
    * create category method which takes category and saves category into category table
    * */
    @Override
    public Category createCategory(Category category) {
        Category categoryResp=this.categoryRepository.findByCategoryName(category.getCategoryName());
        if(categoryResp!=null){
            throw new CustomException("category already exist");
        }
        return this.categoryRepository.save(category);
    }

    /*
    * this is updateCategory method in which we update the category.
    * First we find the category using category id
    * then we set the new values of category into categoryResp and save updated category to category table
    */
    @Override
    public Category upadteCategory(Long id, Category category) {
        Category categoryResp=this.categoryRepository.findById(id).orElseThrow(()-> new CustomException("category does not exist with id"+id));
        categoryResp.setCategoryName(category.getCategoryName());
        categoryResp.setCategoryDescription(category.getCategoryDescription());
        System.out.println(categoryResp);
        return this.categoryRepository.save(categoryResp);
    }


    /*
    * this is delete method in which we delete the category
    * First we find the category by id and if category is present then we delete it
    */
    @Override
    public void deleteCategory(Long categoryId) {
        Category category=this.categoryRepository.findById(categoryId).orElseThrow(()-> new CustomException("category with id "+categoryId+"not found"));
        this.categoryRepository.delete(category);
    }

    @Override
    public Category getCategoryById(Long getCategoryId) {
        Category category=this.categoryRepository.findById(getCategoryId)
                .orElseThrow(()-> new CustomException("category not found with id"+getCategoryId));
        return category;
    }

    @Override
    public Set<Category> getAllCategory() {
        List<Category> categoryList=this.categoryRepository.findAll();
        Set<Category> categorySet=new HashSet<>();
        for(Category category:categoryList){
            categorySet.add(category);
        }

        return categorySet;

    }
}
