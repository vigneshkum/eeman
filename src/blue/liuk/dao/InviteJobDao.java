package blue.liuk.dao;




import java.util.List;
import java.util.Map;

import blue.liuk.base.CommDao;
import blue.liuk.model.InviteJob;
import blue.liuk.util.Page;

public interface InviteJobDao extends CommDao<InviteJob, Integer> {

List<InviteJob> search(Page pagelist, Map<String, String> sw);

}
