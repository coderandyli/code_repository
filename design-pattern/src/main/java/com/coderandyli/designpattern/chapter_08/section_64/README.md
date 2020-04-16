# 状态模式

## 示例 - 超级马里奥马里奥（Super Mario）

### 需求分析

- 玛丽状态(status)
    - SMALL 小马里奥（Small Mario）
    - SUPER 超级马里奥（Super Mario）
    - FIRE 火焰马里奥（Fire Mario）
    - CAPE 斗篷马里奥（Cape Mario)
- 事件
    - E1: 吃了蘑菇(obtainMushRoom)
    - E2: 获得斗篷(obtainCape)
    - E3: 获得火焰(obtainFireFlower)
    - E4: 遇到怪物(meetMonster)
    
- 状态、事件、动作
    - SMALL
        - E1 + 100 = SUPER 
        - E2 + 200 = CAPE
        - E3 + 300 = FIRE
    - SUPER
        - E2 + 200 = CAPE
        - E3 + 300 = FIRE
        - E4 - 100 = SMALL
    - FIRE 
        - E4 - 300 = SMALL
    - CAPE
        - E4 - 200 = SMALL
        
        
## case_01 基于状态模式实现需求

## case_02 优化
- 引入抽象类
    - 抽象类实现接口，避免状态类实现所有的接口方法

- 将状态类改为单例
    - 状态类不包含任何局部变量，可以考虑设计为单例
        