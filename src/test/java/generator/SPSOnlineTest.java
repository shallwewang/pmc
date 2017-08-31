package generator;

import com.bluebirdme.mes.pmc.entity.SpsOnline;
import com.google.gson.Gson;

public class SPSOnlineTest {
	public static void main(String[] args) {
		
		Gson gson=new Gson();
		SpsOnline sol=new SpsOnline();
		sol.setPlantNo("1800");
		sol.setVin("263984");
		sol.setSheetNo("A156");
		sol.setOnlineTime("2017-07-21 11:24:30");
		
		String msg=gson.toJson(sol);
		SpsOnline spsOnline=gson.fromJson(msg, SpsOnline.class);
		 System.out.println(msg);
	}
}
