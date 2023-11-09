package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data","hello@@");
        return mav;
     }
     //view 의 논리 이름 "response/hello" 경로가 렌더링
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello@@");
        return "response/hello";
     }
     //문자열 response/hello 출력
    @ResponseBody
    @RequestMapping("/response-view-v22")
    public String responseViewV22(Model model) {
        model.addAttribute("data", "hello@@");
        return "response/hello";
    }

    /**
     * 불분명하여 권장하지 않는 방식
     * 컨트롤러의 반환값이 없을 경우 컨트롤러의 매핑 경로와 view의 논리적 이름이 똑같으면 그대로 반환
     * @param model
     */
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello@@");
    }
}
