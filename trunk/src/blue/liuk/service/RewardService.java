package blue.liuk.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import blue.liuk.model.Reward;
import blue.liuk.util.Page;


public interface RewardService {

	public Reward findById(int id);

	public void delete(int id);

	public void save(Reward cj);

	public void update(Reward cj);

	public  List<Reward> findAll(Page p);

	public List<Reward> findByTitle(Page p, String title);

	public List<Reward> search(Page p, Map<String, String> sw);

	public	void delete(int[] ids);
	
	
}
