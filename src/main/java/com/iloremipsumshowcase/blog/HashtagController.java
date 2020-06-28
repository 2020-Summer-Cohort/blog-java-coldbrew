package com.iloremipsumshowcase.blog;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class HashtagController {
private HashtagRepository hashtagRepo;
private IpsumPostRepository ipsumPostRepo;
    public HashtagController(HashtagRepository hashtagRepo, IpsumPostRepository ipsumPostRepo) {
        this.hashtagRepo = hashtagRepo;
        this.ipsumPostRepo = ipsumPostRepo;
    }

    @RequestMapping("hashtags/{id}")
    public String showSingleHashtag( @PathVariable Long id, Model model) {
    model.addAttribute("hashtags",hashtagRepo.findById(id));
    return "hashtag-template";
    }
    @GetMapping("hashtags")
    public String showAllHashtags(Model model){
        model.addAttribute("hashtags", hashtagRepo.findAll());
        return "home-template";
    }
    @PostMapping("hashtags/add")
    public String addHashtag(String hashtagName){
        Hashtag hashtagToAdd = new Hashtag(hashtagName);
        hashtagRepo.save(hashtagToAdd);
        return "redirect:/";
    }

    @PostMapping("hashtags/delete")
    public String deleteHashtag(Long hashtagId){
        hashtagRepo.deleteById(hashtagId);
        return "redirect:/";
    }
}
