package io.github.henryssondaniel.teacup.protocol.opcua.client;

/**
 * The status code.
 *
 * @since 1.0
 */
public interface StatusCode {
  /**
   * Returns the value.
   *
   * @return the value
   */
  long getValue();

  /**
   * Returns whether bad or not.
   *
   * @return whether bad or not
   */
  boolean isBad();

  /**
   * Returns whether good or not.
   *
   * @return whether good or not
   */
  boolean isGood();

  /**
   * Returns whether overflow is set or not.
   *
   * @return whether overflow is set or not
   */
  boolean isOverflowSet();

  /**
   * Returns whether uncertain or not.
   *
   * @return whether uncertain or not
   */
  boolean isUncertain();

  /**
   * Returns the status code with overflow.
   *
   * @return the status code with overflow
   */
  StatusCode withOverflow();

  /**
   * Returns the status code without overflow.
   *
   * @return the status code without overflow
   */
  StatusCode withoutOverflow();
}
