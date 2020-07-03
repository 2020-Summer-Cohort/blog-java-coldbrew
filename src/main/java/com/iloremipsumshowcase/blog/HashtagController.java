package com.iloremipsumshowcase.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HashtagController {
private HashtagRepository hashtagRepo;
private IpsumPostRepository ipsumPostRepo;
private IpsumCategoryRepository ipsumCategoryRepo;
    public HashtagController(HashtagRepository hashtagRepo, IpsumPostRepository ipsumPostRepo, IpsumCategoryRepository ipsumCategoryRepo) {
        this.hashtagRepo = hashtagRepo;
        this.ipsumPostRepo = ipsumPostRepo;
        this.ipsumCategoryRepo = ipsumCategoryRepo;
    }

    @GetMapping("hashtags/{id}")
    public String showSingleHashtag( @PathVariable Long id, Model model) {

        model.addAttribute("hashtagToDisplay",hashtagRepo.findHashtagById(id));
        model.addAttribute("ipsumcategories",ipsumCategoryRepo.findAll());
    return "hashtag-template";
    }

    @GetMapping("hashtags/")
    public String showAllHashtags(Model model){
        model.addAttribute("hashtags", hashtagRepo.findAll());
        return "allhashtags-template";
       }
    @PostMapping("hashtags/add")
    public String addHashtag(String hashtagName, String ipsumName){
        IpsumPost ipsumPostToAddHashtag = ipsumPostRepo.findByIpsumName(ipsumName);
        Hashtag newHashtag = new Hashtag(hashtagName);
        hashtagRepo.save(newHashtag);
        ipsumPostToAddHashtag.addHashtag(newHashtag);
        ipsumPostRepo.save(ipsumPostToAddHashtag);

        return "redirect:/";
    }


    @PostMapping("hashtags/remove")
    public String deleteHashtag(String hashtagName, String ipsumName){
        IpsumPost ipsumPostToRemoveHashtag = ipsumPostRepo.findByIpsumName(ipsumName);
        Hashtag oldHashtag = hashtagRepo.findHashtagByHashtagName(hashtagName);
        ipsumPostToRemoveHashtag.removeHashtag(oldHashtag);
        ipsumPostRepo.save(ipsumPostToRemoveHashtag);
        if(oldHashtag.getIpsumPosts().isEmpty()){
            hashtagRepo.delete(oldHashtag);
        }
        return "redirect:/";
    }
}
