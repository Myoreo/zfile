package im.zhaojun.zfile.repository;

import im.zhaojun.zfile.model.entity.DriveConfig;
import im.zhaojun.zfile.model.enums.StorageTypeEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

/**
 * @author zhaojun
 */
@Mapper
public interface DriverConfigRepository {

    /**
     * 根据存储策略类型获取所有驱动器
     *
     * @param   type
     *          存储类型
     *
     * @return  指定存储类型的驱动器
     */
    @Select("select * from driver_config where `type`=#{type}")
    List<DriveConfig> findByType(StorageTypeEnum type);


    /**
     * 更新驱动器 ID 的排序值
     *
     * @param   orderNum
     *          排序值
     *
     * @param   id
     *          驱动器 ID
     */
    @Update("update driver_config set orderNum = #{orderNum} where id = #{id}")
    void updateSetOrderNumById(@Param("orderNum") Integer orderNum,@Param("id") Integer id);


    /**
     * 查询驱动器最大的 ID
     *
     * @return  驱动器最大 ID
     */
    @Select("select max(id) max from driver_config")
    Integer selectMaxId();


    /**
     * 更新驱动器 ID
     *
     * @param   updateId
     *          驱动器原 ID
     *
     * @param   newId
     *          驱动器新 ID
     */
    @Update("update driver_config set id = #{newId} where id = #{updateId}")
    void updateId(@Param("updaetId") Integer updateId, @Param("updateId") Integer newId);

    @Select("<script> select * from drive_config <if test='enable!=null'> where enable =#{enable} </if>order by order_num</script> ")
    List<DriveConfig> findAll(Integer enable);

    @Select("select * from drive_config where id=#{id}")
    DriveConfig findById(Integer id);

    @Insert("insert into drive_config (auto_refresh_cache,default_switch_to_img_mode,enable,enable_cache,`name`,order_num,search_contain_encrypted_file,search_enable,search_ignore_case," +
            "`type`) values(#{autoRefreshCache},#{defaultSwitchToImgMode},#{enable},#{enableCache},#{name},#{orderNum}," +
            "#{searchContainEncryptedFile},#{searchEnable},#{searchIgnoreCase},#{type})")
    int save(DriveConfig driveConfig);
}