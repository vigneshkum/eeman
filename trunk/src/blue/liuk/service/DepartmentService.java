package blue.liuk.service;

import java.util.List;

import blue.liuk.model.Department;
import blue.liuk.util.Page;

public interface DepartmentService {

	void delete(int id);

	void add(Department de);

	void modify(Department de);



	List<Department> findAll(Page p);

	List<Department> findByName(String name);

	List<Department> findByName(Page p, String name);

	Department findById(Integer id);


}
