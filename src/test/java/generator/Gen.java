/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 华东工程中心（无锡）
 * 2016版权所有
 */
package generator;

import com.bluebirdme.mes.pmc.entity.AviCheck;
import com.bluebirdme.mes.pmc.entity.Line;
import com.bluebirdme.mes.pmc.entity.MesPlan;
import com.bluebirdme.mes.pmc.entity.Part;
import com.bluebirdme.mes.pmc.entity.Plant;
import com.bluebirdme.mes.pmc.entity.Sps;
import com.bluebirdme.mes.pmc.entity.SpsOnline;
import com.bluebirdme.mes.pmc.entity.SpsReset;
import com.bluebirdme.mes.pmc.entity.TriggerPoint;
import com.bluebirdme.mes.pmc.entity.UnitLocation;
import com.bluebirdme.mes.pmc.entity.VehicleModel;
import com.bluebirdme.mes.pmc.entity.Workshop;
import com.bluebirdme.mes.pmc.util.DevHelper;

/**
 * 代码生成器
 * 
 * @author shallwe_wang
 * @Date 2016年4月8日 下午12:24:50
 */
public class Gen {

	/**
	 * 生成Controller,Service.Dao
	 * 
	 * @param entity
	 *            实体类.class
	 * @param author
	 *            作者
	 */
	public static <T> void csd(Class<T> entity, String author) {
		try {
			DevHelper.genCSD(entity, author);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成JS,JSP
	 * 
	 * @param entity
	 *            实体类.class
	 * @param author
	 *            作者
	 */
	public static <T> void jsJsp(Class<T> entity, String author) {
		try {
			DevHelper.genJsJsp(entity, author);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成所有的Controller，Service，Dao，JS，JSP
	 * 
	 * @param entity
	 * @param author
	 */
	public static <T> void genAll(Class<T> entity, String author) {
		try {
			DevHelper.genCSD(entity, author);
			DevHelper.genJsJsp(entity, author);
			DevHelper.genSqlXml(entity, author);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		/*genAll(Plant.class, "shallwe_wang");
		genAll(Line.class, "shallwe_wang");
		genAll(Workshop.class, "shallwe_wang");
		genAll(UnitLocation.class, "shallwe_wang");
		genAll(VehicleModel.class, "shallwe_wang");*/
		
	}

}
