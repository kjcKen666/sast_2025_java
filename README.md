## README

这是 2025 年清华大学计算机系学生科协暑期培训 Java 部分的作业。

本部分作业由三个小作业组成，采用**代码填空**的形式进行考察。

- 作业文件位于 `src/main/java/homework/` 中。你可以直接在 IntelliJ IDEA 中运行每一个作业，每一个作业都实现了 `main` 函数，方便用户交互。
- 测试点文件位于 `assets/testcases/` 中。

### 作业 1：TwoNumbersClosestDifference

#### 题目描述

你只需要补全 `findClosestPair` 函数中 `// TODO begin` 和 `// TODO end` 之间的代码即可。

给定一个整数数组 `nums[]` 和一个整数 `target`，请你找出数组中两个不同的元素 `nums[i]` 和 `nums[j]`（`i != j`），使得它们的差值与 `target` 的差的绝对值最小，即最小化$| (nums[i] - nums[j]) - target |$

返回这两个数（顺序不限）。

#### 输入格式

- 一个整数数组 `nums[]`
- 一个整数 `target`

#### 输出格式

- 一个包含两个整数的数组，表示最接近目标差值的两个数

#### 示例

**输入**：

```
nums = [1, 5, 3, 19, 18, 25]
target = 10
```

**输出**：

```
18 19
```

#### 数据规模

```
2 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-10000 <= target <= 10000
```

#### 要求

1. 时间复杂度建议不超过 $O(nlogn)$。
2. 不必须使用额外复杂数据结构，允许直接使用数组排序。
3. 如果存在多个结果，返回任意一组即可。

### 作业 2：Longest Palindromic Substring

#### 题目描述

你只需要补全 `longestPalindrome`函数中 `// TODO begin` 和 `// TODO end` 之间的代码即可。

给定一个字符串 `s`，请你找出 `s` 中最长的回文子串（**回文**：正读和反读都相同的字符串）。

#### 要求

- 时间复杂度应尽可能优化（建议 **O(n²)** 或更优）。
- 如果存在多个长度相同的最长回文子串，可以返回其中任意一个。

#### 输入

- 输入为一个字符串 `s`，长度范围为1 <= s.length <= 1000
- 字符串仅包含大小写字母和数字。

#### 输出

- 返回 `s` 中的最长回文子串，类型为 `String`。

#### 示例 1

```
s = "babad"
输出: "bab"
解释: "aba" 也是一个有效答案。
```

#### 示例 2

```
输入: s = "cbbd"
输出: "bb"
```

#### 方法提示

##### 中心扩展法

该方法的核心思想是：
 **枚举所有可能的回文中心，并从中心向两边扩展，找到最长的回文子串。**

- **回文中心的两种形式**：
  1. **单字符**作为中心（奇数长度回文，如 `"aba"`）。
  2. **两个相邻字符**作为中心（偶数长度回文，如 `"abba"`）。
- 对每个位置 `i`：
  - 调用 `expandAroundCenter(s, i, i)` 处理奇数长度回文。
  - 调用 `expandAroundCenter(s, i, i + 1)` 处理偶数长度回文。
- 比较两种回文长度，取较大值更新当前最长回文的起始位置 `start` 和结束位置 `end`。

### 作业3：ThreadRelayRace

#### 题目描述

你只需要补全代码中所有的`TODO`即可。

本作业使用 **Java 多线程** 模拟一个接力赛场景。每个选手由一个线程 (`Runner` 类) 表示，线程之间通过**接力棒**（调用下一位选手线程）依次传递，直到比赛结束。

- 用户输入参赛选手数量。
- 每位选手的跑步时间为随机值（500 ~ 1500 毫秒）。
- 使用 `Thread.sleep()` 模拟跑步过程。
- 当前选手完成后启动下一位选手，并等待其完成。
- 所有选手跑完后比赛结束。

#### 示例

```
Enter number of runners: 3
Runner 1 started running...
Runner 1 finished! Time: 689 ms
Runner 1 passing baton to Runner 2
Runner 2 started running...
Runner 2 finished! Time: 1123 ms
Runner 2 passing baton to Runner 3
Runner 3 started running...
Runner 3 finished! Time: 942 ms
Race finished!
```

#### 提示

- 随机时间可用：

  ```
  int time = 500 + random.nextInt(1000); // 500~1500 毫秒
  ```

- 等待下一位选手完成可用：

  ```
  nextRunner.start();
  nextRunner.join();
  ```

### 如何测试

将代码补全完毕后，你可以选择在本地查看测试结果：

- 在 IntelliJ IDEA 中运行 `src/test/java/homework/` 中对应的测试文件。
- 或是运行脚本，
  - 对于 Windows 用户，运行 `gradlew.bat`；
  - 对于 Linux 或其他用户，运行 `gradlew`。

### 如何提交

如果你完成了作业，可以将你的仓库链接发在本仓库的 issue 区。请遵循已提供的 issue 模板进行填写。