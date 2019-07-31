package gov.cancer.tests.metaData;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.cancer.framework.ExcelDataReader;
import gov.cancer.pageobject.crosscutting.PageWithMetaTag;
import gov.cancer.pageobject.helper.AllMetaTags;
import gov.cancer.tests.TestObjectBase;
import gov.cancer.tests.TestRunner;

public class MetaData_ContentLanguage_Test extends TestObjectBase {

  /**
   * Verify http-equiv="content-language" content="en"
   *
   * 
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithMetaContentLanguage")
  public void verifyPagesWithMetaContentLanguage(String path, String language) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {

      Assert.assertEquals(page.getContentLanguage(), language);

    });
  }

  /************** Data Providers *************/
  /**
   * Retrieves a list of paths to pages which are expected to have
   * http-equiv="content-language"
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithMetaContentLanguage")
  public Iterator<Object[]> getPagesWithMetaContentLanguage() {
    String[] columns = { "path", "language" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }

}