package com.yorha.adhoc.controller;

import com.yorha.processor.common.*;
import com.yorha.processor.entity.*;
import com.yorha.processor.impl.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProcessorController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {

        return new ResponseEntity<>("hello world", HttpStatus.OK);
    }

    @GetMapping("/processor")
    public ResponseEntity<String> processor() {
        Processor<MyContextEntity> processor = new CompositeProcessor<>("自定义业务流程",
                new AlphaProcessor(),
                new BetaProcessor(),
                new SwitchCaseProcessor<>("自定义分支流程",
                        new GammaProcessor(), (SwitcherContext c) -> "1".equals(c.getId()),
                        new ExtraProcessor(), (SwitcherContext c) -> true

                )

        );
        MyContextEntity context = new MyContextEntity();
        processor.process(context);
        System.out.println(context.getId());
        System.out.println(context.getInfo());
        System.out.println(context.getExtra());
        System.out.println(context.getVersion());
        System.out.println(processor.getFullName());
        return new ResponseEntity<>("process done", HttpStatus.OK);
    }
}
