package im.zhaojun.zfile.repository;

import im.zhaojun.zfile.model.entity.StorageConfig;
import im.zhaojun.zfile.model.enums.StorageTypeEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhaojun
 */
@Mapper
public interface StorageConfigRepository {

    /**
     * 根据存储类型找对应的配置信息
     *
     * @param   type
     *          存储类型
     *
     * @return  此类型所有的配置信息
     */
    @Select("select * from storage_config where `type`=#{type}")
    List<StorageConfig> findByTypeOrderById(StorageTypeEnum type);


    /**
     * 根据存储类型找对应的配置信息
     *
     * @param   driveId
     *          驱动器 ID
     *
     * @return  此驱动器所有的配置信息
     */
    @Select("select * from storage_config where `driveId`=#{driveId} order by id")
    List<StorageConfig> findByDriveIdOrderById(Integer driveId);


    /**
     * 根据驱动器找到对应的配置信息
     *
     * @param   driveId
     *          驱动器 ID
     *
     * @return  此驱动器所有的配置信息
     */
    @Select("select * from storage_config where `driveId`=#{driveId}")
    List<StorageConfig> findByDriveId(Integer driveId);


    /**
     * 删除指定驱动器对应的配置信息
     *
     * @param   driveId
     *          驱动器 ID
     */
    @Delete("delete from storage_config where driveId=#{driveId}")
    void deleteByDriveId(Integer driveId);


    /**
     * 查找某个驱动器的某个 KEY 的值
     *
     * @param   driveId
     *          驱动器
     *
     * @param   key
     *          KEY 值
     *
     * @return  KEY 对应的对象
     */
    @Select("select * from storage_config where driveId=#{driveId} and `key`=#{key}")
    StorageConfig findByDriveIdAndKey(@Param("driveId") Integer driveId, @Param("key") String key);


    /**
     * 更新驱动器 ID 对应的参数设置为新的驱动器 ID
     *
     * @param   updateId
     *          驱动器原 ID
     *
     * @param   newId
     *          驱动器新 ID
     */
    @Update("update storage_config set driveId = #{newId} where driveId = #{updateId}")
    void updateDriveId(@Param("updateId") Integer updateId,@Param("newId") Integer newId);

}