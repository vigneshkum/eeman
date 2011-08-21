package blue.liuk.service.impl;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blue.liuk.base.BaseDao;
import blue.liuk.dao.TrainDao;
import blue.liuk.exception.ErrorMsg;
import blue.liuk.exception.HrException;
import blue.liuk.model.Train;
import blue.liuk.service.TrainService;
import blue.liuk.util.Page;

@Service
@Transactional
public class TrainServiceImpl implements TrainService {
	@Autowired
    private TrainDao  trainDao;
	

	@Override
	public void add(Train train) {
       trainDao.save(train);
	}
	
 	@Override
	public Train findById(int id) {
 		Train train=trainDao.findById(Train.class, id);
 		if (null==train) {
			throw new HrException(ErrorMsg.ID_FIND_NO);
		}
		return train;
	}
	@Override
	public void modify(Train train) {
		Train train2 = this.findById(train.getId());	
		train2.setAddress(train.getAddress());
		train2.setContent(train.getContent());
		train2.setName(train.getName());
		train2.setTime(train.getTime());
		train2.setTitle(train.getTitle());
		trainDao.saveOrUpdate(train2);
	}

	@Override
	public void delete(Integer id) {
		Train train=this.findById(id);
		trainDao.delete(train);
	}

	@Override
	public List<Train> findAll(Page pagelist) {
		if (null==pagelist) {
			return trainDao.findAll(Train.class);
		}
		int total=trainDao.getTotalCount(Train.class);
		pagelist.setRowTotalCount(total);
		return 	trainDao.findAll(Train.class, pagelist.getRowStartCount(), Page.pagesize);
	}
	@Override
	public List<Train> search(Map<String, String> params,Page pagelist) {
		
		int total=trainDao.getTotalCount(params);
		pagelist.setRowTotalCount(total);
		 List<Train> trains=trainDao.search(params, pagelist.getRowStartCount(),Page.pagesize);
		 if (trains.size()==0) {
			throw new HrException(ErrorMsg.NO_RESULT);
		}
		 return trains;
	}
	@Override
	public List<Train> findByTitle(String title,Page pagelist) {
		int total=trainDao.getTotalCount(Train.class, "title",title, BaseDao.LIKE_SQL);
		pagelist.setRowTotalCount(total);
		List<Train> trains= trainDao.findByProperty(Train.class, "title","%"+title+"%",BaseDao.LIKE_SQL, pagelist.getRowStartCount(), Page.pagesize);
		 if (trains.size()==0) {
				throw new HrException(ErrorMsg.NO_RESULT);
			}
		 return trains;
	}
	


	


}

