package com.wjy.ai.tools;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.wjy.ai.entity.po.Course;
import com.wjy.ai.entity.po.CourseReservation;
import com.wjy.ai.entity.po.School;
import com.wjy.ai.entity.query.CourseQuery;
import com.wjy.ai.service.ICourseReservationService;
import com.wjy.ai.service.ICourseService;
import com.wjy.ai.service.ISchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName: CourseTools
 * Package: com.wjy.ai.tools
 * Description:
 *
 * @Author JIAYI WU
 * @Create 2025/6/16 21:59
 * @Version 1.0
 */
@Component
@RequiredArgsConstructor
public class CourseTools {

    private final ICourseService courseService;

    private final ISchoolService schoolService;

    private final ICourseReservationService courseReservationService;

    @Tool(description = "根据条件查询课程")
    public List<Course> queryCourse(@ToolParam(required = false, description = "课程查询条件") CourseQuery query){
        if (query == null){
            return courseService.list();
        }
        QueryChainWrapper<Course> wrapper = courseService.query()
                .eq(query.getType() != null, "type", query.getType()) // 课程类型
                .le(query.getEdu() != null, "edu", query.getEdu()); // 学历要求
        if (query.getSorts() != null && !query.getSorts().isEmpty()){
            for (CourseQuery.Sort sort : query.getSorts()) {
                wrapper.orderBy(true, sort.getAsc(), sort.getField());
            }
        }
        return wrapper.list();
    }

    @Tool(description = "查询所有校区")
    public List<School> querySchool(){
        // TODO 给校区表加上课程，可以查询每个校区有哪些课程
        return schoolService.list();
    }

    @Tool(description = "生成预约单，返回预约单号")
    public Integer createCourseReservation(@ToolParam(description = "预约课程") String course,
                                           @ToolParam(description = "预约校区") String school,
                                           @ToolParam(description = "学生姓名") String studentName,
                                           @ToolParam(description = "联系电话") String contactInfo,
                                           @ToolParam(description = "备注", required = false) String remark){
        CourseReservation reservation = new CourseReservation();
        reservation.setCourse(course);
        reservation.setSchool(school);
        reservation.setStudentName(studentName);
        reservation.setContactInfo(contactInfo);
        reservation.setRemark(remark);
        courseReservationService.save(reservation);

        return reservation.getId();
    }
}
