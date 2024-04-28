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


import com.dao.KaoshiguizeDao;
import com.entity.KaoshiguizeEntity;
import com.service.KaoshiguizeService;
import com.entity.vo.KaoshiguizeVO;
import com.entity.view.KaoshiguizeView;

@Service("kaoshiguizeService")
public class KaoshiguizeServiceImpl extends ServiceImpl<KaoshiguizeDao, KaoshiguizeEntity> implements KaoshiguizeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KaoshiguizeEntity> page = this.selectPage(
                new Query<KaoshiguizeEntity>(params).getPage(),
                new EntityWrapper<KaoshiguizeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KaoshiguizeEntity> wrapper) {
		  Page<KaoshiguizeView> page =new Query<KaoshiguizeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KaoshiguizeVO> selectListVO(Wrapper<KaoshiguizeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KaoshiguizeVO selectVO(Wrapper<KaoshiguizeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KaoshiguizeView> selectListView(Wrapper<KaoshiguizeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KaoshiguizeView selectView(Wrapper<KaoshiguizeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
