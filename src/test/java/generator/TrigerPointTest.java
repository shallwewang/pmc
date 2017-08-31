package generator;

import com.alibaba.fastjson.JSON;
import com.bluebirdme.mes.pmc.entity.TriggerPoint;

public class TrigerPointTest {
	public static void main(String[] args) {
		TriggerPoint triggerPoint=new TriggerPoint();
		
		triggerPoint.setScanType("0");
		triggerPoint.setLineNo("B");
		triggerPoint.setMesScanNo("16");
		triggerPoint.setPlantNo("1600");
		triggerPoint.setScanTime("20170721094947");
		triggerPoint.setTps("tps");
		triggerPoint.setWorkshopNo("GA1");
		 System.out.println(JSON.toJSON(triggerPoint));
	}
}
