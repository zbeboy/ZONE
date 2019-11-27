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
import top.zbeboy.zone.domain.tables.records.CourseRecord;


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
public class Course extends TableImpl<CourseRecord> {

    private static final long serialVersionUID = 649543191;

    /**
     * The reference instance of <code>zone.course</code>
     */
    public static final Course COURSE = new Course();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CourseRecord> getRecordType() {
        return CourseRecord.class;
    }

    /**
     * The column <code>zone.course.course_id</code>.
     */
    public final TableField<CourseRecord, Integer> COURSE_ID = createField(DSL.name("course_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>zone.course.course_name</code>.
     */
    public final TableField<CourseRecord, String> COURSE_NAME = createField(DSL.name("course_name"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>zone.course.course_credit</code>.
     */
    public final TableField<CourseRecord, Double> COURSE_CREDIT = createField(DSL.name("course_credit"), org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>zone.course.course_brief</code>.
     */
    public final TableField<CourseRecord, String> COURSE_BRIEF = createField(DSL.name("course_brief"), org.jooq.impl.SQLDataType.VARCHAR(500), this, "");

    /**
     * The column <code>zone.course.course_is_del</code>.
     */
    public final TableField<CourseRecord, Byte> COURSE_IS_DEL = createField(DSL.name("course_is_del"), org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>zone.course.course_code</code>.
     */
    public final TableField<CourseRecord, String> COURSE_CODE = createField(DSL.name("course_code"), org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>zone.course.school_year</code>.
     */
    public final TableField<CourseRecord, Byte> SCHOOL_YEAR = createField(DSL.name("school_year"), org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column <code>zone.course.term</code>.
     */
    public final TableField<CourseRecord, Byte> TERM = createField(DSL.name("term"), org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column <code>zone.course.college_id</code>.
     */
    public final TableField<CourseRecord, Integer> COLLEGE_ID = createField(DSL.name("college_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>zone.course</code> table reference
     */
    public Course() {
        this(DSL.name("course"), null);
    }

    /**
     * Create an aliased <code>zone.course</code> table reference
     */
    public Course(String alias) {
        this(DSL.name(alias), COURSE);
    }

    /**
     * Create an aliased <code>zone.course</code> table reference
     */
    public Course(Name alias) {
        this(alias, COURSE);
    }

    private Course(Name alias, Table<CourseRecord> aliased) {
        this(alias, aliased, null);
    }

    private Course(Name alias, Table<CourseRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Course(Table<O> child, ForeignKey<O, CourseRecord> key) {
        super(child, key, COURSE);
    }

    @Override
    public Schema getSchema() {
        return Zone.ZONE;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.COURSE_COLLEGE_ID, Indexes.COURSE_COURSE_CODE, Indexes.COURSE_PRIMARY);
    }

    @Override
    public UniqueKey<CourseRecord> getPrimaryKey() {
        return Keys.KEY_COURSE_PRIMARY;
    }

    @Override
    public List<UniqueKey<CourseRecord>> getKeys() {
        return Arrays.<UniqueKey<CourseRecord>>asList(Keys.KEY_COURSE_PRIMARY, Keys.KEY_COURSE_COURSE_CODE);
    }

    @Override
    public List<ForeignKey<CourseRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<CourseRecord, ?>>asList(Keys.COURSE_IBFK_1);
    }

    public College college() {
        return new College(this, Keys.COURSE_IBFK_1);
    }

    @Override
    public Course as(String alias) {
        return new Course(DSL.name(alias), this);
    }

    @Override
    public Course as(Name alias) {
        return new Course(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Course rename(String name) {
        return new Course(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Course rename(Name name) {
        return new Course(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<Integer, String, Double, String, Byte, String, Byte, Byte, Integer> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}