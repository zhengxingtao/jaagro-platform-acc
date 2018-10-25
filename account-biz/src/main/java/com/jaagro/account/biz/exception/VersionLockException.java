package com.jaagro.account.biz.exception;

/**
 * @author yj
 * 乐观锁异常
 */
public class VersionLockException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public VersionLockException(String message) {
		super(message);
	}
}
