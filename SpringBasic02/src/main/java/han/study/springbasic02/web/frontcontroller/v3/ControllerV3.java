package han.study.springbasic02.web.frontcontroller.v3;

import han.study.springbasic02.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
}
