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
public class SystemConfigure implements Serializable {

    private static final long serialVersionUID = 1138287419;

    private String dataKey;
    private String dataValue;

    public SystemConfigure() {}

    public SystemConfigure(SystemConfigure value) {
        this.dataKey = value.dataKey;
        this.dataValue = value.dataValue;
    }

    public SystemConfigure(
        String dataKey,
        String dataValue
    ) {
        this.dataKey = dataKey;
        this.dataValue = dataValue;
    }

    @NotNull
    @Size(max = 50)
    public String getDataKey() {
        return this.dataKey;
    }

    public void setDataKey(String dataKey) {
        this.dataKey = dataKey;
    }

    @Size(max = 100)
    public String getDataValue() {
        return this.dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SystemConfigure (");

        sb.append(dataKey);
        sb.append(", ").append(dataValue);

        sb.append(")");
        return sb.toString();
    }
}
