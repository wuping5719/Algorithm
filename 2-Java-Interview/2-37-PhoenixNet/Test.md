### 凤凰网(PhoenixNet)秋招笔试题 ###
* 1.快速排序.   
   <https://github.com/wuping5719/Algorithm/blob/master/12-Sort/12-6-QuickSort.java>
* 2.最长公共子序列.  
   `思路：动态规划：int[][] dp = new int[aLen+1][bLen+1]。dp[i][j]：表示子串A[0...i]和子串B[0...j]的最长公共子序列。当A[i] == B[j]时，dp[i][j] = dp[i-1][j-1] + 1; 否则，dp[i][j] = max(dp[i-1][j], dp[i][j-1])。最优解为dp[aLen][bLen]。`    
   <https://github.com/wuping5719/Algorithm/blob/master/2-Java-Interview/2-16-huaweiOJ/NowCoder/55-CalculatePublicSubString_55.java>
 
