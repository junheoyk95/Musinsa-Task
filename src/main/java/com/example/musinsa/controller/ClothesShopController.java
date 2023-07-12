package com.example.musinsa.controller;

import com.example.musinsa.vo.MenuPVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClothesShopController {

    @GetMapping("/clothesShop")
    public String clothesShopPage(MenuPVO menuPVO, Model model) {

        model.addAttribute("parentType", menuPVO.getParentType());
        model.addAttribute("childType", menuPVO.getChildType());

        return "/clothesShop";
    }

}
