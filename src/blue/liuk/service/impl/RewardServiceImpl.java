package blue.liuk.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blue.liuk.dao.RewardDao;
import blue.liuk.exception.ErrorMsg;
import blue.liuk.exception.ExceptionMsg;
import blue.liuk.exception.HrException;
import blue.liuk.model.Reward;
import blue.liuk.service.RewardService;
import blue.liuk.util.Page;

@Service
@Transactional
public class RewardServiceImpl implements RewardService {
	@Autowired
	private RewardDao rewardDao;

	@Override
	@Transactional
	public Reward findById(int id) {
		if (null == new Integer(id)) {
			throw new HrException(ErrorMsg.ID_IS_NULL);
		}
		Reward reward = rewardDao.findById(id);
		if (null == reward) {
			throw new HrException(ErrorMsg.ID_FIND_NO);
		}
		return reward;
	}

	@Override
	public void delete(int id) {
		Reward reward = this.findById(id);
		try {
			rewardDao.delete(reward);
		} catch (Exception e) {
			throw new HrException(ErrorMsg.DELETE_ERROR);
		}

	}

	@Override
	public void delete(int[] ids) {
		for (int i : ids) {
			this.delete(i);
		}

	}

	@Override
	public void save(Reward cj) {
		try {
			rewardDao.save(cj);
		} catch (Exception e) {
			throw new HrException(ErrorMsg.SAVE_ERROR);
		}

	}

	@Override
	public void update(Reward cj) {
		try {
			rewardDao.update(cj);
		} catch (Exception e) {
			throw new HrException(ErrorMsg.SAVE_ERROR);
		}

	}

	@Override
	public  List<Reward> findAll(Page p) {
		return rewardDao.findAll(p);

	}

	@Override
	public List<Reward> findByTitle(Page p, String title) {
		return rewardDao.findByTitle(p, title);

	}

	@Override
	public List<Reward> search(Page p, Map<String, String> sw) {
	return	rewardDao.search(p, sw);
	}

}
