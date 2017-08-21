package sy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import sy.dao.TbContentMapper;
import sy.dao.UserMapper;
import sy.model.TbContent;
import sy.model.TbContentExample;
import sy.model.TbContentExample.Criteria;
import sy.model.User;

@Service
public class UserServiceImpl implements UserServiceI {
    
    @Autowired
    private TbContentMapper contentMapper;
    @Autowired
    private UserMapper userMapper;

    
    public List<TbContent> getContents(){
        TbContentExample example = new TbContentExample();
        Criteria c = example.createCriteria();
        c.andIdBetween((long)1,(long) 3);
//        example.or(c);
        Criteria c1 = example.createCriteria();
        c1.andIdBetween((long)1,(long) 5);
        example.or(c1);
        return contentMapper.selectByExample(example);
    }

    @Override
    @Cacheable(value = "common", key = "'id_'+#id")
    public User getUserById(String id) {
        System.out.println("查询。。。。");
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Cacheable(value = "common", key = "'list_'")
    public List<User> getAll() {
        Page<?> page = PageHelper.startPage(3, 2, true);
        List<User> users = userMapper.getAll();
        System.out.println(page.getTotal() + "==========");
        return users;
    }

    @Override
    public List<User> getAll2() {
        return userMapper.getAll2();
    }

    @Override
    public List<User> getAll3() {
        return userMapper.getAll3();
    }

    @Override
    public List<User> getAll4() {
        List<User> list = new ArrayList<>();
        User u = new User();
        u.setId("1");
        list.add(u);
        return userMapper.getAll4(list);
    }

    @Override
    public int insert() {
        User u = new User();
        u.setId("11");
        u.setName("11");
        return userMapper.insert(u);
    }

    @Override
    public int update() {
        User u = new User();
        u.setId("1");
        u.setName("1");
        return userMapper.updateByPrimaryKey(u);
    }

    @Override
    @CachePut(value = "common", key = "#id")
    public int updateCache(String id) {
        User u = new User();
        u.setId("1");
        u.setName("1");
        return userMapper.updateByPrimaryKey(u);
    }
}
