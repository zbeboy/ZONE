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
import top.zbeboy.zone.domain.tables.records.AnswerSubjectRecord;

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
public class AnswerSubject extends TableImpl<AnswerSubjectRecord> {

    private static final long serialVersionUID = 269584328;

    /**
     * The reference instance of <code>zone.answer_subject</code>
     */
    public static final AnswerSubject ANSWER_SUBJECT = new AnswerSubject();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AnswerSubjectRecord> getRecordType() {
        return AnswerSubjectRecord.class;
    }

    /**
     * The column <code>zone.answer_subject.answer_subject_id</code>.
     */
    public final TableField<AnswerSubjectRecord, String> ANSWER_SUBJECT_ID = createField(DSL.name("answer_subject_id"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.answer_subject.content</code>.
     */
    public final TableField<AnswerSubjectRecord, String> CONTENT = createField(DSL.name("content"), org.jooq.impl.SQLDataType.VARCHAR(300).nullable(false), this, "");

    /**
     * The column <code>zone.answer_subject.subject_type</code>.
     */
    public final TableField<AnswerSubjectRecord, Byte> SUBJECT_TYPE = createField(DSL.name("subject_type"), org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column <code>zone.answer_subject.right_key</code>.
     */
    public final TableField<AnswerSubjectRecord, String> RIGHT_KEY = createField(DSL.name("right_key"), org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * The column <code>zone.answer_subject.answer_bank_id</code>.
     */
    public final TableField<AnswerSubjectRecord, String> ANSWER_BANK_ID = createField(DSL.name("answer_bank_id"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.answer_subject.username</code>.
     */
    public final TableField<AnswerSubjectRecord, String> USERNAME = createField(DSL.name("username"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.answer_subject.create_date</code>.
     */
    public final TableField<AnswerSubjectRecord, Timestamp> CREATE_DATE = createField(DSL.name("create_date"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>zone.answer_subject.score</code>.
     */
    public final TableField<AnswerSubjectRecord, Double> SCORE = createField(DSL.name("score"), org.jooq.impl.SQLDataType.DOUBLE.nullable(false), this, "");

    /**
     * The column <code>zone.answer_subject.custom_id</code>.
     */
    public final TableField<AnswerSubjectRecord, Integer> CUSTOM_ID = createField(DSL.name("custom_id"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>zone.answer_subject</code> table reference
     */
    public AnswerSubject() {
        this(DSL.name("answer_subject"), null);
    }

    /**
     * Create an aliased <code>zone.answer_subject</code> table reference
     */
    public AnswerSubject(String alias) {
        this(DSL.name(alias), ANSWER_SUBJECT);
    }

    /**
     * Create an aliased <code>zone.answer_subject</code> table reference
     */
    public AnswerSubject(Name alias) {
        this(alias, ANSWER_SUBJECT);
    }

    private AnswerSubject(Name alias, Table<AnswerSubjectRecord> aliased) {
        this(alias, aliased, null);
    }

    private AnswerSubject(Name alias, Table<AnswerSubjectRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> AnswerSubject(Table<O> child, ForeignKey<O, AnswerSubjectRecord> key) {
        super(child, key, ANSWER_SUBJECT);
    }

    @Override
    public Schema getSchema() {
        return Zone.ZONE;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.ANSWER_SUBJECT_ANSWER_BANK_ID, Indexes.ANSWER_SUBJECT_PRIMARY, Indexes.ANSWER_SUBJECT_USERNAME);
    }

    @Override
    public UniqueKey<AnswerSubjectRecord> getPrimaryKey() {
        return Keys.KEY_ANSWER_SUBJECT_PRIMARY;
    }

    @Override
    public List<UniqueKey<AnswerSubjectRecord>> getKeys() {
        return Arrays.<UniqueKey<AnswerSubjectRecord>>asList(Keys.KEY_ANSWER_SUBJECT_PRIMARY);
    }

    @Override
    public List<ForeignKey<AnswerSubjectRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<AnswerSubjectRecord, ?>>asList(Keys.ANSWER_SUBJECT_IBFK_1, Keys.ANSWER_SUBJECT_IBFK_2);
    }

    public AnswerBank answerBank() {
        return new AnswerBank(this, Keys.ANSWER_SUBJECT_IBFK_1);
    }

    public Users users() {
        return new Users(this, Keys.ANSWER_SUBJECT_IBFK_2);
    }

    @Override
    public AnswerSubject as(String alias) {
        return new AnswerSubject(DSL.name(alias), this);
    }

    @Override
    public AnswerSubject as(Name alias) {
        return new AnswerSubject(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public AnswerSubject rename(String name) {
        return new AnswerSubject(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AnswerSubject rename(Name name) {
        return new AnswerSubject(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<String, String, Byte, String, String, String, Timestamp, Double, Integer> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}
