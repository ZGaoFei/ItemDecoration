# ItemDecoration
这是一个介绍如何使用 ItemDecoration 的一个 Demo，其中也包含了 RecycleView 的一些 基本使用，包括：瀑布流，ItemAnimator 等等

#### 简介：
        包 zero:
            简单的使用 LinearLayoutManager 显示列表
            在 RecycleView 中添加了点击事件
            使用简单的 DividerItemDecoration 设置间距
            扩展 ItemDecoration 自定义 ZeroDecoration 实现间距设置
        包 one：
            通过自定义 ItemDecoration 实现对 RecycleView 列表的再绘制
            使用 GridLayoutManager 显示列表，并设置间距
            在 RecycleView 的下面和上面绘制相应的布局，如矩形等等
        包 two:
            基本包含包 one 和 two 功能
            通过设置 theme 文件来修改默认 DividerItemDecoration 的间距的显示效果
            测试添加 Item 动画和删除 Item 动画
            简单实现瀑布流布局
            
#### 推荐：
[Android RecyclerView 使用完全解析 体验艺术般的控件](http://blog.csdn.net/lmj623565791/article/details/45059587)

[深入理解 RecyclerView 系列之一：ItemDecoration](https://blog.piasy.com/2016/03/26/Insight-Android-RecyclerView-ItemDecoration/)

[RecycleView 动画库](https://github.com/wasabeef/recyclerview-animators)
