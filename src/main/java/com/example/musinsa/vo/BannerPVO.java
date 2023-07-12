package com.example.musinsa.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("bannerPVO")
public class BannerPVO {
    private int id;
    private String image;
    private String url;
    private String text;
    private int bannerOrder;

}
