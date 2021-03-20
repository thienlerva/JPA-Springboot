package com.swagger.Service;

import com.swagger.configure.CAMPSDataSourceConfiguration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CAMPSBatchService extends BatchServiceBase {

    @Autowired
    @Qualifier(CAMPSDataSourceConfiguration.CAMPS_SESSION_FACTORY)
    SqlSessionFactory sqlSessionFactory;

    @Override
    SqlSessionFactory getSqlSessionFactory() { return sqlSessionFactory; }

//    public List<Student> doInBatchWithReturn(Class<Student> mapperClass) {
//
//        try (SqlSession sqlSession = getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
//
//            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
//            List<Student> students = studentMapper.findAll()
//            sqlSession.commit();
//        }
//        return result;
//    }
}
