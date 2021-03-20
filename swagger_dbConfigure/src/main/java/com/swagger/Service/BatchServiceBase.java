package com.swagger.Service;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.function.Consumer;
import java.util.function.Function;

public abstract class BatchServiceBase {

    abstract SqlSessionFactory getSqlSessionFactory();

    public <T> void doInBatch(Class<T> mapperClass, Consumer<T> consumer) {
        doInBatchWithReturn(mapperClass, mapper -> {
            consumer.accept(mapper);
            return null;
        });
    }

    public <T, R> R doInBatchWithReturn(Class<T> mapperClass, Function<T, R> func) {
        R result;
        try (SqlSession sqlSession = getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            T mapper = sqlSession.getMapper(mapperClass);
            result = func.apply(mapper);
            sqlSession.commit();
        }
        return result;
    }
}
