package com.ninggc.multipledb.mysql.hibernate.config;

/**
 * <p>  Created by LXL on 2017-08-10  </p>
 */
public enum DeleteEnum {

    NOT(0, "未删除"),
    YES(1, "已删除");

    private int delete_flag;
    private String info;


    DeleteEnum(int delete_flag, String info) {
        this.delete_flag = delete_flag;
        this.info = info;
    }

    public static DeleteEnum get(Integer delete_flag) {
        for(DeleteEnum deleteEnum : DeleteEnum.values()) {
            if(deleteEnum.value() == delete_flag) {
                return deleteEnum;
            }
        }
        return null;
    }

    /**
     * Created by LXL on 2017-08-10
     * <br> 获取当前删除位对应的整型数值
     * @return 0：未删除 or 1：已删除
     */
    public int value() {
        return delete_flag;
    }

    /**
     * Created by LXL on 2017-07-27
     * <br> 获取当前删除位对应的中文说明
     * @return '未删除' or '已删除'
     */
    public String info() {
        return info;
    }

    public static void main(String[] args) {
        System.out.println(DeleteEnum.YES.ordinal());
    }
}
