package com.kururu.skillup.module.controller;

import com.google.common.collect.Lists;
import com.kururu.skillup.module.constant.SkillUpConstant;
import com.kururu.skillup.module.model.SkillUpEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.IntStream;

@RestController
@Slf4j
public class IndexController {

    @RequestMapping(value = SkillUpConstant.Url.ROOT)
    public String index() {
        log.info("This is hello");
        return "HELLO! Welcome to INDEX";
    }

    @RequestMapping(value = SkillUpConstant.Url.ROOT + "/model")
    public List<SkillUpEntity> getModel() {
        List<SkillUpEntity> result = Lists.newArrayList();
        IntStream.range(0, 15).forEach(i -> result.add(SkillUpEntity.builder().id((long) (i + 1)).quantity((i + 1) * 200).build()));
        return result;
    }

}
