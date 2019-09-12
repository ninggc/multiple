package com.ninggc.demo.morphiademo.morphia.dao.base.impl;

import com.ninggc.demo.morphiademo.morphia.util.DeleteEnum;
import com.ninggc.demo.morphiademo.morphia.dao.base.AbstractQueryCondition;
import com.ninggc.demo.morphiademo.morphia.util.MorphiaMatchMode;
import dev.morphia.query.Criteria;
import dev.morphia.query.CriteriaContainer;
import dev.morphia.query.Query;
import dev.morphia.query.Sort;

import java.util.*;

/**
 * MorphiaQueryCondition可以视为QueryCondition
 * 区别如下：
 * 1. 将private字段设置为protected
 * 2. 添加与key-content有关的查询
 */
public class MorphiaQueryCondition extends AbstractQueryCondition {

    //    key-content的对比单独进行
    private Map<String, Object[]> keyContent;

    /**
     * 指定key查找
     * @param key
     */
    public void addEqKey(String key) {
        keyContent = keyContent == null ? new HashMap<>() : keyContent;
        keyContent.putIfAbsent("map." + key, null);
    }

    public void addEqKeyContent(String key, String content) {
        addLikeKeyContent(key, content, MorphiaMatchMode.EXACT);
    }

    /**
     * 指定key-content查找
     *
     * @param key
     * @param content
     * @param matchMode
     */
    public void addLikeKeyContent(String key, String content, MorphiaMatchMode matchMode) {
        keyContent = keyContent == null ? new HashMap<>() : keyContent;
        keyContent.put("map." + key, new Object[]{content, matchMode});
    }

    @Override
    public <T> Query<T> andCriteria(Query<T> query) {
        // 获取查询条件
        List<CriteriaContainer> criterionList = getCriterions(query);
        // 构造 AND 查询条件,默认添加即为 AND 查询
        if (null != criterionList && criterionList.size() > 0) {
            query.and(criterionList.toArray(new Criteria[0]));
        }
        // 添加排序方式后返回
        initCriteriaOrder(query);
        return query;
    }

    @Override
    public <T> Query<T> orCriteria(Query<T> query) {
        // 获取查询条件
        List<CriteriaContainer> criterionList = getCriterions(query);
        // 构造 AND 查询条件,默认添加即为 AND 查询
        if (null != criterionList && criterionList.size() > 0) {
            query.or(criterionList.toArray(new Criteria[0]));
        }
        // 添加排序方式后返回
        initCriteriaOrder(query);
        return query;
    }

    @SuppressWarnings("all")
    @Override
    protected <T> List<CriteriaContainer> getCriterions(Query<T> morphiaQuery) {
        // 设置返回数组
        List<CriteriaContainer> criterionList = new ArrayList<>();

        // 设置等于条件
        if (null != eq) {
            for (Map.Entry<String, Object> query : eq.entrySet()) {
                String columnName = query.getKey();
                Object param = query.getValue();
                if (param instanceof DeleteEnum) {
                    param = ((DeleteEnum) param).value();
                }
                CriteriaContainer criterion = morphiaQuery.criteria(columnName).equal(param);
                criterionList.add(criterion);
            }
        }
        // 设置不等于条件
        if (null != ne) {
            for (Map.Entry<String, Object> query : ne.entrySet()) {
                String columnName = query.getKey();
                Object param = query.getValue();
                CriteriaContainer criterion = morphiaQuery.criteria(columnName).notEqual(param);
                criterionList.add(criterion);
            }
        }
        // 设置大于条件
        if (null != gt) {
            for (Map.Entry<String, Object> query : gt.entrySet()) {
                String columnName = query.getKey();
                Object param = query.getValue();
                CriteriaContainer criterion = morphiaQuery.criteria(columnName).greaterThan(param);
                criterionList.add(criterion);
            }
        }
        // 设置大于等于条件
        if (null != ge) {
            for (Map.Entry<String, Object> query : ge.entrySet()) {
                String columnName = query.getKey();
                Object param = query.getValue();
                CriteriaContainer criterion = morphiaQuery.criteria(columnName).greaterThanOrEq(param);
                criterionList.add(criterion);
            }
        }
        // 设置小于条件
        if (null != lt) {
            for (Map.Entry<String, Object> query : lt.entrySet()) {
                String columnName = query.getKey();
                Object param = query.getValue();
                CriteriaContainer criterion = morphiaQuery.criteria(columnName).lessThan(param);
                criterionList.add(criterion);
            }
        }
        // 设置小于等于条件
        if (null != le) {
            for (Map.Entry<String, Object> query : le.entrySet()) {
                String columnName = query.getKey();
                Object param = query.getValue();
                CriteriaContainer criterion = morphiaQuery.criteria(columnName).lessThanOrEq(param);
                criterionList.add(criterion);
            }
        }
        // 设置模糊查询条件
        if (null != like) {
            for (Map.Entry<String, Object[]> query : like.entrySet()) {
                String columnName = query.getKey();
                Object[] param = query.getValue();
                CriteriaContainer container = null;
                if (MorphiaMatchMode.ANYWHERE.equals(param[1])) {
                    container = morphiaQuery.criteria(columnName).contains((String) param[0]);
                } else if (MorphiaMatchMode.START.equals(param[1])) {
                    container = morphiaQuery.criteria(columnName).startsWith((String) param[0]);
                } else if (MorphiaMatchMode.END.equals(param[1])) {
                    container = morphiaQuery.criteria(columnName).endsWith((String) param[0]);
                } else if (MorphiaMatchMode.EXACT.equals(param[1])) {
                    container = morphiaQuery.criteria(columnName).equal((String) param[0]);
                }
                criterionList.add(container);
            }
        }
        // 设置忽略大小写的模糊查询条件
        if (null != iLike) {
            for (Map.Entry<String, Object[]> query : iLike.entrySet()) {
                String columnName = query.getKey();
                Object[] param = query.getValue();
                CriteriaContainer container = null;
                if (MorphiaMatchMode.ANYWHERE.equals(param[1])) {
                    container = morphiaQuery.criteria(columnName).containsIgnoreCase((String) param[0]);
                } else if (MorphiaMatchMode.START.equals(param[1])) {
                    container = morphiaQuery.criteria(columnName).startsWithIgnoreCase((String) param[0]);
                } else if (MorphiaMatchMode.END.equals(param[1])) {
                    container = morphiaQuery.criteria(columnName).endsWithIgnoreCase((String) param[0]);
                } else if (MorphiaMatchMode.EXACT.equals(param[1])) {
                    container = morphiaQuery.criteria(columnName).equalIgnoreCase((String) param[0]);
                }
                criterionList.add(container);
            }
        }
        // 设置在所给参数值中的查询条件
        if (null != in) {
            for (Map.Entry<String, Object[]> entry : in.entrySet()) {
                String columnName = entry.getKey();
                Object[] params = entry.getValue();
                CriteriaContainer criterion = morphiaQuery.criteria(columnName).in(Arrays.asList(params));
                criterionList.add(criterion);
            }
        }

        // 设置不在所给参数值的的查询条件,即对 in 查询条件取反
        if (null != notIn) {
            for (Map.Entry<String, Object[]> entry : notIn.entrySet()) {
                String columnName = entry.getKey();
                Object[] params = entry.getValue();
                CriteriaContainer criterion = morphiaQuery.criteria(columnName).notIn(Arrays.asList(params));
                criterionList.add(criterion);
            }
        }
        // 设置介于某两个值之间的查询条件
        if (null != between) {
            for (Map.Entry<String, Object[]> entry : between.entrySet()) {
                String columnName = entry.getKey();
                Object[] params = entry.getValue();
                CriteriaContainer criterion1 = morphiaQuery.criteria(columnName).greaterThan(params[0]);
                CriteriaContainer criterion2 = morphiaQuery.criteria(columnName).lessThan(params[1]);
                criterionList.add(criterion1);
                criterionList.add(criterion2);
            }
        }
        // 设置字段为空的查询条件
        if (null != isNull && isNull.size() > 0) {
            for (String columnName : isNull) {
                CriteriaContainer criterion = morphiaQuery.criteria(columnName).doesNotExist();
                criterionList.add(criterion);
            }
        }
        // 设置字段不为空的查询条件
        if (null != notNull && notNull.size() > 0) {
            for (String columnName : notNull) {
                CriteriaContainer criterion = morphiaQuery.criteria(columnName).exists();
                criterionList.add(criterion);
            }
        }

//        设置key-content的查询条件
        if (null != keyContent && keyContent.size() > 0) {
            for (Map.Entry<String, Object[]> entry : keyContent.entrySet()) {
                String key = entry.getKey();
                Object[] param = entry.getValue();
                CriteriaContainer container = null;
                if (param == null) {
                    container = morphiaQuery.criteria(key).exists();
                } else {
                    if (MorphiaMatchMode.ANYWHERE.equals(param[1])) {
                        container = morphiaQuery.criteria(key).contains((String) param[0]);
                    } else if (MorphiaMatchMode.START.equals(param[1])) {
                        container = morphiaQuery.criteria(key).startsWith((String) param[0]);
                    } else if (MorphiaMatchMode.END.equals(param[1])) {
                        container = morphiaQuery.criteria(key).endsWith((String) param[0]);
                    } else if (MorphiaMatchMode.EXACT.equals(param[1])) {
                        container = morphiaQuery.criteria(key).equal((String) param[0]);
                    }
                }
                criterionList.add(container);
            }
        }
        return criterionList;
    }

    @Override
    protected <T> void initCriteriaOrder(Query<T> morphiaQuery) {
        if (null != order) {
            for (Map.Entry<String, String> entry : order.entrySet()) {
                String columnName = entry.getKey();
                String sort = entry.getValue();
                if ("desc".equals(sort)) {
                    Query<T> order = morphiaQuery.order(Sort.descending(columnName));
                } else {
                    morphiaQuery.order(Sort.ascending(columnName));
                }
            }
        }
    }
}
