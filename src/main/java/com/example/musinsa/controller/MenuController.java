package com.example.musinsa.controller;

import com.example.musinsa.service.BannerService;
import com.example.musinsa.service.MenuService;
import com.example.musinsa.vo.BannerDVO;
import com.example.musinsa.vo.BannerPVO;
import com.example.musinsa.vo.MenuDVO;
import com.example.musinsa.vo.MenuPVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;
    private final BannerService bannerService;

    @GetMapping("/")
    public String home(MenuPVO menuPVO, Model model) {

        List<MenuDVO> list = menuService.selectMainMenuList(menuPVO);
        model.addAttribute("menuList",  list);

        return "/menu";
    }

    @PostMapping("/selectSubMenuList")
    public String selectSubMenuList(@RequestBody MenuPVO menuPVO, Model model) {

        if(menuPVO.getMenuOrder() == 1) {
            BannerPVO bannerPVO = new BannerPVO();
            List<BannerDVO> bannerList = getAllBannerImagePaths(bannerPVO);
            model.addAttribute("bannerList", bannerList);
        }

        List<MenuDVO> list = menuService.selectSubMenuList(menuPVO);
        model.addAttribute("subMenuList",  list);

        return "/menu :: #subMenuTable";
    }

    private List<BannerDVO> getAllBannerImagePaths(BannerPVO bannerPVO) {
        // 이미지 파일 디렉토리 경로 설정
        String filePath = "/image/fileDirectory/";
        List<BannerDVO> bannerList = bannerService.selectBannerList(bannerPVO);

        if (bannerList != null) {
            // 이미지 파일의 경로를 리스트에 추가
            for (BannerDVO banner : bannerList) {
                banner.setImage(filePath + banner.getImage());
            }
        }

        return bannerList;
    }

    @GetMapping("/menuManagement")
    public String menuManagement(MenuPVO menuPVO, Model model) {

        List<MenuDVO> list = menuService.selectMenuList(menuPVO);
        model.addAttribute("menuList",  list);

        List<MenuDVO> parentMenuList = menuService.selectMainMenuList(menuPVO);
        model.addAttribute("parentMenuList", parentMenuList);

        return "/menuManagement";
    }


    @PostMapping("/menuManagement/getMenuList")
    public String getMenuList(@RequestBody MenuPVO menuPVO, Model model) {

        List<MenuDVO> list = menuService.selectMenuList(menuPVO);
        model.addAttribute("menuList",  list);

        return "/menuManagement :: #menuTable";
    }

    @PostMapping("/menuManagement/getMenuInfo")
    public ResponseEntity<MenuDVO> getMenuInfo(@RequestBody MenuPVO menuPVO, Model model) {

        MenuDVO menu = menuService.selectMenuInfo(menuPVO);
        model.addAttribute("menu",  menu);

        if (menu != null) {
            return ResponseEntity.ok(menu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/menuManagement/menuCreate")
    public ResponseEntity<Object> insertMenu(@RequestBody MenuPVO menuPVO) {

        int result = menuService.insertMenu(menuPVO);

        if (result > 0) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/menuManagement/menuUpdate")
    public ResponseEntity<Object> updateMenu(@RequestBody MenuPVO menuPVO) {

        int result = menuService.updateMenu(menuPVO);

        if (result > 0) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/menuManagement/menuDelete")
    public ResponseEntity<Object> deleteMenu(@RequestBody MenuPVO menuPVO) {

        int result = menuService.deleteMenu(menuPVO);

        if (result > 0) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
