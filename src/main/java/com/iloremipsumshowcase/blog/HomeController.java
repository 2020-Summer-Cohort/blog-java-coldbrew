package com.iloremipsumshowcase.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private IpsumPostRepository ipsumPostRepo;
    private AuthorRepository authorRepo;
    private IpsumCategoryRepository ipsumCategoryRepo;
    private HashtagRepository hashtagRepo;

    public HomeController(IpsumCategoryRepository ipsumCategoryRepo,HashtagRepository hashtagRepo){
        this.ipsumCategoryRepo = ipsumCategoryRepo;
        this.hashtagRepo = hashtagRepo;

    }

    @RequestMapping({"","/"})
    public String displayTheIndex(Model model){
        model.addAttribute("ipsumcategories", ipsumCategoryRepo.findAll());
        model.addAttribute("hashtag",hashtagRepo.findAll());
        return "index-template";
    }
}
