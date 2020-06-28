package com.iloremipsumshowcase.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IpsumCategoryController {
    private IpsumCategoryRepository ipsumCategoryRepo;
    private HashtagRepository hashtagRepo;

    public IpsumCategoryController(IpsumCategoryRepository ipsumCategoryRepo, HashtagRepository hashtagRepo) {
        this.ipsumCategoryRepo = ipsumCategoryRepo;
        this.hashtagRepo = hashtagRepo;
    }
    @GetMapping("ipsumcategories")
    public String displayAllIpsumCategories(Model model) {
        model.addAttribute("ipsumcategories",ipsumCategoryRepo.findAll());
        model.addAttribute("hashtags",hashtagRepo.findAll());
        return "home-template";
    }
    @GetMapping("ipsumcategories/{ipsumCategoryName}")
    public String showSingleIpsumCategory(String ipsumCategoryName, Model model) {
    model.addAttribute("ipsumcategory",ipsumCategoryRepo.findByName(ipsumCategoryName));
    model.addAttribute("hashtags",hashtagRepo.findAll());
    return "ipsumcategory-template";

    }
    @PostMapping("ipsumcategories/add")
    public String addIpsumCategory(String ipsumCategoryName, String description ){
        IpsumCategory ipsumCategoryToAdd = new IpsumCategory(ipsumCategoryName,description);
        ipsumCategoryRepo.save(ipsumCategoryToAdd);
        return "redirect:/";
    }
//    @PostMapping("/categories/add")
//    public String addNewIpsumCategory()
}
