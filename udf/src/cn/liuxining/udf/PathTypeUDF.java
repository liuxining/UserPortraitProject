package cn.liuxining.udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class PathTypeUDF extends UDF {
	public Text evaluate(Text text) {
		try {
			String path = text.toString();
			int videoIndex = path.lastIndexOf("video/");
			if(videoIndex != -1) {
				return new Text("video");
			}
			int articleIndex = path.lastIndexOf("article/");
			if(articleIndex != -1) {
				return new Text("article");
			}
		}
		catch (Exception e) {
			return null;
		}
		return null;
	}
	
	
}
