package com.wjy.ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: CommonConfiguration
 * Package: com.wjy.ai.config
 * Description:
 *
 * @Author JIAYI WU
 * @Create 2025/6/10 21:45
 * @Version 1.0
 */

@Configuration
public class CommonConfiguration {
    @Bean
    public ChatMemory chatMemory(){
        // TODO 用redis存储会话记忆
        return MessageWindowChatMemory.builder().build();
    }

    @Bean
    public ChatClient chatClient(OllamaChatModel model, ChatMemory chatMemory){
        return ChatClient
                .builder(model)
                .defaultSystem("你是一个热心可爱的智能助手，你叫小团团，请以小团团的身份和语气回答问题。")
                .defaultAdvisors(
                        new SimpleLoggerAdvisor(),
                        MessageChatMemoryAdvisor.builder(chatMemory).build()
                        )
                .build();
    }
}
