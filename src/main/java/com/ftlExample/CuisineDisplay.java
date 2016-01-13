package com.ftlExample;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

/*
 *Author: Aamin Lakhani
 *
 * Example of using a FTL template in a Java File. The model sets up a list which is then displayed using the ftl template
 *
 */
public class CuisineDisplay {

	@SuppressWarnings("deprecation")
	public static void main (String args[]) {
		Configuration cfg = new Configuration();
		try {
			
			Template template = cfg.getTemplate("src/main/resources/displaySimpleList.ftl");
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("message", "FTL Usage Example");

			List<String> cuisines = new ArrayList<String>();
			cuisines.add("Italian");
			cuisines.add("Chinese");
			cuisines.add("Indian");
			cuisines.add("Ethiopian");
			cuisines.add("Thai");

			data.put("cuisines", cuisines);

			Writer out = new OutputStreamWriter(System.out);
			template.process(data, out);
			out.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
