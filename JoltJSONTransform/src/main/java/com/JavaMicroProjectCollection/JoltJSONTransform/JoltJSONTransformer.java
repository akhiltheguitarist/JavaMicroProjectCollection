package com.JavaMicroProjectCollection.JoltJSONTransform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;

/**
 * Hello world!
 *
 */
public class JoltJSONTransformer {
	public static void main(String[] args) {

		Object inputJSON = JsonUtils.classpathToObject("/InputFile.json");
		for (int i = 1; i < 3; i++) {
			System.out.println("Input JSON: " + JsonUtils.toPrettyJsonString(inputJSON));
			Chainr chainr = Chainr.fromSpec(getTemplateJSON(i));
			Object transformedJSON = chainr.transform(inputJSON);
			System.out.println("Template JSON: " + JsonUtils.toPrettyJsonString(getTemplateJSON(i)));
			System.out.println("Updated JSON: " + JsonUtils.toPrettyJsonString(transformedJSON));
			System.out.println("---------------------------------------------------");
			System.out.println("---------------------------------------------------");
		}

	}

	public static List<Object> getTemplateJSON(int templateId) {

		List<String> templateNames = new ArrayList<String>(
				Arrays.asList("/removeTemplate.json", "/shiftTemplate.json", "/defaultTemplate.json"));
		List<Object> jsonRemoveTemplateList = JsonUtils.classpathToList(templateNames.get(templateId));
		return jsonRemoveTemplateList;
	}

}
