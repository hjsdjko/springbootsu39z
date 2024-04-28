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


import com.dao.KaoshipingfenDao;
import com.entity.KaoshipingfenEntity;
import com.service.KaoshipingfenService;
import com.entity.vo.KaoshipingfenVO;
import com.entity.view.KaoshipingfenView;

@Service("kaoshipingfenService")
public class KaoshipingfenServiceImpl extends ServiceImpl<KaoshipingfenDao, KaoshipingfenEntity> implements KaoshipingfenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KaoshipingfenEntity> page = this.selectPage(
                new Query<KaoshipingfenEntity>(params).getPage(),
                new EntityWrapper<KaoshipingfenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KaoshipingfenEntity> wrapper) {
		  Page<KaoshipingfenView> page =new Query<KaoshipingfenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KaoshipingfenVO> selectListVO(Wrapper<KaoshipingfenEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KaoshipingfenVO selectVO(Wrapper<KaoshipingfenEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KaoshipingfenView> selectListView(Wrapper<KaoshipingfenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KaoshipingfenView selectView(Wrapper<KaoshipingfenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
