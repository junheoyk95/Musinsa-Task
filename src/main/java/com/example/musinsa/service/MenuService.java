package com.example.musinsa.service;

import com.example.musinsa.dao.MenuDAO;
import com.example.musinsa.vo.MenuDVO;
import com.example.musinsa.vo.MenuPVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuDAO menuDAO;

    public List<MenuDVO> selectMainMenuList(MenuPVO menuPVO) {

        return menuDAO.selectDataList("selectMainMenuList", menuPVO);
    }

    public List<MenuDVO> selectSubMenuList(MenuPVO menuPVO) {

        return menuDAO.selectDataList("selectSubMenuList", menuPVO);
    }

    public List<MenuDVO> selectMenuList(MenuPVO menuPVO) {

        return menuDAO.selectDataList("selectMenuList", menuPVO);
    }

    public MenuDVO selectMenuInfo(MenuPVO menuPVO) {

        return menuDAO.selectData("selectMenuInfo", menuPVO);
    }

    public MenuDVO selectMenuByName(MenuPVO menuPVO) {

        return menuDAO.selectData("selectMenuByName", menuPVO);
    }

    public int insertMenu(MenuPVO menuPVO) {

        return menuDAO.insertData("insertMenu", menuPVO);
    }

    public int updateMenu(MenuPVO menuPVO) {

        return menuDAO.updateData("updateMenu", menuPVO);
    }

    public int deleteMenu(MenuPVO menuPVO) {

        return menuDAO.deleteData("deleteMenu", menuPVO);
    }
}
