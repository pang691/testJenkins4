package xxx.xxx.testController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JenkinsController {
    @RequestMapping("/jenkins")
    public String jenkins(){
        System.out.println("测试完成--jenkins自动部署完成");
        return "测试完成--jenkins自动部署完成";
    }
    @RequestMapping("/jenkinsQuartz")
    public String jenkinsQuartz(){
        System.out.println("测试完成--jenkins定时任务自动部署完成qq休息休息");
        return "测试完成--jenkins定时任务自动部署完成qqq休息休息";
    }


}
