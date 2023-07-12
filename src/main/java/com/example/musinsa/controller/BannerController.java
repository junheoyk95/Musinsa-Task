package com.example.musinsa.controller;

import com.example.musinsa.common.ImageUploader;
import com.example.musinsa.service.BannerService;
import com.example.musinsa.vo.BannerDVO;
import com.example.musinsa.vo.BannerPVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/bannerManagement")
@RequiredArgsConstructor
public class BannerController {

    private final BannerService bannerService;
    private final ImageUploader imageUploader;

    @GetMapping
    public String bannerManagement(BannerPVO bannerPVO, Model model) {

        List<BannerDVO> list = bannerService.selectBannerList(bannerPVO);
        model.addAttribute("bannerList", list);

        return "/bannerManagement";
    }

    @PostMapping("/getBannerList")
    public String getBannerList(BannerPVO bannerPVO, Model model) {

        List<BannerDVO> list = bannerService.selectBannerList(bannerPVO);
        model.addAttribute("bannerList", list);

        return "/bannerManagement :: #bannerTable";
    }

    @PostMapping("/bannerCreate")
    public ResponseEntity<Object> insertBanner(@RequestBody BannerPVO bannerPVO) {

        int result = bannerService.insertBanner(bannerPVO);

        if (result > 0) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/bannerDelete")
    public ResponseEntity<Object> deleteBanner(@RequestBody BannerPVO bannerPVO) {

        BannerDVO bannerDVO = bannerService.selectBannerById(bannerPVO);
        if (bannerDVO == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            int result = bannerService.deleteBanner(bannerPVO);
            String filename = bannerPVO.getImage();

            if (result > 0) {
                imageUploader.deleteImage(filename);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/bannerUpload")
    public ResponseEntity<String> uploadBanner(@RequestParam("imageFile") MultipartFile file,
                                               @RequestParam("text") String text,
                                               @RequestParam("url") String url,
                                               @RequestParam("order") int order) {
        try {
            String fileName = imageUploader.uploadImage(file);

            BannerPVO bannerPVO = new BannerPVO();
            bannerPVO.setImage(fileName);
            bannerPVO.setText(text);
            bannerPVO.setUrl(url);
            bannerPVO.setBannerOrder(order);
            bannerService.insertBanner(bannerPVO);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
