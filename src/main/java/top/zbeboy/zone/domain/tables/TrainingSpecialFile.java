/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables;


import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import top.zbeboy.zone.domain.Indexes;
import top.zbeboy.zone.domain.Keys;
import top.zbeboy.zone.domain.Zone;
import top.zbeboy.zone.domain.tables.records.TrainingSpecialFileRecord;

import javax.annotation.Generated;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.12.4"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class TrainingSpecialFile extends TableImpl<TrainingSpecialFileRecord> {

    private static final long serialVersionUID = 1695133376;

    /**
     * The reference instance of <code>zone.training_special_file</code>
     */
    public static final TrainingSpecialFile TRAINING_SPECIAL_FILE = new TrainingSpecialFile();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TrainingSpecialFileRecord> getRecordType() {
        return TrainingSpecialFileRecord.class;
    }

    /**
     * The column <code>zone.training_special_file.training_special_file_id</code>.
     */
    public final TableField<TrainingSpecialFileRecord, String> TRAINING_SPECIAL_FILE_ID = createField(DSL.name("training_special_file_id"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.training_special_file.file_type_id</code>.
     */
    public final TableField<TrainingSpecialFileRecord, String> FILE_TYPE_ID = createField(DSL.name("file_type_id"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.training_special_file.file_id</code>.
     */
    public final TableField<TrainingSpecialFileRecord, String> FILE_ID = createField(DSL.name("file_id"), org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    /**
     * The column <code>zone.training_special_file.username</code>.
     */
    public final TableField<TrainingSpecialFileRecord, String> USERNAME = createField(DSL.name("username"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.training_special_file.uploader</code>.
     */
    public final TableField<TrainingSpecialFileRecord, String> UPLOADER = createField(DSL.name("uploader"), org.jooq.impl.SQLDataType.VARCHAR(30).nullable(false), this, "");

    /**
     * The column <code>zone.training_special_file.create_date</code>.
     */
    public final TableField<TrainingSpecialFileRecord, Timestamp> CREATE_DATE = createField(DSL.name("create_date"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>zone.training_special_file.downloads</code>.
     */
    public final TableField<TrainingSpecialFileRecord, Integer> DOWNLOADS = createField(DSL.name("downloads"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>zone.training_special_file.mapping</code>.
     */
    public final TableField<TrainingSpecialFileRecord, Byte> MAPPING = createField(DSL.name("mapping"), org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "");

    /**
     * Create a <code>zone.training_special_file</code> table reference
     */
    public TrainingSpecialFile() {
        this(DSL.name("training_special_file"), null);
    }

    /**
     * Create an aliased <code>zone.training_special_file</code> table reference
     */
    public TrainingSpecialFile(String alias) {
        this(DSL.name(alias), TRAINING_SPECIAL_FILE);
    }

    /**
     * Create an aliased <code>zone.training_special_file</code> table reference
     */
    public TrainingSpecialFile(Name alias) {
        this(alias, TRAINING_SPECIAL_FILE);
    }

    private TrainingSpecialFile(Name alias, Table<TrainingSpecialFileRecord> aliased) {
        this(alias, aliased, null);
    }

    private TrainingSpecialFile(Name alias, Table<TrainingSpecialFileRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> TrainingSpecialFile(Table<O> child, ForeignKey<O, TrainingSpecialFileRecord> key) {
        super(child, key, TRAINING_SPECIAL_FILE);
    }

    @Override
    public Schema getSchema() {
        return Zone.ZONE;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.TRAINING_SPECIAL_FILE_FILE_TYPE_ID, Indexes.TRAINING_SPECIAL_FILE_PRIMARY);
    }

    @Override
    public UniqueKey<TrainingSpecialFileRecord> getPrimaryKey() {
        return Keys.KEY_TRAINING_SPECIAL_FILE_PRIMARY;
    }

    @Override
    public List<UniqueKey<TrainingSpecialFileRecord>> getKeys() {
        return Arrays.<UniqueKey<TrainingSpecialFileRecord>>asList(Keys.KEY_TRAINING_SPECIAL_FILE_PRIMARY);
    }

    @Override
    public List<ForeignKey<TrainingSpecialFileRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<TrainingSpecialFileRecord, ?>>asList(Keys.TRAINING_SPECIAL_FILE_IBFK_1);
    }

    public TrainingSpecialFileType trainingSpecialFileType() {
        return new TrainingSpecialFileType(this, Keys.TRAINING_SPECIAL_FILE_IBFK_1);
    }

    @Override
    public TrainingSpecialFile as(String alias) {
        return new TrainingSpecialFile(DSL.name(alias), this);
    }

    @Override
    public TrainingSpecialFile as(Name alias) {
        return new TrainingSpecialFile(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TrainingSpecialFile rename(String name) {
        return new TrainingSpecialFile(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TrainingSpecialFile rename(Name name) {
        return new TrainingSpecialFile(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<String, String, String, String, String, Timestamp, Integer, Byte> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}
