package com.iloremipsumshowcase.blog;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import java.util.Collections;

public class CategoryControllerTest {
    @Test
    public void displayAllIpsumCategoriesInteractsWithRepoCorrectly(){
        IpsumCategoryRepository mockRepo = Mockito.mock(IpsumCategoryRepository.class);
        IpsumCategoryController underTest = new IpsumCategoryController(mockRepo);
        Model mockModel = Mockito.mock(Model.class);

        underTest.displayAllIpsumCategories(mockModel);

        Mockito.verify(mockRepo).findAll();
        Mockito.verify(mockModel).addAttribute("ipsumcategories", Collections.EMPTY_LIST);
    }
}
