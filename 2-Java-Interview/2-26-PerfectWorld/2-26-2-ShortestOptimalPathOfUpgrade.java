package acmCoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author WuPing
 * @version 2016年9月19日 下午8:50:05
 */

public class ShortestOptimalPathOfUpgrade {
    
    //单源最短路径-穷举从起点到终点的所有路径，选出路径值最小的路径
    //此外还有Dijsktra算法：http://blog.csdn.net/yexiaohhjk/article/details/52589368
    // 最短路径算法之Dijkstra算法: http://www.cnblogs.com/junyuhuang/p/4544747.html
    // 无向图的最短路径算法JAVA实现: http://www.cnblogs.com/hapjin/p/5435724.html
    // java实现Dikstra迪杰斯特拉算法关于单源顶点最短路径问题的求解: http://blog.csdn.net/lu_ckid/article/details/44062223
    
    /*
     * 最短最优升级路径
          时间限制：C/C++语言 1000MS；其他语言 3000MS
         内存限制：C/C++语言 65536KB；其他语言 589824KB
        题目描述：
                 游戏网站提供若干升级补丁，每个补丁大小不一，玩家要升级到最新版，如何选择下载哪些补丁下载量最小。
         输入:
                   第一行输入                        第一个数为用户版本  第二个数为最新版本，空格分开
                   接着输入N行补丁数据        第一个数补丁开始版本 第二个数为补丁结束版本 第三个数为补丁大小，空格分开
         输出:
                   对于每个测试实例，输出一个升级路径以及最后实际升级的大小
         样例输入:
      1000 1050
      6
      1000 1020 50
      1000 1030 70
      1020 1030 15
      1020 1040 30
      1030 1050 40
      1040 1050 20
          样例输出:
        1000->1020->1040->1050(100)
    */

    //说明：如果只求用户版本到最新版的路径，只打印最后一条即可
    // 费老劲终于弄出来了，动态规划和图的算法得多看看。
    private static int Diff = Integer.MAX_VALUE;  //两点无直连边, 表示顶点之间无法到达 
    
    public static ArrayList<Stack<Integer>> Dijsktra(int[][] weight, int start) {
	ArrayList<Stack<Integer>> pathList = new ArrayList<Stack<Integer>>();

	// 返回一个ArrayList<ArrayList<Integer>>数组，表示从start到它的最短路径
	int n = weight.length; // 顶点个数
	
	int[] dist = new int[n];  // 存储最短路径长度的数组
	int[] prve = new int[n];  // 存储当前顶点的前驱顶点 	
        boolean[] s = new boolean[n];  // 存储已经找到最短路径的顶点，false为未找到 
          
        for(int i = 1; i < n; i++){  
            // 初始化dist数组  
            dist[i] = weight[start][i];  
            s[i] = false;   
            // prve数组存储源点到顶点vi之间的最短路径上该顶点的前驱顶点, 
            // 若从源点到顶点vi之间无法到达，则前驱顶点为-1. 
              
            if(dist[i] < Diff) {              
        	 prve[i] = start;  
            }else {  
        	 prve[i] = -1;  
            }
        }  
        
	dist[start] = 0;  // 初始化v0源点属于s集
	s[start] = true;  // 表示v0源点已经求得最短路径
	for (int i = 1; i < n; i++) {
	    int temp = Diff;   // temp暂存v0源点到vi顶点的最短路径
	    int u = start;
	    for (int j = 1; j < n; j++) {
		if ((!s[j]) && dist[j] < temp) { // 顶点vi不属于s集当前顶点不属于s集(未求得最短路径)并且距离v0更近
		    u = j;     // 更新当前源点, 当前vi作为下一个路径的源点
		    temp = dist[j];  // 更新当前最短路径
		}
	    }
	    s[u] = true; // 顶点vi进s集
	    // 更新当前最短路径以及路径长度
	    for (int j = 0; j < n; j++) {
		if ((!s[j]) && weight[u][j] < Diff) {  // 当前顶点不属于s集(未求得最短路径)并且当前顶点有前驱顶点
		    int newDist = dist[u] + weight[u][j]; // 累加更新最短路径
		    if (newDist < dist[j]) {
			dist[j] = newDist;  // 更新后的最短路径
			prve[j] = u;  // 当前顶点加入前驱顶点集
		    }
		}
	    }
	}
	
	// 保存源点到各点最短路径结果
	for (int i = 0; i < dist.length; i++) {
	    Stack<Integer> stack = new Stack<Integer>();
	    // 当前顶点已求得最短路径并且当前顶点不等于源点
	    if (dist[i] < Diff && i != start) {
		stack.push(dist[i]);
		stack.push(i);
		//System.out.print("v" + i + "<--");
		int next = prve[i];   // 设置当前顶点的前驱顶点
		while (next != start) {   // 若前驱顶点不为一个，循环求得剩余前驱顶点
		    stack.push(next);
		    //System.out.print("v" + next + "<--");
		    next = prve[next];
		}
		
		stack.push(start);
		//System.out.println("v" + start + ":" + dist[i]);
	    }
	    // 当前顶点未求得最短路径的处理方法
	    else if (i != start) {
		stack.push(i);
		stack.push(start);
		stack.push(-1);
		//System.out.println("v" + i + "<--" + "v" + start + ":no path");
	    }
	    
	    pathList.add(stack);
	}
	
	return pathList;
    }
    
    public static void shortestOptimalPathOfUpgrade(int startVersion, int endVersion,
	    int[][] patch) {
	HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();  //根据版本号获得对应的顶点序号
	HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();  //根据顶点序号获得对应的版本号
	map1.put(startVersion, 0);
	map2.put(0, startVersion);
	int index = 0;
	for(int i=0; i<patch.length; i++) {
	    if(!map1.containsKey(patch[i][1])) {
	       map1.put(patch[i][1], index + 1);
	       map2.put(index + 1, patch[i][1]);
	       index++;
	    }
	}
	
	int vertexSize = map1.size();  // 图的顶点个数
	int[][] weight = new int[vertexSize][vertexSize];  //邻接矩阵
	// 邻接矩阵初始化
	for(int i=0; i<vertexSize; i++) {
	    for(int j=0; j<vertexSize; j++) {
		if(i==j) {
		    weight[i][j] = 0;
		}else {
		    weight[i][j] = Diff;
		}
	    }  
	}
        for(int k=0; k<patch.length; k++) {
            int startVertexIndex = map1.get(patch[k][0]);
            int endVertexIndex = map1.get(patch[k][1]);
            weight[startVertexIndex][endVertexIndex] = patch[k][2];
            weight[endVertexIndex][startVertexIndex] = patch[k][2];
        }
	
        //打印邻接矩阵
        /*for(int i=0; i<vertexSize; i++) {
	    for(int j=0; j<vertexSize; j++) {
		System.out.print(weight[i][j]+" ");
	    } 
	    System.out.println();
	}*/
        
        ArrayList<Stack<Integer>> pathList = new ArrayList<Stack<Integer>>();
        pathList = Dijsktra(weight, 0);
        //for(int i=0; i < pathList.size(); i++) {
            //Stack<Integer> tempStack = pathList.get(i);
            Stack<Integer> tempStack = pathList.get(pathList.size()-1);
            StringBuffer sb = new StringBuffer();
            while(!tempStack.isEmpty()) {
        	int temp = tempStack.peek();
        	if(tempStack.size()==1) {
        	    sb.append("(");
        	    sb.append(temp);
        	    sb.append(")");
        	}else {
		    int currentVersion = map2.get(temp);
		    if (currentVersion == startVersion) {
			sb.append(currentVersion);
		    } else {
			sb.append("->");
			sb.append(currentVersion);
		    }
        	}
        	
        	tempStack.pop();
            }
            System.out.println(sb.toString());
        //}
    }

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (sc.hasNext()) {
	    int startVersion = sc.nextInt();
	    int endVersion = sc.nextInt();
	    int n = sc.nextInt();
	    int curretnIndex = 0;
	    StringBuffer sb = new StringBuffer("");
	    while (curretnIndex < n*3) {
		if (sb.toString().equals("")) {
		    sb.append(sc.nextInt());
		} else {
		    sb.append("," + sc.nextInt());
		}
		curretnIndex++;
	    }

	    String[] str = sb.toString().split(",");
	    int rowNum = str.length / 3;

	    int[][] patch = new int[rowNum][3];
	    for (int i = 0; i < rowNum; i++) {
		for (int j = 0; j < 3; j++) {
		    patch[i][j] = Integer.parseInt(str[i * 3 + j]);
		}
	    }

	    shortestOptimalPathOfUpgrade(startVersion, endVersion, patch);
	}

	sc.close();
    }

}
