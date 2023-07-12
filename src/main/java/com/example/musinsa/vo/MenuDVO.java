package com.example.musinsa.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("menuDVO")
public class MenuDVO {
    private int id;
    private String menuNm;
    private String url;
    private int level;
    private int menuOrder;
    private int parentId;
    private String parentType;
    private String childType;

}
