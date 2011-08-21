package blue.liuk.dao;

import java.util.List;
import java.util.Map;

import blue.liuk.base.CommDao;
import blue.liuk.model.Train;

public interface TrainDao extends CommDao<Train, Integer> {

	List<Train> search(Map<String, String> params, int start, int limit);

	int getTotalCount(Map<String, String> params);

}
