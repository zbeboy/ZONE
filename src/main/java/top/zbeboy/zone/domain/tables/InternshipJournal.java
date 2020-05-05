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
import top.zbeboy.zone.domain.tables.records.InternshipJournalRecord;

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
public class InternshipJournal extends TableImpl<InternshipJournalRecord> {

    private static final long serialVersionUID = 1785842859;

    /**
     * The reference instance of <code>zone.internship_journal</code>
     */
    public static final InternshipJournal INTERNSHIP_JOURNAL = new InternshipJournal();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<InternshipJournalRecord> getRecordType() {
        return InternshipJournalRecord.class;
    }

    /**
     * The column <code>zone.internship_journal.internship_journal_id</code>.
     */
    public final TableField<InternshipJournalRecord, String> INTERNSHIP_JOURNAL_ID = createField(DSL.name("internship_journal_id"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.internship_journal.student_name</code>.
     */
    public final TableField<InternshipJournalRecord, String> STUDENT_NAME = createField(DSL.name("student_name"), org.jooq.impl.SQLDataType.VARCHAR(30).nullable(false), this, "");

    /**
     * The column <code>zone.internship_journal.student_number</code>.
     */
    public final TableField<InternshipJournalRecord, String> STUDENT_NUMBER = createField(DSL.name("student_number"), org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>zone.internship_journal.organize</code>.
     */
    public final TableField<InternshipJournalRecord, String> ORGANIZE = createField(DSL.name("organize"), org.jooq.impl.SQLDataType.VARCHAR(200).nullable(false), this, "");

    /**
     * The column <code>zone.internship_journal.school_guidance_teacher</code>.
     */
    public final TableField<InternshipJournalRecord, String> SCHOOL_GUIDANCE_TEACHER = createField(DSL.name("school_guidance_teacher"), org.jooq.impl.SQLDataType.VARCHAR(30).nullable(false), this, "");

    /**
     * The column <code>zone.internship_journal.graduation_practice_company_name</code>.
     */
    public final TableField<InternshipJournalRecord, String> GRADUATION_PRACTICE_COMPANY_NAME = createField(DSL.name("graduation_practice_company_name"), org.jooq.impl.SQLDataType.VARCHAR(200).nullable(false), this, "");

    /**
     * The column <code>zone.internship_journal.create_date</code>.
     */
    public final TableField<InternshipJournalRecord, Timestamp> CREATE_DATE = createField(DSL.name("create_date"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>zone.internship_journal.student_id</code>.
     */
    public final TableField<InternshipJournalRecord, Integer> STUDENT_ID = createField(DSL.name("student_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>zone.internship_journal.internship_release_id</code>.
     */
    public final TableField<InternshipJournalRecord, String> INTERNSHIP_RELEASE_ID = createField(DSL.name("internship_release_id"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.internship_journal.staff_id</code>.
     */
    public final TableField<InternshipJournalRecord, Integer> STAFF_ID = createField(DSL.name("staff_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>zone.internship_journal.internship_journal_word</code>.
     */
    public final TableField<InternshipJournalRecord, String> INTERNSHIP_JOURNAL_WORD = createField(DSL.name("internship_journal_word"), org.jooq.impl.SQLDataType.VARCHAR(500), this, "");

    /**
     * The column <code>zone.internship_journal.is_see_staff</code>.
     */
    public final TableField<InternshipJournalRecord, Byte> IS_SEE_STAFF = createField(DSL.name("is_see_staff"), org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "");

    /**
     * Create a <code>zone.internship_journal</code> table reference
     */
    public InternshipJournal() {
        this(DSL.name("internship_journal"), null);
    }

    /**
     * Create an aliased <code>zone.internship_journal</code> table reference
     */
    public InternshipJournal(String alias) {
        this(DSL.name(alias), INTERNSHIP_JOURNAL);
    }

    /**
     * Create an aliased <code>zone.internship_journal</code> table reference
     */
    public InternshipJournal(Name alias) {
        this(alias, INTERNSHIP_JOURNAL);
    }

    private InternshipJournal(Name alias, Table<InternshipJournalRecord> aliased) {
        this(alias, aliased, null);
    }

    private InternshipJournal(Name alias, Table<InternshipJournalRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> InternshipJournal(Table<O> child, ForeignKey<O, InternshipJournalRecord> key) {
        super(child, key, INTERNSHIP_JOURNAL);
    }

    @Override
    public Schema getSchema() {
        return Zone.ZONE;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.INTERNSHIP_JOURNAL_INTERNSHIP_RELEASE_ID, Indexes.INTERNSHIP_JOURNAL_PRIMARY, Indexes.INTERNSHIP_JOURNAL_STAFF_ID, Indexes.INTERNSHIP_JOURNAL_STUDENT_ID);
    }

    @Override
    public UniqueKey<InternshipJournalRecord> getPrimaryKey() {
        return Keys.KEY_INTERNSHIP_JOURNAL_PRIMARY;
    }

    @Override
    public List<UniqueKey<InternshipJournalRecord>> getKeys() {
        return Arrays.<UniqueKey<InternshipJournalRecord>>asList(Keys.KEY_INTERNSHIP_JOURNAL_PRIMARY);
    }

    @Override
    public List<ForeignKey<InternshipJournalRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<InternshipJournalRecord, ?>>asList(Keys.INTERNSHIP_JOURNAL_IBFK_1, Keys.INTERNSHIP_JOURNAL_IBFK_2, Keys.INTERNSHIP_JOURNAL_IBFK_3);
    }

    public Student student() {
        return new Student(this, Keys.INTERNSHIP_JOURNAL_IBFK_1);
    }

    public InternshipRelease internshipRelease() {
        return new InternshipRelease(this, Keys.INTERNSHIP_JOURNAL_IBFK_2);
    }

    public Staff staff() {
        return new Staff(this, Keys.INTERNSHIP_JOURNAL_IBFK_3);
    }

    @Override
    public InternshipJournal as(String alias) {
        return new InternshipJournal(DSL.name(alias), this);
    }

    @Override
    public InternshipJournal as(Name alias) {
        return new InternshipJournal(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public InternshipJournal rename(String name) {
        return new InternshipJournal(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public InternshipJournal rename(Name name) {
        return new InternshipJournal(name, null);
    }

    // -------------------------------------------------------------------------
    // Row12 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row12<String, String, String, String, String, String, Timestamp, Integer, String, Integer, String, Byte> fieldsRow() {
        return (Row12) super.fieldsRow();
    }
}
