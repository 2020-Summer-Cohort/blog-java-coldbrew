package com.iloremipsumshowcase.blog;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;

public class AuthorControllerTest {
@Test
    public void shouldAskAuthorStorageForCorrectIdThenPassToModel(){
    AuthorRepository mockAuthorRepo = mock(AuthorRepository.class);
    Author testAuthor = new Author("Mr.Test");
    when(mockAuthorRepo.findByName(testAuthor.getAuthorName())).thenReturn(testAuthor);
    AuthorController underTest = new AuthorController(mockAuthorRepo);
    Model mockModel = mock(Model.class);

    underTest.showSingleAuthor(testAuthor.getAuthorName(),mockModel);

    verify(mockAuthorRepo).findByName(testAuthor.getAuthorName());
    verify(mockModel).addAttribute("author",testAuthor);
}
}

