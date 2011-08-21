package blue.liuk.comdao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blue.liuk.dao.Itest;
import blue.liuk.model.User;
@Component
public class commdaottest {
@Autowired
	private Itest itest;

public void de() {
	itest.findAll(User.class);
	
}
}
