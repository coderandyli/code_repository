### 重写equalse规范、技巧

* **自反性**
````
任何非空引用x，x.equalse(x) 应该返回true （自己一定等于自己）
````
* **对称性**
```
任何引用x和y，当x.equals(y)返回true，y.equals(x)也应返回true
```
* **传递性**
```
任何引用x、y和z，当x.equalse(y)和y.equalse(z)，那么x.equalse(z)也应返回true
``` 

* **一致性**
```
如果x和y引用的对象没有发生任何变化，那么反复x.equals(y)都应返回一样的结果
```

* **任何非空引用 x.euqals(null) 都应返回 false**

* **重写equalse时，也要重写hashCode方法**

### reference
[java重写equals()方法和hashCode()方法](https://blog.csdn.net/panchao888888/article/details/80888592)