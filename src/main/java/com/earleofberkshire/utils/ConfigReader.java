package com.earleofberkshire.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class to read configuration values from the {@code config.properties} file.
 *
 * <p>This class loads the configuration file once when the class is first accessed and provides a
 * static method to retrieve values by key.
 */
public class ConfigReader {

  private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);
  private static final Properties properties = new Properties();

  // Static block to load the config file when the class is first accessed
  static {
    try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
      properties.load(fis);
      logger.info("Loaded config.properties successfully.");
    } catch (IOException e) {
      logger.error("Failed to load config.properties", e);
      throw new RuntimeException("Failed to load config.properties", e);
    }
  }

  /**
   * Retrieves the value associated with the given key from the configuration file.
   *
   * @param key the name of the property to retrieve
   * @return the property value, or {@code null} if the key does not exist
   */
  public static String get(String key) {
    String value = properties.getProperty(key);
    if (value == null) {
      logger.warn("Config key '{}' not found in properties file.", key);
    } else {
      logger.debug("Retrieved config key '{}': {}", key, value);
    }
    return value;
  }
}
