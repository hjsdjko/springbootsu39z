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


import com.dao.KaoshitongjiDao;
import com.entity.KaoshitongjiEntity;
import com.service.KaoshitongjiService;
import com.entity.vo.KaoshitongjiVO;
import com.entity.view.KaoshitongjiView;

@Service("kaoshitongjiService")
public class KaoshitongjiServiceImpl extends ServiceImpl<KaoshitongjiDao, KaoshitongjiEntity> implements KaoshitongjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KaoshitongjiEntity> page = this.selectPage(
                new Query<KaoshitongjiEntity>(params).getPage(),
                new EntityWrapper<KaoshitongjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KaoshitongjiEntity> wrapper) {
		  Page<KaoshitongjiView> page =new Query<KaoshitongjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KaoshitongjiVO> selectListVO(Wrapper<KaoshitongjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KaoshitongjiVO selectVO(Wrapper<KaoshitongjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KaoshitongjiView> selectListView(Wrapper<KaoshitongjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KaoshitongjiView selectView(Wrapper<KaoshitongjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
