package im.zhaojun.zfile.repository;

import im.zhaojun.zfile.model.entity.ShortLinkConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

/**
 * @author zhaojun
 */
@Mapper
public interface ShortLinkConfigRepository{

    /**
     * 获取驱动器下的所有规则
     *
     * @param       key
     *              短链 Key
     */
    @Select("select * from short_link where `key`=#{key} ")
    ShortLinkConfig findFirstByKey(String key);

    // @Query(nativeQuery = true,
    //         value = " select * from SHORT_LINK where " +
    //                 " key like concat('%', :key,'%') " +
    //                 " and url like concat('%', :url,'%') " +
    //                 " and (:dateFrom is null or date_format(create_date, '%Y-%m-%d') >= date_format(:dateFrom, '%Y-%m-%d'))" +
    //                 " and (:dateTo is null or date_format(create_date, '%Y-%m-%d') <= date_format(:dateTo, '%Y-%m-%d')) ) ",
    //         countQuery =  " select count(1) from SHORT_LINK where " +
    //                 " key like concat('%', :key,'%') " +
    //                 " and url like concat('%', :url,'%') " +
    //                 " and (:dateFrom  is null or date_format(create_date, '%Y-%m-%d') >= date_format(:dateFrom, '%Y-%m-%d'))" +
    //                 " and (:dateTo is null or date_format(create_date, '%Y-%m-%d') <= date_format(:dateTo, '%Y-%m-%d')) ) "
    // )
    @Select(" select * from short_link where " +
            " key like concat('%', #{key},'%') " +
            " and url like concat('%', #{url},'%') " +
            " and (#{dateFrom} is null or create_date >= #{dateFrom}" +
            " and (#{dateTo} is null or create_date <= #{dateTo}) ")
    List<ShortLinkConfig> findByPage(@Param("key") String key, @Param("url") String url, @Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo);

    /**
     * 获取驱动器下的所有规则
     *
     * @param       url
     *              短链 URL
     */
    @Select("select * from short_link where `url`=#{url}")
    ShortLinkConfig findFirstByUrl(String url);


    @Update("update short_link set url = replace(url, #{updateSubPath}, #{newSubPath})")
    void updateUrlDriveId(@Param("updateSubPath")String updateSubPath,@Param("newSubPath") String newSubPath);
}