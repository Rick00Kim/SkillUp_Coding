package com.kururu.skillup.module.controller;

import com.google.common.collect.Lists;
import com.kururu.skillup.module.constant.SkillUpConstant;
import com.kururu.skillup.module.model.SkillUpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.IntStream;

@RestController
public class IndexController {

    @RequestMapping(value = SkillUpConstant.Url.ROOT)
    public String index() {
        return "HELLO! Welcome to INDEX";
    }

    @RequestMapping(value = SkillUpConstant.Url.ROOT + "/model")
    public List<SkillUpEntity> getModel() {
        List<SkillUpEntity> result = Lists.newArrayList();
        IntStream.range(0, 15).forEach(i -> result.add(SkillUpEntity.builder().id(new Long(i + 1)).quantity((i + 1) * 200).build()));
        return result;
    }

}
