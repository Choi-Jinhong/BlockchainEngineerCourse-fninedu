package spring.day0625.anno;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("logic")
public class LogicController {
	
	 
	//@Autowired //�ڵ�����
	@Resource
	MyDao dao;
	
	public LogicController(MyDao dao) {
		this.dao=dao;
	}
	
	public void insert(String str)
	{
		dao.insertData(str);
	}
	
	public void delete(String num)
	{
		dao.deleteData(num);
	}

}
