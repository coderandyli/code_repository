
## 积分系统设计与实现

## 性能统计分析平台（WARDER / 守望者平台）
### 类设计
 - 【class】MetricsCollector 
 提供API, 采集接口请求的原始数据
 - 【interface】MetricsStorage 
 原始数据存储, RedisMetricsStorage: 可采用redis存储; HbaseMetricsStorage：可采用hbase存储
 - 【class】Aggregator 
 数据聚合计算
 - 【class】ConsoleReporter
 统计结果输出到命令行
 - 【class】EmailReporter
 统计结果发送到到邮件