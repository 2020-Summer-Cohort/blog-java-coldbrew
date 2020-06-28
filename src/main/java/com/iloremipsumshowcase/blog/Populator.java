package com.iloremipsumshowcase.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    IpsumPostRepository ipsumPostRepo;
    @Autowired
    IpsumCategoryRepository ipsumCategoryRepo;
    @Autowired
    AuthorRepository authorRepo;
    @Autowired
    HashtagRepository hashtagRepo;


    @Override
    public void run(String... args){
        IpsumCategory alphabetIpsums = new IpsumCategory("Alphabet Ipsums","Lorem Ipsums which utilize other alphabets and languages");
        IpsumCategory humorIpsums = new IpsumCategory("Chuckle Ipsums","Twists on the classic Lorem Ipsum designed to make the reader laugh.");
        IpsumCategory fillerIpsum = new IpsumCategory("Other Filler Texts","Unique Ipsum-ajacent methods of filling up text on a page");
        ipsumCategoryRepo.save(alphabetIpsums);
        ipsumCategoryRepo.save(humorIpsums);
        ipsumCategoryRepo.save(fillerIpsum);

        Author author1 = new Author("Cicero");
        Author author2 = new Author("Mr.Letraset");
        Author author3 = new Author("xxxBIG_IPSUM_FANxxx");
        authorRepo.save(author1);
        authorRepo.save(author2);
        authorRepo.save(author3);

        Hashtag hashtag1 = new Hashtag("haha");
        Hashtag hashtag2 = new Hashtag("non-english");
        Hashtag hashtag3 = new Hashtag("TryThisOnForSize");
        hashtagRepo.save(hashtag1);
        hashtagRepo.save(hashtag2);
        hashtagRepo.save(hashtag3);
        LocalDate date1 = LocalDate.of(2020, 6, 27);
        LocalDate date2 = LocalDate.of(2020, 6,28);

//        this.ipsumName = ipsumName;
//        this.ipsumDescription = ipsumDescription;
//        this.ipsumSample = ipsumSample;
//        this.ipsumSource = ipsumSource;
//        this.ipsumCategory = ipsumCategory;
//        this.author = author;
//        this.bgPic = bgPic;
//        this.date = date;
//        this.hashtags = new ArrayList<>(Arrays.asList(hashtags));
        IpsumPost ipsumPost1 = new IpsumPost("Lorem Ipsum","The classic filler text, helping create page templates since 1914.","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ",
        "https://www.lipsum.com/", "https://cdn-www.enfocus.com/sites/combell-www.enfocus.com/files/media/blog/2017-08-09-Lorem-Ipsum/lorem-ipsum.jpg",
                date1, alphabetIpsums,author1,hashtag3);
        IpsumPost ipsumPost2 = new IpsumPost("Thousand Character Classic","This filler text is used by some chinese companies for graphic design filler text with Chinese Characters. It comes from a classic Chinese Poem for teaching children to read.", "天地玄黄 宇宙洪荒 日月盈昃 辰宿列张 寒来暑往 秋收冬藏  闰馀成岁 律吕调阳 云腾致雨 露结为霜 金生丽水 玉出昆冈 剑号巨阙",
                "https://www.chinasage.info/1000character-classic.htm","https://www.chinasage.info/imgs/Script1000.jpg",
                date1,alphabetIpsums,author3,hashtag2,hashtag3);

        IpsumPost ipsumPost3 = new IpsumPost("Dummy Test","this filler text often used for Japanese page layouts. The characters form the english words 'dummy test', and it is named as such", "ダミーテキストダミーテキストダミーテキストダミーテキストダミーテキストダミーテキストダミーテキストダミーテキストダミーテキスト",
                "https://lipsum.sugutsukaeru.jp/","https://static.vecteezy.com/system/resources/previews/000/089/609/original/crash-dummy-vectors.jpg",
                date2,alphabetIpsums,author2,hashtag2,hashtag3);

        IpsumPost ipsumPost4 = new IpsumPost("Pirate Ipsum","This amusing variant on Lorem Ipsum uses garbled words associated with pirates and sailign to fill up your webpage.","Prow scuttle parrel provost Sail ho shrouds spirits boom mizzenmast yardarm. Pinnace holystone mizzenmast quarter crow's nest nipperkin grog yardarm hempen halter furl. Swab barque interloper.",
                "https://pirateipsum.me/","https://www.tacer.biz/mm5/graphics/00000001/Pirate-Parrot-Prop-1.jpg",date2,humorIpsums,author3,hashtag1);
        IpsumPost ipsumPost5 = new IpsumPost("Alice in Wonderland", "A frequent alternative to generated nonsense and filler text is to use passages from Lewis Caroll's Alice in Wonderland."," The Mock Turtle sighed deeply, and drew the back of one flapper across his eyes. He looked at Alice, and tried to speak, but for a minute or two sobs choked his voice. ",
                "https://www.gutenberg.org/files/11/11-h/11-h.htm","https://i.pinimg.com/originals/06/e1/92/06e192535e56210ce9a6e36204e41e99.jpg",date2,fillerIpsum,author2,hashtag3);

        ipsumPostRepo.save(ipsumPost1);
        ipsumPostRepo.save(ipsumPost2);
        ipsumPostRepo.save(ipsumPost3);
        ipsumPostRepo.save(ipsumPost4);
        ipsumPostRepo.save(ipsumPost5);
    }

}
