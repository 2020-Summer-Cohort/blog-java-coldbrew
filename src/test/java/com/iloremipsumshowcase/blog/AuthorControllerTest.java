package com.iloremipsumshowcase.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class AuthorControllerTest {
    private AuthorRepository mockAuthorRepo;
    private IpsumPostRepository mockIpsumPostRepo;
    private IpsumCategoryRepository mockIpsumCategoryRepo;
    private AuthorController underTest;
    private Model mockModel;
    private Long testAuthorId;
    private Author testAuthor;

    @BeforeEach
    void setUp() {
        mockAuthorRepo = mock(AuthorRepository.class);
        mockIpsumPostRepo = mock(IpsumPostRepository.class);
        mockIpsumCategoryRepo = mock(IpsumCategoryRepository.class);
        testAuthor = new Author("Mr.Test");
        testAuthorId = testAuthor.getId();
        underTest = new AuthorController(mockAuthorRepo, mockIpsumPostRepo, mockIpsumCategoryRepo);
        mockModel = Mockito.mock(Model.class);
    }
    @Test
        public void shouldAskAuthorStorageForCorrectIdThenPassToModel(){


        when(mockAuthorRepo.findAuthorById(testAuthorId)).thenReturn(testAuthor);


        underTest.showSingleAuthor(testAuthorId,mockModel);

        verify(mockAuthorRepo).findAuthorById(testAuthorId);
        verify(mockModel).addAttribute("author",testAuthor);
    }

    @Test
        public void authorControllerShouldReturnAuthorTemplateForASingleAuthor(){
        String templateName = underTest.showSingleAuthor(testAuthorId,mockModel);
        assertThat(templateName).isEqualTo("author-template");
    }

    @Test
    public void showSingleAuthorAsksAuthorStorageForMrTest(){
        underTest.showSingleAuthor(testAuthorId,mockModel);
        verify(mockAuthorRepo).findAuthorById(testAuthorId);

    }

    @Test
    public void showSingleAuthorAddsMsTestToModel(){
        Author testAuthor2 = new Author("Ms Test");
        when(mockAuthorRepo.findAuthorById(testAuthor2.getId())).thenReturn(testAuthor2);
        underTest.showSingleAuthor(testAuthor2.getId(),mockModel);
        verify(mockModel).addAttribute("author",testAuthor2);
    }
}

