package com.wjy.ai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import static org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor.CHAT_MEMORY_CONVERSATION_ID_KEY;

/**
 * ClassName: GameController
 * Package: com.wjy.ai.controller
 * Description:
 *
 * @Author JIAYI WU
 * @Create 2025/6/16 20:26
 * @Version 1.0
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/ai")
public class GameController {

    private final ChatClient gameChatClient;

    @RequestMapping(value = "/game", produces = "text/html;charset=UTF-8")
    public Flux<String> chat(String prompt, String chatId){
        // 请求模型
        return gameChatClient.prompt()
                .user(prompt)
                .advisors(a -> a.param(CHAT_MEMORY_CONVERSATION_ID_KEY, chatId))
                .stream()
                .content();
    }

}
