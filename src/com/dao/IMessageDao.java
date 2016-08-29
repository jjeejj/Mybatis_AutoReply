package com.dao;

import java.util.List;
import com.bean.Message;;
/**
 * 与message配置文件相对应的接口
 * @author jiang
 *
 */
public interface IMessageDao {
	/**
	 * 查询
	 * @param message
	 * @return
	 */
	public List<Message> queryMessageList(Message message);
}
