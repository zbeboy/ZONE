/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row9;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import top.zbeboy.zone.domain.Indexes;
import top.zbeboy.zone.domain.Keys;
import top.zbeboy.zone.domain.Zone;
import top.zbeboy.zone.domain.tables.records.TrainingDocumentRecord;


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
public class TrainingDocument extends TableImpl<TrainingDocumentRecord> {

    private static final long serialVersionUID = 1238638048;

    /**
     * The reference instance of <code>zone.training_document</code>
     */
    public static final TrainingDocument TRAINING_DOCUMENT = new TrainingDocument();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TrainingDocumentRecord> getRecordType() {
        return TrainingDocumentRecord.class;
    }

    /**
     * The column <code>zone.training_document.training_document_id</code>.
     */
    public final TableField<TrainingDocumentRecord, String> TRAINING_DOCUMENT_ID = createField(DSL.name("training_document_id"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.training_document.training_release_id</code>.
     */
    public final TableField<TrainingDocumentRecord, String> TRAINING_RELEASE_ID = createField(DSL.name("training_release_id"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.training_document.username</code>.
     */
    public final TableField<TrainingDocumentRecord, String> USERNAME = createField(DSL.name("username"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.training_document.course_id</code>.
     */
    public final TableField<TrainingDocumentRecord, Integer> COURSE_ID = createField(DSL.name("course_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>zone.training_document.creator</code>.
     */
    public final TableField<TrainingDocumentRecord, String> CREATOR = createField(DSL.name("creator"), org.jooq.impl.SQLDataType.VARCHAR(30).nullable(false), this, "");

    /**
     * The column <code>zone.training_document.create_date</code>.
     */
    public final TableField<TrainingDocumentRecord, Timestamp> CREATE_DATE = createField(DSL.name("create_date"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>zone.training_document.reading</code>.
     */
    public final TableField<TrainingDocumentRecord, Integer> READING = createField(DSL.name("reading"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>zone.training_document.is_original</code>.
     */
    public final TableField<TrainingDocumentRecord, Byte> IS_ORIGINAL = createField(DSL.name("is_original"), org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("1", org.jooq.impl.SQLDataType.TINYINT)), this, "");

    /**
     * The column <code>zone.training_document.origin</code>.
     */
    public final TableField<TrainingDocumentRecord, String> ORIGIN = createField(DSL.name("origin"), org.jooq.impl.SQLDataType.VARCHAR(500), this, "");

    /**
     * Create a <code>zone.training_document</code> table reference
     */
    public TrainingDocument() {
        this(DSL.name("training_document"), null);
    }

    /**
     * Create an aliased <code>zone.training_document</code> table reference
     */
    public TrainingDocument(String alias) {
        this(DSL.name(alias), TRAINING_DOCUMENT);
    }

    /**
     * Create an aliased <code>zone.training_document</code> table reference
     */
    public TrainingDocument(Name alias) {
        this(alias, TRAINING_DOCUMENT);
    }

    private TrainingDocument(Name alias, Table<TrainingDocumentRecord> aliased) {
        this(alias, aliased, null);
    }

    private TrainingDocument(Name alias, Table<TrainingDocumentRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> TrainingDocument(Table<O> child, ForeignKey<O, TrainingDocumentRecord> key) {
        super(child, key, TRAINING_DOCUMENT);
    }

    @Override
    public Schema getSchema() {
        return Zone.ZONE;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.TRAINING_DOCUMENT_COURSE_ID, Indexes.TRAINING_DOCUMENT_PRIMARY, Indexes.TRAINING_DOCUMENT_TRAINING_RELEASE_ID, Indexes.TRAINING_DOCUMENT_USERNAME);
    }

    @Override
    public UniqueKey<TrainingDocumentRecord> getPrimaryKey() {
        return Keys.KEY_TRAINING_DOCUMENT_PRIMARY;
    }

    @Override
    public List<UniqueKey<TrainingDocumentRecord>> getKeys() {
        return Arrays.<UniqueKey<TrainingDocumentRecord>>asList(Keys.KEY_TRAINING_DOCUMENT_PRIMARY);
    }

    @Override
    public List<ForeignKey<TrainingDocumentRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<TrainingDocumentRecord, ?>>asList(Keys.TRAINING_DOCUMENT_IBFK_1, Keys.TRAINING_DOCUMENT_IBFK_2, Keys.TRAINING_DOCUMENT_IBFK_3);
    }

    public TrainingRelease trainingRelease() {
        return new TrainingRelease(this, Keys.TRAINING_DOCUMENT_IBFK_1);
    }

    public Users users() {
        return new Users(this, Keys.TRAINING_DOCUMENT_IBFK_2);
    }

    public Course course() {
        return new Course(this, Keys.TRAINING_DOCUMENT_IBFK_3);
    }

    @Override
    public TrainingDocument as(String alias) {
        return new TrainingDocument(DSL.name(alias), this);
    }

    @Override
    public TrainingDocument as(Name alias) {
        return new TrainingDocument(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TrainingDocument rename(String name) {
        return new TrainingDocument(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TrainingDocument rename(Name name) {
        return new TrainingDocument(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<String, String, String, Integer, String, Timestamp, Integer, Byte, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}
