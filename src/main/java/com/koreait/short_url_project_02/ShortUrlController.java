
package com.koreait.short_url_project_02;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShortUrlController {

    private List<Surl> surls = new ArrayList<Surl>();
    private long surlLastId;

    @GetMapping("/add")
    @ResponseBody
    public Surl add(String body, String url) {
        Surl surl = Surl.builder()
                .id(++surlLastId)
                .body(body)
                .url(url)
                .build();

        surls.add(surl);

        return surl;
    }

    @GetMapping("/s/{body}**")
    @ResponseBody
    public String add(
            @PathVariable String body,
            HttpServletRequest req) {
        String url = req.getRequestURI();

        String[] urlBits = url.split("",4);

        url = urlBits[3];

        return url;
    }
}
