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

public class MetaData_Test extends TestObjectBase {

  /**
   * Verify meta name="twitter:card" content="summary" />
   * ==============================
   *
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithAllMeta")
  public void verifyPagesWithTwitterTag(String path) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {
      AllMetaTags tag = page.getTwitterMetaTag();
      Assert.assertTrue(tag.getTwitterMetaName(), "Found 'Twitter' metatag");

    });
  }

  /**
   * Verify meta property="og:type" content="Website"
   * />===========================
   *
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithAllMeta")
  public void verifyPagesWithOGMetaTag(String path) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {
      AllMetaTags tag = page.getOGTypeMetaTag();
      Assert.assertTrue(tag.getOGTypeMetaName(), "Found 'OGType' metatag");

    });
  }

  /**
   * Verify meta name="dcterms.isReferencedBy" content="event1"
   * />===========================
   *
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithAllMeta")
  public void verifyPagesWithDCTermsReferencedBy(String path) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {
      AllMetaTags tag = page.getDCTermsReferencedBy();
      Assert.assertTrue(tag.getDCTermsIsReferencedBy(), "Found 'isReferencedBy' metatag");

    });
  }

  /**
   * Verify meta name="dcterms.coverage" content="nciglobal,ncienterprise"
   * ===========================
   *
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithAllMeta")
  public void verifyPagesWithDCTermsCoverage(String path) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {
      AllMetaTags tag = page.getDCTermsCoverage();
      Assert.assertTrue(tag.getDCTermsCoverage(), "Found 'dcterms.coverage' metatag");

    });
  }

  /************** Data Provider *************/
  /**
   * Retrieves a list of paths to pages which are expected to have Include in
   * Search Selected
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithAllMeta")
  public Iterator<Object[]> getPagesWithAllMeta() {
    String[] columns = { "path" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }

  // <meta name="dcterms.type" content="cgvPressRelease"
  // />=========================================
  /**
   * Verify that the "og:type" tag is present
   *
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithdcTermType")
  public void verifyPagesWithOGType(String path, String dcTermsType) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {
      Assert.assertEquals(page.getDCTermsType(), dcTermsType);

    });
  }

  /************** Data Providers *************/
  /**
   * Retrieves a list of paths to pages which are expected to have Include in
   * Search Selected
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithdcTermType")
  public Iterator<Object[]> getPagesWithdcTermType() {
    String[] columns = { "path", "dcTermsType" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }

  /**
   * Verify meta name="dcterms.subject" content="About Cancer"
   * />================================
   *
   * 
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithdcTermsSubject")
  public void verifyPagesWithDCTermsSubject(String path, String dcTermsSubject) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {
      Assert.assertEquals(page.getDCTermsSubject(), dcTermsSubject);

    });
  }

  /************** Data Providers *************/
  /**
   * Retrieves a list of paths to pages which are expected to have Include in
   * Search Selected
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithdcTermsSubject")
  public Iterator<Object[]> getPagesWithdcTermsSubject() {
    String[] columns = { "path", "dcTermsSubject" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }

  /**
   * Verify meta name="dcterms.isPartOf" content="NCI"
   * />================================
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
   * Retrieves a list of paths to pages which are expected to have Include in
   * Search Selected
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithdcTermsPartOf")
  public Iterator<Object[]> getPagesWithdcTermsPartOf() {
    String[] columns = { "path", "dcTermsPartOf" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }

  /**
   * Verify meta name="title" content="title - Instituto Nacional Del Cáncer"
   * ================================
   *
   * 
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithMetaTitle")
  public void verifyPagesWithMetaTitle(String path, String title) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {
      Assert.assertEquals(page.getMetaTitle(), title);
      Assert.assertEquals(page.getCurrentPageTitle(), page.getMetaTitle());

    });
  }

  /************** Data Providers *************/
  /**
   * Retrieves a list of paths to pages which are expected to have Include in
   * Search Selected
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithMetaTitle")
  public Iterator<Object[]> getPagesWithMetaTitle() {
    String[] columns = { "path", "title" };

    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }

  /**
   * Verify <meta property="og:site_name" content="
   * ================================
   *
   * 
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithMetaSiteName")
  public void verifyPagesWithMetaSiteName(String path, String siteName) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {
      Assert.assertEquals(page.getMetaSiteName(), siteName);

    });
  }

  /************** Data Providers *************/
  /**
   * Retrieves a list of paths to pages which are expected to have Include in
   * Search Selected
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithMetaSiteName")
  public Iterator<Object[]> getPagesWithMetaSiteName() {
    String[] columns = { "path", "siteName" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }

  /**
   * Verify meta property="og:title" content= ================================
   *
   * 
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithMetaOGTitle")
  public void verifyPagesWithMetaOGTitle(String path, String siteName) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {
      Assert.assertEquals(page.getMetaSiteName(), siteName);

    });
  }

  /************** Data Providers *************/
  /**
   * Retrieves a list of paths to pages which are expected to have Include in
   * Search Selected
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithMetaOGTitle")
  public Iterator<Object[]> getPagesWithMetaOGTitle() {
    String[] columns = { "path", "siteName" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }

  /**
   * Verify meta property="og:site_name" content= ================================
   *
   * 
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithMetaOGSiteName")
  public void verifyPagesWithMetaOGSiteName(String path, String siteName) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {

      Assert.assertEquals(page.getMetaSiteName(), siteName);

    });
  }

  /************** Data Providers *************/
  /**
   * Retrieves a list of paths to pages which are expected to have Include in
   * Search Selected
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithMetaOGSiteName")
  public Iterator<Object[]> getPagesWithMetaOGSiteName() {
    String[] columns = { "path", "siteName" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }

  /**
   * Verify meta property="og:url" content= ================================
   *
   * 
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithMetaOGURL")
  public void verifyPagesWithMetaOGURL(String path) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {

      Assert.assertEquals(page.getCurrentURL(), page.getOGURL());
      Assert.assertEquals(page.getCurrentURL(), page.getCanonicalURL());

    });
  }

  /************** Data Providers *************/
  /**
   * Retrieves a list of paths to pages which are expected to have Include in
   * Search Selected
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithMetaOGURL")
  public Iterator<Object[]> getPagesWithMetaOGURL() {
    String[] columns = { "path" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }

  /**
   * Verify meta property="og:url" content= ================================
   *
   * 
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithMetaOGDescription")
  public void verifyPagesWithMetaDescription(String path, String metaDesc, String ogDesc) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {

      Assert.assertEquals(page.getMetaDescription(), metaDesc);
      Assert.assertEquals(page.getOGMetaDescription(), ogDesc);

    });
  }

  /************** Data Providers *************/
  /**
   * Retrieves a list of paths to pages which are expected to have Include in
   * Search Selected
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithMetaOGDescription")
  public Iterator<Object[]> getPagesWithMetaOGDescription() {
    String[] columns = { "path", "metaDesc", "ogDesc" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }

  /**
   * Verify meta property="og:url" content= ================================
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
   * Retrieves a list of paths to pages which are expected to have Include in
   * Search Selected
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
