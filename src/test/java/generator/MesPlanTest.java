package generator;

import com.alibaba.fastjson.JSON;
import com.bluebirdme.mes.pmc.entity.MesPlan;

public class MesPlanTest {
	public static void main(String[] args) {
		
		MesPlan plan=new MesPlan();
		plan.setTps("00000185");
		plan.setVin("12309");
		plan.setOrderType("01");
		plan.setModel("Sw");
		plan.setDate("2017-07-21 11:24:30");
		plan.setSequence("12");
		plan.setLineNo("A");
		System.out.println(JSON.toJSON(plan));
	}
}
