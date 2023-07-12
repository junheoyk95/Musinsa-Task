package com.example.musinsa.dao;

import com.example.musinsa.common.CommonDAO;
import com.example.musinsa.vo.MenuDVO;
import com.example.musinsa.vo.MenuPVO;
import org.springframework.stereotype.Repository;

@Repository("menuDAO")
public class MenuDAO extends CommonDAO<MenuPVO, MenuDVO> {

}
