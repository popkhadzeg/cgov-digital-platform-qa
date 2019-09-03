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

public class MetaData_DCTermsSubject_Test extends TestObjectBase {

  /**
   * This method is checking if 'dcterms.subject' matatag name matches
   * dcTermsSubject from data provider
   * 
   * @param path           Path of the page to check.
   * @param dcTermsSubject Label of dcTermsSubject metatag.
   * 
   */
  @Test(dataProvider = "getPagesWithdcTermsSubject")
  public void verifyPagesWithDCTermsSubject(String path, String dcTermsSubject) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {
      Assert.assertEquals(page.getDCTermsSubject(), dcTermsSubject);

    });
  }

  /************** Data Providers *************/
  /**
   * Retrieves a list of paths to pages which are expected to have meta
   * name="dcterms.subject"
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithdcTermsSubject")
  public Iterator<Object[]> getPagesWithdcTermsSubject() {
    String[] columns = { "path", "dcTermsSubject" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }

}
