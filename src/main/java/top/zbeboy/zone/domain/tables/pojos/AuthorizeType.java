/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AuthorizeType implements Serializable {

    private static final long serialVersionUID = -1631483855;

    private Integer authorizeTypeId;
    private String  authorizeTypeName;

    public AuthorizeType() {}

    public AuthorizeType(AuthorizeType value) {
        this.authorizeTypeId = value.authorizeTypeId;
        this.authorizeTypeName = value.authorizeTypeName;
    }

    public AuthorizeType(
        Integer authorizeTypeId,
        String  authorizeTypeName
    ) {
        this.authorizeTypeId = authorizeTypeId;
        this.authorizeTypeName = authorizeTypeName;
    }

    public Integer getAuthorizeTypeId() {
        return this.authorizeTypeId;
    }

    public void setAuthorizeTypeId(Integer authorizeTypeId) {
        this.authorizeTypeId = authorizeTypeId;
    }

    @NotNull
    @Size(max = 100)
    public String getAuthorizeTypeName() {
        return this.authorizeTypeName;
    }

    public void setAuthorizeTypeName(String authorizeTypeName) {
        this.authorizeTypeName = authorizeTypeName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AuthorizeType (");

        sb.append(authorizeTypeId);
        sb.append(", ").append(authorizeTypeName);

        sb.append(")");
        return sb.toString();
    }
}
