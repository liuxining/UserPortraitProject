package cn.liuxining.udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class PathIdUDF extends UDF {
	public Text evaluate(Text text) {
		try {
			String path = text.toString();
			String resultStr = null;
			int videoIndex = path.lastIndexOf("video/");
			if(videoIndex != -1) {
				resultStr = path.substring(videoIndex + 6);
			}
			int articleIndex = path.lastIndexOf("article/");
			if(articleIndex != -1) {
				resultStr = path.substring(articleIndex + 8);
			}
			if(resultStr != null && resultStr.length() > 0) {
				try{
					Integer.parseInt(resultStr);
					return new Text(resultStr);
				}
				catch(Exception e) {
					return null;
				}
			}
		}
		catch (Exception e) {
			return null;
		}
		return null;
	}
	
//	public static void main(String[] args) {
//		System.out.println(new PathIdUDF().evaluate(new Text("http://www.neusoft.com/article/11325")).toString());
//	}
}
