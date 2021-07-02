package im.zhaojun.zfile.model.entity;

import im.zhaojun.zfile.model.enums.StorageTypeEnum;
import lombok.Data;


/**
 * @author zhaojun
 */
@Data
public class StorageConfig {

    private Integer id;

    private StorageTypeEnum type;

    private String key;

    private String title;

    private String value;

    private Integer driveId;

    public StorageConfig(String key, String title) {
        this.key = key;
        this.title = title;
    }

}