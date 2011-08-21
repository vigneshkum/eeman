package blue.liuk.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.sql.Delete;

import blue.liuk.model.Train;
import blue.liuk.util.GetSth;
import blue.liuk.util.Page;

public interface TrainService {

	Train findById(int id);

	void modify(Train train);

	void delete(Integer id);

	List<Train> findAll(Page pagelist);

	void add(Train train);

	List<Train> search(Map<String, String> params, Page pagelist);

	List<Train> findByTitle(String title, Page pagelist);

}
