# 访问者模式（不常用 了解）

# 需求
- 解析PDF、PPT、word类型文件内容到txt中

## case_01 简单实现 

## case_02   拆分解耦，将业务操作与数据结构解耦，
- case_01实现逻辑，如果后续，不仅要能抽取文本内容，还要支持压缩、提取文件元信息（文件名、大小、更新时间等等）构建索引等一系列的功能
    - 违背开闭原则，添加一个新的功能，所有类的代码都要修改；
    - 虽然功能增多，每个类的代码都不断膨胀，可读性和可维护性都变差了；
    - 把所有比较上层的业务逻辑都耦合到 PdfFile、PPTFile、WordFile 类中，导致这些类的职责不够单一，变成了大杂烩
- 定义一个Extractor类，实现提取文件内容到txt中，通过重载方法实现(执行会报错，java是单分派语言，如果java是多分派语言，就不需要访问者模式)，详见Extractor类。

## case_03 
 基于case_02 每个资源文件类中定义新的 accept 重载函数
 
## case_04
  - case_03每新增一个功能点，都要在file类中修改，不符合开闭原则
  - 定义个Visitor接口，并定义通用的方法 visit()；Extractor、Compressor类实现Visitor接口，即访问者模式