package generator;

import java.util.ArrayList;
import java.util.List;

import com.bluebirdme.mes.pmc.entity.Sps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;  
public class Test {

	public static void main(String[] args) {
		// @JsonProperty("mail") 
		Sps sps=new Sps();
		sps.setPlantNo("");
		sps.setWorkshopNo("12");
		sps.setSheetNo("2160523NS01999");
		sps.setSheetStatus("发布");
		sps.setVin("231xxx");
		sps.setCsnGa("2");
		sps.setProduct("SV61");
		sps.setMaterialNo("VC01");
		sps.setPartkitNo("");
		sps.setScanTime("20170720161900");
		sps.setIssuesTime("20170720161900");
		sps.setReqeustTime("20170720161900");
		sps.setUlocNo("");
		Gson gson=new Gson();
		 ObjectMapper mapper = new ObjectMapper();
		 mapper.setSerializationInclusion(Include.NON_NULL);  
		 try {
			System.out.println(mapper.writeValueAsString(sps));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		 System.out.println(JSON.toJSON(sps));
		System.out.println(gson.toJson(sps));
		
	}
	
}
