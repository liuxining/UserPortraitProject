package cn.liuxining.udf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class Date2DayUDF extends UDF {
	public Text evaluate(Text text) {
		try {
			SimpleDateFormat str2date = new SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ss Z]",Locale.ENGLISH);
			Date date = null;
			try {
				date = str2date.parse(text.toString());
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				int day = calendar.get(Calendar.DAY_OF_MONTH);
				Text result = new Text(day + "");
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
