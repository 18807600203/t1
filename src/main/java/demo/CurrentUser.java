package demo;

import org.springframework.stereotype.Component;

import io.ebean.config.CurrentUserProvider;

/**
 * Provides the current user to EbeanServer.
 */
@Component
public class CurrentUser implements CurrentUserProvider {

  @Override
  public Object currentUser() {
    return "test";
  }
}
