/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import top.zbeboy.zone.domain.Indexes;
import top.zbeboy.zone.domain.Keys;
import top.zbeboy.zone.domain.Zone;
import top.zbeboy.zone.domain.tables.records.FilesRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.12"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Files extends TableImpl<FilesRecord> {

    private static final long serialVersionUID = -1004545024;

    /**
     * The reference instance of <code>zone.files</code>
     */
    public static final Files FILES = new Files();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FilesRecord> getRecordType() {
        return FilesRecord.class;
    }

    /**
     * The column <code>zone.files.file_id</code>.
     */
    public final TableField<FilesRecord, String> FILE_ID = createField("file_id", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.files.file_size</code>.
     */
    public final TableField<FilesRecord, Long> FILE_SIZE = createField("file_size", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>zone.files.content_type</code>.
     */
    public final TableField<FilesRecord, String> CONTENT_TYPE = createField("content_type", org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>zone.files.original_file_name</code>.
     */
    public final TableField<FilesRecord, String> ORIGINAL_FILE_NAME = createField("original_file_name", org.jooq.impl.SQLDataType.VARCHAR(300), this, "");

    /**
     * The column <code>zone.files.new_name</code>.
     */
    public final TableField<FilesRecord, String> NEW_NAME = createField("new_name", org.jooq.impl.SQLDataType.VARCHAR(300), this, "");

    /**
     * The column <code>zone.files.relative_path</code>.
     */
    public final TableField<FilesRecord, String> RELATIVE_PATH = createField("relative_path", org.jooq.impl.SQLDataType.VARCHAR(800), this, "");

    /**
     * The column <code>zone.files.ext</code>.
     */
    public final TableField<FilesRecord, String> EXT = createField("ext", org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * Create a <code>zone.files</code> table reference
     */
    public Files() {
        this(DSL.name("files"), null);
    }

    /**
     * Create an aliased <code>zone.files</code> table reference
     */
    public Files(String alias) {
        this(DSL.name(alias), FILES);
    }

    /**
     * Create an aliased <code>zone.files</code> table reference
     */
    public Files(Name alias) {
        this(alias, FILES);
    }

    private Files(Name alias, Table<FilesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Files(Name alias, Table<FilesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Files(Table<O> child, ForeignKey<O, FilesRecord> key) {
        super(child, key, FILES);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Zone.ZONE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.FILES_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<FilesRecord> getPrimaryKey() {
        return Keys.KEY_FILES_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<FilesRecord>> getKeys() {
        return Arrays.<UniqueKey<FilesRecord>>asList(Keys.KEY_FILES_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Files as(String alias) {
        return new Files(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Files as(Name alias) {
        return new Files(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Files rename(String name) {
        return new Files(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Files rename(Name name) {
        return new Files(name, null);
    }
}
