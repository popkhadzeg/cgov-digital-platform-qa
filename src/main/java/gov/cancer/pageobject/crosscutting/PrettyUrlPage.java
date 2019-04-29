package gov.cancer.pageobject.crosscutting;

import java.net.URL;
import gov.cancer.pageobject.PageObjectBase;

/**
 * Pseudo page object representing any page in the system.
 */
public class PrettyUrlPage extends PageObjectBase {

  boolean flag = false;

  String url = getBrowser().getCurrentUrl();

  /**
   * Constructor
   *
   * @param path server-relative path of the page to load.
   */
  public PrettyUrlPage(String path) {
    super(path);
  }

  /* Returns true if url is valid */
  public static boolean isValid(String url) {
    /* Try creating a valid URL */
    try {
      new URL(url).toURI();
      return true;
    }

    // If there was an Exception
    // while creating URL object
    catch (Exception e) {
      return false;
    }
  }

  // Since the variable is private, we provide an accessor
  public String getUrl() {
    return this.url;
  }
}
