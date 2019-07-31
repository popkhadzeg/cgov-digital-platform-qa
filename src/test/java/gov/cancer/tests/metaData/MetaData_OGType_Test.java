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

public class MetaData_OGType_Test extends TestObjectBase {

  /**
   * Verify <meta property="og:type" content=
   *
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithOGMetaTag")
  public void verifyPagesWithOGMetaTag(String path) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {
      AllMetaTags tag = page.getOGTypeMetaTag();
      Assert.assertTrue(tag.getOGTypeMetaName(), "Found 'OGType' metatag");

    });
  }

  /************** Data Provider *************/
  /**
   * Retrieves a list of paths to pages which are expected to have meta
   * property="og:type"
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithOGMetaTag")
  public Iterator<Object[]> getPagesWithOGMetaTag() {
    String[] columns = { "path" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }

}
