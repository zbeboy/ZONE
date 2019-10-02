/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables;


import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
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
import top.zbeboy.zone.domain.tables.records.StudentRecord;


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
public class Student extends TableImpl<StudentRecord> {

    private static final long serialVersionUID = 1246173911;

    /**
     * The reference instance of <code>zone.student</code>
     */
    public static final Student STUDENT = new Student();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StudentRecord> getRecordType() {
        return StudentRecord.class;
    }

    /**
     * The column <code>zone.student.student_id</code>.
     */
    public final TableField<StudentRecord, Integer> STUDENT_ID = createField("student_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>zone.student.student_number</code>.
     */
    public final TableField<StudentRecord, String> STUDENT_NUMBER = createField("student_number", org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>zone.student.birthday</code>.
     */
    public final TableField<StudentRecord, Date> BIRTHDAY = createField("birthday", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * The column <code>zone.student.sex</code>.
     */
    public final TableField<StudentRecord, String> SEX = createField("sex", org.jooq.impl.SQLDataType.VARCHAR(2), this, "");

    /**
     * The column <code>zone.student.family_residence</code>.
     */
    public final TableField<StudentRecord, String> FAMILY_RESIDENCE = createField("family_residence", org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    /**
     * The column <code>zone.student.political_landscape_id</code>.
     */
    public final TableField<StudentRecord, Integer> POLITICAL_LANDSCAPE_ID = createField("political_landscape_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>zone.student.nation_id</code>.
     */
    public final TableField<StudentRecord, Integer> NATION_ID = createField("nation_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>zone.student.dormitory_number</code>.
     */
    public final TableField<StudentRecord, String> DORMITORY_NUMBER = createField("dormitory_number", org.jooq.impl.SQLDataType.VARCHAR(15), this, "");

    /**
     * The column <code>zone.student.parent_name</code>.
     */
    public final TableField<StudentRecord, String> PARENT_NAME = createField("parent_name", org.jooq.impl.SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>zone.student.parent_contact_phone</code>.
     */
    public final TableField<StudentRecord, String> PARENT_CONTACT_PHONE = createField("parent_contact_phone", org.jooq.impl.SQLDataType.VARCHAR(15), this, "");

    /**
     * The column <code>zone.student.place_origin</code>.
     */
    public final TableField<StudentRecord, String> PLACE_ORIGIN = createField("place_origin", org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    /**
     * The column <code>zone.student.organize_id</code>.
     */
    public final TableField<StudentRecord, Integer> ORGANIZE_ID = createField("organize_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>zone.student.username</code>.
     */
    public final TableField<StudentRecord, String> USERNAME = createField("username", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * Create a <code>zone.student</code> table reference
     */
    public Student() {
        this(DSL.name("student"), null);
    }

    /**
     * Create an aliased <code>zone.student</code> table reference
     */
    public Student(String alias) {
        this(DSL.name(alias), STUDENT);
    }

    /**
     * Create an aliased <code>zone.student</code> table reference
     */
    public Student(Name alias) {
        this(alias, STUDENT);
    }

    private Student(Name alias, Table<StudentRecord> aliased) {
        this(alias, aliased, null);
    }

    private Student(Name alias, Table<StudentRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Student(Table<O> child, ForeignKey<O, StudentRecord> key) {
        super(child, key, STUDENT);
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
        return Arrays.<Index>asList(Indexes.STUDENT_ORGANIZE_ID, Indexes.STUDENT_PRIMARY, Indexes.STUDENT_STUDENT_NUMBER, Indexes.STUDENT_USERNAME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<StudentRecord, Integer> getIdentity() {
        return Keys.IDENTITY_STUDENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<StudentRecord> getPrimaryKey() {
        return Keys.KEY_STUDENT_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<StudentRecord>> getKeys() {
        return Arrays.<UniqueKey<StudentRecord>>asList(Keys.KEY_STUDENT_PRIMARY, Keys.KEY_STUDENT_STUDENT_NUMBER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<StudentRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<StudentRecord, ?>>asList(Keys.STUDENT_IBFK_1, Keys.STUDENT_IBFK_2);
    }

    public Organize organize() {
        return new Organize(this, Keys.STUDENT_IBFK_1);
    }

    public Users users() {
        return new Users(this, Keys.STUDENT_IBFK_2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Student as(String alias) {
        return new Student(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Student as(Name alias) {
        return new Student(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Student rename(String name) {
        return new Student(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Student rename(Name name) {
        return new Student(name, null);
    }
}
