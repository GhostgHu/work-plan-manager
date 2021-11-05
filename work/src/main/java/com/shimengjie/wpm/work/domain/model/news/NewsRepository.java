package com.shimengjie.wpm.work.domain.model.news;

/**
 * @author shimengjie
 * @date 2021/9/22 17:17
 **/
public interface NewsRepository {

    /**
     * 根据ID查询 News
     *
     * @param id ID
     * @return News
     */
    News newsOfId(Long id);

}
