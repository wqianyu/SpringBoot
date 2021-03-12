/*
 * Copyright 1999-2019 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wuqy.controller;

import com.alibaba.csp.sentinel.adapter.reactor.SentinelReactorTransformer;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.wuqy.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.config.EnableWebFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Eric Zhao
 */
@RestController
@RequestMapping(value = "/foo")
@EnableWebFlux
public class FooController {

    static {
        System.out.println("test");
        List<FlowRule> flowRules = new ArrayList<>();
        FlowRule rule = new FlowRule("demo_foo_normal_single");
        rule.setCount(1);
        rule.setGrade(1);
        rule.setControlBehavior(0);
        flowRules.add(rule);
        FlowRuleManager.loadRules(flowRules);
    }

    @Autowired
    private FooService fooService;

    @GetMapping("/single")
    public Mono<String> apiNormalSingle() {
        return fooService.emitSingle()
            // transform the publisher here.
            .transform(new SentinelReactorTransformer<>("demo_foo_normal_single"));
    }

    @GetMapping("/flux")
    public Flux<Integer> apiNormalFlux() {
        return fooService.emitMultiple()
            .transform(new SentinelReactorTransformer<>("demo_foo_normal_flux"));
    }

    @GetMapping("/slow")
    public Mono<String> apiDoSomethingSlow(ServerHttpResponse response) {
        return fooService.doSomethingSlow();
    }
}
