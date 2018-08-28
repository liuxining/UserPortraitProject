package cn.liuxining.udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;
import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.lionsoul.ip2region.Util;

public class Ip2RegionUDF extends UDF {
	public Text evaluate(Text text) {
		try {
			String ip = text.toString();
			boolean isIpAddress = Util.isIpAddress(ip);
			if(!isIpAddress) {
				return null;
			}
			try {
				DbConfig conf = new DbConfig();
				String dbFile = "/soft/ip2region.db";
//				String dbFile = "/Users/liuxining/Downloads/ip2region.db";
				DbSearcher searcher = new DbSearcher(conf, dbFile);
				DataBlock block = searcher.btreeSearch(ip);
				String region = block.getRegion();
				searcher.close();
				String[] regions = region.split("\\|");
				for (String reg : regions) {
					if(reg.contains("市")) {
						return new Text(reg);
					}
				}
				if(regions != null && regions.length > 0) {
					return new Text(regions[0]);
				}
				return null;
			} catch (Exception e) {
//				e.printStackTrace();
				return null;
			} 
		}
		catch (Exception e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new Ip2RegionUDF().evaluate(new Text("14.145.74.175")).toString());
	}
	
}
