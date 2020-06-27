package com.iloremipsumshowcase.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAWiringTest {
    @Autowired
    IpsumCategoryRepository ipsumCategoryRepo;
    @Autowired
    IpsumPostRepository ipsumPostRepo;
    @Autowired
    AuthorRepository authorRepo;
    @Autowired
    HashtagRepository hashtagRepo;
    @Autowired
    TestEntityManager entityManager;

    @Test
            public void postsShouldHaveACategoryAndAuthor() {
        IpsumCategory testCategory = new IpsumCategory("Name of category", "intro" );
        Author testAuthor = new Author("firstName");
        Hashtag testHashtag1 = new Hashtag("lorum");
        Hashtag testHashtag2 = new Hashtag("ipsum");
        hashtagRepo.save(testHashtag1);
        hashtagRepo.save(testHashtag2);
        ipsumCategoryRepo.save(testCategory);
        authorRepo.save(testAuthor);
        IpsumPost testPost = new IpsumPost("Name of Ipsum", "Description of Ipsum", "Sample of Ipsum", "Source of ipsum", "date", testCategory, testAuthor);
       ipsumPostRepo.save(testPost);

        entityManager.flush();
        entityManager.clear();

        IpsumPost retrievedIpsumPost = ipsumPostRepo.findById(testPost.getId()).get();
        Author retrievedAuthor = authorRepo.findById(testAuthor.getId()).get();
        IpsumCategory retrievedIpsumCategory = ipsumCategoryRepo.findById(testCategory.getId()).get();
//        assertThat(retrievedIpsumPost).isEqualTo(testPost);
//        assertThat(retrievedIpsumCategory.getIpsumPosts()).containsExactly(testPost);
//        assertThat(retrievedAuthor.getIpsumPosts()).containsExactly(testPost);
//        assertThat(retrievedIpsumPost.getHashtags()).containsExactly(testHashtag1,testHashtag2);
    }

@Test
    public void postsShouldHaveMultipleHashtags(){
    IpsumCategory testCategory = new IpsumCategory("Name of category", "intro" );
    ipsumCategoryRepo.save(testCategory);
    Author testAuthor = new Author("firstName");
    authorRepo.save(testAuthor);

    IpsumPost testPost1 = new IpsumPost("Name of Ipsum", "Description of Ipsum", "Sample of Ipsum", "Source of ipsum", "date", testCategory, testAuthor);
    IpsumPost testPost2 = new IpsumPost("FFF ", "Description of Ipsum", "Sample of Ipsum", "Source of ipsum", "date", testCategory, testAuthor);
    ipsumPostRepo.save(testPost1);
    ipsumPostRepo.save(testPost2);

    Hashtag testHashtag1 = new Hashtag("lorum", testPost1, testPost2);
    Hashtag testHashtag2 = new Hashtag("ipsum",testPost2);
    hashtagRepo.save(testHashtag1);
    hashtagRepo.save(testHashtag2);
    entityManager.flush();
    entityManager.clear();

    Hashtag retrievedHashtag = hashtagRepo.findById(testHashtag1.getId()).get();
    assertThat(retrievedHashtag).isEqualTo(testHashtag1);
    assertThat(retrievedHashtag.getIpsumPosts()).containsExactly(testPost1,testPost2);
    Hashtag retrievedHashtag2 = hashtagRepo.findById(testHashtag2.getId()).get();
    assertThat(retrievedHashtag2.getIpsumPosts()).containsExactly(testPost2);
}

    }
