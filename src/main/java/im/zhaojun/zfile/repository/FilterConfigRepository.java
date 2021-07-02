package im.zhaojun.zfile.repository;

import im.zhaojun.zfile.model.entity.FilterConfig;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhaojun
 */
@Mapper
public interface FilterConfigRepository {

    /**
     * 获取驱动器下的所有规则
     * @param       driveId
     *              驱动器 ID
     */
    @Select("select * from filter_config where drive_id=#{driveId}")
    List<FilterConfig> findByDriveId(Integer driveId);

    /**
     * 根据驱动器 ID 删除其所有的规则
     * @param       driveId
     *              驱动器 ID
     */
    @Delete("delete from filter_config where drive_id=#{driveId}")
    void deleteByDriveId(Integer driveId);


    /**
     * 更新驱动器 ID 对应的参数设置为新的驱动器 ID
     *
     * @param   updateId
     *          驱动器原 ID
     *
     * @param   newId
     *          驱动器新 ID
     */
    @Update("update filter_config set driveId = #{newId} where driveId = #{updateId}")
    void updateDriveId(@Param("updateId") Integer updateId, @Param("newId") Integer newId);
}