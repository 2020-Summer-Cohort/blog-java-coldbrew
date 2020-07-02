package com.iloremipsumshowcase.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Controller
public class IpsumPostController {
    private IpsumPostRepository ipsumPostRepo;
    private IpsumCategoryRepository ipsumCategoryRepo;
    private AuthorRepository authorRepo;
    private HashtagRepository hashtagRepo;
    public IpsumPostController(IpsumPostRepository ipsumPostRepo, IpsumCategoryRepository ipsumCategoryRepo, AuthorRepository authorRepo, HashtagRepository hashtagRepo) {
        this.ipsumPostRepo = ipsumPostRepo;
        this.ipsumCategoryRepo = ipsumCategoryRepo;
        this.authorRepo = authorRepo;
        this.hashtagRepo = hashtagRepo;
    }

    @GetMapping("ipsumposts/{ipsumName}")
    public String showSingleIpsumPost(@PathVariable String ipsumName, Model model){
        model.addAttribute("ipsumPostToDisplay",ipsumPostRepo.findByIpsumName(ipsumName));
        model.addAttribute("ipsumcategories",ipsumCategoryRepo.findAll());

        return "ipsumpost-template";
    }

    @GetMapping("ipsumposts")
    public String showAllIpsumPosts(Model model){
        model.addAttribute("ipsumposts",ipsumPostRepo.findAll());
        model.addAttribute("authors",authorRepo.findAll());
        model.addAttribute("ipsumcategories",ipsumCategoryRepo.findAll());
        return "allipsumposts-template";
    }

    @PostMapping("ipsumposts/add")
    public String addIpsumPost(String ipsumName, String ipsumDescription, String ipsumSample, String ipsumSource, String bgPic, LocalDate date3, String postCategoryName, String postAuthorName/*, long... hashtagIds*/) {
        IpsumCategory categoryName = ipsumCategoryRepo.findByCategoryName(postCategoryName);
        Author author = authorRepo.findByAuthorName(postAuthorName);
//        Collection<Hashtag> postHashtags = Arrays.stream(hashtagIds)
//                .mapToObj(id->hashtagRepo.findHashtagById(id))
//                .collect(Collectors.toSet());
        ipsumPostRepo.save(new IpsumPost(ipsumName,ipsumDescription,
                ipsumSample, ipsumSource, bgPic, date3,
                categoryName, author));

        return "redirect:/ipsumcategories/"+postCategoryName;
    }

    @PostMapping("ipsumposts/delete")
    public String deleteIpsumPost(String ipsumName){
       IpsumPost ipsumPostToDelete = ipsumPostRepo.findByIpsumName(ipsumName);
       ipsumPostRepo.delete(ipsumPostToDelete);
        return "redirect:/";
    }

}

