package com.example.musinsa.common;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommonDAO<TP, TD> extends SqlSessionDaoSupport {

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public TD selectData(String queryId, TP param) {
        try {
            return getSqlSession().selectOne(queryId, param);
        } catch (Exception e) {
            throw new RuntimeException(String.format("%s 데이터 조회 오류", queryId), e);
        }
    }

    public List<TD> selectDataList(String queryId, TP param) {
        try {
            return getSqlSession().selectList(queryId, param);
        } catch (Exception e) {
            throw new RuntimeException(String.format("%s 데이터 조회 오류", queryId), e);
        }
    }

    public <T> int insertData(String queryId, T param) {
        try {
            return getSqlSession().insert(queryId, param);
        } catch (Exception e) {
            throw new RuntimeException(String.format("%s 데이터 등록 오류", queryId), e);
        }
    }

    public <T> int updateData(String queryId, T param) {
        try {
            return getSqlSession().update(queryId, param);
        } catch (Exception e) {
            throw new RuntimeException(String.format("%s 데이터 수정 오류", queryId), e);
        }
    }

    public <T> int deleteData(String queryId, T param) {
        try {
            return getSqlSession().delete(queryId, param);
        } catch (Exception e) {
            throw new RuntimeException(String.format("%s 데이터 삭제 오류", queryId), e);
        }
    }
}
