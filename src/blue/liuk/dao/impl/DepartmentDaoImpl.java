package blue.liuk.dao.impl;

import org.springframework.stereotype.Component;

import blue.liuk.base.CommDaoImpl;
import blue.liuk.dao.DepartmentDao;
import blue.liuk.model.Department;

/**
 * @author liuk
 * 
 */
@Component
public class DepartmentDaoImpl extends CommDaoImpl<Department, Integer> implements DepartmentDao {

}
