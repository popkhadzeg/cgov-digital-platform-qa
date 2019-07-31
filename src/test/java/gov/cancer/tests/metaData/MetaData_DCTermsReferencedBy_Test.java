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

public class MetaData_DCTermsReferencedBy_Test extends TestObjectBase {

  /**
   * Verify <meta name="dcterms.isReferencedBy" content="event1"
   *
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithDCTermsReferencedBy")
  public void verifyPagesWithDCTermsReferencedBy(String path) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {
      AllMetaTags tag = page.getDCTermsReferencedBy();
      Assert.assertTrue(tag.getDCTermsIsReferencedBy(), "Found 'isReferencedBy' metatag");

    });
  }

  /************** Data Provider *************/
  /**
   * Retrieves a list of paths to pages which are expected to have meta
   * name="dcterms.isReferencedBy"
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithDCTermsReferencedBy")
  public Iterator<Object[]> getPagesWithDCTermsReferencedBy() {
    String[] columns = { "path" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }
}
