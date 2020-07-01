package com.iloremipsumshowcase.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CategoryControllerTest {

    private IpsumCategoryRepository mockIpsumCategoryRepo;
    private IpsumCategoryController underTest;
    private HashtagRepository mockHashtagRepo;
    private AuthorRepository mockAuthorRepo;
    private IpsumPostRepository mockIpsumPostRepo;
    private Model model;


    @BeforeEach
    void setUp(){
        mockIpsumCategoryRepo = mock(IpsumCategoryRepository.class);
        mockHashtagRepo = mock(HashtagRepository.class);
        mockAuthorRepo = mock(AuthorRepository.class);
        mockIpsumPostRepo = mock(IpsumPostRepository.class);
        underTest = new IpsumCategoryController(mockIpsumCategoryRepo, mockHashtagRepo,mockAuthorRepo, mockIpsumPostRepo  );
        model = Mockito.mock(Model.class);
    }

    @Test
    public void ipsumCategoryControllershouldReturnIpsumCategoryTemplateWhenAskedToViewSingleIpsumCategory(){

        String templateName = underTest.showSingleIpsumCategory("Goof Ipsums", model);
        assertThat(templateName).isEqualTo("ipsumcategory-template");

    }

    @Test
    public void displayAllIpsumCategoriesInteractsWithRepoCorrectly(){
        IpsumCategoryRepository mockRepo = mock(IpsumCategoryRepository.class);
        IpsumCategoryController underTest = new IpsumCategoryController(mockRepo, mockHashtagRepo, mockAuthorRepo, mockIpsumPostRepo);
        Model mockModel = mock(Model.class);

        underTest.displayAllIpsumCategories(mockModel);

        verify(mockRepo).findAll();
        verify(mockModel).addAttribute("ipsumcategories", Collections.EMPTY_LIST);
    }
    @Test
    public void showSingleIpsumCategoryAddsRetrievedIpsumCategoryToModel(){
        IpsumCategory testCategory = new IpsumCategory("fun ipsum","filler text thats so much fun");
        when(mockIpsumCategoryRepo.findByCategoryName("fun ipsum")).thenReturn(testCategory);

        underTest.showSingleIpsumCategory("fun ipsum",model);
        verify(model).addAttribute("ipsumcategory",testCategory);
    }

//consider adding funcitonality to add new categories later!
}
