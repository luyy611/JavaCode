package session1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;

import javax.security.auth.kerberos.KerberosKey;

/*
 * java基础语法操作练习
 */
public class javaBase {
	//自定义输出
	public static void print(int i,Object obj){
		System.out.println(String.format("{%d},%s",i,obj.toString()));
	}
	//基本运算
	public static void demoOperation(){
		print(1, 2+3);
		print(2, 2-3);
		print(3, 2*3);
		print(4, 3/2.0);
		print(5, 3<<2);
		print(6, 3>>2);
		print(7, 3&2);
		print(8, 3|2);
		print(9, 3^2);
	}
	//控制流
	public static void demoControlFlow(){
		int score=68;
		if(score>=90){
			print(1, "A");
		}
		else if(score>=80){
			print(2, "B");
		}
		else{
			print(3, "C");
		}
		String gird="B";
		switch(gird){
			case "A":
				print(4, "优");
				break;
			case "B":
				print(5, "良");
				break;
			case "C":
				print(6, "及格");
				break;
			default:
				print(7, "差");
		}
		for(int i=0;i<5;i+=2){
			if(i==2){
				continue;
			}
			if(i==4){
				print(9, "i=4");
			}
			print(8, i);
		}
		int current=20;
		int target=0;
		while(current>target){
			current-=5;
			print(10, current);
			if(current==10){
				break;
			}
		}
		String str="hello";
		for(char c:str.toCharArray()){
			print(9, c);
		}
	}
	//字符串操作
	public static void demoString(){
		String str="Hello World";
		print(1, str.length());
		print(2, str.charAt(4));
		print(3, str.toLowerCase());
		print(4, str.toUpperCase());
		print(5, str.indexOf('o'));
		print(6, str.codePointAt(1));
		print(7, str.compareTo("Hello Vorld"));
		print(8, str.compareTo("Hello Xorld"));
		print(9, str.replace('o', 'O'));
		print(10, str.replaceAll("Hello", "Hi"));
		print(11, str.replaceAll("o|l", "u"));
		print(12, str.concat("!!"));
		print(13, str.contains("He"));
		print(14, str.endsWith("ld"));
		StringBuilder sb = new StringBuilder();
		sb.append(true);
		sb.append(1);
		sb.append(2.2);
		print(15, sb.toString());
		print(16, "a"+"b"+String.valueOf(12));
	}
	//List操作
	public static void demoList(){
		List<String> strList=new ArrayList<String>();
		for(int i=1;i<5;i++){
			strList.add(String.valueOf(i));
		}
		print(1, strList);
		List<String> otherList=new ArrayList<String>();
		for(int j=0;j<4;j++){
			otherList.add(String.valueOf(j*j+1));
		}
		strList.addAll(otherList);//添加另外一个集合
		print(2, strList);
		strList.remove(0);
		print(3, strList);
		strList.remove("1");
		print(4, strList);
		print(5, strList.get(2));
		
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(9);
		for(int k=0;k<9;k++){
			nums.add(k);
		}		
		//默认正序排序
		Collections.sort(nums);
		print(6, nums);
		//自定义逆序排序
		Collections.sort(nums,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1,Integer o2){
				return o2.compareTo(o1);
			}
		});
		print(7, nums);
		Collections.reverse(nums);//反序，不一定得到逆序排序
		print(8, nums);
	}
	//Set操作
	public static void demoSet(){
		Set<String> strSet=new HashSet<String>();
		for(int i=0;i<3;i++){
			strSet.add(String.valueOf(i));
		}
		print(1, strSet);
		strSet.remove("0");
		print(2, strSet);
		strSet.addAll(Arrays.asList(new String[]{"A","B","C"}));
		print(3, strSet);
		print(4, strSet.isEmpty());
		print(5, strSet.size());
		print(6, strSet.hashCode());
		//遍历
		int n=7;
		for(String value:strSet){
			print(n++, value);
		}
	}
	//Map操作
	public static void demoMap(){
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(int i=0;i<4;i++){
			map.put(i, String.valueOf(i*i));
		}
		print(1, map);
		//遍历
		for(Map.Entry<Integer, String> entry:map.entrySet()){
			print(2, entry.getKey()+":"+entry.getValue());
		}
		print(3, map.keySet());
		print(4, map.values());
		print(5, map.containsKey(1));
		print(6, map.containsValue("4"));
		print(7, map.get(2));//获取键为2的值
		map.replace(1, "A");//替换键为1的值为“A”
		print(8, map);
	}
	//异常抛出
	public static void demoException(){
		try{
			print(1, "开始了");
			String str = null;
			str.indexOf('a');
			int i=2/0;
		}
		catch(NullPointerException npe){
			//npe.getMessage();
			//npe.printStackTrace();
			//npe.fillInStackTrace();
			print(1, "NPE");
		}
		catch(Exception ex){
			print(2, "Exception");
		}
		finally{
			print(3, "Finally");
		}
	}
	//常规类
	public static void demoCommon(){
		//随机数
		Random r = new Random();
		//固定算法产生随机数 即加上这句话产生的随机数相同
		r.setSeed(1);
		for(int i=0;i<4;i++){
			print(1, r.nextInt(100));
			print(2, r.nextDouble());
		}
		
		//数组洗牌
		List<Integer> array=new ArrayList<Integer>();
		array.addAll(Arrays.asList(new Integer[]{5,7,8,1,2}));
		print(3, array);
		Collections.shuffle(array);//随机洗牌
		print(4, array);
		
		//获取系统时间
		Date dt = new Date();
		//Sat Jul 07 17:17:20 CST 2018
		print(5, dt);
		//1530955040285
		print(6, dt.getTime());
		//print(7, dt.getDate());
		//2018-07-07 05:17:20
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		print(8, df.format(dt));
		//2018年7月7日 星期六
		print(9, DateFormat.getDateInstance(DateFormat.FULL).format(dt));
	
		//Math
		print(10, Math.ceil(2.5));
		print(11, Math.floor(2.5));
		print(12, Math.max(1, 2));
		print(13, Math.log(2));
	}
	public static void main(String[] args){
		//demoOperation();
		//demoControlFlow();
		//demoException();
		//demoString();
		//demoList();
		//demoSet();
		//demoMap();
		demoCommon();
		ArrayList<String> lstStr= new ArrayList<String>();
	}


}
