第二周 作业 3

## 串行 GC 

参数 
-XX:+PrintGCDetails

-XX:+PrintGCDateStamps 

-Xloggc:gc.demo.log 

-XX:+UseSerialGC

 当xms xmx  都是 256m 的时候发生了 8次young GC  19次 full GC

第一次young GC 时候 young 区  由 69兆压缩到了 8兆，堆内存 68 -> 23 m, 推断出 晋升 old 区 15m

随后 7 次   young gc  时候，old 使用量不断增大 出发 full gc ，full GC 时候 old 区 前后没变化

young gc 平均耗时 10-20 毫秒 

full gc  平均耗时 30-50 毫秒



xms xmx  512m 时候   

full  GC 次数减少  但是 young gc  和 full  gc 的 耗时 平均 增加了 20 毫秒左右

young gc 平均耗时 30-50 毫秒 

full gc  平均耗时 50-70 毫秒



xms xmx  1g 时候   

full  GC 只发生了一次    但是 young gc   耗时增加了 

young gc 平均耗时 30-50 毫秒 

full gc  75 毫秒



xms xmx  4g  

full  GC 已经不发生了    但是 young gc   为  135 和 175毫秒 



xms xmx  8g  

仅 发生 一次 young gc   为  186毫秒 

 串行  GC 适合用在  堆内存大小 为 几百兆的 地方



## 并行 GC 

参数 
-XX:+PrintGCDetails

-XX:+PrintGCDateStamps 

-Xloggc:gc.demo.log 

-XX:+UseParallelGC

内存配置大小 256 m

发生young fc 和 full  gc 次数与 并行 gc 次数并无多少 差异 但是 yonggc 时间 控制在了 10 毫秒以下

full gc 时间 在 10 到 30 毫秒时间段 ，优于 串行 gc

 内存配置大小  512m

young gc  次数相比于 之前的加多 ，fullgc 次数减少 ，相比于 young  gc  时间依旧在 10毫秒以下，full gc  耗时 有明显增加  平均 为  50 -80 毫秒

 内存配置大小 为 1g 时候 

young  gc  耗时依旧在 10毫秒以下 ，full gc  只发生了两次分别耗时 82 和 78 毫秒 ，young 区  大小 300m

 内存配置大小 为 2g 时候 

 full  gc 没有发生，young  gc 耗时 为 20-30 毫秒  ，young 区  大小 600m

 内存配置大小 为 4g 和 8g  时候 

 full  gc 没有发生，young  gc 耗时 为 40-44 毫秒 

相比于 串行 gc ,并行gc 不论内存大小，都优于 串行



## CMS GC

参数 
-XX:+PrintGCDetails

-XX:+PrintGCDateStamps 

-Xloggc:gc.demo.log 

-XX:+UseConcMarkSweepGC
内存  128 m

young gc 耗时范围 10 毫秒以下 ，cms gc 时候 初始标记和最终标记耗时均在 10毫秒一下

并且gc 次数 随 内存增加减少， 4g -8g 时候初始young 区 大小 不变了，都是 672 m

原因：

 caleForWordSize 的值大约是 64M *线程数 * 13 / 10 ＝ 332.8M，再做下对齐就得到 332.75M 了；max_heap / (NewRatio+1) 的值为2048M / 3 = 672M，而新生代的值取了较小的 ScaleForWordSize，故为 332.75M。

## G1GC

-XX:+PrintGCDetails

-XX:+PrintGCDateStamps 

-Xloggc:gc.demo.log 

-XX:+UseG1GC

不看内存大小 耗时均为 10毫秒一下

