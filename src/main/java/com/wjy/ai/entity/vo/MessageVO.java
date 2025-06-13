package com.wjy.ai.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ai.chat.messages.Message;

/**
 * ClassName: MessageVO
 * Package: com.wjy.ai.entity.vo
 * Description:
 *
 * @Author JIAYI WU
 * @Create 2025/6/13 9:40
 * @Version 1.0
 */
@NoArgsConstructor
@Data
public class MessageVO {
    private String role;
    private String content;

    public MessageVO(Message message) {
        switch (message.getMessageType()) {
            case USER:
                role = "user";
                break;
            case ASSISTANT:
                role = "assistant";
                break;
            default:
                role = "";
                break;
        }
        this.content = message.getText();
    }
}
