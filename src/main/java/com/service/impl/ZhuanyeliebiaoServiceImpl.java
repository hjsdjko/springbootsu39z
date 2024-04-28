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


import com.dao.ZhuanyeliebiaoDao;
import com.entity.ZhuanyeliebiaoEntity;
import com.service.ZhuanyeliebiaoService;
import com.entity.vo.ZhuanyeliebiaoVO;
import com.entity.view.ZhuanyeliebiaoView;

@Service("zhuanyeliebiaoService")
public class ZhuanyeliebiaoServiceImpl extends ServiceImpl<ZhuanyeliebiaoDao, ZhuanyeliebiaoEntity> implements ZhuanyeliebiaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhuanyeliebiaoEntity> page = this.selectPage(
                new Query<ZhuanyeliebiaoEntity>(params).getPage(),
                new EntityWrapper<ZhuanyeliebiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhuanyeliebiaoEntity> wrapper) {
		  Page<ZhuanyeliebiaoView> page =new Query<ZhuanyeliebiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhuanyeliebiaoVO> selectListVO(Wrapper<ZhuanyeliebiaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhuanyeliebiaoVO selectVO(Wrapper<ZhuanyeliebiaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhuanyeliebiaoView> selectListView(Wrapper<ZhuanyeliebiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhuanyeliebiaoView selectView(Wrapper<ZhuanyeliebiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
