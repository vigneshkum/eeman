/**
 * 
 */
package blue.liuk.db;

import java.util.Set;

import javax.persistence.FetchType;

import org.junit.Test;

import blue.liuk.dao.SalaryDao;
import blue.liuk.dao.impl.SalaryDaoImpl;
import blue.liuk.model.Employee;
import blue.liuk.model.Pay;
import blue.liuk.model.Reward;
import blue.liuk.model.Train;
import blue.liuk.service.EmployeeService;
import blue.liuk.service.impl.EmployeeServiceImpl;
import blue.liuk.util.Page;




/**
 * @author Administrator
 *
 */
public class UtilPageTest {
	@Test
	public void shuzu() {
   Page page=new Page(2)	;
   page.setPageNum(9);
   page.setActionname("findall");
   page.setRowTotalCount(80);
	System.out.println(page.getPageNum());
	System.out.println(page.getPageNextNum());
	System.out.println(page.getActionname());
	for (int i : page.getPageNums()) {
		if (i==page.getPageNum()) {
			System.out.print("(当前"+i+")");
			
		}
		else {
			System.out.print(i);
		}
		
	}
	}
	
	@Test
	//employee 
	public void emallinfo() {
		EmployeeService eImpl = new EmployeeServiceImpl();
		Employee e = eImpl.findById(61);
		System.out.print(e.getName()+"属于");
		System.out.print(e.getDepartment().getName()+"参加了");
		//fetch=FetchType.EAGER
		Set<Train> trs=e.getTrains();
		System.out.print(trs.size());
		for (Train train : trs) {
			System.out.print(" "+train.getName()+" ");
		}
		//fetch=FetchType.EAGER
		Set<Reward> rewards=e.getRewards();
		for (Reward reward : rewards) {
			System.out.print(" "+reward.getType()+" ");
		}
	}
	
	@Test
	public void pay() {
		SalaryDao salary=new SalaryDaoImpl();
		Page p=new Page(1);
	//	salary.findAll(p);
		Pay pay=(Pay)p.getList().get(0);
		int id=pay.getAccount();
		pay=salary.findById(id);
		System.out.print(pay.getAccount());
		salary.delete(pay);
		pay=salary.findById(id+1);
		pay.setBasePay(20);
		salary.update(pay);
	}
}
