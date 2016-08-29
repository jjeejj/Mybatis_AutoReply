package com.dao;

import java.util.List;

import com.bean.Command;

public interface ICommandDao {
	/**
	 * 查询
	 * @param command
	 * @return
	 */
	public List<Command> queryCommandList(Command command);
}
