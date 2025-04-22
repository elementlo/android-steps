# Android Steps

帮助构建 Android 基础能力, 不止需要一些面试技巧, 更重要的是亲自上手体验, 才能真正掌握. 前进每一小步都是有价值的.

## ConstraintLayout

使用 ConstraintLayout 的一些技巧, 以及少被人提及的特性.

app:layout_constraintTop_toTopOf="": constraint后边表示要给 view 的哪个方向做约束, _to 后边指要针对目标 view 的哪个方向做约束.

设置0dp 代表充满约束.

Sample包含以下演示:

1. 常见列表项布局更简单.
2. 可以让一个 view 的中线对准另一个 view 的底边.
3. 可以实现权重功能.
4. 可以实现对齐文字的 baseline 或者 bottom.
5. 可以实现基于方位角度的布局.
6. 可以将文字的显示限制在另一个 view 的宽度之内.
7. 使用 bias 在原有的约束上修正.
8. 使用 Gone Margin 设置占位.
9. 建立双向约束形成链, 可以控制一条链的整体 style.
10. 通过 Dimension Ratio 控制 view 的宽高比.
11. 支持百分比布局(一般用来做适配, Guide line 更常用).
12. 使用 Guide Line 辅助布局.
13. 使用 Group 控制多个 view 的可见性.
14. 使用 Layer 对多个 view 做旋转, 平移等操作.
15. 使用 Barrier 将长短不一的 view 统一占位尺寸.
16. 使用 Place Holder 占位.
17. 使用 Flow 组装网格布局.
18. 使用 ConstraintSet 将布局变换更简单的应用到原始布局.

## MotionLayout
使用 MotionLayout 较简便的实现复杂的变换或者补间动画.



