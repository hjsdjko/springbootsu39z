package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.WangjimimarenyuandengjiDao;
import com.entity.WangjimimarenyuandengjiEntity;
import com.service.WangjimimarenyuandengjiService;
import com.entity.vo.WangjimimarenyuandengjiVO;
import com.entity.view.WangjimimarenyuandengjiView;

@Service("wangjimimarenyuandengjiService")
public class WangjimimarenyuandengjiServiceImpl extends ServiceImpl<WangjimimarenyuandengjiDao, WangjimimarenyuandengjiEntity> implements WangjimimarenyuandengjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WangjimimarenyuandengjiEntity> page = this.selectPage(
                new Query<WangjimimarenyuandengjiEntity>(params).getPage(),
                new EntityWrapper<WangjimimarenyuandengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WangjimimarenyuandengjiEntity> wrapper) {
		  Page<WangjimimarenyuandengjiView> page =new Query<WangjimimarenyuandengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WangjimimarenyuandengjiVO> selectListVO(Wrapper<WangjimimarenyuandengjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WangjimimarenyuandengjiVO selectVO(Wrapper<WangjimimarenyuandengjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WangjimimarenyuandengjiView> selectListView(Wrapper<WangjimimarenyuandengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WangjimimarenyuandengjiView selectView(Wrapper<WangjimimarenyuandengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
