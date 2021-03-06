/**
 * 实现代码文件
 * 
 * @author XXX
 * @since 2016-3-4
 * @version V1.0
 */
package com.routesearch.route;

import java.util.*;

import com.filetool.util.LogUtil;

public final class Route
{
	private static int StartID;
	private static int EndID;
	private static Set<Integer> IncVertexs=new HashSet<>();
	private static final int MAX_VERTEX=600;
	private static Graph CreatGraph(String graphContent){
		Graph graph=new Graph(MAX_VERTEX);
		String name=null;
		Integer SourceID=null;
		Integer DestinationID=null;
		
		char[] graphcontent=graphContent.toCharArray();
    	int count=0;
    	int index=0;
		for(int i=0;i<graphcontent.length;i++){
			if(graphcontent[i]==','||graphcontent[i]=='\n'){
				count++;
    			switch(count){
    			case 1://Edge name
    				//edge=new DirectedEdge();
    				//edge.Name=graphContent.substring(index, i);
    				index=i+1;
    				break;
    			case 2://SourceID
    				//edge.SourceID=Integer.parseInt(graphContent.substring(index, i));
    				index=i+1;
    				break;
    			case 3://DestinationID
    				//edge.DestinationID=Integer.parseInt(graphContent.substring(index, i));
    				index=i+1;
    				break;
    			case 4://Cost
    				//edge.Cost=Integer.parseInt(graphContent.substring(index, i));
    				index=i+1;
    				count=0;
    				//graph.addEdge(edge);
    				break;
    			}				
			}
		}
		return graph;
	}
	
	private static void AnalysisCondition(String Condition){
		if(Condition==null)return;
		char[] condition=Condition.toCharArray();
		int i;
		int count=0;
		int index=0;
		for(i=0;i<condition.length;i++){
			if(condition[i]==','){
				count++;
				if(count==1){
					StartID=Integer.parseInt(Condition.substring(index, i));
					index=i+1;
				}
				else if(count==2){
					EndID=Integer.parseInt(Condition.substring(index, i));
					index=i+1;
					break;
				}
			}
		}
		for(;i<condition.length;i++){
			if(condition[i]=='|'||condition[i]=='\n'){
				IncVertexs.add(Integer.valueOf(Condition.substring(index, i)));
				index=i+1;
			}
		}
	}
    /**
     * 你需要完成功能的入口
     * 
     * @author XXX
     * @since 2016-3-4
     * @version V1
     */
    public static String searchRoute(String graphContent, String condition)
    {
    	if(graphContent==null||condition==null)return null;
    	Graph graph=CreatGraph(graphContent);//创建图
    	AnalysisCondition(condition);
    	Solution_1 solution=new Solution_1();
    	String path=solution.FindPath(StartID, EndID, IncVertexs,graph);
        return path;
    }

}
