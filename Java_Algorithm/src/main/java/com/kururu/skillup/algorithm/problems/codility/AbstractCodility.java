package com.kururu.skillup.algorithm.problems.codility;

import com.kururu.skillup.algorithm.AlgorithmIF;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;

@Slf4j
public abstract class AbstractCodility implements AlgorithmIF {

    @Override
    public void input() {
        log.info("Input : " + getInputData());
    }

    @Override
    public void output() {
        StringBuilder sb = new StringBuilder();
        sb.append("Expected : ");
        sb.append(Validate.notBlank(getExpectedResult()));
        sb.append(", ");
        sb.append("Output : ");
        sb.append(Validate.notBlank(getOutputData()));
        sb.append(", ");
        sb.append("Algorithm Result -> [");
        if (getExpectedResult().equals(getOutputData())) {
            sb.append(RESULT.SUCCESS.toString());
        } else {
            sb.append(RESULT.FAILURE.toString());
        }
        sb.append("]");

        log.info(sb.toString());
    }

    abstract protected String getInputData();

    abstract protected String getOutputData();

    abstract protected String getExpectedResult();

}
