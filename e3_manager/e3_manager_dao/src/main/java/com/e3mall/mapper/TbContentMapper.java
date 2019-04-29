package com.e3mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.e3mall.pojo.TbContent;
import com.e3mall.pojo.TbContentExample;

public interface TbContentMapper {
    int countByExample(TbContentExample example);

    int deleteByExample(TbContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbContent record);

    int insertSelective(TbContent record);

    List<TbContent> selectByExampleWithBLOBs(TbContentExample example);

    List<TbContent> selectByExample(TbContentExample example);

    TbContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbContent record, @Param("example") TbContentExample example);

    int updateByExampleWithBLOBs(@Param("record") TbContent record, @Param("example") TbContentExample example);

    int updateByExample(@Param("record") TbContent record, @Param("example") TbContentExample example);

    int updateByPrimaryKeySelective(TbContent record);

    int updateByPrimaryKeyWithBLOBs(TbContent record);

    int updateByPrimaryKey(TbContent record);

	/**
	 * 根据id批量删除内容
	 * <p>Title: deleteBatchById</p>
	 * <p>@date 2019年4月29日 下午1:32:28</p>
	 * @param ids
	 * @return
	 */
	int deleteBatchById(List<String> ids);
}