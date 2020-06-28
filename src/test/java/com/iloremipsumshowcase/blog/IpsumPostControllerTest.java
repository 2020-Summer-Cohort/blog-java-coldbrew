package com.iloremipsumshowcase.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class IpsumPostControllerTest {
private IpsumCategoryRepository mockIpsumCategoryRepo;
private IpsumCategory testIpsumCategory;
private IpsumPostRepository mockIpsumPostRepo;
private AuthorRepository mockAuthorRepo;
private Author testAuthor;
private HashtagRepository mockHashtagRepo;
private Hashtag testHashtag;
private IpsumPostController underTest;
private IpsumPost testPost;

@BeforeEach
    void setUp() {
    mockIpsumCategoryRepo = mock(IpsumCategoryRepository.class);
    mockIpsumPostRepo = mock(IpsumPostRepository.class);
    mockAuthorRepo = mock(AuthorRepository.class);
    mockHashtagRepo = mock(HashtagRepository.class);
    underTest = new IpsumPostController(mockIpsumPostRepo, mockIpsumCategoryRepo, mockAuthorRepo, mockHashtagRepo);

    testIpsumCategory = new IpsumCategory("Test Category", "A Test category");
    testAuthor = new Author("test");
    testHashtag = new Hashtag("testHashtaggg");
    testPost = new IpsumPost("Test Ipsum", "this is a test blog post", "Test sample", "test source", "testpic", null, testIpsumCategory, testAuthor, testHashtag);
}
    @Test
    public void addPostShouldRedirectToCorrectCategory(){
    String redirect = underTest.addIpsumPost("Test Ipsum","this is a test blog post","Test sample", "test source", "testpic",null, testIpsumCategory.getCategoryName(),testAuthor.getAuthorName(),testHashtag.getId());
    assertThat(redirect).isEqualTo("redirect:/ipsumcategories/" + testIpsumCategory.getCategoryName());
}

@Test
    public void addPostShouldAddPostToPostStorage(){
   when(mockIpsumCategoryRepo.findByName(testIpsumCategory.getCategoryName())).thenReturn(testIpsumCategory);
    when(mockAuthorRepo.findByName(testAuthor.getAuthorName())).thenReturn(testAuthor);
    when(mockHashtagRepo.findHashtagById(testHashtag.getId())).thenReturn(testHashtag);
    underTest.addIpsumPost("Test Ipsum", "this is a test blog post", "Test sample", "test source", "testpic",null,testIpsumCategory.getCategoryName(),testAuthor.getAuthorName(),testHashtag.getId());
    verify(mockIpsumPostRepo).save(testPost);
}

}
