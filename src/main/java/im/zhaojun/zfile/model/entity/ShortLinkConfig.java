package im.zhaojun.zfile.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ShortLinkConfig {

    private Integer id;

    private String key;

    private String url;

    private Date createDate;

}
