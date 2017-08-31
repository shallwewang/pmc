package com.bluebirdme.mes.pmc.util;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.UUID;

import org.xdemo.superutil.j2se.StringUtils;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
public class Utils {

	private static final String CHARSET = "UTF-8";

	private static Configuration getFreemarkerConfig() throws IOException {
		@SuppressWarnings("deprecation")
		Configuration config = new Configuration();
		config.setClassForTemplateLoading(Utils.class, "/template/");
		config.setEncoding(Locale.CHINA, "utf-8");
		return config;
	}

	public static void generateToFile(String ftlName, String outputFile, Object data) throws IOException {

		FileOutputStream fos = new FileOutputStream(outputFile);
		Writer out = new OutputStreamWriter(fos, CHARSET);

		try {

			Template tpl = getFreemarkerConfig().getTemplate(ftlName);
			tpl.setEncoding(CHARSET);

			tpl.process(data, out);
			out.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fos.close();
			out.close();
		}
	}

	public static String firstCharToLowerCase(String str) {
		if (Character.isLowerCase(str.charAt(0))) {
			return str;
		} else {
			char[] cs = str.toCharArray();
			cs[0] += 32;
			return String.valueOf(cs);
		}
	}

}

