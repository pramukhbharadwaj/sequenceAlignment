# SequenceAlignment
Memory and run time comparison between Needleman-Wunsch algorithm and Hirschberg's algorithm



The basic version of the algorithm, also called the Needleman-Wunsch algorithm, finds an optimal alignment in O(n*m) time and O(n*m) space where n, m are the length of the two main.java.com.pb.sequenceAligner.input strings for which we have to find the alignment. It uses dynamic programming to solve the problem. We get the alignment cost from the DP matrix and take a top-down approach to get the alignment.

The memory-efficient version of the algorithm is also called Hirschberg's algorithm, a clever modification of the Needleman-Wunsch algorithm. It still takes O(n*m) time but only O(min(m,n)) space where n, m are the length of the two main.java.com.pb.sequenceAligner.input strings for which we have to find the alignment. Here, this uses divide and conquer technique to optimally split the strings and recursively solve the subproblems. The outputs from the two sub-problems are combined(strings are just concatenated). We use Dynamic Programming here to solve the trivial problems and get the optimal breakpoint for the strings.


From the attached graph, we can clearly see the Hirschberg's algorithm takes more time compared to the basic Needleman-Wunsch's algorithm. The algorithm runs recursively on strings of size q and n/2, and on strings of size m − q and n/2. Thus, for some constant c, and some choice of index q(optimal breakpoint), we have
T(m, n) ≤ cmn + T(q, n/2) + T(m − q, n/2) 
T(m, 2) ≤ cm
T(2, n) ≤ cn

Recursive function calls(as per the above recurrence relation) adds overhead and hence we can see the increase in the time.


For memory, the crucial point is that we apply these recursive calls sequentially and reuse the working space from one call to the next. Thus, since we only work on one recursive call at a time, the total space usage is O(min(m,n)*2). Hence, the drop in the memory usage in the graph is justified when the main.java.com.pb.sequenceAligner.input size is large. The decrease in memory is visible only after a threshold(main.java.com.pb.sequenceAligner.input size of 224(m+n) in our case) because the overhead caused by the recursion compensates for the difference in the memory utilization before the threshold. Hence, we don't see any improvement.


<img width="709" alt="MemoryComparison" src="https://user-images.githubusercontent.com/26455885/146857325-64f71db0-e8b8-48c0-bc9f-ad40de106685.png">
<img width="713" alt="TimeComparison" src="https://user-images.githubusercontent.com/26455885/146857329-9180d0be-5c1e-43da-8f96-07a7d29cd256.png">
