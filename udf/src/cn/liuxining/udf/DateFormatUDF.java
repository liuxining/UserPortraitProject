package cn.liuxining.udf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class DateFormatUDF extends UDF {
	public Text evaluate(Text text) {
		try {
			SimpleDateFormat date2str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat str2date = new SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ss Z]", Locale.ENGLISH);
			Date date = null;
			try {
				date = str2date.parse("[10/Nov/2016:00:01:53 +0800]");
				String time = date2str.format(date);
				Text result = new Text(time);
				return result;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		catch (Exception e) {
			return null;
		}
		return null;
	}
}
