package com.example.musinsa.dao;

import com.example.musinsa.common.CommonDAO;
import com.example.musinsa.vo.BannerDVO;
import com.example.musinsa.vo.BannerPVO;
import org.springframework.stereotype.Repository;

@Repository("bannerDAO")
public class BannerDAO extends CommonDAO<BannerPVO, BannerDVO> {

}
