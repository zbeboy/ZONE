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
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Nation implements Serializable {

    private static final long serialVersionUID = 979379907;

    private Integer nationId;
    private String  nationName;

    public Nation() {}

    public Nation(Nation value) {
        this.nationId = value.nationId;
        this.nationName = value.nationName;
    }

    public Nation(
        Integer nationId,
        String  nationName
    ) {
        this.nationId = nationId;
        this.nationName = nationName;
    }

    public Integer getNationId() {
        return this.nationId;
    }

    public void setNationId(Integer nationId) {
        this.nationId = nationId;
    }

    @NotNull
    @Size(max = 30)
    public String getNationName() {
        return this.nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Nation (");

        sb.append(nationId);
        sb.append(", ").append(nationName);

        sb.append(")");
        return sb.toString();
    }
}
