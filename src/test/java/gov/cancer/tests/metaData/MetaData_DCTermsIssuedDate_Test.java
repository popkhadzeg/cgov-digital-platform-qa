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

public class MetaData_DCTermsIssuedDate_Test extends TestObjectBase {

  /**
   * This method is checking if 'dcterms.issued' matatag name matches
   * issuedDate from data provider
   * 
   * @param path       Path of the page to check.
   * @param issuedDate Label of issuedDate metatag.
   * 
   */
  @Test(dataProvider = "getPagesWithDCTermsIssuedDate")
  public void verifyPagesWithDCTermsIssuedDate(String path, String issuedDate) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {

      Assert.assertEquals(page.getDCTermsIssuedDate(), issuedDate);

    });
  }

  /************** Data Providers *************/
  /**
   * Retrieves a list of paths to pages which are expected to have Include
   * name="dcterms.issued"
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithDCTermsIssuedDate")
  public Iterator<Object[]> getPagesWithDCTermsIssuedDate() {
    String[] columns = { "path", "issuedDate" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta_Issued_date", columns);
  }
}