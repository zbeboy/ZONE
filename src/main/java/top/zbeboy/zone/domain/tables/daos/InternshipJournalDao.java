/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.daos;


import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.zbeboy.zone.domain.tables.InternshipJournal;
import top.zbeboy.zone.domain.tables.records.InternshipJournalRecord;

import javax.annotation.Generated;
import java.sql.Timestamp;
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
@Repository
public class InternshipJournalDao extends DAOImpl<InternshipJournalRecord, top.zbeboy.zone.domain.tables.pojos.InternshipJournal, String> {

    /**
     * Create a new InternshipJournalDao without any configuration
     */
    public InternshipJournalDao() {
        super(InternshipJournal.INTERNSHIP_JOURNAL, top.zbeboy.zone.domain.tables.pojos.InternshipJournal.class);
    }

    /**
     * Create a new InternshipJournalDao with an attached configuration
     */
    @Autowired
    public InternshipJournalDao(Configuration configuration) {
        super(InternshipJournal.INTERNSHIP_JOURNAL, top.zbeboy.zone.domain.tables.pojos.InternshipJournal.class, configuration);
    }

    @Override
    public String getId(top.zbeboy.zone.domain.tables.pojos.InternshipJournal object) {
        return object.getInternshipJournalId();
    }

    /**
     * Fetch records that have <code>internship_journal_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchRangeOfInternshipJournalId(String lowerInclusive, String upperInclusive) {
        return fetchRange(InternshipJournal.INTERNSHIP_JOURNAL.INTERNSHIP_JOURNAL_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>internship_journal_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchByInternshipJournalId(String... values) {
        return fetch(InternshipJournal.INTERNSHIP_JOURNAL.INTERNSHIP_JOURNAL_ID, values);
    }

    /**
     * Fetch a unique record that has <code>internship_journal_id = value</code>
     */
    public top.zbeboy.zone.domain.tables.pojos.InternshipJournal fetchOneByInternshipJournalId(String value) {
        return fetchOne(InternshipJournal.INTERNSHIP_JOURNAL.INTERNSHIP_JOURNAL_ID, value);
    }

    /**
     * Fetch records that have <code>student_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchRangeOfStudentName(String lowerInclusive, String upperInclusive) {
        return fetchRange(InternshipJournal.INTERNSHIP_JOURNAL.STUDENT_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>student_name IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchByStudentName(String... values) {
        return fetch(InternshipJournal.INTERNSHIP_JOURNAL.STUDENT_NAME, values);
    }

    /**
     * Fetch records that have <code>student_number BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchRangeOfStudentNumber(String lowerInclusive, String upperInclusive) {
        return fetchRange(InternshipJournal.INTERNSHIP_JOURNAL.STUDENT_NUMBER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>student_number IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchByStudentNumber(String... values) {
        return fetch(InternshipJournal.INTERNSHIP_JOURNAL.STUDENT_NUMBER, values);
    }

    /**
     * Fetch records that have <code>organize BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchRangeOfOrganize(String lowerInclusive, String upperInclusive) {
        return fetchRange(InternshipJournal.INTERNSHIP_JOURNAL.ORGANIZE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>organize IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchByOrganize(String... values) {
        return fetch(InternshipJournal.INTERNSHIP_JOURNAL.ORGANIZE, values);
    }

    /**
     * Fetch records that have <code>school_guidance_teacher BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchRangeOfSchoolGuidanceTeacher(String lowerInclusive, String upperInclusive) {
        return fetchRange(InternshipJournal.INTERNSHIP_JOURNAL.SCHOOL_GUIDANCE_TEACHER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>school_guidance_teacher IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchBySchoolGuidanceTeacher(String... values) {
        return fetch(InternshipJournal.INTERNSHIP_JOURNAL.SCHOOL_GUIDANCE_TEACHER, values);
    }

    /**
     * Fetch records that have <code>graduation_practice_company_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchRangeOfGraduationPracticeCompanyName(String lowerInclusive, String upperInclusive) {
        return fetchRange(InternshipJournal.INTERNSHIP_JOURNAL.GRADUATION_PRACTICE_COMPANY_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>graduation_practice_company_name IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchByGraduationPracticeCompanyName(String... values) {
        return fetch(InternshipJournal.INTERNSHIP_JOURNAL.GRADUATION_PRACTICE_COMPANY_NAME, values);
    }

    /**
     * Fetch records that have <code>create_date BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchRangeOfCreateDate(Timestamp lowerInclusive, Timestamp upperInclusive) {
        return fetchRange(InternshipJournal.INTERNSHIP_JOURNAL.CREATE_DATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>create_date IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchByCreateDate(Timestamp... values) {
        return fetch(InternshipJournal.INTERNSHIP_JOURNAL.CREATE_DATE, values);
    }

    /**
     * Fetch records that have <code>student_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchRangeOfStudentId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(InternshipJournal.INTERNSHIP_JOURNAL.STUDENT_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>student_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchByStudentId(Integer... values) {
        return fetch(InternshipJournal.INTERNSHIP_JOURNAL.STUDENT_ID, values);
    }

    /**
     * Fetch records that have <code>internship_release_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchRangeOfInternshipReleaseId(String lowerInclusive, String upperInclusive) {
        return fetchRange(InternshipJournal.INTERNSHIP_JOURNAL.INTERNSHIP_RELEASE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>internship_release_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchByInternshipReleaseId(String... values) {
        return fetch(InternshipJournal.INTERNSHIP_JOURNAL.INTERNSHIP_RELEASE_ID, values);
    }

    /**
     * Fetch records that have <code>staff_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchRangeOfStaffId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(InternshipJournal.INTERNSHIP_JOURNAL.STAFF_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>staff_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchByStaffId(Integer... values) {
        return fetch(InternshipJournal.INTERNSHIP_JOURNAL.STAFF_ID, values);
    }

    /**
     * Fetch records that have <code>internship_journal_word BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchRangeOfInternshipJournalWord(String lowerInclusive, String upperInclusive) {
        return fetchRange(InternshipJournal.INTERNSHIP_JOURNAL.INTERNSHIP_JOURNAL_WORD, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>internship_journal_word IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchByInternshipJournalWord(String... values) {
        return fetch(InternshipJournal.INTERNSHIP_JOURNAL.INTERNSHIP_JOURNAL_WORD, values);
    }

    /**
     * Fetch records that have <code>is_see_staff BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchRangeOfIsSeeStaff(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(InternshipJournal.INTERNSHIP_JOURNAL.IS_SEE_STAFF, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>is_see_staff IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.InternshipJournal> fetchByIsSeeStaff(Byte... values) {
        return fetch(InternshipJournal.INTERNSHIP_JOURNAL.IS_SEE_STAFF, values);
    }
}
