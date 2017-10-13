package final_count;
import java.awt.event.*;  
import java.io.*;  

import javax.swing.*; 

import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;
import java.util.Vector;


import javax.imageio.*;

import java.util.Map;
import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.ImageIcon;



import javax.swing.*; 
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.omg.CORBA.Bounds;

public class counter {
	private static LinkedList<String> strslist=new LinkedList<String>();
    private static LinkedList<Node> nodeslist=new LinkedList<Node>();
    private static String InfofGraph="";
    private static String BridgeWords="";
    private static String FilePath="";
    private static String RandomPath="";
    private static String ValidInf="";
	public static void main(String[] args){
		JFrame f = new JFrame();
        f.setTitle("Menu");//标题内容
        f.setBounds(0,0,1000,600);
        f.setLocation(300,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        ImageIcon background=new ImageIcon("23.jpg");// 背景图片  
        JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面   
        label.setBounds(0,0,1000,600);   
        JPanel imagePanel=(JPanel)f.getContentPane();  
        imagePanel.setOpaque(false);  
        f.getLayeredPane().setLayout(null);   
        f.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));  
        
        
        JButton function_Open=new JButton("Open the file");
        JButton function_Show=new JButton("Show the Graph");//在窗口中添加一个按钮；
        JButton function_Check=new JButton("Find the BridgeWord");
        JButton function_Create=new JButton("Create New Sentence");
        JButton function_ShortestPath=new JButton("Find the ShortestPath");
        JButton function_RandomPath=new JButton("Random Walk");
        JButton function_Exit=new JButton("Exit");
        function_Open.setBounds(50,200,150,30);
        function_Show.setBounds(50,250,150,30);
        function_Check.setBounds(50,300,150,30);
        function_Create.setBounds(50,350,150,30);
        function_ShortestPath.setBounds(50,400,150,30);
        function_RandomPath.setBounds(50,450,150,30);
        function_Exit.setBounds(50,500,150,30);
        f.add(function_Open);
        f.add(function_Show);
        f.add(function_Check);
        f.add(function_Create);
        f.add(function_ShortestPath);
        f.add(function_RandomPath);
        f.add(function_Exit);
        f.add(new JLabel());
        f.setVisible(true);//窗体可见。
        f.setResizable(false);
        
        function_Open.addActionListener(listen_Open);
        
        
        function_Show.addActionListener(listen_Show);
	    //showDirectedGraph(nodeslist);  //功能2
	    
        function_Check.addActionListener(listen_Check);
	    /*System.out.println("请输入任意两个单词：word1和word2");   //功能3
	    String Word1,Word2;
		Scanner in=new Scanner(System.in);
		Word1=in.next();
		Word2=in.next();
		String answer=queryBridgeWords(Word1,Word2);
		System.out.println(answer);*/
		
        function_ShortestPath.addActionListener(listen_SP);
		/*System.out.println("请输入任意一行新文本语句：");   //功能4
		String sentence;
		Scanner cin=new Scanner(System.in);
		sentence=cin.nextLine();
		String NewSentence=generateNewText(sentence);
		System.out.println(NewSentence);*/
	    
        function_Create.addActionListener(listen_Create);
	    /*System.out.println("请输入任意一个或两个单词(单词间以空格分隔)：");   //功能5
	    String words,start,end,AllPath=null;
	    Scanner in=new Scanner(System.in);
	    words=in.nextLine();
	    p=Pattern.compile(" ");
	    String[]SplitWords=p.split(words);
	    if(SplitWords.length==1){
	    	start=SplitWords[0];
	    	if(strslist.indexOf(start)==-1){
	    		System.out.println("Error!No such word in the graph");
	    	}
	    	else{
	    		for(i=0;i<nodeslist.size();i++){
	    			if(start.equals(strslist.get(i))){
	    				continue;
	    			}
		    		AllPath=calcShortestPath(start,strslist.get(i));
		    		if(AllPath!=null){
			    		if(AllPath.trim().equals("")){
				    		System.out.println("There is no path between "+"\""+start+"\""+ " and "+"\""+strslist.get(i)+"\"");
				    	}
			    		else{
			    			p=Pattern.compile(",");
			    		    String[]paths=p.split(AllPath);
			    		    System.out.println("The shortest paths between "+"\""+start+"\""+ " and "+"\""+strslist.get(i)+"\""+" are:");
			    		    for(j=0;j<paths.length;j++){
			    		    	System.out.println(paths[j]);
			    		    }
			    		}
			    	}
		    		System.out.println("==========");
		    	}
	    	}
	    }
	    else if(SplitWords.length==2){
	    	start=SplitWords[0];
	    	end=SplitWords[1];
	    	if(strslist.indexOf(start)==-1||strslist.indexOf(end)==-1){
	    		System.out.println("Error!No such word in the graph");
	    	}
	    	else{
	    		AllPath=calcShortestPath(start,end);
		    	if(AllPath!=null){
		    		if(AllPath.trim().equals("")){
			    		System.out.println("There is no path between "+"\""+start+"\""+ " and "+"\""+end+"\"");
			    	}
		    		else{
		    			p=Pattern.compile(",");
		    		    String[]paths=p.split(AllPath);
		    		    System.out.println("The shortest paths between "+"\""+start+"\""+ " and "+"\""+end+"\""+" are:");
		    		    for(i=0;i<paths.length;i++){
		    		    	System.out.println(paths[i]);
		    		    }
		    		}
		    	}
	    	}
	    }
	    else{
	    	System.out.println("Error!More than two words!");
	    }*/
	    
        function_RandomPath.addActionListener(listen_Random);
	    /*String RandomPath=randomWalk(); //功能6
	    File FileToWrite=new File("D:\\RandomPath.txt");//新建一个文件对象
        FileWriter fw;
        try {
            fw=new FileWriter(FileToWrite);
            fw.write(RandomPath);
            fw.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
	    System.out.println(RandomPath);*/
        
        function_Exit.addActionListener(listen_Exit);
	}
    public static void CreateDirectedGraph(){
    	int flag=0;
		int i,j;
		String[] nodes=null;
		Pattern p;
		nodeslist.clear();
		strslist.clear();
		if(ValidInf!=null){
			ValidInf=ValidInf.toLowerCase();   //处理文本文件
			ValidInf=ValidInf.replaceAll("[,.!?]"," "); 
			ValidInf=ValidInf.replaceAll("[\\pP‘’“”]",""); 
			ValidInf=ValidInf.replaceAll("[\\pN‘’“”]","");
			ValidInf=ValidInf.replaceAll("\\s+"," ");
			ValidInf=ValidInf.trim();
		}
		
		if(ValidInf!=null){
			p=Pattern.compile("\\s+");   //生成图
			nodes=p.split(ValidInf); 
		    for(i=0;i<nodes.length;i++){
		    	if(!strslist.contains(nodes[i])){
		    		strslist.add(nodes[i]);
		    	}
		    }
		}

	    for(Iterator iter1=strslist.iterator();iter1.hasNext();) {
	    	Node temp=new Node((String) iter1.next());
	    	nodeslist.add(temp);
	    }
	    if(nodes!=null){
	    	for (i=0; i<nodes.length-1; i++) {  
		    	Edge edge=new Edge();
		    	edge.SetHead(nodes[i]);
		    	edge.SetTail(nodes[i+1]);
		    	edge.SetWeight();
		    	int index=strslist.indexOf(nodes[i]);
		    	Edge e=nodeslist.get(index).GetAdj();
		    	if(e==null){
		    		nodeslist.get(index).SetAdj(edge);
		    		nodeslist.get(index).SetNumOfEdge();
		    	}
		    	else{
		    		while(e!=null){
		    			if(e.GetTail().equals(edge.GetTail())){
		    				e.SetWeight();
		    				flag=1;
		    				break;
		    			}
		    			if(e.GetAdj()!=null)
		    				e=e.GetAdj();
		    			else
		    				break;
		    		}
		    		if(flag==0){
		    		   e.SetAdj(edge);
		    		   nodeslist.get(index).SetNumOfEdge();
		    		}
		    		flag=0;
		    	}
		    }   
	    }
    }
	public static void myshowDirectedGraph(LinkedList<Node> G){
		int index=0;
		InfofGraph="";
		GraphViz gViz=new GraphViz("D:\\program_picture", "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe");
		gViz.start_graph();
		String ptr="";
		for(Iterator iter1=G.iterator();iter1.hasNext();) {
	    	InfofGraph+=(((Node) iter1.next()).getName()+" : ");
	    	Edge edge=G.get(index++).GetAdj();
	    	while(edge!=null){
	    		ptr+=edge.GetHead()+"->"+edge.GetTail()+" "+"[label="+edge.GetWeight()+"];";
	    		InfofGraph+=(edge.GetTail()+"("+edge.GetWeight()+") ");
	    		edge=edge.GetAdj();
	    		gViz.addln(ptr);
	    		ptr="";
	    	}
	    	InfofGraph+=("\n");
	    }
		gViz.end_graph();
        try {
            gViz.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
    public static void showDirectedGraph(int loc[][]) {
		//init();
		//int loc[][] = new int[1000][2];//各个圆心坐标
		BufferedImage image;
		int radiu;//排列半径
		int huiqiu = 100;
		int num=nodeslist.size();
		double pi = Math.PI;
		radiu = (int)(150/Math.sin(pi/num));
		image = new BufferedImage(2*radiu+huiqiu*2, 2*radiu+huiqiu*2, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		Graphics2D g2d = (Graphics2D)graphics;
			for(int i = 0;i < num;i++) {
				loc[i][0] = radiu+huiqiu+(int)(radiu*Math.sin(2*i*pi/num));
				loc[i][1] = radiu+huiqiu+(int)(radiu*Math.cos(2*i*pi/num));
			}
        
			
		for(int i = 0;i < nodeslist.size();i++) {
			Edge no=nodeslist.get(i).GetAdj();
			for(;no!=null;no=no.GetAdj()) {
				int j=strslist.indexOf(no.GetTail());
				int w = no.GetWeight();
					
				double b = huiqiu/Math.sqrt((loc[j][0]-loc[i][0])*(loc[j][0]-loc[i][0])+(loc[j][1]-loc[i][1])*(loc[j][1]-loc[i][1]));
				int ax = (int)(loc[i][0]*b+(1-b)*loc[j][0]);
				int ay = (int)(loc[i][1]*b+(1-b)*loc[j][1]);
				
				BasicStroke bs=new BasicStroke(5);//width是线宽,float型
				g2d.setStroke(bs);
				
				graphics.setColor(Color.RED);
				graphics.fillOval(ax-15,ay-15,30 , 30);
				graphics.setColor(Color.WHITE);
				g2d.drawLine(loc[i][0], loc[i][1], loc[j][0], loc[j][1]);
				Font f = new Font("宋体",Font.BOLD ,60);
				graphics.setFont(f);
				graphics.drawString(""+w,(loc[i][0]+loc[j][0])/2,(loc[i][1]+loc[j][1])/2);
			}
			System.out.println();
		}
		for(int i = 0;i <num;i++) {
			graphics.setColor(Color.gray);
			graphics.fillOval(loc[i][0]-huiqiu,loc[i][1]-huiqiu,huiqiu*2,2*huiqiu);
			graphics.setColor(Color.yellow);
			Font f = new Font("宋体",Font.BOLD ,60);
			graphics.setFont(f);
			graphics.drawString(nodeslist.get(i).getName(), loc[i][0]-huiqiu, loc[i][1]);
		}
		File result = new File("D:\\program_picture\\first.jpg");  
        try {  
            ImageIO.write(image, "JPG", result);  
        } catch (IOException k) {  
            k.printStackTrace();  
        }    
		graphics.dispose();
    	JFrame pic2=new JFrame("Graph Pattern2");
		File picture2 = new File("D:\\program_picture\\dotGif.jpg");
		BufferedImage sourceImg2;
		try {
			sourceImg2=ImageIO.read(new FileInputStream(picture2));
			int width=sourceImg2.getWidth();
			int height=sourceImg2.getHeight();
		    pic2.setSize(600,800);
			JPanel panel=new JPanel();
			JLabel label=new JLabel();
			pic2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ImageIcon img=new ImageIcon("D:\\program_picture\\dotGif.jpg");
			label.setIcon(img);
			panel.add(label);
			JScrollPane scr=new JScrollPane(panel);
			scr.setVisible(true);
			pic2.getContentPane().add(scr);
			pic2.setVisible(true);
			pic2.setAlwaysOnTop(true);
		} catch (IOException e2) {
			
		}
		JFrame pic1=new JFrame("Graph Pattern1");
		File picture1 = new File("D:\\program_picture\\first.jpg");
		BufferedImage sourceImg1;
		try {
			sourceImg1=ImageIO.read(new FileInputStream(picture1));
			int width=sourceImg1.getWidth();
			int height=sourceImg1.getHeight();
		    pic1.setSize(1366,768);
			JPanel panel=new JPanel();
			JLabel label=new JLabel();
			pic1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ImageIcon img = new ImageIcon("D:\\program_picture\\first.jpg");
			label.setIcon(img);
			panel.add(label);
			JScrollPane scr = new JScrollPane(panel);
			scr.setVisible(true);
			pic1.getContentPane().add(scr);
			pic1.setVisible(true);
		} catch (IOException e1) {
			
		}
		/*try {
			FileOutputStream fos = new FileOutputStream("D:\\first.jpg");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
			encoder.encode(image);
			bos.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		//return loc;
	}
	public static String queryBridgeWords(String Word1,String Word2){
		String result=" ";
		int index1=strslist.indexOf(Word1);
		int index2=strslist.indexOf(Word2);
		if(index1==-1 && index2!=-1){
			result="No "+"\""+Word1+"\""+" in the graph!";
		    return result;
		}
		else if(index1!=-1 && index2==-1){
		    result="No "+"\""+Word2+"\""+" in the graph!";
		    return result;
		}
		else if(index1==-1 && index2==-1){
			result="No "+"\""+Word1+"\""+" or "+"\""+Word2+"\""+" in the graph!";
			return result;
		}
		else{
			Edge edge=nodeslist.get(index1).GetAdj();
			if (edge==null){
			   result="No bridge words from "+"\""+Word1+"\""+" to "+"\""+Word2+"\""+"!";
			   return result;
			}
			else if(edge.GetTail().equals(Word2)){
				result="No bridge words from "+"\""+Word1+"\""+" to "+"\""+Word2+"\""+"!";
				return result;
			}
			else{
				while(edge!=null){
					int index3=strslist.indexOf(edge.GetTail());
					Edge edge2=nodeslist.get(index3).GetAdj();
					if (edge2==null)
						break;
					else{
						while(edge2!=null){
							if(edge2.GetTail().equals(Word2)){
								result=result+edge2.GetHead()+",";
								break;
							}
							edge2=edge2.GetAdj();
						}
					}
	    			edge=edge.GetAdj();
				}
			}
		}
		result=result.trim();
		if(result.equals("")){
			result="No bridge words from "+"\""+Word1+"\""+" to "+"\""+Word2+"\""+"!";
		}
		else{
			Pattern p=Pattern.compile(",");   
			String[] answers=p.split(result);
			if (answers.length==1){
				result="The bridge words from "+"\""+Word1+"\""+" to "+"\""+Word2+"\""+" is: "+answers[0];
			}
			else{
				result="The bridge words from "+"\""+Word1+"\""+" to "+"\""+Word2+"\""+" are: "+answers[0];
				for(int i=1;i<answers.length;i++){
					if(i==answers.length-1){
						result=result+" and "+answers[i]+".\"";
					}
					else{
						result=result+", "+answers[i];
					}
				}
			}
		}
		return result;
	}
	
	public static String generateNewText(String inputText){
		Pattern p=Pattern.compile("\\s+"); 
		String[] words=p.split(inputText);
		String bridge=null;
		String result=words[0]+" ";
		for(int i=0;i<words.length-1;i++){
			String bridges=queryAddWords(words[i],words[i+1]);
			bridges.trim();
			if(!bridges.equals(" ")){
				Pattern p2=Pattern.compile(",");   
				String[] BridgesWords=p2.split(bridges);
				int max=BridgesWords.length-1;
		        int min=0;
		        Random random = new Random();
		        int RandomIndex=random.nextInt(max-min+1)+min;
				result=result+BridgesWords[RandomIndex].trim()+" ";
			}
			result=result+words[i+1]+" ";
		}
		return result;
	}
	
	public static String queryAddWords(String Word1,String Word2){
		String result=" ";
		int index1=strslist.indexOf(Word1);
		int index2=strslist.indexOf(Word2);
		if(index1==-1 || index2==-1){
			result=" ";
		}
		else{
			Edge edge=nodeslist.get(index1).GetAdj();
			if (edge==null){
			    result=" ";
			}
			else if(edge.GetTail().equals(Word2)){
				result=" ";
			}
			else{
				while(edge!=null){
					int index3=strslist.indexOf(edge.GetTail());
					Edge edge2=nodeslist.get(index3).GetAdj();
					if (edge2==null)
						break;
					else{
						while(edge2!=null){
							if(edge2.GetTail().equals(Word2)){
								result=result+edge2.GetHead()+",";
								break;
							}
							edge2=edge2.GetAdj();
						}
					}
	    			edge=edge.GetAdj();
				}
			}
		}
		return result;
	}
	
	public static String calcShortestPath(String word1,String word2){
		int sta[]=new int[strslist.size()];
		Path res=new Path();
		Vector<Integer> prev[]=new Vector[strslist.size()];
		int index1=strslist.indexOf(word1);
		int index2=strslist.indexOf(word2);
		prev=Dijkstra(nodeslist.size(),index1,index2);
		SearchPath(res,prev,index1,index2,0,sta);
		return res.GetPath();
	}
	public static Vector<Integer>[] Dijkstra(int n,int index1,int index2){
		int visited[]=new int[n];
		int index=0;
		int i,j;
		int dist[]=new int[n];
		int DirectDis[][]=new int[n][n];
		Vector<Integer> prev[]=new Vector[n];
		for(i=0;i<n;i++){
			dist[i]=999;
			visited[i]=0;
			for(j=0;j<n;j++){
				DirectDis[i][j]=999;
			}
		}
		for(index=0;index<nodeslist.size();index++) {
	    	Edge edge=nodeslist.get(index).GetAdj();
	    	while(edge!=null){
	    		if(edge!=null){
	    			DirectDis[strslist.indexOf(edge.GetHead())][strslist.indexOf(edge.GetTail())]=edge.GetWeight();
	    			edge=edge.GetAdj();
	    		}
	    	}
	    }
		for(i=0;i<n;i++){
			if(i!=index1){
				dist[i]=DirectDis[index1][i];
				visited[i]=0;
			}
			else{
				visited[i]=1;
			    dist[i]=0;
			}
			prev[i]=new Vector();
			if(dist[i]<999){
				prev[i].addElement(index1);
			}
		}
		for(i=1;i<n;i++){
			int temp=999;
			int NodeNum=index1;
			for(j=0;j<n;j++){
				if(visited[j]==0 && dist[j]<temp){
					NodeNum=j;
					temp=dist[j];
				}	
			}
			visited[NodeNum]=1;
			for(j=0;j<n;j++){
				if(visited[j]==0 && DirectDis[NodeNum][j]<999){
				   int NewDist=dist[NodeNum]+DirectDis[NodeNum][j];
				   if(NewDist<=dist[j]){
					   if(NewDist<dist[j]){
						   prev[j].removeAllElements();
						   dist[j]=NewDist;
					   }
					   prev[j].addElement(NodeNum);
				   }
			}
		}
		}
		return prev;
	}
    public static void SearchPath(Path res,Vector<Integer>[] prev,int start,int end,int len,int sta[]){
    	if(start==end){
    		if(start>=0){
    			res.SetPath(strslist.get(start));	
    		}
    		return;
        }
    	sta[len]=end;
    	for(int i=0;i<prev[end].size();i++){
    		if(i>0){
    			for(int j=len-1;j>=0;j--){
    				res.SetPath("->"+strslist.get(sta[j]));	
    			}
    			res.SetPath(",");
    		}
    		SearchPath(res,prev,start,prev[end].elementAt(i),len+1,sta);
    		res.SetPath("->"+strslist.get(end));		
    	}
    }
    public static String randomWalk(){
    	String result="";
    	RandomPath="";
    	Vector<Integer> Isvisited[]=new Vector[nodeslist.size()];
    	int max=nodeslist.size()-1;
        int min=0;
        long t1=System.currentTimeMillis();
        Random random1=new Random(t1);
        int RandomNode1Index=0;
        for(int i=0;i<nodeslist.size();i++){
        	Isvisited[i]=new Vector();
        }
        if(max-min+1>0)
        	RandomNode1Index=random1.nextInt(max-min+1)+min;
        else
        	RandomNode1Index=min;
        if(RandomNode1Index<strslist.size()){
        	 result+=strslist.get(RandomNode1Index)+" ";
        	 RandomPath+=strslist.get(RandomNode1Index)+" ";
        }
        //System.out.println(result);
        while(true){
        	Edge e=null;
        	if(RandomNode1Index<strslist.size()){
           	 e=nodeslist.get(RandomNode1Index).GetAdj();
            }
            if(e==null){
            	return result;
            }
            else{
                max=nodeslist.get(RandomNode1Index).GetNumOfEdge();
            	min=0;
            	int flag=0;
            	while(flag==0){
            		try   
            		{   
            		    Thread.currentThread().sleep(1000);//毫秒   
            		}   
            		catch(Exception e2){
            			JOptionPane.showMessageDialog(null,"Thread Error!");
            		}  
            		long t2=System.currentTimeMillis();
                	Random random2=new Random(t2);
                	int index=random2.nextInt(max-min+1)+min;
                	for(int i=0;i<index-1;i++){
                		e=e.GetAdj();
                	}
                	int RandomNode2Index=0;
					if(e!=null&&e.GetTail()!=null&&e.GetTail()!="")
                	   RandomNode2Index=strslist.indexOf(e.GetTail());
					result=result+strslist.get(RandomNode2Index)+" ";
            		RandomPath=RandomPath+strslist.get(RandomNode2Index)+" ";
                	if(Isvisited[RandomNode1Index].indexOf(RandomNode2Index)==-1){
                		Isvisited[RandomNode1Index].addElement(RandomNode2Index);
                		RandomNode1Index=RandomNode2Index;
                		//System.out.println(strslist.get(RandomNode1Index));
                		flag=1;
                		break; 
                	}
                	else{
                		return result;
                	}
            	}
            }
        }
    }
    public static LinkedList<Node> getNodeslist(){
    	return nodeslist;
    }
    public static LinkedList<String> getStrslist(){
    	return strslist;
    }
    public static String getInfofGraph(){
    	return InfofGraph;
    }
    public static String getRandomPath(){
    	return RandomPath;
    }
    public void clearRandomPath(){
    	RandomPath="";
    }
    public void setRandomPath(String str){
    	RandomPath+=str;
    }
    public static void SetFilePath(String path){
    	FilePath=path;
    }
    public static String getValidInf(){
    	return ValidInf;
    }
    public static void SetValidInf(String inf){
    	ValidInf=inf;
    }
    public static int[][] getarry(){
    	int loc[][] = new int[1000][2];
    	return loc;
    }
    
    
    static ActionListener listen_Open=new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
    		ReadFile readfile=new ReadFile();
    		CreateDirectedGraph();
    		//readfile desgraph=new FileReader();
    	}
	};
	
    static ActionListener listen_Show=new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
    	     DescribeGraph desgraph=new DescribeGraph();
    	}
	};
	
	static ActionListener listen_Check=new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
           CheckBridgeWords FindWords=new CheckBridgeWords();
    	}
	};
	
	static ActionListener listen_Create=new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
           CreateNewTXT CreateSentence=new CreateNewTXT();
    	}
	};
	static ActionListener listen_SP=new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
           FindShortestPath ShortestPath=new FindShortestPath();
    	}
	};
	static ActionListener listen_Random=new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
    		 RandomWalk RandomResult=new  RandomWalk();
    	}
	};
	static ActionListener listen_Exit=new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
           System.exit(0);
    	}
	};
	
    
}



class Path{
	private String FinalPath;
	Path(){
		this.FinalPath="";
	}
	public void SetPath(String PartofPath){
		FinalPath=FinalPath+PartofPath;
	}
	public String GetPath(){
		return this.FinalPath;
	}
}
/*边类*/
class Edge{
	private int weight;
	private Edge next=null;
	private String head;
	private String tail;
	Edge(){
		weight=0;
		next=null;
	}
    public void SetWeight(){
    	weight=weight+1;
    }
    public void SetHead(String shead){
    	head=shead;
    }
    public void SetTail(String stail){
    	tail=stail;
    }
    public void SetAdj(Edge edge){
    	next=edge;
    }
    public Edge GetAdj(){
    	return next;
    }
    public String GetTail(){
    	return tail;
    }
    public String GetHead(){
    	return head;
    }
    public int GetWeight(){
    	return weight;
    }
}
/*节点类*/
class Node{
	private String name;
	private Edge adj=null;
	private int NumOfEdge;
	Node(String name){
		this.name=name;
		NumOfEdge=0;
	}
	public String getName(){
		return name;
	}
	public Edge GetAdj(){
    	return adj;
    }
	public void SetAdj(Edge edge){
    	adj=edge;
    }
	public void SetNumOfEdge(){
    	NumOfEdge++;
    }
	public int GetNumOfEdge(){
    	return NumOfEdge;
    }
}  

/*读入文件*/
class ReadFile extends JFrame implements ActionListener{  
    JButton open=null;  
    int flag=0;
    counter count=new counter();
    String ValidInf=null;
    public ReadFile(){  
    	String FilePath=null;
    	JFileChooser jfc=new JFileChooser();   
        FileNameExtensionFilter filter = new FileNameExtensionFilter(  
                "文本文件(*.txt)", "txt");  
        jfc.setFileFilter(filter);  
        int option=jfc.showOpenDialog(null);  
        if(option==JFileChooser.APPROVE_OPTION){     
            File file=jfc.getSelectedFile();      
            if(!file.getName().endsWith(".txt")){  
            	JOptionPane.showMessageDialog(null,"IO Error!");
            }  
            else{
            	 FilePath=file.getPath();
            }
            
    		try{
    			if(FilePath!=null){
    				FileReader fr=new FileReader(FilePath);
    				if(fr!=null){
    					BufferedReader br=new BufferedReader(fr);
    					String line=null;
    					ValidInf=line=br.readLine();
    					while(line!=null){
    						line=br.readLine();
    						if(line!=null)
    							ValidInf=ValidInf+" "+line;
    					}
    					br.close();	
    				}	
    			}
    		}
    		catch(IOException e){
    			JOptionPane.showMessageDialog(null,"IO Error!");
    		}
    		count.SetValidInf(ValidInf);
    		//System.out.println(ValidInf);
            
        }  
    }  

    public void actionPerformed(ActionEvent e){  
    	
    }  
}  

class DescribeGraph extends JFrame implements ActionListener{ 
	JLabel hint=new JLabel("Structure of the graph is:");
	Font font=new Font("SansSerif",1,15); 
	counter count=new counter();
	JTextArea output=new JTextArea(); 
	JScrollPane jsp=new JScrollPane(output);
    int flag=0;
    public DescribeGraph(){  
    	output.setBounds(80,100,300,1000);
    	output.setEditable(true);
    	jsp.setBounds(80,100,300,300);
    	//jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
    	
    	JPanel panel=(JPanel)this.getContentPane();
    	panel.setLayout(null);
    	panel.add(jsp);
    	panel.add(hint);
    	ImageIcon background=new ImageIcon("008.jpg");
    	JLabel labelbg=new JLabel(background);
    	labelbg.setBounds(0,0,500,600);
    	panel.add(labelbg);
    	panel.setOpaque(false);
    	this.setTitle("Show Graph");//标题内容
		this.setBounds(0,0,500,600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		this.setVisible(true);
		this.setResizable(false);
	
		hint.setFont(font);
		hint.setForeground(Color.blue);
	    hint.setBounds(150,40,300,30);
	  
	    count.showDirectedGraph(count.getarry());
	    count.myshowDirectedGraph(count.getNodeslist());
	    output.setLineWrap(true);
        output.setBorder(new LineBorder(new Color(0, 0, 0)));
        output.setWrapStyleWord(true);
        output.setText(count.getInfofGraph());
        output.setPreferredSize(new Dimension(1000,3000)); 
    }  
	public void actionPerformed(ActionEvent e) {
        
		int loc[][] = new int[1000][2];
    	count.myshowDirectedGraph(count.getNodeslist());
    	count.showDirectedGraph(loc);
	}
}

class CheckBridgeWords extends JFrame implements ActionListener{  
	JLabel hint=new JLabel("Please input the words");
	JLabel hintword1=new JLabel("word1");
	JLabel hintword2=new JLabel("word2");
	JLabel hintresult=new JLabel("bridgewords");
	JLabel hintoutput=new JLabel("Below is the answer");
	JTextArea input1=new JTextArea();
	JTextArea input2=new JTextArea();
	JTextArea output=new JTextArea();
	Button sure=new Button("OK");  
	Font font=new Font("SansSerif",1,15); 
	counter count=new counter();
	JScrollPane jsp=new JScrollPane(output);
    int flag=0;
    public CheckBridgeWords(){  
    	output.setBounds(80,310,300,120);
    	jsp.setBounds(80,310,300,80);
    	jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
    	JPanel panel=(JPanel)this.getContentPane();
    	panel.setLayout(null);
    	ImageIcon background=new ImageIcon("008.jpg");
    	JLabel labelbg=new JLabel(background);
    	labelbg.setBounds(0,0,500,600);
    	panel.add(hint);
    	panel.add(input1);
    	panel.add(input2);
    	panel.add(sure);
    	panel.add(hintword1);
    	panel.add(hintword2);
    	panel.add(hintresult);
    	panel.add(hintoutput);
    	panel.add(jsp);
    	panel.add(labelbg);
    	panel.setOpaque(false);
    	
    	
    	this.setTitle("Find the Bridgewords");//标题内容
		this.setBounds(270,30,500,600);
		this.setLocation(300,200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		this.setVisible(true); 
		this.setResizable(false);
		hint.setFont(font);
		hint.setForeground(Color.blue);
	    hint.setBounds(150,50,300,30);
	        
		hintword1.setForeground(Color.blue);
		hintword1.setBounds(0,120,300,30);
		    
		hintword2.setForeground(Color.blue);
	    hintword2.setBounds(0,190,300,30);
	        
		hintresult.setForeground(Color.blue);
        hintresult.setBounds(0,330,330,30);
        
        hintoutput.setForeground(Color.blue);
        hintoutput.setFont(font);
        hintoutput.setBounds(150,250,300,30);
	        
	    input1.setBounds(80,120,300,40);
	    input1.setLineWrap(true);
	    input1.setWrapStyleWord(true);
	    
	    input2.setBounds(80,190,300,40);
	    input2.setLineWrap(true);
	    input2.setWrapStyleWord(true);
	    
        output.setLineWrap(true);
        output.setBorder(new LineBorder(new Color(0, 0, 0)));
        output.setWrapStyleWord(true);
        output.setPreferredSize(new Dimension(400,600)); 
        
        sure.setBounds(160,420,150,30);
        sure.addActionListener(this);
    }  

    public void actionPerformed(ActionEvent e){  
       String word1="",word2="",result=null;
       word1=input1.getText().toLowerCase();
       word2=input2.getText().toLowerCase();
       if(word1!=""||word2!=""){
    	   result=count.queryBridgeWords(word1,word2);
           output.setText(result);
       }
       else{
    	   output.setText("Please input...");
       }
    }  
	
}

class CreateNewTXT extends JFrame implements ActionListener{  
	JLabel hint=new JLabel("Please input a sentence");
	JLabel hintsentence=new JLabel("oldsentence");
	JLabel hintresult=new JLabel("newsentence");
	JLabel hintoutput=new JLabel("Below is the new sentence");
	JTextArea input=new JTextArea();
	JTextArea output=new JTextArea();
	Button sure=new Button("OK");  
	Font font=new Font("SansSerif",1,15); 
	counter count=new counter();
	JScrollPane jsp1=new JScrollPane(input);
	JScrollPane jsp2=new JScrollPane(output);
    public CreateNewTXT(){  
    	input.setBounds(80,120,300,120);
    	jsp1.setBounds(80,120,300,80);
    	jsp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
    	output.setBounds(80,310,300,120);
    	jsp2.setBounds(80,310,300,80);
    	jsp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
    	JPanel panel=(JPanel)this.getContentPane();
    	panel.setLayout(null);
    	ImageIcon background=new ImageIcon("008.jpg");
    	JLabel labelbg=new JLabel(background);
    	labelbg.setBounds(0,0,500,600);
    	panel.add(hint);
    	panel.add(sure);
    	panel.add(hintsentence);
    	panel.add(hintresult);
    	panel.add(hintoutput);
    	panel.add(jsp1);
    	panel.add(jsp2);
    	panel.add(labelbg);
    	panel.setOpaque(false);
    	
    	this.setTitle("Create New Sentences");//标题内容
		this.setBounds(270,30,500,600);
		this.setLocation(300,200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		this.setVisible(true); 
		this.setResizable(false);
		hint.setFont(font);
		hint.setForeground(Color.blue);
	    hint.setBounds(150,50,300,30);
	        
		hintsentence.setForeground(Color.blue);
		hintsentence.setBounds(0,120,300,30);

	        
		hintresult.setForeground(Color.blue);
        hintresult.setBounds(0,330,330,30);
        
        hintoutput.setForeground(Color.blue);
        hintoutput.setFont(font);
        hintoutput.setBounds(150,250,300,30);
	        
	    input.setLineWrap(true);
	    input.setWrapStyleWord(true);
	    input.setPreferredSize(new Dimension(400,600));
	    
        output.setLineWrap(true);
        output.setBorder(new LineBorder(new Color(0, 0, 0)));
        output.setWrapStyleWord(true);
        output.setPreferredSize(new Dimension(400,600));
        
        sure.setBounds(160,420,150,30);
        sure.addActionListener(this);
    }  

    public void actionPerformed(ActionEvent e){  
       String sentence=input.getText().toLowerCase();
       if(sentence!=null){
    	   sentence=sentence.toLowerCase();   //处理文本文件
    	   sentence=sentence.replaceAll("[,.!?]"," "); 
    	   sentence=sentence.replaceAll("[\\pP‘’“”]",""); 
    	   sentence=sentence.replaceAll("[\\pN‘’“”]","");
    	   sentence=sentence.replaceAll("\\s+"," ");
    	   sentence=sentence.trim();
		}
		
       String NewSentence=count.generateNewText(sentence);
       output.setText(NewSentence);
    }  
	
}

class FindShortestPath extends JFrame implements ActionListener{  
	JLabel hint=new JLabel("Please input a word\n(if two,split with space)");
	JLabel hintwords=new JLabel("word(s)");
	JLabel hintresult=new JLabel("shortestpath(s)");
	JLabel hintoutput=new JLabel("Below are the shortest paths");
	JTextArea input=new JTextArea();
	JTextArea output=new JTextArea();
	Button sure=new Button("OK");  
	Font font=new Font("SansSerif",1,15); 
	counter count=new counter(); 
	JScrollPane jsp=new JScrollPane(output);
    public FindShortestPath(){
    	output.setBounds(90,260,300,500);
    	jsp.setBounds(90,260,300,300);
    	jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
    	JPanel panel=(JPanel)this.getContentPane();
    	panel.setLayout(null);
    	ImageIcon background=new ImageIcon("008.jpg");
    	JLabel labelbg=new JLabel(background);
    	labelbg.setBounds(0,0,500,800);
    	panel.add(hint);
    	panel.add(input);
    	panel.add(sure);
    	panel.add(hintwords);
    	panel.add(hintresult);
    	panel.add(hintoutput);
    	panel.add(jsp);
    	panel.add(labelbg);
    	panel.setOpaque(false);
    	
    	this.setTitle("Find Shoretst Paths");//标题内容
		this.setBounds(270,30,500,700);
		this.setLocation(300,200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		this.setVisible(true); 
		this.setResizable(false);
		output.setEditable(true);
		
		hint.setFont(font);
		hint.setForeground(Color.blue);
	    hint.setBounds(110,40,300,30);
	        
		hintwords.setForeground(Color.blue);
		hintwords.setBounds(0,120,300,30);

	        
		hintresult.setForeground(Color.blue);
        hintresult.setBounds(0,330,330,30);
        
        hintoutput.setForeground(Color.blue);
        hintoutput.setFont(font);
        hintoutput.setBounds(130,200,300,30);
	        
	    input.setBounds(90,120,300,40);
	    input.setLineWrap(true);
	    input.setWrapStyleWord(true);
	    
        output.setLineWrap(true);
        output.setBorder(new LineBorder(new Color(0, 0, 0)));
        output.setWrapStyleWord(true);
        output.setPreferredSize(new Dimension(400,3000));
        
        sure.setBounds(160,600,150,30);
        sure.addActionListener(this);
    }  

    public void actionPerformed(ActionEvent e){  
    	String words=null,start=null,end=null,AllPath=null,answer="";
    	int loc[][]=new int[1000][2];
    	words=input.getText().toLowerCase();
    	Pattern p=Pattern.compile(" ");
    	String[] SplitWords=p.split(words);
    	if(SplitWords[0]==""){
    		output.setText("Please input...");
    	}
    	else if(SplitWords.length==1){
    		start=SplitWords[0];
        	if(count.getStrslist().indexOf(start)==-1){
        		output.setText("Error!No such word in the graph");
        	}
        	else{
        		for(int i=0;i<count.getNodeslist().size();i++){
        			if(start.equals(count.getStrslist().get(i))){
        				continue;
        			}
    	    		AllPath=count.calcShortestPath(start,count.getStrslist().get(i));
    	    		if(AllPath!=null){
    		    		if(AllPath.trim().equals("")){
    		    			output.setText("There is no path between "+"\""+start+"\""+ " and "+"\""+count.getStrslist().get(i)+"\"");
    			    	}
    		    		else{
    		    			
    		    			p=Pattern.compile(",");
    		    		    String[]paths=p.split(AllPath);
    		    		    answer+=("The shortest paths between "+"\""+start+"\""+ " and "+"\""+count.getStrslist().get(i)+"\""+" are:\n");  
    
    		    		    for(int j=0;j<paths.length;j++){   		    		    	    		    				    		    				
    		    		    	BufferedImage imager=null;
        	        			File f=null;
        	        	 	    Graphics g=null;
        	        	 	    try {
        	        	 	    count.showDirectedGraph(loc);
        	        	 	    f=new File("D:\\program_picture\\first.jpg");
        	        	 		imager = ImageIO.read(f);
        	        	 		g = imager.getGraphics();
        	        	 	    }catch (Exception v) {
        	        	 			v.printStackTrace();}
    		    		    	String colorlist[]= {"-16776961","-256","-16711936","-20561","-1","-16711681","-65536","-16777216"};
    		    		    	answer+=(paths[j]);
    		    		    	answer+="\n";
    		    		    	String[] pathl=paths[j].split("->");
    		    		    	
    		    		    	GraphViz gViz=new GraphViz("D:\\program_picture", "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe");
    		    				gViz.start_graph();
    		    				gViz.setname(start+count.getStrslist().get(i)+j);
    		    		    	    		    				
    		    				for(int index=0;index<count.getNodeslist().size();) {
    		    			    	Edge edge=count.getNodeslist().get(index++).GetAdj();
    		    			    	String ptr="";
    		    			    	while(edge!=null){
    		    			    		int x=-1,y=-1;
    		    			    		for(int num=0;num<pathl.length;num++)
    		    			    		{
    		    			    			if(pathl[num].equals(edge.GetHead())) x=num;
    		    			    			if(pathl[num].equals(edge.GetTail())) y=num;
    		    			    		}
    		    			    		if(y-x==1 & (x!=-1) & (y!=-1))
    		    			    		{
    		    			    		ptr+=edge.GetHead()+"->"+edge.GetTail()+" "+"[color=blue,label="+edge.GetWeight()+"];";
    		    			    		
    		    			    		//gViz.addln(ptr);
    		    			    		}
    		    			    		else
    		    			    		{	
    		    			    		ptr+=edge.GetHead()+"->"+edge.GetTail()+" "+"[label="+edge.GetWeight()+"];";}
    		    			    		//System.out.println(ptr);
    		    			    		edge=edge.GetAdj();
    		    			    		gViz.addln(ptr);
    		    			    		ptr="";
    		    			    		
    		    			    	}
    		    			    }
    		    				gViz.end_graph();
    		    				//Scanner dd=new Scanner(System.in);
    		    		       // int ff=dd.nextInt();
    		    		        System.out.println(2);
    		    		        try {
    		    		            gViz.run();
    		    		        } catch (Exception h) {
    		    		            h.printStackTrace();
    		    		        }
    		    		        
			    		    	int x1,x2,y1,y2,a,b;
			    		    	a=count.getStrslist().indexOf(pathl[0]);
			    		    	for(int k=1;k<pathl.length;k++) {			    		    						    		    		
		    		    		x1=loc[a][0];
			    		    	y1=loc[a][1];
		    		    		b=count.getStrslist().indexOf(pathl[k]);
		    		    		x2=loc[b][0];
			    		    	y2=loc[b][1];
			    		    	
			    		    	//g.setColor(c);
			    		    	g.setColor(Color.decode(colorlist[i%8]));
			    				Graphics2D g2d = (Graphics2D)g;
			    				BasicStroke bs=new BasicStroke(6);//width是线宽,float型
			    				g2d.setStroke(bs);
			    				g2d.drawLine(x1, y1, x2, y2);
			    				//g2d.dispose();
			    				a=b;
    		    		    }
		    		    	File filen = new File("D:\\program_picture\\"+start+"-and-"+count.getStrslist().get(i)+(j+1)+".jpg");  
			    	         try {  
			    	             ImageIO.write(imager, "JPG", filen);  
			    	         } catch (IOException k) {  
			    	             k.printStackTrace();  
			    	         }    
			    	         //释放资源  
			    	         g.dispose();
    		    		}
		    		    
    		    	}
    	    		answer+=("==========\n");
    	    		output.setText(answer);
    	    	}
        	}
        }}
    	else if(SplitWords.length==2){
        	start=SplitWords[0];
        	end=SplitWords[1];
        	if(count.getStrslist().indexOf(start)==-1||count.getStrslist().indexOf(end)==-1){
        		output.setText("Error!No such word in the graph");
        	}
        	else{
        		AllPath=count.calcShortestPath(start,end);
    	    	if(AllPath!=null){
    	    		if(AllPath.trim().equals("")){
    	    			output.setText("There is no path between "+"\""+start+"\""+ " and "+"\""+end+"\"");
    		    	}
    	    		else{
    	    			p=Pattern.compile(",");
    	    		    String[]paths=p.split(AllPath);
    	    		    answer+=("The shortest paths between "+"\""+start+"\""+ " and "+"\""+end+"\""+" are:\n");
    	    		    for(int i=0;i<paths.length;i++){
    	    		    	BufferedImage imager=null;
    	        			File f=null;
    	        	 	    Graphics g=null;
    	        	 	    try {
    	        	 	    count.showDirectedGraph(loc);
    	        	 	    f=new File("D:\\program_picture\\first.jpg");
    	        	 		imager = ImageIO.read(f);
    	        	 		g = imager.getGraphics();
    	        	 	    }catch (Exception v) {
    	        	 			v.printStackTrace();}
    	    		    	String colorlist[]= {"-16776961","-256","-16711936","-20561","-1","-16711681","-65536","-16777216"};
    	    		    	answer+=(paths[i]);
    	    		    	answer+="\n";
    	    		    	String[] pathl=paths[i].split("->");
    	    		    	
    	    		    	GraphViz gViz=new GraphViz("D:\\program_picture", "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe");
		    				gViz.start_graph();
		    				gViz.setname(start+"-too-"+end+i);
		    				String ptr="";
		    				
		    				for(int index=0;index<count.getNodeslist().size();index++) {
		    			    	Edge edge=count.getNodeslist().get(index).GetAdj();
		    			    	while(edge!=null){
		    			    		int x=-1,y=-1;
		    			    		for(int num=0;num<pathl.length;num++)
		    			    		{
		    			    			if(pathl[num].equals(edge.GetHead())) x=num;
		    			    			if(pathl[num].equals(edge.GetTail())) y=num;
		    			    		}
		    			    		if(y-x==1 & (x!=-1) & (y!=-1))
		    			    		{
		    			    		ptr+=edge.GetHead()+"->"+edge.GetTail()+" "+"[color=blue,label="+edge.GetWeight()+"];";
		    			    		System.out.println(edge.GetHead()+edge.GetTail());
		    			    		
		    			    		}
		    			    		else
		    			    		{	
		    			    		ptr+=edge.GetHead()+"->"+edge.GetTail()+" "+"[label="+edge.GetWeight()+"];";}
		    			    		
		    			    		edge=edge.GetAdj();
		    			    		gViz.addln(ptr);
		    			    		ptr="";
		    			    		
		    			    	}
		    			    }
		    				gViz.end_graph();
		    		        try {
		    		            gViz.run();
		    		        } catch (Exception h) {
		    		            h.printStackTrace();
		    		        }
    	    		    	
		    		    	//System.out.println(paths[i]);
		    		    	int x1,x2,y1,y2,a,b;
		    		    	a=count.getStrslist().indexOf(pathl[0]);
		    		    	for(int k=1;k<pathl.length;k++) {
	    		    		x1=loc[a][0];
		    		    	y1=loc[a][1];
	    		    		b=count.getStrslist().indexOf(pathl[k]);
	    		    		x2=loc[b][0];
		    		    	y2=loc[b][1];
		    		    	g.setColor(Color.decode(colorlist[i%8]));
		    				Graphics2D g2d = (Graphics2D)g;
		    				BasicStroke bs=new BasicStroke(6);//width是线宽,float型
		    				g2d.setStroke(bs);
		    				g2d.drawLine(x1, y1, x2, y2);
		    				a=b;
    	    		    }
	    		    	File filen = new File("D:\\program_picture\\"+start+"-to-"+end+(i+1)+".jpg");  
		    	         try {  
		    	             ImageIO.write(imager, "JPG", filen);  
		    	         } catch (IOException k) {  
		    	             k.printStackTrace();  
		    	         }
		    	        
		    	         //释放资源  
		    	         g.dispose();
    	    		    output.setText(answer);
    	    		}
    	    	}
        	}
        }}
        else{
        	output.setText("Error!More than two words!");
        }
    System.out.println("that is ok!");	 
    }
}

/*class RandomWalk extends JFrame implements ActionListener{  
	JLabel hintresult=new JLabel("RandomPath");
	JLabel hintoutput=new JLabel("Below is the RandomPath");
	JTextArea output=new JTextArea();
	Button begin=new Button("begin");
	Button stop=new Button("stop");
	Button save=new Button("Save to file");
	Font font=new Font("SansSerif",1,15); 
	counter count=new counter();
	JScrollPane jsp=new JScrollPane(output);
	String result="";
	String CurResult=count.getRandomPath();
    public RandomWalk(){  
    	output.setBounds(90,100,300,200);
    	jsp.setBounds(90,100,300,120);
    	jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
    	JPanel panel=(JPanel)this.getContentPane();
    	panel.setLayout(null);
    	ImageIcon background=new ImageIcon("008.jpg");
    	JLabel labelbg=new JLabel(background);
    	labelbg.setBounds(0,0,500,600);
    	panel.add(stop);
    	panel.add(begin);
    	panel.add(save);
    	panel.add(hintresult);
    	panel.add(hintoutput);
    	panel.add(jsp);
    	panel.add(labelbg);
    	panel.setOpaque(false);
    	
    	this.setTitle("Create New Sentences");//标题内容
		this.setBounds(270,30,500,600);
		this.setLocation(300,200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		this.setVisible(true); 
	        
		hintresult.setForeground(Color.blue);
        hintresult.setBounds(0,130,330,30);
        
        hintoutput.setForeground(Color.blue);
        hintoutput.setFont(font);
        hintoutput.setBounds(150,50,300,30);
	    
        output.setLineWrap(true);
        output.setBorder(new LineBorder(new Color(0, 0, 0)));
        output.setWrapStyleWord(true);
        output.setPreferredSize(new Dimension(400,3000));
        
        begin.setBounds(160,300,150,30);
        stop.setBounds(160,350,150,30);
        save.setBounds(140,400,180,30);
        
        begin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	result=count.randomWalk();
                output.setText(result);
            	}
        }) ;
        
        stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	output.setText(count.randomWalk());
            }
        });
        
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                JFileChooser jfc=new JFileChooser();   
                FileNameExtensionFilter filter = new FileNameExtensionFilter(  
                        "文本文件(*.txt)", "txt");  
                jfc.setFileFilter(filter);  
                int option=jfc.showSaveDialog(null);  
                if(option==JFileChooser.APPROVE_OPTION){     
                    File file=jfc.getSelectedFile();  
                    String fname=jfc.getName(file);     
                    if(fname.indexOf(".txt")==-1){  
                        file=new File(jfc.getCurrentDirectory(),fname+".txt");  
                    }  
                    String path=file.getPath();
                    File FileToWrite=new File(path);
                    FileWriter fw;
                    try{  
                    	fw=new FileWriter(FileToWrite);
                        fw.write(result);
                        fw.close();
                    }catch (IOException e2) { 
                    	JOptionPane.showMessageDialog(null,"IO Error!");
                        e2.printStackTrace();  
                    }     
                }  
            }
        });
    }  
	@Override
	public void actionPerformed(ActionEvent e){
		
	}
} */
class RandomWalk extends JFrame implements ActionListener{  
	SheThread thread = null;
	JLabel hintresult=new JLabel("RandomPath");
	Button begin=new Button("begin");
	Button stop=new Button("stop");
	Button save=new Button("Save to file");
	Font font=new Font("SansSerif",1,35); 
	counter count=new counter();
	String result="";
	public RandomWalk() {  
        try {  
            createFrame();  
            }  
            catch(Exception e) {  
            e.printStackTrace();  
        }  
    }
	private void createFrame(){
    	JPanel panel=(JPanel)this.getContentPane();
    	panel.setLayout(null);
    	ImageIcon background=new ImageIcon("008.jpg");
    	JLabel labelbg=new JLabel(background);
    	labelbg.setBounds(0,0,500,600);
    	panel.add(stop);
    	panel.add(begin);
    	panel.add(save);
    	panel.add(hintresult);
    	panel.add(labelbg);
    	panel.setOpaque(false);
    	
    	this.setTitle("RandomWalk");//标题内容
		this.setBounds(200,30,500,400);
		this.setLocation(300,200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		this.setVisible(true); 
		this.setResizable(false);
	        
		hintresult.setForeground(Color.blue);
		hintresult.setFont(font);
        hintresult.setBounds(130,100,330,30);
       
        
        begin.setBounds(160,200,150,30);
        stop.setBounds(160,250,150,30);
        save.setBounds(140,300,180,30);
        
        begin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {  
                if (thread != null)  
                    thread.stop();  
                thread=new SheThread();  
                thread.start(); 
                thread.SetSign(true);
            }  
        }) ;
        
        stop.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {  
                if (thread != null)  
                    thread.stop();  
                thread = null;  
            }  
        });
        
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                JFileChooser jfc=new JFileChooser();   
                FileNameExtensionFilter filter = new FileNameExtensionFilter(  
                        "文本文件(*.txt)", "txt");  
                jfc.setFileFilter(filter);  
                int option=jfc.showSaveDialog(null);  
                if(option==JFileChooser.APPROVE_OPTION){     
                    File file=jfc.getSelectedFile();  
                    String fname=jfc.getName(file);     
                    if(fname.indexOf(".txt")==-1){  
                        file=new File(jfc.getCurrentDirectory(),fname+".txt");  
                    }  
                    String path=file.getPath();
                    File FileToWrite=new File(path);
                    FileWriter fw;
                    try{  
                    	fw=new FileWriter(FileToWrite);
                        fw.write(count.getRandomPath());
                        fw.close();
                    }catch (IOException e2) { 
                    	JOptionPane.showMessageDialog(null,"IO Error!");
                        e2.printStackTrace();  
                    }     
                }  
            }
        });		
	}
	@Override
	public void actionPerformed(ActionEvent e){
		
	}
} 
class SheThread extends Thread {
    counter count=new counter();
    String result="",CurWord="";
    boolean sign=false;
    RandomProcedure frame=new RandomProcedure();
    Vector<Integer> Isvisited[]=new Vector[count.getNodeslist().size()];
    int max=count.getNodeslist().size()-1;
    int min=0;
    long t1=System.currentTimeMillis();
    Random random1=new Random(t1);
    int state=0;
    
    public SheThread() {  
    }  
  
    public void run(){ 
    	count.clearRandomPath();
    	int RandomNode1Index=0;
    	for(int i=0;i<count.getNodeslist().size();i++){
    		Isvisited[i]=new Vector();
    	}
    	if(max-min+1>0)
    		RandomNode1Index=random1.nextInt(max-min+1)+min;
    	else
    		RandomNode1Index=min;
    	if(RandomNode1Index<count.getStrslist().size()){
    		 result+=count.getStrslist().get(RandomNode1Index)+" ";
    		 count.setRandomPath(count.getStrslist().get(RandomNode1Index)+" ");
    	}
    	frame.getOutPut().setText(result);
    	try { 
            Thread.sleep(1000); 
           }catch (InterruptedException e){ 
              e.printStackTrace(); } 
    	
    	while(sign){
    		int flag2=0;
    		Edge e=null;
    		if(RandomNode1Index<count.getStrslist().size()){
    	   	 e=count.getNodeslist().get(RandomNode1Index).GetAdj();
    	    }
    	    if(e==null || flag2==1){
    	    	if (this!=null){  
                    this.stop();
    	    	}
    	    }
    	    else{
    	        max=count.getNodeslist().get(RandomNode1Index).GetNumOfEdge();
    	    	min=0;
    	    	int flag=0;
    	    	while(flag==0){
    	    		long t2=System.currentTimeMillis();
    	        	Random random2=new Random(t2);
    	        	int index=random2.nextInt(max-min+1)+min;
    	        	for(int i=0;i<index-1;i++){
    	        		e=e.GetAdj();
    	        	}
    	        	int RandomNode2Index=0;
    				if(e!=null&&e.GetTail()!=null&&e.GetTail()!="")
    	        	   RandomNode2Index=count.getStrslist().indexOf(e.GetTail());
    				result=result+count.getStrslist().get(RandomNode2Index)+" ";
    				count.setRandomPath(count.getStrslist().get(RandomNode2Index)+" ");
    				frame.getOutPut().setText(result);
    	        	if(Isvisited[RandomNode1Index].indexOf(RandomNode2Index)==-1){
    	        		Isvisited[RandomNode1Index].addElement(RandomNode2Index);
    	        		RandomNode1Index=RandomNode2Index;
    	        		flag=1;
    	        		break; 
    	        	}
    	        	else{
    	        		if (this!=null){  
    	        			state=1;
    	                    this.stop();
    	                    
    	    	    	}
    	        	}
    	    	}
    	    }
    	    try   
    		{   
    		    Thread.currentThread().sleep(1000);//毫秒   
    		}   
    		catch(Exception e2){
    			JOptionPane.showMessageDialog(null,"Thread Error!");
    		}
    	}
    }
    public void SetSign(boolean s){
    	sign=s;
    }
}

class RandomProcedure extends JFrame {
	
	JTextArea output=new JTextArea();
	counter count=new counter(); 
	JScrollPane jsp=new JScrollPane(output);
    public RandomProcedure(){
    	output.setBounds(0,0,300,500);
    	jsp.setBounds(0,0,300,300);
    	jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
    	JPanel panel=(JPanel)this.getContentPane();
    	panel.setLayout(null);
    	ImageIcon background=new ImageIcon("008.jpg");
    	JLabel labelbg=new JLabel(background);
    	labelbg.setBounds(0,0,500,800);
    	panel.add(jsp);
    	panel.add(labelbg);
    	panel.setOpaque(false);
    	this.setTitle("Procedure of RandomWalk");//标题内容
		this.setBounds(0,0,315,335);
		this.setLocation(300,200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		this.setVisible(true); 
		this.setResizable(false);
		output.setEditable(true);
        output.setLineWrap(true);
        output.setBorder(new LineBorder(new Color(0, 0, 0)));
        output.setWrapStyleWord(true);
        output.setPreferredSize(new Dimension(400,3000));
    }
	public JTextArea getOutPut(){
		return output;
	}
}