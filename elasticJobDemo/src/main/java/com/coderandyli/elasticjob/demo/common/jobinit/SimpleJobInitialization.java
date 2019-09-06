package com.coderandyli.elasticjob.demo.common.jobinit;

import com.coderandyli.elasticjob.demo.common.properties.ElasticJobProperties;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.JobTypeConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;

import java.util.Map;

/**
 * Simple Job Initialization
 *
 * @author Hanping QIAO
 * 2018-09-25 下午3:48
 **/
public class SimpleJobInitialization extends AbstractJobInitialization{

    private Map<String, ElasticJobProperties.SimpleConfiguration> simpleConfigurationMap;

    public SimpleJobInitialization(final Map<String, ElasticJobProperties.SimpleConfiguration> simpleConfigurationMap) {
        this.simpleConfigurationMap = simpleConfigurationMap;
    }

    public void init() {
        for (String jobName : simpleConfigurationMap.keySet()) {
            ElasticJobProperties.SimpleConfiguration configuration = simpleConfigurationMap.get(jobName);
            initJob(jobName, configuration.getJobType(), configuration);
        }
    }

    @Override
    public JobTypeConfiguration getJobTypeConfiguration(String jobName, JobCoreConfiguration jobCoreConfiguration) {
        ElasticJobProperties.SimpleConfiguration configuration = simpleConfigurationMap.get(jobName);
        return new SimpleJobConfiguration(jobCoreConfiguration, configuration.getJobClass());
    }
}
