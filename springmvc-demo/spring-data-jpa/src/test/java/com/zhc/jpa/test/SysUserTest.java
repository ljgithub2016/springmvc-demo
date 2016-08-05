package com.zhc.jpa.test;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhc.jpa.domain.SysUser;
import com.zhc.jpa.service.SysUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/applicationContext.xml"}) 
public class SysUserTest {
	@Autowired private SysUserService sysUserService;
	//保存用户
    @Test
    public void testSaveUser() {
//    	sysUserService.saveSysUser(new SysUser("zhouhc", "123456"));
    	sysUserService.saveBatchSysUser(Arrays.asList(new SysUser("zhouhc6","12394"),new SysUser("zhc1136", "234567")));
    }
    
    /**
     * query sysUser
     */
    @Test
    public void testQueryUser() {
//    	System.out.println(sysUserService.findAll().size());
//    	System.out.println(sysUserService.findSysUserById(1).getAccount());
//    	System.out.println(sysUserService.findByAccount("zhc").getPassword());
//    	System.out.println(sysUserService.findByAccountLike("zhouhc1").getPassword());
//    	System.out.println(sysUserService.findByAccountIn(Arrays.asList("zhc","zhouhc")).size());
//    	System.out.println(sysUserService.findByAccountAndPassword("zhc", "234567").getPassword());
//    	System.out.println(sysUserService.findPage().getContent().size());
//    	System.out.println(sysUserService.getByCondition(new SysUser("叶花仙", "")).getContent().size());
//    	System.out.println(sysUserService.queryByMutiCondition(new SysUser("zhc", "")).size());
    	System.out.println(sysUserService.queryPageByMutiCondition(new SysUser("zhc", "")).getContent().size());
    }
    
    @Test
    public void testUpdate(){
    	SysUser su=sysUserService.findSysUserById(2);
    	su.setAccount("叶花仙");
    	sysUserService.updateSysUser(su);
    	System.out.println(sysUserService.findByAccount("叶花仙").getPassword());
    	
    }
}
