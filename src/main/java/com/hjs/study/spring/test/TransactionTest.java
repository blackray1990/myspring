package com.hjs.study.spring.test;

/**
 * 演示声明式事务用法
 */
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class TransactionTest {
	private JdbcTemplate template;
//    private TransactionTemplate transaction;
    private static final String M_TEST_INSERT="insert into user(id,name) values(?,?)";
    private static final String M_TEST_DELETE = "delete from user where id=?";
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

//    public void setTransaction(TransactionTemplate transaction) {
//        this.transaction = transaction;
//    }
    
    /**read-only*/
    public void getData(){
        template.update(M_TEST_INSERT,new Object[]{100,"123shuai"});
    }
    /**Throwable*/
    public void insertData() throws Exception{
    	for(int i=0;i<10;i++){
          if (i==8) 
        	  throw new Exception("====error when updaa=======");
          template.update(M_TEST_INSERT,new Object[]{100+i,"123shuai"});
      }
    }   
    /**注解方式配置事务
     * 如果没有配置回滚机制时，默认出现异常也会提交*/
    @Transactional(rollbackFor=Exception.class)
    public void deleteData() throws Exception{
    	for(int i=100;i<103;i++){
    		if(i==102) 
    			throw new Exception("出现异常，回滚...");
    		template.update(M_TEST_DELETE, i);
    	}
    }
    public static void main(String[] args) throws Exception{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("ApplicationContext-ad.xml");
        TransactionTest t=(TransactionTest)ctx.getBean("JTransaction");
        //在配置文件中配置了get开头方法为readonly，因此在此方法内执行写入操作将抛出异常
        //t.getData();
        //在配置文件中配置了update方法遇到异常时回滚，因此要么方法内所有记录都操作成功，否则都操作失败
        //t.insertData();
        //测试注解事务
        t.deleteData();
    }
}
