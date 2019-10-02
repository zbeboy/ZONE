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
import top.zbeboy.zone.domain.tables.records.TrainingUsersRecord;


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
public class TrainingUsers extends TableImpl<TrainingUsersRecord> {

    private static final long serialVersionUID = -177524446;

    /**
     * The reference instance of <code>zone.training_users</code>
     */
    public static final TrainingUsers TRAINING_USERS = new TrainingUsers();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TrainingUsersRecord> getRecordType() {
        return TrainingUsersRecord.class;
    }

    /**
     * The column <code>zone.training_users.training_users_id</code>.
     */
    public final TableField<TrainingUsersRecord, String> TRAINING_USERS_ID = createField("training_users_id", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.training_users.training_release_id</code>.
     */
    public final TableField<TrainingUsersRecord, String> TRAINING_RELEASE_ID = createField("training_release_id", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.training_users.student_id</code>.
     */
    public final TableField<TrainingUsersRecord, Integer> STUDENT_ID = createField("student_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>zone.training_users</code> table reference
     */
    public TrainingUsers() {
        this(DSL.name("training_users"), null);
    }

    /**
     * Create an aliased <code>zone.training_users</code> table reference
     */
    public TrainingUsers(String alias) {
        this(DSL.name(alias), TRAINING_USERS);
    }

    /**
     * Create an aliased <code>zone.training_users</code> table reference
     */
    public TrainingUsers(Name alias) {
        this(alias, TRAINING_USERS);
    }

    private TrainingUsers(Name alias, Table<TrainingUsersRecord> aliased) {
        this(alias, aliased, null);
    }

    private TrainingUsers(Name alias, Table<TrainingUsersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> TrainingUsers(Table<O> child, ForeignKey<O, TrainingUsersRecord> key) {
        super(child, key, TRAINING_USERS);
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
        return Arrays.<Index>asList(Indexes.TRAINING_USERS_PRIMARY, Indexes.TRAINING_USERS_STUDENT_ID, Indexes.TRAINING_USERS_TRAINING_RELEASE_ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TrainingUsersRecord> getPrimaryKey() {
        return Keys.KEY_TRAINING_USERS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TrainingUsersRecord>> getKeys() {
        return Arrays.<UniqueKey<TrainingUsersRecord>>asList(Keys.KEY_TRAINING_USERS_PRIMARY, Keys.KEY_TRAINING_USERS_TRAINING_RELEASE_ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<TrainingUsersRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<TrainingUsersRecord, ?>>asList(Keys.TRAINING_USERS_IBFK_1, Keys.TRAINING_USERS_IBFK_2);
    }

    public TrainingRelease trainingRelease() {
        return new TrainingRelease(this, Keys.TRAINING_USERS_IBFK_1);
    }

    public Student student() {
        return new Student(this, Keys.TRAINING_USERS_IBFK_2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TrainingUsers as(String alias) {
        return new TrainingUsers(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TrainingUsers as(Name alias) {
        return new TrainingUsers(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TrainingUsers rename(String name) {
        return new TrainingUsers(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TrainingUsers rename(Name name) {
        return new TrainingUsers(name, null);
    }
}
