package com.wjy.ai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjy.ai.entity.po.School;
import com.wjy.ai.mapper.SchoolMapper;
import com.wjy.ai.service.ISchoolService;
import org.springframework.stereotype.Service;

/**
 * ClassName: SchoolServiceImpl
 * Package: com.wjy.ai.service.impl
 * Description:
 *
 * @Author JIAYI WU
 * @Create 2025/6/16 21:54
 * @Version 1.0
 */
@Service
public class SchoolServiceImpl extends ServiceImpl<SchoolMapper, School> implements ISchoolService {
}
