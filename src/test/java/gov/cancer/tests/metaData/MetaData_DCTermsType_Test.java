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

public class MetaData_DCTermsType_Test extends TestObjectBase {

  /**
   * This method is checking if 'dcterms.type' matatag name matches
   * dcTermsType from data provider
   * 
   * @param path           Path of the page to check.
   * @param dcTermsType    Label of dcTermsType metatag.
   * 
   */
  @Test(dataProvider = "getPagesWithdcTermType")
  public void verifyPagesWithOGType(String path, String dcTermsType) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {
      Assert.assertEquals(page.getDCTermsType(), dcTermsType);

    });
  }

  /************** Data Providers *************/
  /**
   * Retrieves a list of paths to pages which are expected to have meta
   * name="dcterms.type"
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithdcTermType")
  public Iterator<Object[]> getPagesWithdcTermType() {
    String[] columns = { "path", "dcTermsType" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }

}
