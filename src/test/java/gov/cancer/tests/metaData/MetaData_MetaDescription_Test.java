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

public class MetaData_MetaDescription_Test extends TestObjectBase {

  /**
   * This method is checking if 'description' matatag name matches dcTermsSubject
   * from data provider
   * 
   * @param path     Path of the page to check.
   * @param metaDesc Label of metaDesc metatag.
   * 
   */
  @Test(dataProvider = "getPagesWithMetaDescription")
  public void verifyPagesWithMetaDescription(String path, String metaDesc) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {

      Assert.assertEquals(page.getMetaDescription(), metaDesc);

    });
  }

  /************** Data Providers *************/
  /**
   * Retrieves a list of paths to pages which are expected to have meta
   * name="description"
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithMetaDescription")
  public Iterator<Object[]> getPagesWithMetaDescription() {
    String[] columns = { "path", "metaDesc" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }

}
