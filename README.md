#分治算法的设计模式如下：
if |P|<=n0
    then return(ADHOC(P))
//将P分解为较小的子问题，P1,P2,P3.....,Pk
for i <- 1 to K
do yi <- Divide-and-Conquer(Pi) 递归解决Pi
T <- MERGE(y1,y2,....,yk) 合并子问题
return(T)


其中|P|表示问题P的规模： no为一阈值，表示当前问题P的规模不超过no时，问题已
容易直接解出，不必再继续分解。ADHOC(P)是该分治法中的基本子算法，用于直接解小规模
的问题P。因此，当P的规模不超过n0时，直接用算法ADHOC(P)求解，
算法MERGE(y1,y2,....,yk)是该分治法中的合并子算法，用于将P的子问题P1,P2,.....,Pk的相应的解y1,y2,....yk
合并为P的解


