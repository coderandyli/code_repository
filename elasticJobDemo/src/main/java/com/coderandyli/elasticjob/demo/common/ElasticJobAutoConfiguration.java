package com.coderandyli.elasticjob.demo.common;

import com.coderandyli.elasticjob.demo.common.jobinit.DataflowJobInitialization;
import com.coderandyli.elasticjob.demo.common.jobinit.ScriptJobInitialization;
import com.coderandyli.elasticjob.demo.common.jobinit.SimpleJobInitialization;
import com.coderandyli.elasticjob.demo.common.properties.ElasticJobProperties;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Job Configuration
 *
 * @author Hanping QIAO
 * 2018-09-25 下午3:25
 **/
@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties(ElasticJobProperties.class)
public class ElasticJobAutoConfiguration {

    /**
     * Default register center
     */
    public static final String DEFAULT_REGISTRY_CENTER_NAME = "elasticJobRegistryCenter";

    @Autowired
    private ElasticJobProperties elasticJobProperties;

    @Bean(name = DEFAULT_REGISTRY_CENTER_NAME, initMethod = "init")
    @ConditionalOnMissingBean
    public ZookeeperRegistryCenter elasticJobRegistryCenter(){
        ElasticJobProperties.ZkConfiguration regCenterProperties = elasticJobProperties.getZookeeper();
        ZookeeperConfiguration zookeeperConfiguration = new ZookeeperConfiguration(regCenterProperties.getServerLists(),regCenterProperties.getNamespace());
        zookeeperConfiguration.setBaseSleepTimeMilliseconds(regCenterProperties.getBaseSleepTimeMilliseconds());
        zookeeperConfiguration.setConnectionTimeoutMilliseconds(regCenterProperties.getConnectionTimeoutMilliseconds());
        zookeeperConfiguration.setMaxSleepTimeMilliseconds(regCenterProperties.getMaxSleepTimeMilliseconds());
        zookeeperConfiguration.setSessionTimeoutMilliseconds(regCenterProperties.getSessionTimeoutMilliseconds());
        zookeeperConfiguration.setMaxRetries(regCenterProperties.getMaxRetries());
        zookeeperConfiguration.setDigest(regCenterProperties.getDigest());
        return new ZookeeperRegistryCenter(zookeeperConfiguration);
    }

    @Bean(initMethod = "init")
    @ConditionalOnMissingBean
    @ConditionalOnBean(ZookeeperRegistryCenter.class)
    public SimpleJobInitialization simpleJobInitialization() {
        return new SimpleJobInitialization(elasticJobProperties.getSimples());
    }

    @Bean(initMethod = "init")
    @ConditionalOnMissingBean
    @ConditionalOnBean(ZookeeperRegistryCenter.class)
    public DataflowJobInitialization dataflowJobInitialization() {
        return new DataflowJobInitialization(elasticJobProperties.getDataflows());
    }

    @Bean(initMethod = "init")
    @ConditionalOnMissingBean
    @ConditionalOnBean(ZookeeperRegistryCenter.class)
    public ScriptJobInitialization scriptJobInitialization() {
        return new ScriptJobInitialization(elasticJobProperties.getScripts());
    }

}
