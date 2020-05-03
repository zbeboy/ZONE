package top.zbeboy.zone.test;

import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.joda.time.Years;
import org.junit.Test;
import top.zbeboy.zone.service.util.DateTimeUtil;

import java.util.Date;

import static top.zbeboy.zone.domain.Tables.ATTEND_RELEASE_SUB;

public class TestDate {

    @Test
    public void testDate(){
        DateTime now = DateTime.now();
        DateTime startTime = new DateTime(DateTimeUtil.defaultParseSqlDate("1994-06-19"));
        System.out.println(Years.yearsBetween(startTime ,now).getYears());

        System.out.println(DateTimeUtil.getNowYear());
        System.out.println(DateTimeUtil.getNowMonth());
        System.out.println(DateTimeUtil.getNowDay());
    }
}
