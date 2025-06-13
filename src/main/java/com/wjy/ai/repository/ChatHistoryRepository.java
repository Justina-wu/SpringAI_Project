package com.wjy.ai.repository;

import java.util.List;

/**
 * ClassName: ChatHistoryRepository
 * Package: com.wjy.ai.repository
 * Description:
 *
 * @Author JIAYI WU
 * @Create 2025/6/12 13:41
 * @Version 1.0
 */
public interface ChatHistoryRepository {

    /**
     * 保存会话记录
     * @param type 业务类型，如：chat、service、pdf
     * @param chatId 会话ID
     */
    void save(String type, String chatId);

    /**
     * 获取会话ID列表
     * @param type 业务类型，如：chat、service、pdf
     * @return 会话ID列表
     */
    List<String> getChatIds(String type);
}
