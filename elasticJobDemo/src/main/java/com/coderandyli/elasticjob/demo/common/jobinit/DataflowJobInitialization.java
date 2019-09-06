package com.coderandyli.elasticjob.demo.common.jobinit;

import com.coderandyli.elasticjob.demo.common.properties.ElasticJobProperties;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.JobTypeConfiguration;
import com.dangdang.ddframe.job.config.dataflow.DataflowJobConfiguration;

import java.util.Map;

/**
 * Data flow Job Initialization
 *
 * @author Hanping QIAO
 * 2018-09-25 下午3:47
 **/
public class DataflowJobInitialization extends AbstractJobInitialization {

    private Map<String, ElasticJobProperties.DataflowConfiguration> dataflowConfigurationMap;

    public DataflowJobInitialization(final Map<String, ElasticJobProperties.DataflowConfiguration> dataflowConfigurationMap) {
        this.dataflowConfigurationMap = dataflowConfigurationMap;
    }

    public void init() {
        for (String jobName : dataflowConfigurationMap.keySet()) {
            ElasticJobProperties.DataflowConfiguration configuration = dataflowConfigurationMap.get(jobName);
            initJob(jobName, configuration.getJobType(), configuration);
        }
    }

    @Override
    public JobTypeConfiguration getJobTypeConfiguration(String jobName, JobCoreConfiguration jobCoreConfiguration) {
        ElasticJobProperties.DataflowConfiguration configuration = dataflowConfigurationMap.get(jobName);
        return new DataflowJobConfiguration(jobCoreConfiguration, configuration.getJobClass(), configuration.isStreamingProcess());
    }

}
