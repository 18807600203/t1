package com.ium.um.cache;



public class CacheConfiguration {

	/*
     * ehcache 主要的管理器
     */
//   
//    public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean){
//        return new EhCacheCacheManager (bean.getObject ());
//    }
//
//    /*
//     * 据shared与否的设置,Spring分别通过CacheManager.create()或new CacheManager()方式来创建一个ehcache基地.
//     */
//   
//    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
//        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean ();
//        cacheManagerFactoryBean.setConfigLocation (new ClassPathResource ("ehcache.xml"));
//        cacheManagerFactoryBean.setShared (true);
//        return cacheManagerFactoryBean;
//    }
}
