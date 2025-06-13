package com.wjy.ai.repository;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: InMemoryChatHistoryRepository
 * Package: com.wjy.ai.repository
 * Description:
 *
 * @Author JIAYI WU
 * @Create 2025/6/12 13:54
 * @Version 1.0
 */
@Component
public class InMemoryChatHistoryRepository implements ChatHistoryRepository{

    private final Map<String, List<String>> chatHistory = new HashMap<>();

    @Override
    public void save(String type, String chatId) {
//        if (!chatHistory.containsKey(type)){ // 查询是否有这个类型的对话，如果没有，添加
//            chatHistory.put(type, new ArrayList<>());
//        }
//        // 如果有的话，取出对应类型的集合（chatId）
//        List<String> chatIds = chatHistory.get(type);
        // 简化写法：判断type是否存在，不存在就新建
        List<String> chatIds = chatHistory.computeIfAbsent(type, k -> new ArrayList<>());
        // 判断当前列表中是否已经存在该chatId。如果不存在添加进去
        if (chatIds.contains(chatId)){
            return;
        }
        chatIds.add(chatId);
    }

    @Override
    public List<String> getChatIds(String type) {
//        List<String> chatIds = chatHistory.get(type);
//        return chatIds == null? new ArrayList<>() : chatIds;
        // 简化写法
        return chatHistory.getOrDefault(type, List.of());
    }
}
