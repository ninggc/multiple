package com.ninggc.demo.morphiademo.morphia.config;


import dev.morphia.Morphia;
import org.springframework.beans.factory.config.AbstractFactoryBean;

@Deprecated
public class MorphiaFactoryBean extends AbstractFactoryBean<Morphia> {


    /**
     * 要扫描的包
     * @return
     */
    private String[] mapPackages;

    /**
     * 要映射的类
     */
    private String[] mapClasses;

    /**
     * 扫描包时，是否忽略不映射的类
     * 这里按照Morphia的原始定义，默认设为false
     */
    private boolean ignoreInvalidClasses;

    @Override
    public Class<?> getObjectType() {
        return Morphia.class;
    }

    @Override
    protected Morphia createInstance() throws Exception {
        Morphia morphia = new Morphia();
        if (mapPackages != null) {
            for (String packageName: mapPackages) {
                morphia.mapPackage(packageName, ignoreInvalidClasses);
            }
        }
        if (mapClasses != null) {
            for (String entityClass: mapClasses) {
                morphia.map(Class.forName(entityClass));
            }
        }
        return morphia;
    }

    public String[] getMapPackages() {
        return mapPackages;
    }

    public void setMapPackages(String[] mapPackages) {
        this.mapPackages = mapPackages;
    }

    public String[] getMapClasses() {
        return mapClasses;
    }

    public void setMapClasses(String[] mapClasses) {
        this.mapClasses = mapClasses;
    }

    public boolean isIgnoreInvalidClasses() {
        return ignoreInvalidClasses;
    }

    public void setIgnoreInvalidClasses(boolean ignoreInvalidClasses) {
        this.ignoreInvalidClasses = ignoreInvalidClasses;
    }
}
