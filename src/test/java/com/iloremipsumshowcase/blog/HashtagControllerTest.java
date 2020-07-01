package com.iloremipsumshowcase.blog;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;

public class HashtagControllerTest {

    @Test
    public void shouldAskHashtagStorageForProperHashtagWhenGivenIdThenPassesItToModel(){
        HashtagRepository mockHashtagRepo = mock(HashtagRepository.class);
        Hashtag testHashtag = new Hashtag("tester");
        IpsumPostRepository mockIpsumPostRepo = mock(IpsumPostRepository.class);
        IpsumCategoryRepository mockIpsumCategoryRepo = mock(IpsumCategoryRepository.class);
        when(mockHashtagRepo.findHashtagById(testHashtag.getId())).thenReturn(testHashtag);
        HashtagController underTest = new HashtagController(mockHashtagRepo,mockIpsumPostRepo,mockIpsumCategoryRepo);
        Model mockModel = mock(Model.class);

        underTest.showSingleHashtag(testHashtag.getId(),mockModel);

        verify(mockHashtagRepo).findHashtagById(testHashtag.getId());
        verify(mockModel).addAttribute("hashtag",testHashtag);
    }

}
