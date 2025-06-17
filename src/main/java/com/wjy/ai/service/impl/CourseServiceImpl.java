package com.wjy.ai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjy.ai.entity.po.Course;
import com.wjy.ai.mapper.CourseMapper;
import com.wjy.ai.service.ICourseService;
import org.springframework.stereotype.Service;

/**
 * ClassName: CourseServiceImpl
 * Package: com.wjy.ai.service.impl
 * Description:
 *
 * @Author JIAYI WU
 * @Create 2025/6/16 21:53
 * @Version 1.0
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {
}
