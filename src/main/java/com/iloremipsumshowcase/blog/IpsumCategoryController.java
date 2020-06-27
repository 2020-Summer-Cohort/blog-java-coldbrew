package com.iloremipsumshowcase.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class IpsumCategoryController {
    private IpsumCategoryRepository ipsumCategoryRepo;
    public IpsumCategoryController(IpsumCategoryRepository ipsumCategoryRepo) {
        this.ipsumCategoryRepo = ipsumCategoryRepo;
    }

    public String displayAllIpsumCategories(Model mockModel) {
        mockModel.addAttribute("ipsumcategories",ipsumCategoryRepo.findAll());
        return null;
    }
}
