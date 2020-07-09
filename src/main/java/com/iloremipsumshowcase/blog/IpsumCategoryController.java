package com.iloremipsumshowcase.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class IpsumCategoryController {
    private IpsumCategoryRepository ipsumCategoryRepo;
    private HashtagRepository hashtagRepo;
    private AuthorRepository authorRepo;
    private IpsumPostRepository ipsumPostRepo;

    public IpsumCategoryController(IpsumCategoryRepository ipsumCategoryRepo, HashtagRepository hashtagRepo, AuthorRepository authorRepo, IpsumPostRepository ipsumPostRepo) {
        this.ipsumCategoryRepo = ipsumCategoryRepo;
        this.hashtagRepo = hashtagRepo;
        this.authorRepo = authorRepo;
        this.ipsumPostRepo = ipsumPostRepo;
    }

    @GetMapping("ipsumcategories")
    public String displayAllIpsumCategories(Model model) {
        model.addAttribute("ipsumcategories", ipsumCategoryRepo.findAll());
        model.addAttribute("hashtags", hashtagRepo.findAll());
        return "allcategories-template";
    }

    @GetMapping("ipsumcategories/{categoryName}")
    public String showSingleIpsumCategory(@PathVariable String categoryName, Model model) {
        model.addAttribute("ipsumcategory", ipsumCategoryRepo.findByCategoryName(categoryName));
        model.addAttribute("ipsumcategories", ipsumCategoryRepo.findAll());
        model.addAttribute("ipsumposts",ipsumPostRepo.findAll());
        model.addAttribute("hashtags", hashtagRepo.findAll());
        model.addAttribute("authors",authorRepo.findAll());
        return "ipsumcategory-template";

    }

    @PostMapping("ipsumcategories/add")
    public String addIpsumCategory(String categoryName, String description) {
        IpsumCategory ipsumCategoryToAdd = new IpsumCategory(categoryName, description);
        ipsumCategoryRepo.save(ipsumCategoryToAdd);
        return "redirect:/";
    }
}