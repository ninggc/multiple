package com.ninggc.demo.morphiademo.morphia.dao.base;

import com.mongodb.MongoException;
import com.ninggc.demo.morphiademo.morphia.dao.base.impl.MorphiaQueryCondition;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LXL on 2017/9/20.
 * Hibernate BaseDao 实现类
 * @param <T> 实体类
 */
public interface MorphiaBase<T> {

    /**
     * <br> 将某个主键为空的实体存入数据库,由于实体中主键的生成策略一般为整型自增,且主键唯一
     * <br> 因此当实体的主键存在时不建议使用此方法,而应该使用 update
     * @param po 需要持久化的实体类
     * @return 已经持久化的实体类, 且主键已自动分配
     */
    T save(T po);

    /**
     * <br> 对某个已经知道主键的实体进行修改时,通过此方法完成待修改实体的持久化操作
     * @param po 需要持久化的实体类
     * @return 已经持久化的实体类
     */
    T update(T po);

    /**
     * <br> 根据实体类的主键 id 获取实体类
     * @param id 实体类的主键 id
     * @return 对应 id 实体类
     */
    T get(Serializable id);

    /**
     * <br> 查询全部的记录
     * @return 全部记录
     */
    List<T> findAll();

    /**
     * <br> 查询全部的记录,以分页方式返回,具体显示哪一页通过 pageNumber 传入,采用默认的页大小(每页10条记录)
     * @param pageNumber 需要查询第几页
     * @return 分页结果对象
     */
    List<T> findAll(int pageNumber);

    /**
     * <br> 查询全部的记录,以分页方式返回,具体显示哪一页通过 pageNumber 传入,采用指定的页大小(每页 pageSize 条记录)
     * @param pageNumber 需要查询第几页
     * @param pageSize   每页包含多少条记录
     * @return 分页结果对象
     */
    List<T> findAll(int pageNumber, int pageSize);

    /**
     * <br> 使用查询对象 QueryCondition 进行 AND 查询
     * @param queryCondition 查询对象
     * @return 符合条件的查询结果
     */
    List<T> findByAND(MorphiaQueryCondition queryCondition);

    /**
     * <br> 使用查询对象 QueryCondition 进行 AND 查询,具体显示哪一页通过 pageNumber 传入,采用默认的页大小(每页10条记录)
     * @param pageNumber     需要查询第几页
     * @param queryCondition 查询对象
     * @return 分页结果对象
     */
    List<T> findByAND(int pageNumber, MorphiaQueryCondition queryCondition);

    /**
     * <br> 使用查询对象 QueryCondition 进行 AND 查询,具体显示哪一页通过 pageNumber 传入,采用指定的页大小(每页 pageSize 条记录)
     * @param pageNumber     需要查询第几页
     * @param pageSize       每页包含多少条记录
     * @param queryCondition 查询对象
     * @return 分页结果对象
     */
    List<T> findByAND(int pageNumber, int pageSize, MorphiaQueryCondition queryCondition);

    /**
     * <br> 使用查询对象 QueryCondition 进行 AND 的统计学方式查询
     * @param queryCondition 查询对象
     * @return 分页结果对象
     */
    Object findByANDWithStatistic(MorphiaQueryCondition queryCondition);

    /**
     * <br> 使用查询对象 QueryCondition 进行 OR 查询
     * @param queryCondition 查询对象
     * @return 对应的查询结果
     */
    List<T> findByOR(MorphiaQueryCondition queryCondition);

    /**
     * <br> 使用查询对象 QueryCondition 进行 OR 查询,具体显示哪一页通过 pageNumber 传入,采用默认的页大小(每页10条记录)
     * @param pageNumber     需要查询第几页
     * @param queryCondition 查询对象
     * @return 分页结果对象
     */
    List<T> findByOR(int pageNumber, MorphiaQueryCondition queryCondition);

    /**
     * <br> 使用查询对象 QueryCondition 进行 OR 查询,具体显示哪一页通过 pageNumber 传入,采用指定的页大小(每页 pageSize 条记录)
     * @param pageNumber     需要查询第几页
     * @param pageSize       每页包含多少条记录
     * @param queryCondition 查询对象
     * @return 分页结果对象
     */
    List<T> findByOR(int pageNumber, int pageSize, MorphiaQueryCondition queryCondition);

    /**
     * <br> 使用查询对象 QueryCondition 进行 OR 的统计学方式查询
     * @param queryCondition 查询对象
     * @return 分页结果对象
     */
    Object findByORWithStatistic(MorphiaQueryCondition queryCondition);

    /**
     * 批量插入
     * 由于Morphia不支持事务，现在使用Java Drive实现
     * @param pos
     */
    public void saveList(List<T> pos) throws MongoException;
}
