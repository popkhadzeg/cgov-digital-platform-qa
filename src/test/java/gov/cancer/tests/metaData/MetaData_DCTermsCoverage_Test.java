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

public class MetaData_DCTermsCoverage_Test extends TestObjectBase {

  /**
   * Verify <meta name="dcterms.coverage" content="nciglobal,ncienterprise"
   * ===========================
   *
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithDCTermsCoverage")
  public void verifyPagesWithDCTermsCoverage(String path) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {
      AllMetaTags tag = page.getDCTermsCoverage();
      Assert.assertTrue(tag.getDCTermsCoverage(), "Found 'dcterms.coverage' metatag");

    });
  }

  /************** Data Provider *************/
  /**
   * Retrieves a list of paths to pages which are expected to have meta
   * name="dcterms.coverage"
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithDCTermsCoverage")
  public Iterator<Object[]> getPagesWithDCTermsCoverage() {
    String[] columns = { "path" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }
}
