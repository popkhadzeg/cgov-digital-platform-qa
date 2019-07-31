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

public class MetaData_DCTermsIsPartOf_Test extends TestObjectBase {

  /**
   * Verify <meta name="dcterms.isPartOf" content="Coping"
   *
   * 
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithdcTermsPartOf")
  public void verifyPagesWithDCTermsPartOf(String path, String dcTermsPartOf) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {
      Assert.assertEquals(page.getDCTermsPartOf(), dcTermsPartOf);

    });
  }

  /************** Data Providers *************/
  /**
   * Retrieves a list of paths to pages which are expected to have meta
   * name="dcterms.isPartOf"
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithdcTermsPartOf")
  public Iterator<Object[]> getPagesWithdcTermsPartOf() {
    String[] columns = { "path", "dcTermsPartOf" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }

}
