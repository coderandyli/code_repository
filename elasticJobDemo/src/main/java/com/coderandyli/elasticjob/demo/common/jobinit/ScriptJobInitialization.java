package com.coderandyli.elasticjob.demo.common.jobinit;

import com.coderandyli.elasticjob.demo.common.properties.ElasticJobProperties;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.JobTypeConfiguration;
import com.dangdang.ddframe.job.config.script.ScriptJobConfiguration;

import java.util.Map;

/**
 * Script Job Initialization
 *
 * @author Hanping QIAO
 * 2018-09-25 下午3:48
 **/
public class ScriptJobInitialization extends AbstractJobInitialization {
    private Map<String, ElasticJobProperties.ScriptConfiguration> scriptConfigurationMap;

    public ScriptJobInitialization(final Map<String, ElasticJobProperties.ScriptConfiguration> scriptConfigurationMap) {
        this.scriptConfigurationMap = scriptConfigurationMap;
    }

    public void init() {
        for (String jobName : scriptConfigurationMap.keySet()) {
            ElasticJobProperties.ScriptConfiguration configuration = scriptConfigurationMap.get(jobName);
            initJob(jobName, configuration.getJobType(), configuration);
        }
    }

    @Override
    public JobTypeConfiguration getJobTypeConfiguration(String jobName, JobCoreConfiguration jobCoreConfiguration) {
        ElasticJobProperties.ScriptConfiguration configuration = scriptConfigurationMap.get(jobName);
        return new ScriptJobConfiguration(jobCoreConfiguration, configuration.getScriptCommandLine());
    }
}
