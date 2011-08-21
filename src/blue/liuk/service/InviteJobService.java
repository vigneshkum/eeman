package blue.liuk.service;

import java.util.List;
import java.util.Map;

import blue.liuk.model.Employee;
import blue.liuk.model.InviteJob;
import blue.liuk.util.Page;





public interface InviteJobService {

	List<InviteJob> search(Page pagelist, Map<String, String> sw);

	List<InviteJob> getAll(Page page);

	void deleteMore(int[] ids);

	void delete(int id);

	InviteJob findById(int id);

	void modify(InviteJob invite);

	void add(InviteJob invite);

	List<InviteJob> getByVer(Page pagelist, Integer ver);

	Employee change(Integer id);

	List<InviteJob> findByName(Page p,String name);

}
