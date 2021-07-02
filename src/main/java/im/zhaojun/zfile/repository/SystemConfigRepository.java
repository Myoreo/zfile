package im.zhaojun.zfile.repository;

import im.zhaojun.zfile.model.entity.SystemConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author zhaojun
 */
@Mapper
public interface SystemConfigRepository {

    /**
     * 查找系统设置中, 某个设置项对应的值
     *
     * @param   key
     *          设置项
     *
     * @return  设置值
     */
    @Select("select * from system_config where `key`=#{key}")
    SystemConfig findByKey(String key);

}