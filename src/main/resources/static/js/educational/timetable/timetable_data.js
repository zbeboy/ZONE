//# sourceURL=timetable_data.js
require(["jquery", "lodash", "tools", "handlebars", "nav.active", "sweetalert2", "select2-zh-CN", "jquery-labelauty"],
    function ($, _, tools, Handlebars, navActive, Swal) {
        /*
         ajax url.
        */
        var ajax_url = {
            data: web_path + '/web/educational/timetable/search',
            course_name: web_path + '/web/educational/timetable/course-name',
            lesson_name: web_path + '/web/educational/timetable/lesson-name',
            room: web_path + '/web/educational/timetable/room',
            teacher_name: web_path + '/web/educational/timetable/teacher-name',
            school_year: web_path + '/web/educational/timetable/school-year',
            timetable_import: web_path + '/web/educational/timetable/import',
            generate_ics:web_path + '/web/educational/timetable/generate-ics',
            page: '/web/menu/educational/timetable'
        };

        navActive(ajax_url.page);

        /*
        参数
        */
        var param = {
            courseName: '',
            lessonName: '',
            room: '',
            teacherName: '',
            schoolYear: ''
        };

        /*
        web storage key.
        */
        var webStorageKey = {
            COURSE_NAME: 'EDUCATIONAL_TIMETABLE_COURSE_NAME_SEARCH',
            LESSON_NAME: 'EDUCATIONAL_TIMETABLE_LESSON_NAME_SEARCH',
            ROOM: 'EDUCATIONAL_TIMETABLE_ROOM_SEARCH',
            TEACHER_NAME: 'EDUCATIONAL_TIMETABLE_TEACHER_NAME_SEARCH',
            SCHOOL_YEAR: 'EDUCATIONAL_TIMETABLE_SCHOOL_YEAR_SEARCH'
        };

        /*
         参数id
         */
        var param_id = {
            courseName: '#search_course_name',
            lessonName: '#search_lesson_name',
            room: '#search_room',
            teacherName: '#search_teacher_name',
            schoolYear: '#search_school_year'
        };

        var courseNameSelect2;
        var lessonNameSelect2;
        var roomSelect2;
        var teacherNameSelect2;
        var schoolYearSelect2;

        /*
        清空参数
        */
        function cleanParam() {
            courseNameSelect2.val('').trigger("change");
            lessonNameSelect2.val('').trigger("change");
            roomSelect2.val('').trigger("change");
            teacherNameSelect2.val('').trigger("change");
            schoolYearSelect2.val('').trigger("change");
        }

        function initParam() {
            param.courseName = $(param_id.courseName).val();
            param.lessonName = $(param_id.lessonName).val();
            param.room = $(param_id.room).val();
            param.teacherName = $(param_id.teacherName).val();
            param.schoolYear = $(param_id.schoolYear).val();
        }

        var init_configure = {
            init_course_name: false,
            init_lesson_name: false,
            init_room: false,
            init_teacher_name: false,
            init_school_year: false
        };

        /**
         * 刷新查询参数
         */
        function refreshSearch() {
            initParam();
            if (localStorage) {
                localStorage.setItem(webStorageKey.COURSE_NAME, param.courseName != null ? param.courseName : '');
                localStorage.setItem(webStorageKey.LESSON_NAME, param.lessonName != null ? param.lessonName : '');
                localStorage.setItem(webStorageKey.ROOM, param.room != null ? param.room : '');
                localStorage.setItem(webStorageKey.TEACHER_NAME, param.teacherName != null ? param.teacherName : '');
                localStorage.setItem(webStorageKey.SCHOOL_YEAR, param.schoolYear != null ? param.schoolYear : '');
            }
        }

        /*
        搜索
        */
        $('#search').click(function () {
            refreshSearch();
            initData();
        });

        /*
         重置
         */
        $('#reset_search').click(function () {
            cleanParam();
            refreshSearch();
            initData();
        });

        $('#refresh').click(function () {
            initData();
        });

        $(param_id.courseName).on('select2:select', function (e) {
            refreshSearch();
            initData();
        });

        $(param_id.lessonName).on('select2:select', function (e) {
            refreshSearch();
            initData();
        });

        $(param_id.room).on('select2:select', function (e) {
            refreshSearch();
            initData();
        });

        $(param_id.teacherName).on('select2:select', function (e) {
            refreshSearch();
            initData();
        });

        $(param_id.schoolYear).on('select2:select', function (e) {
            refreshSearch();
            initData();
        });

        init();

        /**
         * 初始化数据
         */
        function init() {
            initSearchInput();
            initSearchContent();
            initSchoolYear();
            initSelect2();
        }

        function initData() {
            tools.dataLoading();
            $.get(ajax_url.data, param, function (data) {
                tools.dataEndLoading();
                generateData(data);
            });
        }

        function initCourseName() {
            $.get(ajax_url.course_name, function (data) {
                $(param_id.courseName).html('<option label="请选择课程"></option>');
                courseNameSelect2 = $(param_id.courseName).select2({data: data.results});

                if (!init_configure.init_course_name) {
                    if (localStorage) {
                        var courseName = localStorage.getItem(webStorageKey.COURSE_NAME);
                        courseNameSelect2.val(courseName).trigger("change");
                    }
                    init_configure.init_course_name = true;
                }
            });
        }

        function initLessonName() {
            $.get(ajax_url.lesson_name, function (data) {
                $(param_id.lessonName).html('<option label="请选择班级"></option>');
                lessonNameSelect2 = $(param_id.lessonName).select2({data: data.results});

                if (!init_configure.init_lesson_name) {
                    if (localStorage) {
                        var lessonName = localStorage.getItem(webStorageKey.LESSON_NAME);
                        lessonNameSelect2.val(lessonName).trigger("change");
                    }
                    init_configure.init_lesson_name = true;
                }
            });
        }

        function initRoom() {
            $.get(ajax_url.room, function (data) {
                $(param_id.room).html('<option label="请选择教室"></option>');
                roomSelect2 = $(param_id.room).select2({data: data.results});

                if (!init_configure.init_room) {
                    if (localStorage) {
                        var room = localStorage.getItem(webStorageKey.ROOM);
                        roomSelect2.val(room).trigger("change");
                    }
                    init_configure.init_room = true;
                }
            });
        }

        function initTeacherName() {
            $.get(ajax_url.teacher_name, function (data) {
                $(param_id.teacherName).html('<option label="请选择教师"></option>');
                teacherNameSelect2 = $(param_id.teacherName).select2({data: data.results});

                if (!init_configure.init_teacher_name) {
                    if (localStorage) {
                        var teacherName = localStorage.getItem(webStorageKey.TEACHER_NAME);
                        teacherNameSelect2.val(teacherName).trigger("change");
                    }
                    init_configure.init_teacher_name = true;
                }
            });
        }

        function initSchoolYear() {
            $.get(ajax_url.school_year, function (data) {
                schoolYearSelect2 = $(param_id.schoolYear).select2({data: data.results});

                if (!init_configure.init_school_year) {
                    if (localStorage) {
                        var schoolYear = localStorage.getItem(webStorageKey.SCHOOL_YEAR);
                        if(schoolYear && Number(schoolYear) > 0){
                            schoolYearSelect2.val(schoolYear).trigger("change");
                        } else {
                            schoolYearSelect2.val(data.results[0].id).trigger("change");
                        }
                    }
                    init_configure.init_school_year = true;
                }
            });
        }

        function initSelect2() {
            $('.select2-show-search').select2({
                language: "zh-CN"
            });
        }

        /*
        初始化搜索内容
       */
        function initSearchContent() {
            initParam();

            var courseName = null;
            var lessonName = null;
            var room = null;
            var teacherName = null;
            var schoolYear = null;
            if (localStorage) {
                courseName = localStorage.getItem(webStorageKey.COURSE_NAME);
                lessonName = localStorage.getItem(webStorageKey.LESSON_NAME);
                room = localStorage.getItem(webStorageKey.ROOM);
                teacherName = localStorage.getItem(webStorageKey.TEACHER_NAME);
                schoolYear = localStorage.getItem(webStorageKey.SCHOOL_YEAR);
            }
            if (courseName !== null) {
                param.courseName = courseName;
            }

            if (lessonName !== null) {
                param.lessonName = lessonName;
            }

            if (room !== null) {
                param.room = room;
            }

            if (teacherName !== null) {
                param.teacherName = teacherName;
            }

            if (schoolYear !== null) {
                param.schoolYear = schoolYear;
            }

        }

        /*
        初始化搜索框
        */
        function initSearchInput() {
            var courseName = null;
            var lessonName = null;
            var room = null;
            var teacherName = null;
            var schoolYear = null;
            if (localStorage) {
                courseName = localStorage.getItem(webStorageKey.COURSE_NAME);
                lessonName = localStorage.getItem(webStorageKey.LESSON_NAME);
                room = localStorage.getItem(webStorageKey.ROOM);
                teacherName = localStorage.getItem(webStorageKey.TEACHER_NAME);
                schoolYear = localStorage.getItem(webStorageKey.SCHOOL_YEAR);
            }
            if (courseName !== null) {
                $(param_id.courseName).val(courseName);
            }

            if (lessonName !== null) {
                $(param_id.lessonName).val(lessonName);
            }

            if (room !== null) {
                $(param_id.room).val(room);
            }

            if (teacherName !== null) {
                $(param_id.teacherName).val(teacherName);
            }

            if (schoolYear !== null) {
                $(param_id.schoolYear).val(schoolYear);
            }

        }

        function cleanData() {
            // 清空之前的数据
            for (var i = 1; i <= 7; i++) {
                for (var j = 1; j <= 12; j++) {
                    $('#week_' + i + '_' + j).empty();
                }
            }
        }

        function generateData(data) {
            cleanData();
            $.each(data.listResult, function (i, v) {
                for (var j = 1; j <= 12; j++) {
                    week(j, v);
                }
            })
        }

        function week(j, v) {
            var isRight = j>=v.startUnit && j<=v.endUnit;
            if (isRight) {
                generateDataHtml('#week_' + v.weekday + '_' + j, v);
            }
        }

        function generateDataHtml(target, v) {
            var template = Handlebars.compile($("#timetable-template").html());
            Handlebars.registerHelper('weekUnit', function () {
                var weekUnit = '';
                var startWeek = this.startWeek;
                var endWeek = this.endWeek;
                if (!endWeek || endWeek === '') {
                    weekUnit = startWeek + '周';
                } else {
                    weekUnit = startWeek + '-' + endWeek + '周';
                }
                return new Handlebars.SafeString(Handlebars.escapeExpression(weekUnit));
            });
            Handlebars.registerHelper('sectionUnit', function () {
                var sectionUnit = '';
                var startUnit = this.startUnit;
                var endUnit = this.endUnit;
                if (!endUnit || endUnit === '') {
                    sectionUnit = startUnit + '节';
                } else {
                    sectionUnit = startUnit + '-' + endUnit + '周';
                }
                return new Handlebars.SafeString(Handlebars.escapeExpression(sectionUnit));
            });
            $(target).html(template(v));
        }

        $('#importCourse').click(function (){
            $.address.value(ajax_url.timetable_import);
        });
    });