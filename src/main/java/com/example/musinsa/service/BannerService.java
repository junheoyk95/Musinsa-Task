package com.example.musinsa.service;

import com.example.musinsa.dao.BannerDAO;
import com.example.musinsa.vo.BannerDVO;
import com.example.musinsa.vo.BannerPVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {
    @Autowired
    BannerDAO bannerDAO;

    public List<BannerDVO> selectBannerList(BannerPVO bannerPVO) {

        List<BannerDVO> list = bannerDAO.selectDataList("selectBannerList", bannerPVO);

        return list;
    }

    public BannerDVO selectBannerById(BannerPVO bannerPVO) {

        return bannerDAO.selectData("selectBannerById", bannerPVO);
    }

    public BannerDVO selectBannerByImage(BannerPVO bannerPVO) {

        return bannerDAO.selectData("selectBannerByImage", bannerPVO);
    }

    public int insertBanner(BannerPVO bannerPVO) {

        int result = bannerDAO.insertData("insertBanner", bannerPVO);

        return result;
    }

    public int deleteBanner(BannerPVO bannerPVO) {

        int result = bannerDAO.deleteData("deleteBanner", bannerPVO);

        return result;
    }
}
